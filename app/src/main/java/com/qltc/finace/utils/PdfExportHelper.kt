package com.qltc.finace.utils

import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.MediaStore
import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.core.content.FileProvider
import com.github.mikephil.charting.charts.PieChart
import com.itextpdf.text.*
import com.itextpdf.text.pdf.*
import com.itextpdf.text.pdf.draw.LineSeparator
import com.qltc.finace.R
import com.qltc.finace.data.entity.CategoryExpenseDetail
import com.qltc.finace.data.entity.CategoryIncomeDetail
import com.qltc.finace.data.entity.Expense
import com.qltc.finace.data.entity.Income
import com.qltc.finace.view.main.calendar.FinancialRecord
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.DecimalFormat
import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.YearMonth
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.apply
import kotlin.collections.forEach
import kotlin.collections.forEachIndexed
import kotlin.collections.isEmpty
import kotlin.collections.isNullOrEmpty
import kotlin.collections.joinToString
import kotlin.collections.sumOf
import kotlin.collections.take
import kotlin.io.copyTo
import kotlin.io.outputStream
import kotlin.io.readBytes
import kotlin.io.use
import kotlin.jvm.javaClass
import kotlin.text.contains
import kotlin.text.toRegex

class PdfExportHelper(private val context: Context) {
    
    companion object {
        private const val TAG = "PdfExportHelper"
        private const val FILE_PROVIDER_AUTHORITY = "com.qltc.finace.fileprovider"
        
        // Export types
        const val TYPE_EXPENSE = 0
        const val TYPE_INCOME = 1
        const val TYPE_BOTH = 2
        
        // Display options
        const val OPTION_SHOW_CHARTS = 1
        const val OPTION_SHOW_DETAILS = 2
        const val OPTION_SHOW_STATISTICS = 4
    }
    
    private val formatter = NumberFormat.getCurrencyInstance(Locale("vi", "VN")).apply {
        maximumFractionDigits = 0
    }
    
    // Sử dụng định dạng dd/MM/yyyy cho hiển thị người dùng trong PDF
    private val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy", Locale.getDefault())
    private val monthYearFormatter = DateTimeFormatter.ofPattern("MM/yyyy", Locale.getDefault())
    
    /**
     * Create a PDF report based on the provided parameters
     * 
     * @param fileName Name for the PDF file (without extension)
     * @param startDate Start date for the report
     * @param endDate End date for the report
     * @param reportType Type of data to include (expense, income, or both)
     * @param displayOptions Bitwise flags for what to display (charts, details, stats)
     * @param expenseData List of expense data by category
     * @param incomeData List of income data by category
     * @param expensePieChart Optional chart for expense data
     * @param incomePieChart Optional chart for income data
     * @return Uri to the generated PDF file or null if failed
     */
    fun createPdfReport(
        fileName: String,
        startDate: LocalDate,
        endDate: LocalDate,
        reportType: Int,
        displayOptions: Int,
        expenseData: List<CategoryExpenseDetail>? = null,
        incomeData: List<CategoryIncomeDetail>? = null,
        expensePieChart: PieChart? = null,
        incomePieChart: PieChart? = null
    ): Uri? {
        try {
            // Create PDF document
            val document = Document(PageSize.A4)
            
            // Sử dụng phương thức an toàn cho tất cả phiên bản Android
            val pdfFile: File
            val fileOutputStream: FileOutputStream
            val returnUri: Uri
            
            // Tạo file trong directory của ứng dụng
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                // Android 10+: Sử dụng MediaStore
                Log.d(TAG, "Android 10+: Using MediaStore for PDF creation")
                val contentValues = ContentValues().apply {
                    put(MediaStore.MediaColumns.DISPLAY_NAME, "$fileName.pdf")
                    put(MediaStore.MediaColumns.MIME_TYPE, "application/pdf")
                    put(MediaStore.MediaColumns.RELATIVE_PATH, "Documents/QLTC")
                }
                
                val contentUri = MediaStore.Files.getContentUri("external")
                val uri = context.contentResolver.insert(contentUri, contentValues)
                
                if (uri != null) {
                    Log.d(TAG, "MediaStore URI created: $uri")
                    fileOutputStream = context.contentResolver.openOutputStream(uri) as FileOutputStream
                    returnUri = uri
                } else {
                    throw kotlin.Exception("Không thể tạo file PDF qua MediaStore")
                }
            } else {
                // Android 9 trở xuống: Sử dụng FileProvider
                Log.d(TAG, "Android 9 and below: Using FileProvider for PDF creation")
                val pdfDir = File(
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS),
                    "QLTC"
                )
                if (!pdfDir.exists()) {
                    pdfDir.mkdirs()
                }
                
                pdfFile = File(pdfDir, "$fileName.pdf")
                fileOutputStream = FileOutputStream(pdfFile)
                
                // Sử dụng FileProvider để tạo URI an toàn
                returnUri = FileProvider.getUriForFile(
                    context,
                    FILE_PROVIDER_AUTHORITY,
                    pdfFile
                )
                Log.d(TAG, "FileProvider URI created: $returnUri for file: ${pdfFile.absolutePath}")
            }
            
            // Tạo PDF document
            PdfWriter.getInstance(document, fileOutputStream)
            document.open()
            
            // Add document header
            addDocumentHeader(document, startDate, endDate, reportType)
            
            // Add content based on report type
            addReportContent(document, reportType, displayOptions, expenseData, incomeData, expensePieChart, incomePieChart)
            
            // Close the document
            document.close()
            fileOutputStream.close()
            
            Log.d(TAG, "PDF created successfully: $returnUri")
            return returnUri
        } catch (e: Exception) {
            Log.e(TAG, "Error creating PDF: ${e.message}", e)
            return null
        }
    }
    
    /**
     * Create a PDF report specifically for Android Q+ using MediaStore
     * 
     * @param contentValues MediaStore ContentValues with file details
     * @param startDate Start date for the report
     * @param endDate End date for the report
     * @param reportType Type of data to include (expense, income, or both)
     * @param displayOptions Bitwise flags for what to display (charts, details, stats)
     * @param expenseData List of expense data by category
     * @param incomeData List of income data by category
     * @param expensePieChart Optional chart for expense data
     * @param incomePieChart Optional chart for income data
     * @return Uri to the generated PDF file or null if failed
     */
    fun createPdfReportWithMediaStore(
        contentValues: ContentValues,
        startDate: LocalDate,
        endDate: LocalDate,
        reportType: Int,
        displayOptions: Int,
        expenseData: List<CategoryExpenseDetail>? = null,
        incomeData: List<CategoryIncomeDetail>? = null,
        expensePieChart: PieChart? = null,
        incomePieChart: PieChart? = null
    ): Uri? {
        try {
            // Create PDF document
            val document = Document(PageSize.A4)
            
            val contentUri = MediaStore.Files.getContentUri("external")
            val uri = context.contentResolver.insert(contentUri, contentValues)
                ?: throw IOException("Không thể tạo file PDF")
            
            val outputStream = context.contentResolver.openOutputStream(uri)
                ?: throw IOException("Không thể mở file để ghi")
            
            PdfWriter.getInstance(document, outputStream)
            document.open()
            
            // Add document header
            addDocumentHeader(document, startDate, endDate, reportType)
            
            // Add content based on report type
            addReportContent(document, reportType, displayOptions, expenseData, incomeData, expensePieChart, incomePieChart)
            
            // Close the document
            document.close()
            outputStream.close()
            
            return uri
        } catch (e: Exception) {
            Log.e(TAG, "Error creating PDF with MediaStore: ${e.message}", e)
            throw e
        }
    }
    
    /**
     * Add report content to PDF document in the correct order based on report type
     */
    private fun addReportContent(
        document: Document,
        reportType: Int,
        displayOptions: Int,
        expenseData: List<CategoryExpenseDetail>? = null,
        incomeData: List<CategoryIncomeDetail>? = null,
        expensePieChart: PieChart? = null,
        incomePieChart: PieChart? = null
    ) {
        val showCharts = (displayOptions and OPTION_SHOW_CHARTS) != 0
        val showStats = (displayOptions and OPTION_SHOW_STATISTICS) != 0
        val showDetails = (displayOptions and OPTION_SHOW_DETAILS) != 0
        
        Log.d(TAG, "📋 Adding report content - Charts: $showCharts, Stats: $showStats, Details: $showDetails")
        
        // Kiểm tra có ít nhất một phần được chọn
        if (!showCharts && !showStats && !showDetails) {
            Log.w(TAG, "⚠️ No content options selected, adding default message")
            try {
                val noContentMessage = Paragraph(
                    "Không có nội dung nào được chọn để hiển thị trong báo cáo.\n" +
                    "Vui lòng chọn ít nhất một trong các tùy chọn: Biểu đồ, Thống kê, hoặc Chi tiết.",
                    Font(getVietnameseFont(), 12f, Font.ITALIC, BaseColor.GRAY)
                )
                noContentMessage.alignment = Element.ALIGN_CENTER
                noContentMessage.spacingBefore = 20f
                noContentMessage.spacingAfter = 20f
                document.add(noContentMessage)
            } catch (e: Exception) {
                Log.e(TAG, "❌ Error adding no content message: ${e.message}", e)
            }
            return
        }
        
        // Track số phần đã được thêm thành công
        var sectionsAdded = 0
        
        // Add sections based on report type
        when (reportType) {
            TYPE_EXPENSE -> {
                Log.d(TAG, "📊 Processing TYPE_EXPENSE report")
                
                // Add expense chart before expense statistics if enabled
                if (showCharts && expensePieChart != null) {
                    try {
                        Log.d(TAG, "📈 Adding expense chart...")
                        addChartToPdf(document, expensePieChart, "BIỂU ĐỒ CHI TIÊU")
                        sectionsAdded++
                        Log.d(TAG, "✅ Expense chart added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add expense chart: ${e.message}", e)
                        // Chart thất bại không làm dừng việc thêm các phần khác
                    }
                } else if (showCharts) {
                    Log.w(TAG, "⚠️ Charts requested but expensePieChart is null")
                }
                
                // Add expense statistics if enabled
                if (showStats) {
                    try {
                        Log.d(TAG, "📊 Adding expense statistics...")
                        addStatisticsToPdf(document, expenseData, null, TYPE_EXPENSE)
                        sectionsAdded++
                        Log.d(TAG, "✅ Expense statistics added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add expense statistics: ${e.message}", e)
                    }
                }
                
                // Add expense details if enabled
                if (showDetails) {
                    try {
                        Log.d(TAG, "📋 Adding expense details...")
                        addDetailsToPdf(document, expenseData, null, TYPE_EXPENSE)
                        sectionsAdded++
                        Log.d(TAG, "✅ Expense details added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add expense details: ${e.message}", e)
                    }
                }
            }
            
            TYPE_INCOME -> {
                Log.d(TAG, "📊 Processing TYPE_INCOME report")
                
                // Add income chart before income statistics if enabled
                if (showCharts && incomePieChart != null) {
                    try {
                        Log.d(TAG, "📈 Adding income chart...")
                        addChartToPdf(document, incomePieChart, "BIỂU ĐỒ THU NHẬP")
                        sectionsAdded++
                        Log.d(TAG, "✅ Income chart added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add income chart: ${e.message}", e)
                    }
                } else if (showCharts) {
                    Log.w(TAG, "⚠️ Charts requested but incomePieChart is null")
                }
                
                // Add income statistics if enabled
                if (showStats) {
                    try {
                        Log.d(TAG, "📊 Adding income statistics...")
                        addStatisticsToPdf(document, null, incomeData, TYPE_INCOME)
                        sectionsAdded++
                        Log.d(TAG, "✅ Income statistics added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add income statistics: ${e.message}", e)
                    }
                }
                
                // Add income details if enabled
                if (showDetails) {
                    try {
                        Log.d(TAG, "📋 Adding income details...")
                        addDetailsToPdf(document, null, incomeData, TYPE_INCOME)
                        sectionsAdded++
                        Log.d(TAG, "✅ Income details added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add income details: ${e.message}", e)
                    }
                }
            }
            
            TYPE_BOTH -> {
                Log.d(TAG, "📊 Processing TYPE_BOTH report")
                
                // 1. Thống kê tổng quan (nếu được chọn)
                if (showStats) {
                    try {
                        Log.d(TAG, "📊 Adding overview statistics...")
                        addOverviewStatistics(document, expenseData, incomeData)
                        sectionsAdded++
                        Log.d(TAG, "✅ Overview statistics added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add overview statistics: ${e.message}", e)
                    }
                }
                
                // 2. Phần chi tiêu
                Log.d(TAG, "📊 Processing expense section for TYPE_BOTH")
                
                // 2a. Biểu đồ chi tiêu
                if (showCharts && expensePieChart != null) {
                    try {
                        Log.d(TAG, "📈 Adding expense chart...")
                        val chartTitle = expensePieChart.centerText?.toString() ?: ""
                        val datePattern = "Chi tiêu tháng (\\d+)/(\\d+)".toRegex()
                        val matchResult = datePattern.find(chartTitle)
                        val monthYear = if (matchResult != null) {
                            " THÁNG ${matchResult.groupValues[1]}/${matchResult.groupValues[2]}"
                        } else {
                            ""
                        }
                        
                        addChartToPdf(document, expensePieChart, "BIỂU ĐỒ CHI TIÊU$monthYear")
                        sectionsAdded++
                        Log.d(TAG, "✅ Expense chart added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add expense chart: ${e.message}", e)
                    }
                } else if (showCharts) {
                    Log.w(TAG, "⚠️ Charts requested but expensePieChart is null")
                }
                
                // 2b. Chi tiết chi tiêu (chỉ thêm nếu showDetails = true)
                if (showDetails) {
                    try {
                        Log.d(TAG, "📋 Adding expense details...")
                        addDetailsToPdf(document, expenseData, null, TYPE_EXPENSE)
                        sectionsAdded++
                        Log.d(TAG, "✅ Expense details added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add expense details: ${e.message}", e)
                    }
                }
                
                // 3. Phần thu nhập
                Log.d(TAG, "📊 Processing income section for TYPE_BOTH")
                
                // 3a. Biểu đồ thu nhập
                if (showCharts && incomePieChart != null) {
                    try {
                        Log.d(TAG, "📈 Adding income chart...")
                        val chartTitle = incomePieChart.centerText?.toString() ?: ""
                        val datePattern = "Thu nhập tháng (\\d+)/(\\d+)".toRegex()
                        val matchResult = datePattern.find(chartTitle)
                        val monthYear = if (matchResult != null) {
                            " THÁNG ${matchResult.groupValues[1]}/${matchResult.groupValues[2]}"
                        } else {
                            ""
                        }
                        
                        addChartToPdf(document, incomePieChart, "BIỂU ĐỒ THU NHẬP$monthYear")
                        sectionsAdded++
                        Log.d(TAG, "✅ Income chart added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add income chart: ${e.message}", e)
                    }
                } else if (showCharts) {
                    Log.w(TAG, "⚠️ Charts requested but incomePieChart is null")
                }
                
                // 3b. Chi tiết thu nhập (chỉ thêm nếu showDetails = true)
                if (showDetails) {
                    try {
                        Log.d(TAG, "📋 Adding income details...")
                        addDetailsToPdf(document, null, incomeData, TYPE_INCOME)
                        sectionsAdded++
                        Log.d(TAG, "✅ Income details added successfully")
                    } catch (e: Exception) {
                        Log.e(TAG, "❌ Failed to add income details: ${e.message}", e)
                    }
                }
            }
        }
        
        // Kiểm tra cuối cùng: nếu không có phần nào được thêm thành công
        Log.d(TAG, "📊 Total sections added: $sectionsAdded")
        if (sectionsAdded == 0) {
            Log.w(TAG, "⚠️ No sections were added successfully, adding fallback content")
            try {
                val fallbackMessage = Paragraph(
                    "Không thể tạo nội dung báo cáo.\n" +
                    "Có thể do không có dữ liệu trong khoảng thời gian đã chọn hoặc xảy ra lỗi kỹ thuật.\n" +
                    "Vui lòng thử lại hoặc chọn khoảng thời gian khác.",
                    Font(getVietnameseFont(), 12f, Font.NORMAL, BaseColor.GRAY)
                )
                fallbackMessage.alignment = Element.ALIGN_CENTER
                fallbackMessage.spacingBefore = 20f
                fallbackMessage.spacingAfter = 20f
                document.add(fallbackMessage)
                Log.d(TAG, "✅ Fallback content added")
            } catch (e: Exception) {
                Log.e(TAG, "❌ Failed to add fallback content: ${e.message}", e)
                // Thêm nội dung tối thiểu để đảm bảo PDF không rỗng
                try {
                    document.add(Paragraph("Báo cáo không có nội dung"))
                } catch (e2: Exception) {
                    Log.e(TAG, "❌ Even minimal content failed: ${e2.message}", e2)
                }
            }
        }
    }
    
    /**
     * Add overview statistics including total expense, income and balance
     */
    private fun addOverviewStatistics(
        document: Document,
        expenseData: List<CategoryExpenseDetail>?,
        incomeData: List<CategoryIncomeDetail>?
    ) {
        try {
            // Sử dụng font cho thống kê
            val baseFont = getVietnameseFont()
            val boldFont = getVietnameseBoldFont()
            val mediumFont = getVietnameseMediumFont()
            
            // Tạo font trực tiếp khi cần sử dụng
            val contentFont = Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK)
            val highlightFont = Font(mediumFont, 12f, Font.NORMAL, BaseColor(255, 128, 0))
            
            // Add section title - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
            // Tạo font trực tiếp để đảm bảo encoding Unicode
            val sectionTitle = Paragraph("THỐNG KÊ TỔNG QUAN", 
                Font(boldFont, 14f, Font.NORMAL, BaseColor(90, 90, 90)))
            sectionTitle.spacingBefore = 15f
            sectionTitle.spacingAfter = 10f
            document.add(sectionTitle)
            
            // Create table for statistics
            val table = PdfPTable(2)
            table.widthPercentage = 100f
            table.setWidths(floatArrayOf(6f, 4f))
            
            // Add table headers - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
            addTableHeaderCell(table, "Thông tin", boldFont)
            addTableHeaderCell(table, "Số tiền (VND)", boldFont)
            
            // Calculate and add total values
            val totalExpense = expenseData?.sumOf { it.totalAmount } ?: 0
            val totalIncome = incomeData?.sumOf { it.totalAmount } ?: 0
            
            // Add expense row - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
            val expenseCell = PdfPCell(
                Phrase("Tổng chi tiêu", 
                    Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
            )
            expenseCell.paddingLeft = 10f
            expenseCell.paddingTop = 8f
            expenseCell.paddingBottom = 8f
            expenseCell.borderColor = BaseColor(240, 240, 240)
            table.addCell(expenseCell)
            
            val expenseValueCell = PdfPCell(
                Phrase(formatter.format(totalExpense), 
                    Font(mediumFont, 12f, Font.NORMAL, BaseColor(255, 128, 0)))
            )
            expenseValueCell.horizontalAlignment = Element.ALIGN_RIGHT
            expenseValueCell.paddingRight = 10f
            expenseValueCell.paddingTop = 8f
            expenseValueCell.paddingBottom = 8f
            expenseValueCell.borderColor = BaseColor(240, 240, 240)
            table.addCell(expenseValueCell)
            
            // Add income row - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
            val incomeCell = PdfPCell(
                Phrase("Tổng thu nhập", 
                    Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
            )
            incomeCell.paddingLeft = 10f
            incomeCell.paddingTop = 8f
            incomeCell.paddingBottom = 8f
            incomeCell.borderColor = BaseColor(240, 240, 240)
            table.addCell(incomeCell)
            
            val incomeValueCell = PdfPCell(
                Phrase(formatter.format(totalIncome), 
                    Font(mediumFont, 12f, Font.NORMAL, BaseColor(255, 128, 0)))
            )
            incomeValueCell.horizontalAlignment = Element.ALIGN_RIGHT
            incomeValueCell.paddingRight = 10f
            incomeValueCell.paddingTop = 8f
            incomeValueCell.paddingBottom = 8f
            incomeValueCell.borderColor = BaseColor(240, 240, 240)
            table.addCell(incomeValueCell)
            
            // Add balance row - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
            val balance = totalIncome - totalExpense
            
            val balanceCell = PdfPCell(
                Phrase("Số dư", 
                    Font(boldFont, 12f, Font.NORMAL, BaseColor.BLACK))
            )
            balanceCell.paddingLeft = 10f
            balanceCell.paddingTop = 8f
            balanceCell.paddingBottom = 8f
            balanceCell.borderColor = BaseColor(240, 240, 240)
            table.addCell(balanceCell)
            
            val balanceColor = if (balance >= 0) BaseColor(0, 150, 0) else BaseColor(200, 0, 0)
            val balanceValueCell = PdfPCell(
                Phrase(formatter.format(balance), 
                    Font(boldFont, 12f, Font.NORMAL, balanceColor))
            )
            balanceValueCell.horizontalAlignment = Element.ALIGN_RIGHT
            balanceValueCell.paddingRight = 10f
            balanceValueCell.paddingTop = 8f
            balanceValueCell.paddingBottom = 8f
            balanceValueCell.borderColor = BaseColor(240, 240, 240)
            table.addCell(balanceValueCell)
            
            document.add(table)
        } catch (e: Exception) {
            Log.e(TAG, "Error adding overview statistics: ${e.message}", e)
        }
    }
    
    private fun addDocumentHeader(
        document: Document,
        startDate: LocalDate,
        endDate: LocalDate,
        reportType: Int
    ) {
        try {
            // Sử dụng font Montserrat cho mọi thành phần văn bản
            val baseFont = getVietnameseFont()
            val boldFont = getVietnameseBoldFont()
            val mediumFont = getVietnameseMediumFont()
            val italicFont = getVietnameseItalicFont()
            
            // Add title - Tạo font trực tiếp cho từng trường hợp sử dụng
            val title = when (reportType) {
                TYPE_EXPENSE -> "BÁO CÁO CHI TIÊU"
                TYPE_INCOME -> "BÁO CÁO THU NHẬP"
                else -> "BÁO CÁO THU CHI"
            }
            
            // Tạo font trực tiếp để đảm bảo encoding Unicode đúng
            val titleParagraph = Paragraph(title, 
                Font(boldFont, 18f, Font.NORMAL, BaseColor(51, 51, 51)))
            titleParagraph.alignment = Element.ALIGN_CENTER
            titleParagraph.spacingAfter = 5f
            document.add(titleParagraph)
            
            // Add date range - Tạo chuỗi với font trực tiếp
            val formattedStartDate = startDate.format(dateFormatter)
            val formattedEndDate = endDate.format(dateFormatter)
            
            val dateRange = "Từ $formattedStartDate đến $formattedEndDate"
            // Tạo font trực tiếp để đảm bảo encoding Unicode đúng
            val dateRangeParagraph = Paragraph(dateRange, 
                Font(italicFont, 10f, Font.NORMAL, BaseColor(153, 153, 153)))
            dateRangeParagraph.alignment = Element.ALIGN_CENTER
            dateRangeParagraph.spacingAfter = 20f
            document.add(dateRangeParagraph)
            
            // Add separator line
            val line = LineSeparator()
            line.lineWidth = 1f
            line.percentage = 100f
            line.lineColor = BaseColor(230, 230, 230)
            document.add(Chunk(line))
            
            // Add intro paragraph - tạo với font trực tiếp
            val intro = "Báo cáo này thống kê các thông tin tài chính trong khoảng thời gian đã chọn."
            // Tạo font trực tiếp để đảm bảo encoding Unicode đúng
            val introParagraph = Paragraph(intro, 
                Font(baseFont, 12f, Font.NORMAL, BaseColor(102, 102, 102)))
            introParagraph.alignment = Element.ALIGN_LEFT
            introParagraph.spacingBefore = 10f
            introParagraph.spacingAfter = 15f
            document.add(introParagraph)
        } catch (e: Exception) {
            Log.e(TAG, "Error adding document header", e)
        }
    }
    
    private fun addChartToPdf(document: Document, chart: PieChart, title: String) {
        try {
            Log.d(TAG, "📊 Starting to add chart to PDF: '$title'")
            Log.d(TAG, "📏 Chart dimensions: width=${chart.width}, height=${chart.height}")
            Log.d(TAG, "📊 Chart data entries: ${chart.data?.entryCount ?: 0}")
            Log.d(TAG, "📊 Chart data value sum: ${chart.data?.yValueSum ?: 0f}")
            
            // Tạo font trực tiếp để đảm bảo encoding Unicode cho tiêu đề biểu đồ
            Log.d(TAG, "🔤 Creating chart title with font...")
            val boldFont = getVietnameseBoldFont()
            val chartTitle = Paragraph(title, 
                Font(boldFont, 16f, Font.NORMAL, BaseColor(51, 51, 51)))
            chartTitle.alignment = Element.ALIGN_CENTER
            chartTitle.spacingBefore = 20f
            chartTitle.spacingAfter = 15f
            document.add(chartTitle)
            Log.d(TAG, "✅ Chart title added successfully")
            
            // Kiểm tra chart data
            if (chart.data == null) {
                Log.w(TAG, "⚠️ Chart data is null!")
                throw kotlin.Exception("Chart data is null")
            }
            
            val totalValue = chart.data.yValueSum
            val entryCount = chart.data.entryCount
            Log.d(TAG, "📈 Chart data: totalValue=$totalValue, entryCount=$entryCount")
            
            if (totalValue <= 0 || entryCount <= 0) {
                Log.w(TAG, "⚠️ Chart has no valid data!")
                throw kotlin.Exception("Chart has no valid data (totalValue=$totalValue, entryCount=$entryCount)")
            }
            
            // Đảm bảo chart đã được render và tính toán đầy đủ
            Log.d(TAG, "🔄 Preparing chart for rendering...")
            chart.calculateOffsets()
            chart.notifyDataSetChanged()
            chart.invalidate()
            
            // QUAN TRỌNG: Cần thêm thời gian chờ cho animation hoàn tất
            Log.d(TAG, "⏳ Waiting for chart animation to complete (500ms)...")
            try {
                Thread.sleep(500)
            } catch (e: InterruptedException) {
                Thread.currentThread().interrupt()
            }
            
            // Kiểm tra kích thước chart sau khi prepare
            Log.d(TAG, "📏 Chart dimensions after prepare: width=${chart.width}, height=${chart.height}")
            
            if (chart.width <= 0 || chart.height <= 0) {
                Log.e(TAG, "❌ Chart has invalid dimensions: ${chart.width}x${chart.height}")
                throw kotlin.Exception("Chart has invalid dimensions after prepare: ${chart.width}x${chart.height}")
            }
            
            // Tạo bitmap từ chart với chất lượng cao
            Log.d(TAG, "🖼️ Creating bitmap from chart...")
            val bitmap = getBitmapFromView(chart)
            
            if (bitmap.isRecycled) {
                throw kotlin.Exception("Generated bitmap is recycled")
            }
            
            Log.d(TAG, "✅ Bitmap created: ${bitmap.width}x${bitmap.height}, config=${bitmap.config}")
            
            // Convert bitmap to Image với chất lượng tối ưu
            Log.d(TAG, "📦 Converting bitmap to PDF image...")
            val stream = ByteArrayOutputStream()
            val compressed = bitmap.compress(Bitmap.CompressFormat.PNG, 95, stream)
            
            if (!compressed) {
                throw kotlin.Exception("Failed to compress bitmap to PNG")
            }
            
            val byteArray = stream.toByteArray()
            Log.d(TAG, "📦 Bitmap compressed to ${byteArray.size} bytes")
            
            if (byteArray.isEmpty()) {
                throw kotlin.Exception("Compressed bitmap is empty")
            }
            
            val image = Image.getInstance(byteArray)
            Log.d(TAG, "✅ PDF Image created: ${image.width}x${image.height}")
            
            // Scale image để fit trang với tỷ lệ tối ưu
            val pageWidth = document.pageSize.width - document.leftMargin() - document.rightMargin()
            val maxImageWidth = pageWidth * 0.8f  // Sử dụng 80% chiều rộng trang
            val maxImageHeight = pageWidth * 0.6f  // Tỷ lệ 4:3
            
            Log.d(TAG, "📐 Scaling image: pageWidth=$pageWidth, maxWidth=$maxImageWidth, maxHeight=$maxImageHeight")
            
            image.scaleToFit(maxImageWidth, maxImageHeight)
            image.alignment = Element.ALIGN_CENTER
            
            Log.d(TAG, "📐 Image scaled to: ${image.scaledWidth}x${image.scaledHeight}")
            
            // Thêm khoảng trống và image
            document.add(Paragraph("\n"))
            document.add(image)
            document.add(Paragraph("\n"))
            
            Log.d(TAG, "✅ Chart added to PDF successfully with dimensions: ${image.scaledWidth}x${image.scaledHeight}")
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error adding chart to PDF: ${e.message}", e)
            Log.e(TAG, "❌ Exception type: ${e.javaClass.simpleName}")
            Log.e(TAG, "❌ Stack trace: ${e.stackTrace.take(5).joinToString("\n") { "  at $it" }}")
            
            // Thêm thông báo lỗi chi tiết vào PDF
            try {
                Log.d(TAG, "📝 Adding error message to PDF...")
                val errorMessage = "Không thể hiển thị biểu đồ.\nLỗi: ${e.javaClass.simpleName}\nChi tiết: ${e.message}"
                val errorParagraph = Paragraph(errorMessage, 
                    Font(getVietnameseFont(), 11f, Font.ITALIC, BaseColor.RED))
                errorParagraph.alignment = Element.ALIGN_CENTER
                errorParagraph.spacingBefore = 10f
                errorParagraph.spacingAfter = 10f
                document.add(errorParagraph)
                Log.d(TAG, "✅ Error message added to PDF")
            } catch (e2: Exception) {
                Log.e(TAG, "❌ Error adding error message to PDF: ${e2.message}", e2)
                // Fallback: thêm text đơn giản
                try {
                    document.add(Paragraph("Lỗi hiển thị biểu đồ"))
                } catch (e3: Exception) {
                    Log.e(TAG, "❌ Even fallback error message failed: ${e3.message}", e3)
                }
            }
        }
    }
    
    private fun getBitmapFromView(view: PieChart): Bitmap {
        try {
            Log.d(TAG, "🖼️ Creating bitmap from chart with dimensions: ${view.width}x${view.height}")
            
            // Kích thước tối ưu cho biểu đồ PDF (đủ lớn để hiển thị rõ ràng)
            val OPTIMAL_WIDTH = 1200
            val OPTIMAL_HEIGHT = 1200
            
            // Kiểm tra view có hợp lệ không
            if (view.data == null) {
                throw kotlin.Exception("Chart data is null")
            }
            
            if (view.data.entryCount <= 0) {
                throw kotlin.Exception("Chart has no data entries")
            }
            
            // Đảm bảo view có kích thước hợp lý
            if (view.width <= 0 || view.height <= 0) {
                Log.d(TAG, "📏 Chart has no dimensions, setting to optimal size")
                
                view.measure(
                    View.MeasureSpec.makeMeasureSpec(OPTIMAL_WIDTH, View.MeasureSpec.EXACTLY),
                    View.MeasureSpec.makeMeasureSpec(OPTIMAL_HEIGHT, View.MeasureSpec.EXACTLY)
                )
                view.layout(0, 0, OPTIMAL_WIDTH, OPTIMAL_HEIGHT)
                
                Log.d(TAG, "📏 Chart dimensions after layout: ${view.width}x${view.height}")
            }
            
            // Kiểm tra lại sau khi layout
            if (view.width <= 0 || view.height <= 0) {
                throw kotlin.Exception("Chart still has invalid dimensions after layout: ${view.width}x${view.height}")
            }
            
            // Sử dụng kích thước tối ưu để đảm bảo chất lượng bitmap
            val finalWidth = Math.max(view.width, OPTIMAL_WIDTH)
            val finalHeight = Math.max(view.height, OPTIMAL_HEIGHT)
            
            Log.d(TAG, "🖼️ Creating bitmap with optimal dimensions: ${finalWidth}x${finalHeight}")
            
            // Kiểm tra memory có đủ không
            val bytesNeeded = finalWidth * finalHeight * 4 // ARGB_8888 = 4 bytes per pixel
            val maxMemory = Runtime.getRuntime().maxMemory()
            val usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()
            val availableMemory = maxMemory - usedMemory
            
            Log.d(TAG, "💾 Memory check: need=${bytesNeeded/1024/1024}MB, available=${availableMemory/1024/1024}MB")
            
            if (bytesNeeded > availableMemory * 0.8) { // Chỉ dùng 80% memory available
                Log.w(TAG, "⚠️ Not enough memory, reducing bitmap size")
                val scale = Math.sqrt((availableMemory * 0.8) / bytesNeeded)
                val reducedWidth = (finalWidth * scale).toInt()
                val reducedHeight = (finalHeight * scale).toInt()
                Log.d(TAG, "📉 Reduced bitmap size to: ${reducedWidth}x${reducedHeight}")
                return createBitmapWithSize(view, reducedWidth, reducedHeight)
            }
            
            // Tạo bitmap với chất lượng cao
            val returnedBitmap = Bitmap.createBitmap(
                finalWidth,
                finalHeight,
                Bitmap.Config.ARGB_8888
            )
            
            Log.d(TAG, "✅ Bitmap created successfully: ${returnedBitmap.width}x${returnedBitmap.height}")
            
            // Tạo canvas và vẽ view lên bitmap
            val canvas = Canvas(returnedBitmap)
            canvas.drawColor(Color.WHITE) // Đảm bảo nền trắng
            
            Log.d(TAG, "🎨 Drawing chart on canvas...")
            
            // Nếu view nhỏ hơn bitmap, scale để fit
            if (view.width < finalWidth || view.height < finalHeight) {
                val scaleX = finalWidth.toFloat() / view.width
                val scaleY = finalHeight.toFloat() / view.height
                val scale = Math.min(scaleX, scaleY)
                
                Log.d(TAG, "📐 Scaling chart: scaleX=$scaleX, scaleY=$scaleY, finalScale=$scale")
                
                canvas.save()
                canvas.scale(scale, scale)
                
                // Center the chart
                val translateX = (finalWidth / scale - view.width) / 2
                val translateY = (finalHeight / scale - view.height) / 2
                canvas.translate(translateX, translateY)
                
                Log.d(TAG, "📍 Translating chart: translateX=$translateX, translateY=$translateY")
                
                // QUAN TRỌNG: Gọi draw method để render biểu đồ
                view.draw(canvas)
                canvas.restore()
                
                Log.d(TAG, "✅ Chart drawn to canvas with scaling")
            } else {
                // Draw directly without scaling
                Log.d(TAG, "✅ Chart drawn to canvas without scaling")
                view.draw(canvas)
            }
            
            Log.d(TAG, "✅ Chart rendered to bitmap successfully with dimensions: ${returnedBitmap.width}x${returnedBitmap.height}")
            
            // Kiểm tra bitmap có hợp lệ không
            if (returnedBitmap.isRecycled) {
                throw kotlin.Exception("Generated bitmap is recycled")
            }
            
            return returnedBitmap
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error creating bitmap from chart: ${e.message}", e)
            Log.e(TAG, "❌ Exception type: ${e.javaClass.simpleName}")
            Log.e(TAG, "❌ Chart data: ${view.data?.entryCount ?: 0} entries, value sum: ${view.data?.yValueSum ?: 0f}")
            
            // Nếu có lỗi, tạo một bitmap đơn giản với thông báo lỗi
            return createFallbackBitmap(e.message ?: "Unknown error")
        }
    }
    
    private fun createBitmapWithSize(view: PieChart, width: Int, height: Int): Bitmap {
        val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        val canvas = Canvas(bitmap)
        canvas.drawColor(Color.WHITE)
        
        val scaleX = width.toFloat() / view.width
        val scaleY = height.toFloat() / view.height
        val scale = Math.min(scaleX, scaleY)
        
        canvas.save()
        canvas.scale(scale, scale)
        
        val translateX = (width / scale - view.width) / 2
        val translateY = (height / scale - view.height) / 2
        canvas.translate(translateX, translateY)
        
        view.draw(canvas)
        canvas.restore()
        
        return bitmap
    }
    
    private fun createFallbackBitmap(errorMessage: String): Bitmap {
        try {
            val width = 800
            val height = 600
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            canvas.drawColor(Color.WHITE)
            
            val paint = Paint().apply {
                color = Color.RED
                textSize = 32f
                isAntiAlias = true
                textAlign = Paint.Align.CENTER
            }
            
            // Vẽ nhiều dòng text
            val lines = listOf(
                "Không thể hiển thị biểu đồ",
                "Lỗi: $errorMessage"
            )
            
            val lineHeight = paint.textSize * 1.2f
            val startY = height / 2f - (lines.size - 1) * lineHeight / 2f
            
            lines.forEachIndexed { index, line ->
                canvas.drawText(line, width / 2f, startY + index * lineHeight, paint)
            }
            
            Log.d(TAG, "✅ Fallback bitmap created with error message")
            return bitmap
        } catch (e2: Exception) {
            Log.e(TAG, "❌ Failed to create fallback bitmap: ${e2.message}", e2)
            // Tạo bitmap tối thiểu
            return Bitmap.createBitmap(100, 100, Bitmap.Config.ARGB_8888).apply {
                eraseColor(Color.WHITE)
            }
        }
    }
    
    private fun addStatisticsToPdf(
        document: Document,
        expenseData: List<CategoryExpenseDetail>?,
        incomeData: List<CategoryIncomeDetail>?,
        reportType: Int
    ) {
        try {
            Log.d(TAG, "📊 Adding statistics for reportType: $reportType")
            
            // Kiểm tra có dữ liệu không
            val hasExpenseData = !expenseData.isNullOrEmpty()
            val hasIncomeData = !incomeData.isNullOrEmpty()
            
            Log.d(TAG, "📊 Data availability - Expense: $hasExpenseData, Income: $hasIncomeData")
            
            // Nếu không có dữ liệu nào, vẫn hiển thị thống kê với giá trị 0
            if (!hasExpenseData && !hasIncomeData && reportType == TYPE_BOTH) {
                Log.d(TAG, "📊 No data available, showing zero statistics")
            }
            
            // Sử dụng font cho thống kê
            val baseFont = getVietnameseFont()
            val boldFont = getVietnameseBoldFont()
            val mediumFont = getVietnameseMediumFont()
            
            // Tạo font trực tiếp khi cần sử dụng
            val contentFont = Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK)
            val highlightFont = Font(mediumFont, 12f, Font.NORMAL, BaseColor(255, 128, 0))
            
            // Add section title với font tạo trực tiếp để đảm bảo Unicode
            val sectionTitle = when (reportType) {
                TYPE_EXPENSE -> Paragraph("THỐNG KÊ CHI TIÊU", 
                    Font(boldFont, 14f, Font.NORMAL, BaseColor(90, 90, 90)))
                TYPE_INCOME -> Paragraph("THỐNG KÊ THU NHẬP", 
                    Font(boldFont, 14f, Font.NORMAL, BaseColor(90, 90, 90)))
                else -> Paragraph("THỐNG KÊ TỔNG QUAN", 
                    Font(boldFont, 14f, Font.NORMAL, BaseColor(90, 90, 90)))
            }
            sectionTitle.spacingBefore = 15f
            sectionTitle.spacingAfter = 10f
            document.add(sectionTitle)
            
            // Create table for statistics
            val table = PdfPTable(2)
            table.widthPercentage = 100f
            table.setWidths(floatArrayOf(6f, 4f))
            
            // Add table headers - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
            addTableHeaderCell(table, "Thông tin", boldFont)
            addTableHeaderCell(table, "Số tiền (VND)", boldFont)
            
            // Add relevant statistics based on report type
            if (reportType == TYPE_EXPENSE) {
                val totalExpense = expenseData?.sumOf { it.totalAmount } ?: 0
                Log.d(TAG, "📊 Expense total: $totalExpense")
                
                // Add expense row - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
                val expenseCell = PdfPCell(
                    Phrase("Tổng chi tiêu", 
                        Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                )
                expenseCell.paddingLeft = 10f
                expenseCell.paddingTop = 8f
                expenseCell.paddingBottom = 8f
                expenseCell.borderColor = BaseColor(240, 240, 240)
                table.addCell(expenseCell)
                
                val expenseValueCell = PdfPCell(
                    Phrase(formatter.format(totalExpense), 
                        Font(mediumFont, 12f, Font.NORMAL, BaseColor(255, 128, 0)))
                )
                expenseValueCell.horizontalAlignment = Element.ALIGN_RIGHT
                expenseValueCell.paddingRight = 10f
                expenseValueCell.paddingTop = 8f
                expenseValueCell.paddingBottom = 8f
                expenseValueCell.borderColor = BaseColor(240, 240, 240)
                table.addCell(expenseValueCell)
                
                // Thêm thông tin về số lượng giao dịch nếu có dữ liệu
                if (hasExpenseData) {
                    val transactionCount = expenseData?.sumOf { it.listExpense?.size ?: 0 } ?: 0
                    Log.d(TAG, "📊 Expense transaction count: $transactionCount")
                    
                    val countCell = PdfPCell(
                        Phrase("Số giao dịch chi tiêu", 
                            Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                    )
                    countCell.paddingLeft = 10f
                    countCell.paddingTop = 8f
                    countCell.paddingBottom = 8f
                    countCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(countCell)
                    
                    val countValueCell = PdfPCell(
                        Phrase("$transactionCount giao dịch", 
                            Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                    )
                    countValueCell.horizontalAlignment = Element.ALIGN_RIGHT
                    countValueCell.paddingRight = 10f
                    countValueCell.paddingTop = 8f
                    countValueCell.paddingBottom = 8f
                    countValueCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(countValueCell)
                } else {
                    // Thêm thông báo không có dữ liệu
                    val noDataCell = PdfPCell(
                        Phrase("Trạng thái dữ liệu", 
                            Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                    )
                    noDataCell.paddingLeft = 10f
                    noDataCell.paddingTop = 8f
                    noDataCell.paddingBottom = 8f
                    noDataCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(noDataCell)
                    
                    val noDataValueCell = PdfPCell(
                        Phrase("Không có dữ liệu chi tiêu", 
                            Font(baseFont, 12f, Font.ITALIC, BaseColor.GRAY))
                    )
                    noDataValueCell.horizontalAlignment = Element.ALIGN_RIGHT
                    noDataValueCell.paddingRight = 10f
                    noDataValueCell.paddingTop = 8f
                    noDataValueCell.paddingBottom = 8f
                    noDataValueCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(noDataValueCell)
                }
            } else if (reportType == TYPE_INCOME) {
                val totalIncome = incomeData?.sumOf { it.totalAmount } ?: 0
                Log.d(TAG, "📊 Income total: $totalIncome")
                
                // Add income row - Đảm bảo dấu tiếng Việt hiển thị đầy đủ
                val incomeCell = PdfPCell(
                    Phrase("Tổng thu nhập", 
                        Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                )
                incomeCell.paddingLeft = 10f
                incomeCell.paddingTop = 8f
                incomeCell.paddingBottom = 8f
                incomeCell.borderColor = BaseColor(240, 240, 240)
                table.addCell(incomeCell)
                
                val incomeValueCell = PdfPCell(
                    Phrase(formatter.format(totalIncome), 
                        Font(mediumFont, 12f, Font.NORMAL, BaseColor(255, 128, 0)))
                )
                incomeValueCell.horizontalAlignment = Element.ALIGN_RIGHT
                incomeValueCell.paddingRight = 10f
                incomeValueCell.paddingTop = 8f
                incomeValueCell.paddingBottom = 8f
                incomeValueCell.borderColor = BaseColor(240, 240, 240)
                table.addCell(incomeValueCell)
                
                // Thêm thông tin về số lượng giao dịch nếu có dữ liệu
                if (hasIncomeData) {
                    val transactionCount = incomeData?.sumOf { it.listIncome?.size ?: 0 } ?: 0
                    Log.d(TAG, "📊 Income transaction count: $transactionCount")
                    
                    val countCell = PdfPCell(
                        Phrase("Số giao dịch thu nhập", 
                            Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                    )
                    countCell.paddingLeft = 10f
                    countCell.paddingTop = 8f
                    countCell.paddingBottom = 8f
                    countCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(countCell)
                    
                    val countValueCell = PdfPCell(
                        Phrase("$transactionCount giao dịch", 
                            Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                    )
                    countValueCell.horizontalAlignment = Element.ALIGN_RIGHT
                    countValueCell.paddingRight = 10f
                    countValueCell.paddingTop = 8f
                    countValueCell.paddingBottom = 8f
                    countValueCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(countValueCell)
                } else {
                    // Thêm thông báo không có dữ liệu
                    val noDataCell = PdfPCell(
                        Phrase("Trạng thái dữ liệu", 
                            Font(baseFont, 12f, Font.NORMAL, BaseColor.BLACK))
                    )
                    noDataCell.paddingLeft = 10f
                    noDataCell.paddingTop = 8f
                    noDataCell.paddingBottom = 8f
                    noDataCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(noDataCell)
                    
                    val noDataValueCell = PdfPCell(
                        Phrase("Không có dữ liệu thu nhập", 
                            Font(baseFont, 12f, Font.ITALIC, BaseColor.GRAY))
                    )
                    noDataValueCell.horizontalAlignment = Element.ALIGN_RIGHT
                    noDataValueCell.paddingRight = 10f
                    noDataValueCell.paddingTop = 8f
                    noDataValueCell.paddingBottom = 8f
                    noDataValueCell.borderColor = BaseColor(240, 240, 240)
                    table.addCell(noDataValueCell)
                }
            }
            
            document.add(table)
        } catch (e: Exception) {
            Log.e(TAG, "Error adding statistics: ${e.message}", e)
        }
    }
    
    private fun addDetailsToPdf(
        document: Document,
        expenseData: List<CategoryExpenseDetail>?,
        incomeData: List<CategoryIncomeDetail>?,
        reportType: Int
    ) {
        try {
            Log.d(TAG, "📋 Adding details for reportType: $reportType")
            
            // Kiểm tra có dữ liệu không
            val hasExpenseData = !expenseData.isNullOrEmpty()
            val hasIncomeData = !incomeData.isNullOrEmpty()
            
            Log.d(TAG, "📋 Data availability - Expense: $hasExpenseData, Income: $hasIncomeData")
            
            // Sử dụng font cho chi tiết
            val baseFont = getVietnameseFont()
            val boldFont = getVietnameseBoldFont()
            val mediumFont = getVietnameseMediumFont()
            
            // Không tạo sectionTitleFont để tránh lỗi encoding
            val contentFont = Font(baseFont, 10f, Font.NORMAL, BaseColor.BLACK)
            
            // Add Expense Details if needed
            if (reportType == TYPE_EXPENSE || reportType == TYPE_BOTH) {
                Log.d(TAG, "📋 Processing expense details section")
                
                if (hasExpenseData) {
                    Log.d(TAG, "📋 Adding expense details with data")
                } else {
                    Log.d(TAG, "📋 Adding expense details without data (showing empty state)")
                }
                // Tạo font trực tiếp để đảm bảo encoding Unicode đúng
                val expenseTitle = Paragraph("\nCHI TIẾT CHI TIÊU THEO DANH MỤC",
                    Font(boldFont, 14f, Font.NORMAL, BaseColor(90, 90, 90)))
                expenseTitle.spacingBefore = 20f
                expenseTitle.spacingAfter = 10f
                document.add(expenseTitle)
                
                if (hasExpenseData) {
                    // Add expense categories summary table
                    val categoryTable = PdfPTable(3)
                    categoryTable.widthPercentage = 100f
                    categoryTable.setWidths(floatArrayOf(1f, 5f, 3f))
                    
                    addTableHeaderCell(categoryTable, "STT", boldFont)
                    addTableHeaderCell(categoryTable, "Danh mục", boldFont)
                    addTableHeaderCell(categoryTable, "Tổng chi (VND)", boldFont)
                    
                    // Add category rows
                    expenseData!!.forEachIndexed { index, category ->
                        // STT column
                        val indexCell = PdfPCell(Phrase((index + 1).toString(), contentFont))
                        indexCell.horizontalAlignment = Element.ALIGN_CENTER
                        indexCell.paddingTop = 6f
                        indexCell.paddingBottom = 6f
                        indexCell.borderColor = BaseColor(240, 240, 240)
                        categoryTable.addCell(indexCell)
                        
                        // Category name column
                        val categoryCell = PdfPCell(Phrase(category.category?.title ?: "Không tên", contentFont))
                        categoryCell.paddingLeft = 10f
                        categoryCell.paddingTop = 6f
                        categoryCell.paddingBottom = 6f
                        categoryCell.borderColor = BaseColor(240, 240, 240)
                        categoryTable.addCell(categoryCell)
                        
                        // Amount column
                        val amountCell = PdfPCell(Phrase(formatter.format(category.totalAmount), contentFont))
                        amountCell.horizontalAlignment = Element.ALIGN_RIGHT
                        amountCell.paddingRight = 10f
                        amountCell.paddingTop = 6f
                        amountCell.paddingBottom = 6f
                        amountCell.borderColor = BaseColor(240, 240, 240)
                        categoryTable.addCell(amountCell)
                    }
                    
                    document.add(categoryTable)
                } else {
                    // Thêm thông báo không có dữ liệu
                    val noDataMessage = Paragraph(
                        "Không có dữ liệu chi tiêu trong khoảng thời gian đã chọn.",
                        Font(baseFont, 12f, Font.ITALIC, BaseColor.GRAY)
                    )
                    noDataMessage.alignment = Element.ALIGN_CENTER
                    noDataMessage.spacingBefore = 10f
                    noDataMessage.spacingAfter = 10f
                    document.add(noDataMessage)
                }
                
                // Add expense items detail tables for each category
                if (hasExpenseData) {
                    expenseData!!.forEach { category ->
                    if (!category.listExpense.isNullOrEmpty()) {
                        val detailTitle = Paragraph(
                            "\nChi tiết danh mục: ${category.category?.title ?: "Không tên"}",
                            Font(baseFont, 12f, Font.BOLD, BaseColor(90, 90, 90))
                        )
                        detailTitle.spacingBefore = 10f
                        detailTitle.spacingAfter = 5f
                        document.add(detailTitle)
                        
                        val detailTable = PdfPTable(4)
                        detailTable.widthPercentage = 100f
                        detailTable.setWidths(floatArrayOf(1f, 2f, 4f, 2f))
                        
                        // Đảm bảo header bảng chi tiết sử dụng font Unicode
                        addTableHeaderCell(detailTable, "STT", baseFont)
                        addTableHeaderCell(detailTable, "Ngày", baseFont)
                        addTableHeaderCell(detailTable, "Ghi chú", baseFont)
                        addTableHeaderCell(detailTable, "Số tiền (VND)", baseFont)
                        
                        // Add expense detail rows
                        category.listExpense?.forEachIndexed { index, expense ->
                            // STT column
                            val indexCell = PdfPCell(Phrase((index + 1).toString(), contentFont))
                            indexCell.horizontalAlignment = Element.ALIGN_CENTER
                            indexCell.paddingTop = 6f
                            indexCell.paddingBottom = 6f
                            indexCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(indexCell)
                            
                            // Date column
                            val dateString = try {
                                val date = LocalDate.parse(expense.date, DateTimeFormatter.ISO_DATE)
                                date.format(dateFormatter)
                            } catch (e: Exception) {
                                Log.e(TAG, "Error parsing date: ${expense.date}, error: ${e.message}")
                                expense.date ?: ""
                            }
                            
                            val dateCell = PdfPCell(Phrase(dateString, contentFont))
                            dateCell.horizontalAlignment = Element.ALIGN_CENTER
                            dateCell.paddingTop = 6f
                            dateCell.paddingBottom = 6f
                            dateCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(dateCell)
                            
                            // Note column
                            val noteCell = PdfPCell(Phrase(expense.note ?: "", contentFont))
                            noteCell.paddingLeft = 10f
                            noteCell.paddingTop = 6f
                            noteCell.paddingBottom = 6f
                            noteCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(noteCell)
                            
                            // Amount column
                            val amountCell = PdfPCell(Phrase(formatter.format(expense.expense ?: 0), contentFont))
                            amountCell.horizontalAlignment = Element.ALIGN_RIGHT
                            amountCell.paddingRight = 10f
                            amountCell.paddingTop = 6f
                            amountCell.paddingBottom = 6f
                            amountCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(amountCell)
                        }
                        
                        document.add(detailTable)
                    }
                    }
                }
            }
            
            // Add Income Details if needed
            if (reportType == TYPE_INCOME || reportType == TYPE_BOTH) {
                Log.d(TAG, "📋 Processing income details section")
                
                if (hasIncomeData) {
                    Log.d(TAG, "📋 Adding income details with data")
                } else {
                    Log.d(TAG, "📋 Adding income details without data (showing empty state)")
                }
                // Tạo font trực tiếp để đảm bảo encoding Unicode đúng
                val incomeTitle = Paragraph("\nCHI TIẾT THU NHẬP THEO DANH MỤC",
                    Font(boldFont, 14f, Font.NORMAL, BaseColor(90, 90, 90)))
                incomeTitle.spacingBefore = 20f
                incomeTitle.spacingAfter = 10f
                document.add(incomeTitle)
                
                if (hasIncomeData) {
                    // Add income categories summary table
                    val categoryTable = PdfPTable(3)
                    categoryTable.widthPercentage = 100f
                    categoryTable.setWidths(floatArrayOf(1f, 5f, 3f))
                    
                    addTableHeaderCell(categoryTable, "STT", baseFont)
                    addTableHeaderCell(categoryTable, "Danh mục", baseFont)
                    addTableHeaderCell(categoryTable, "Tổng thu (VND)", baseFont)
                    
                    // Add category rows
                    incomeData!!.forEachIndexed { index, category ->
                        // STT column
                        val indexCell = PdfPCell(Phrase((index + 1).toString(), contentFont))
                        indexCell.horizontalAlignment = Element.ALIGN_CENTER
                        indexCell.paddingTop = 6f
                        indexCell.paddingBottom = 6f
                        indexCell.borderColor = BaseColor(240, 240, 240)
                        categoryTable.addCell(indexCell)
                        
                        // Category name column
                        val categoryCell = PdfPCell(Phrase(category.category?.title ?: "Không tên", contentFont))
                        categoryCell.paddingLeft = 10f
                        categoryCell.paddingTop = 6f
                        categoryCell.paddingBottom = 6f
                        categoryCell.borderColor = BaseColor(240, 240, 240)
                        categoryTable.addCell(categoryCell)
                        
                        // Amount column
                        val amountCell = PdfPCell(Phrase(formatter.format(category.totalAmount), contentFont))
                        amountCell.horizontalAlignment = Element.ALIGN_RIGHT
                        amountCell.paddingRight = 10f
                        amountCell.paddingTop = 6f
                        amountCell.paddingBottom = 6f
                        amountCell.borderColor = BaseColor(240, 240, 240)
                        categoryTable.addCell(amountCell)
                    }
                    
                    document.add(categoryTable)
                } else {
                    // Thêm thông báo không có dữ liệu
                    val noDataMessage = Paragraph(
                        "Không có dữ liệu thu nhập trong khoảng thời gian đã chọn.",
                        Font(baseFont, 12f, Font.ITALIC, BaseColor.GRAY)
                    )
                    noDataMessage.alignment = Element.ALIGN_CENTER
                    noDataMessage.spacingBefore = 10f
                    noDataMessage.spacingAfter = 10f
                    document.add(noDataMessage)
                }
                
                // Add income items detail tables for each category
                if (hasIncomeData) {
                    incomeData!!.forEach { category ->
                    if (!category.listIncome.isNullOrEmpty()) {
                        val detailTitle = Paragraph(
                            "\nChi tiết danh mục: ${category.category?.title ?: "Không tên"}",
                            Font(baseFont, 12f, Font.BOLD, BaseColor(90, 90, 90))
                        )
                        detailTitle.spacingBefore = 10f
                        detailTitle.spacingAfter = 5f
                        document.add(detailTitle)
                        
                        val detailTable = PdfPTable(4)
                        detailTable.widthPercentage = 100f
                        detailTable.setWidths(floatArrayOf(1f, 2f, 4f, 2f))
                        
                        // Đảm bảo header bảng chi tiết sử dụng font Unicode
                        addTableHeaderCell(detailTable, "STT", baseFont)
                        addTableHeaderCell(detailTable, "Ngày", baseFont)
                        addTableHeaderCell(detailTable, "Ghi chú", baseFont)
                        addTableHeaderCell(detailTable, "Số tiền (VND)", baseFont)
                        
                        // Add income detail rows
                        category.listIncome?.forEachIndexed { index, income ->
                            // STT column
                            val indexCell = PdfPCell(Phrase((index + 1).toString(), contentFont))
                            indexCell.horizontalAlignment = Element.ALIGN_CENTER
                            indexCell.paddingTop = 6f
                            indexCell.paddingBottom = 6f
                            indexCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(indexCell)
                            
                            // Date column
                            val dateString = try {
                                val date = LocalDate.parse(income.date, DateTimeFormatter.ISO_DATE)
                                date.format(dateFormatter)
                            } catch (e: Exception) {
                                Log.e(TAG, "Error parsing date: ${income.date}, error: ${e.message}")
                                income.date ?: ""
                            }
                            
                            val dateCell = PdfPCell(Phrase(dateString, contentFont))
                            dateCell.horizontalAlignment = Element.ALIGN_CENTER
                            dateCell.paddingTop = 6f
                            dateCell.paddingBottom = 6f
                            dateCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(dateCell)
                            
                            // Note column
                            val noteCell = PdfPCell(Phrase(income.note ?: "", contentFont))
                            noteCell.paddingLeft = 10f
                            noteCell.paddingTop = 6f
                            noteCell.paddingBottom = 6f
                            noteCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(noteCell)
                            
                            // Amount column
                            val amountCell = PdfPCell(Phrase(formatter.format(income.income ?: 0), contentFont))
                            amountCell.horizontalAlignment = Element.ALIGN_RIGHT
                            amountCell.paddingRight = 10f
                            amountCell.paddingTop = 6f
                            amountCell.paddingBottom = 6f
                            amountCell.borderColor = BaseColor(240, 240, 240)
                            detailTable.addCell(amountCell)
                        }
                        
                        document.add(detailTable)
                    }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(TAG, "Error adding details: ${e.message}", e)
        }
    }
    
    private fun addTableHeaderCell(table: PdfPTable, text: String, boldFont: BaseFont) {
        // Tạo font trực tiếp để đảm bảo encoding Unicode đúng cho tiêu đề bảng
        val cell = PdfPCell(
            Phrase(text, 
                Font(boldFont, 10f, Font.NORMAL, BaseColor.WHITE))
        )
        cell.backgroundColor = BaseColor(255, 128, 0)
        cell.horizontalAlignment = Element.ALIGN_CENTER
        cell.paddingTop = 6f
        cell.paddingBottom = 6f
        cell.borderColor = BaseColor(240, 240, 240)
        table.addCell(cell)
    }
    
    /**
     * Open the generated PDF file
     */
    fun openPdfFile(uri: Uri) {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            setDataAndType(uri, "application/pdf")
            flags = Intent.FLAG_ACTIVITY_NO_HISTORY or
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
        }
        
        try {
            context.startActivity(intent)
        } catch (e: Exception) {
            Log.e(TAG, "No PDF viewer app found: ${e.message}", e)
        }
    }
    
    /**
     * Get a font that supports Vietnamese characters
     */
    private fun getVietnameseFont(): BaseFont {
        return getMontserratFont("montserrat_regular.ttf")
    }
    
    /**
     * Get Montserrat bold font
     */
    private fun getVietnameseBoldFont(): BaseFont {
        return getMontserratFont("montserrat_bold.ttf")
    }
    
    /**
     * Get Montserrat medium font
     */
    private fun getVietnameseMediumFont(): BaseFont {
        return getMontserratFont("montserrat_medium.ttf")
    }
    
    /**
     * Get Montserrat italic font
     */
    private fun getVietnameseItalicFont(): BaseFont {
        return getMontserratFont("montserrat_italic.ttf")
    }
    
    /**
     * Helper method to load Montserrat font variants from assets
     * Đảm bảo font hỗ trợ đầy đủ các ký tự Unicode tiếng Việt
     */
    private fun getMontserratFont(fontName: String): BaseFont {
        try {
            Log.d(TAG, "🔤 Loading font: $fontName")
            
            // Kiểm tra font file tồn tại trong assets
            val assetManager = context.assets
            try {
                val inputStream = assetManager.open("fonts/$fontName")
                inputStream.close()
                Log.d(TAG, "✅ Font file exists in assets: fonts/$fontName")
            } catch (e: Exception) {
                Log.e(TAG, "❌ Font file not found in assets: fonts/$fontName", e)
                throw kotlin.Exception("Font file not found: $fontName")
            }
            
            // Phương pháp ưu tiên: Copy font vào cache và sử dụng đường dẫn file thực
            val tempFile = File(context.cacheDir, fontName)
            
            // Chỉ copy lại nếu file chưa tồn tại hoặc bị lỗi
            if (!tempFile.exists() || tempFile.length() == 0L) {
                try {
                    Log.d(TAG, "📁 Copying font to cache: ${tempFile.absolutePath}")
                    val inputStream = assetManager.open("fonts/$fontName")
                    tempFile.outputStream().use { output ->
                        inputStream.copyTo(output)
                    }
                    inputStream.close()
                    Log.d(TAG, "✅ Font file copied successfully. Size: ${tempFile.length()} bytes")
                } catch (e: Exception) {
                    Log.e(TAG, "❌ Error copying font file to cache: ${e.message}", e)
                    throw e
                }
            } else {
                Log.d(TAG, "✅ Font file already exists in cache. Size: ${tempFile.length()} bytes")
            }
            
            // Kiểm tra file đã được copy thành công
            if (!tempFile.exists() || tempFile.length() == 0L) {
                throw kotlin.Exception("Font file copy failed or empty: ${tempFile.absolutePath}")
            }
            
            // Sử dụng đường dẫn file thực với IDENTITY_H để hỗ trợ đầy đủ Unicode
            Log.d(TAG, "🔧 Creating BaseFont with IDENTITY_H encoding...")
            val baseFont = BaseFont.createFont(
                tempFile.absolutePath,
                BaseFont.IDENTITY_H,  // Mã hóa Unicode cho tiếng Việt
                BaseFont.EMBEDDED     // Đảm bảo font được nhúng vào PDF
            )
            
            Log.d(TAG, "✅ Successfully loaded font: $fontName using IDENTITY_H from file path")
            
            // Test font với text tiếng Việt để đảm bảo hoạt động
            val testText = "Tiếng Việt có dấu: Tết đến, Xuân về"
            Log.d(TAG, "🧪 Testing font with Vietnamese text: $testText")
            
            return baseFont
        } catch (e: Exception) {
            Log.e(TAG, "❌ Error loading font $fontName with file path: ${e.message}", e)
            
            // Phương pháp backup: Sử dụng ByteArray với IDENTITY_H
            try {
                Log.d(TAG, "🔄 Trying backup method with byte array for font: $fontName")
                val inputStream = context.assets.open("fonts/$fontName")
                val bytes = inputStream.readBytes()
                inputStream.close()
                
                if (bytes.isEmpty()) {
                    throw kotlin.Exception("Font file is empty: $fontName")
                }
                
                Log.d(TAG, "📦 Font bytes loaded. Size: ${bytes.size} bytes")
                
                val baseFont = BaseFont.createFont(
                    fontName,
                    BaseFont.IDENTITY_H,  // Vẫn sử dụng IDENTITY_H cho Unicode
                    BaseFont.EMBEDDED,
                    true,
                    bytes,
                    null
                )
                Log.d(TAG, "✅ Successfully loaded font: $fontName using IDENTITY_H and byte array")
                return baseFont
            } catch (e2: Exception) {
                Log.e(TAG, "❌ Error loading font with IDENTITY_H from bytes: ${e2.message}", e2)
                
                // Fallback cuối cùng: Sử dụng font hệ thống với IDENTITY_H
                Log.w(TAG, "⚠️ Using system font as fallback for: $fontName")
                return try {
                    when {
                        fontName.contains("bold", ignoreCase = true) -> {
                            BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
                        }
                        fontName.contains("italic", ignoreCase = true) -> {
                            BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
                        }
                        else -> {
                            BaseFont.createFont(BaseFont.HELVETICA, BaseFont.IDENTITY_H, BaseFont.EMBEDDED)
                        }
                    }
                } catch (e3: Exception) {
                    Log.e(TAG, "❌ Even system font failed with IDENTITY_H: ${e3.message}", e3)
                    // Fallback cuối cùng: sử dụng CP1252 cho system font
                    when {
                        fontName.contains("bold", ignoreCase = true) -> {
                            BaseFont.createFont(BaseFont.HELVETICA_BOLD, BaseFont.CP1252, BaseFont.EMBEDDED)
                        }
                        fontName.contains("italic", ignoreCase = true) -> {
                            BaseFont.createFont(BaseFont.HELVETICA_OBLIQUE, BaseFont.CP1252, BaseFont.EMBEDDED)
                        }
                        else -> {
                            BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.EMBEDDED)
                        }
                    }
                }
            }
        }
    }
} 