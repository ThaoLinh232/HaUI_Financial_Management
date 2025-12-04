package com.qltc.finace.utils

import android.content.ContentValues
import android.content.Context
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import androidx.core.content.FileProvider
import com.qltc.finace.data.entity.CategoryExpenseDetail
import com.qltc.finace.data.entity.CategoryIncomeDetail
import java.io.File
import java.io.FileOutputStream
import java.io.OutputStreamWriter
import java.nio.charset.StandardCharsets
import java.text.NumberFormat
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.apply
import kotlin.collections.forEach
import kotlin.collections.forEachIndexed
import kotlin.collections.isNullOrEmpty
import kotlin.collections.sumOf
import kotlin.io.use
import kotlin.text.appendLine
import kotlin.text.contains
import kotlin.text.repeat
import kotlin.text.replace
import kotlin.text.take

/**
 * Helper class để xuất báo cáo dạng CSV
 * CSV format đơn giản, chỉ chứa dữ liệu dạng bảng, không có biểu đồ
 */
class CsvExportHelper(private val context: Context) {
    
    companion object {
        private const val TAG = "CsvExportHelper"
        private const val FILE_PROVIDER_AUTHORITY = "com.qltc.finace.fileprovider"
        
        // Export types (giống PdfExportHelper để tương thích)
        const val TYPE_EXPENSE = 0
        const val TYPE_INCOME = 1
        const val TYPE_BOTH = 2
    }
    
    private val formatter = NumberFormat.getCurrencyInstance(Locale("vi", "VN")).apply {
        maximumFractionDigits = 0
    }
    
    private val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
    
    /**
     * Tạo báo cáo CSV
     * 
     * @param fileName Tên file (không cần đuôi .csv)
     * @param startDate Ngày bắt đầu
     * @param endDate Ngày kết thúc
     * @param reportType Loại báo cáo (chi tiêu, thu nhập, hoặc cả hai)
     * @param expenseData Dữ liệu chi tiêu theo danh mục
     * @param incomeData Dữ liệu thu nhập theo danh mục
     * @return Uri của file CSV đã tạo, hoặc null nếu thất bại
     */
    fun createCsvReport(
        fileName: String,
        startDate: LocalDate,
        endDate: LocalDate,
        reportType: Int,
        expenseData: List<CategoryExpenseDetail>? = null,
        incomeData: List<CategoryIncomeDetail>? = null
    ): Uri? {
        try {
            Log.d(TAG, "🔄 Creating CSV report: $fileName")
            Log.d(TAG, "📅 Date range: $startDate to $endDate")
            Log.d(TAG, "📊 Report type: $reportType")
            Log.d(TAG, "💰 Expense data: ${expenseData?.size ?: 0} categories")
            Log.d(TAG, "💵 Income data: ${incomeData?.size ?: 0} categories")
            
            val csvContent = buildCsvContent(startDate, endDate, reportType, expenseData, incomeData)
            
            Log.d(TAG, "📝 CSV content length: ${csvContent.length} characters")
            Log.d(TAG, "📝 First 200 chars: ${csvContent.take(200)}")
            
            // Tạo file và lưu
            val uri = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // Android 10+ sử dụng MediaStore
                Log.d(TAG, "💾 Using MediaStore (Android 10+)")
                createFileWithMediaStore(fileName, csvContent)
            } else {
                // Android 9 trở xuống sử dụng FileProvider
                Log.d(TAG, "💾 Using FileProvider (Android 9-)")
                createFileWithFileProvider(fileName, csvContent)
            }
            
            Log.d(TAG, "✅ CSV file created successfully: $uri")
            return uri
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error creating CSV file: ${e.message}", e)
            e.printStackTrace()
            return null
        }
    }
    
    /**
     * Xây dựng nội dung CSV
     */
    private fun buildCsvContent(
        startDate: LocalDate,
        endDate: LocalDate,
        reportType: Int,
        expenseData: List<CategoryExpenseDetail>?,
        incomeData: List<CategoryIncomeDetail>?
    ): String {
        val csv = kotlin.text.StringBuilder()
        
        // UTF-8 BOM để Excel hiển thị đúng tiếng Việt
        csv.append("\uFEFF")

        // Header - Tiêu đề báo cáo
        val reportTitle = when (reportType) {
            TYPE_EXPENSE -> "BÁO CÁO CHI TIÊU"
            TYPE_INCOME -> "BÁO CÁO THU NHẬP"
            else -> "BÁO CÁO THU CHI"
        }

        // Khoảng thời gian
        val formattedStartDate = startDate.format(dateFormatter)
        val formattedEndDate = endDate.format(dateFormatter)
        csv.appendLine(escapeCsv("Từ $formattedStartDate đến $formattedEndDate"))
        csv.appendLine() // Dòng trống

        // Thống kê tổng quan (nếu là TYPE_BOTH)
        if (reportType == TYPE_BOTH) {
            csv.appendLine(escapeCsv("THỐNG KÊ TỔNG QUAN"))
            csv.appendLine("${escapeCsv("Thông tin")},${escapeCsv("Số tiền (VND)")}")

            val totalExpense = expenseData?.sumOf { it.totalAmount } ?: 0
            val totalIncome = incomeData?.sumOf { it.totalAmount } ?: 0
            val balance = totalIncome - totalExpense

            csv.appendLine("${escapeCsv("Tổng chi tiêu")},${formatNumber(totalExpense)}")
            csv.appendLine("${escapeCsv("Tổng thu nhập")},${formatNumber(totalIncome)}")
            csv.appendLine("${escapeCsv("Số dư")},${formatNumber(balance)}")
            csv.appendLine() // Dòng trống

        }

        // Chi tiết chi tiêu
        if (reportType == TYPE_EXPENSE || reportType == TYPE_BOTH) {
            addExpenseDataToCsv(csv, expenseData)
        }

        // Chi tiết thu nhập
        if (reportType == TYPE_INCOME || reportType == TYPE_BOTH) {
            addIncomeDataToCsv(csv, incomeData)
        }

        return csv.toString()
    }
    
    /**
     * Thêm dữ liệu chi tiêu vào CSV
     */
    private fun addExpenseDataToCsv(csv: StringBuilder, expenseData: List<CategoryExpenseDetail>?) {
        if (expenseData.isNullOrEmpty()) {
            csv.appendLine(escapeCsv("Không có dữ liệu chi tiêu"))
            csv.appendLine()
            return
        }

        // Tiêu đề phần chi tiêu
        csv.appendLine(escapeCsv("CHI TIẾT CHI TIÊU THEO DANH MỤC"))
        csv.appendLine()

        // Tổng hợp theo danh mục
        csv.appendLine("STT,${escapeCsv("Danh mục")},${escapeCsv("Số giao dịch")},${escapeCsv("Tổng chi (VND)")}")
        
        expenseData.forEachIndexed { index, category ->
            val transactionCount = category.listExpense?.size ?: 0

            csv.appendLine(
                "${index + 1}," +
                "${escapeCsv(category.category?.title ?: "Không tên")}," +
                "$transactionCount," +
                "${formatNumberWithComma(category.totalAmount)},"
            )
        }

        csv.appendLine() // Dòng trống

        // Chi tiết từng giao dịch

        csv.appendLine(escapeCsv("CHI TIẾT CÁC GIAO DỊCH CHI TIÊU"))

        csv.appendLine("STT,${escapeCsv("Danh mục")},${escapeCsv("Ngày")},${escapeCsv("Ghi chú")},${escapeCsv("Số tiền (VND)")}")

        var stt = 1
        expenseData.forEach { category ->
            category.listExpense?.forEach { expense ->
                val dateString = try {
                    val date = LocalDate.parse(expense.date, DateTimeFormatter.ISO_DATE)
                    date.format(dateFormatter)
                } catch (e: Exception) {
                    expense.date ?: ""
                }
                
                csv.appendLine(
                    "$stt," +
                    "${escapeCsv(category.category?.title ?: "Không tên")}," +
                    "${escapeCsv(dateString)}," +
                    "${escapeCsv(expense.note ?: "")}," +
                    "${formatNumber(expense.expense ?: 0)}"
                )
                stt++
            }
        }

        csv.appendLine() // Dòng trống
    }
    
    /**
     * Thêm dữ liệu thu nhập vào CSV
     */
    private fun addIncomeDataToCsv(csv: StringBuilder, incomeData: List<CategoryIncomeDetail>?) {
        if (incomeData.isNullOrEmpty()) {
            csv.appendLine(escapeCsv("Không có dữ liệu thu nhập"))
            csv.appendLine()
            return
        }

        // Tiêu đề phần thu nhập
        csv.appendLine(escapeCsv("CHI TIẾT THU NHẬP THEO DANH MỤC"))
        csv.appendLine()

        // Tổng hợp theo danh mục
        csv.appendLine("STT,${escapeCsv("Danh mục")},${escapeCsv("Số giao dịch")},${escapeCsv("Tổng thu (VND)")}")
        
        incomeData.forEachIndexed { index, category ->
            val transactionCount = category.listIncome?.size ?: 0

            csv.appendLine(
                "${index + 1}," +
                "${escapeCsv(category.category?.title ?: "Không tên")}," +
                "$transactionCount," +
                "${formatNumber(category.totalAmount)}"
            )
        }

        csv.appendLine() // Dòng trống

        // Chi tiết từng giao dịch
        csv.appendLine(escapeCsv("CHI TIẾT CÁC GIAO DỊCH THU NHẬP"))
        csv.appendLine("STT,${escapeCsv("Danh mục")},${escapeCsv("Ngày")},${escapeCsv("Ghi chú")},${escapeCsv("Số tiền (VND)")}")
        
        var stt = 1
        incomeData.forEach { category ->
            category.listIncome?.forEach { income ->
                val dateString = try {
                    val date = LocalDate.parse(income.date, DateTimeFormatter.ISO_DATE)
                    date.format(dateFormatter)
                } catch (e: Exception) {
                    income.date ?: ""
                }
                
                csv.appendLine(
                    "$stt," +
                    "${escapeCsv(category.category?.title ?: "Không tên")}," +
                    "${escapeCsv(dateString)}," +
                    "${escapeCsv(income.note ?: "")}," +
                    "${formatNumberWithComma(income.income ?: 0)}"
                )
                stt++
            }
        }
        
        csv.appendLine()
        csv.appendLine("=".repeat(80))
        csv.appendLine()
    }
    
    /**
     * Escape đặc biệt cho CSV (xử lý dấu phẩy, dấu ngoặc kép)
     */
    private fun escapeCsv(value: String): String {
        return if (value.contains(",") || value.contains("\"") || value.contains("\n")) {
            "\"${value.replace("\"", "\"\"")}\""
        } else {
            value
        }
    }
    
    /**
     * Format số tiền (chỉ số, không có ký hiệu tiền tệ để dễ import vào Excel)
     */
    private fun formatNumber(amount: Long): String {
        return NumberFormat.getNumberInstance(Locale("vi", "VN")).format(amount)
    }
    
    /**
     * Format số tiền với ngoặc kép (cho CSV) để Excel hiển thị đúng
     */
    private fun formatNumberWithComma(amount: Long): String {
        val formatted = NumberFormat.getNumberInstance(Locale("vi", "VN")).format(amount)
        return "\"$formatted\""  // Thêm ngoặc kép để Excel không tách cột
    }
    
    /**
     * Tạo file CSV với MediaStore (Android 10+)
     */
    private fun createFileWithMediaStore(fileName: String, content: String): Uri? {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.Q) {
            Log.w(TAG, "⚠️ MediaStore not available on this Android version")
            return null
        }
        
        try {
            val contentValues = ContentValues().apply {
                put(MediaStore.MediaColumns.DISPLAY_NAME, "$fileName.csv")
                put(MediaStore.MediaColumns.MIME_TYPE, "text/comma-separated-values")
                put(MediaStore.MediaColumns.RELATIVE_PATH, "${Environment.DIRECTORY_DOCUMENTS}/QLTC")
            }
            
            val contentUri = MediaStore.Files.getContentUri("external")
            Log.d(TAG, "📂 Content URI: $contentUri")
            
            val uri = context.contentResolver.insert(contentUri, contentValues)
                ?: throw kotlin.Exception("Không thể tạo file CSV qua MediaStore")
            
            Log.d(TAG, "✅ File URI created: $uri")
            
            context.contentResolver.openOutputStream(uri)?.use { outputStream ->
                OutputStreamWriter(outputStream, StandardCharsets.UTF_8).use { writer ->
                    writer.write(content)
                }
                Log.d(TAG, "✅ Content written to file: ${content.length} chars")
            } ?: throw kotlin.Exception("Không thể ghi file CSV")
            
            return uri
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error in createFileWithMediaStore: ${e.message}", e)
            throw e
        }
    }
    
    /**
     * Tạo file CSV với FileProvider (Android 9 trở xuống)
     */
    private fun createFileWithFileProvider(fileName: String, content: String): Uri {
        try {
            val csvDir = File(
                Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                "QLTC"
            )
            
            Log.d(TAG, "📂 CSV directory: ${csvDir.absolutePath}")
            
            if (!csvDir.exists()) {
                val created = csvDir.mkdirs()
                Log.d(TAG, "📂 Directory created: $created")
            }
            
            val csvFile = File(csvDir, "$fileName.csv")
            Log.d(TAG, "💾 CSV file path: ${csvFile.absolutePath}")
            
            FileOutputStream(csvFile).use { outputStream ->
                OutputStreamWriter(outputStream, StandardCharsets.UTF_8).use { writer ->
                    writer.write(content)
                }
            }
            
            Log.d(TAG, "✅ File written successfully: ${csvFile.length()} bytes")
            
            val uri = FileProvider.getUriForFile(
                context,
                FILE_PROVIDER_AUTHORITY,
                csvFile
            )
            
            Log.d(TAG, "✅ FileProvider URI: $uri")
            return uri
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error in createFileWithFileProvider: ${e.message}", e)
            throw e
        }
    }
}