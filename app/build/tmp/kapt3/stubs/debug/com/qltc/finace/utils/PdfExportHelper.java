package com.qltc.finace.utils;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.core.content.FileProvider;
import com.github.mikephil.charting.charts.PieChart;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.qltc.finace.R;
import com.qltc.finace.data.entity.CategoryExpenseDetail;
import com.qltc.finace.data.entity.CategoryIncomeDetail;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u0000 A2\u00020\u0001:\u0001AB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J8\u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J(\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J0\u0010\u001f\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u0015H\u0002J\\\u0010 \u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0010H\u0002J8\u0010$\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\'2\u0006\u0010(\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*H\u0002J \u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00102\u0006\u0010.\u001a\u00020\u001a2\u0006\u0010/\u001a\u00020\u001aH\u0002J\u0010\u00100\u001a\u00020,2\u0006\u00101\u001a\u00020\u0012H\u0002Jl\u00102\u001a\u0004\u0018\u0001032\u0006\u00104\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0010Jl\u00105\u001a\u0004\u0018\u0001032\u0006\u00106\u001a\u0002072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010!\u001a\u00020\u001a2\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00152\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u0010J\u0010\u00108\u001a\u00020,2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0010\u00109\u001a\u00020*2\u0006\u0010:\u001a\u00020\u0012H\u0002J\b\u0010;\u001a\u00020*H\u0002J\b\u0010<\u001a\u00020*H\u0002J\b\u0010=\u001a\u00020*H\u0002J\b\u0010>\u001a\u00020*H\u0002J\u000e\u0010?\u001a\u00020\f2\u0006\u0010@\u001a\u000203R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006B"}, d2 = {"Lcom/qltc/finace/utils/PdfExportHelper;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dateFormatter", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "formatter", "Ljava/text/NumberFormat;", "monthYearFormatter", "addChartToPdf", "", "document", "Lcom/itextpdf/text/Document;", "chart", "Lcom/github/mikephil/charting/charts/PieChart;", "title", "", "addDetailsToPdf", "expenseData", "", "Lcom/qltc/finace/data/entity/CategoryExpenseDetail;", "incomeData", "Lcom/qltc/finace/data/entity/CategoryIncomeDetail;", "reportType", "", "addDocumentHeader", "startDate", "Ljava/time/LocalDate;", "endDate", "addOverviewStatistics", "addReportContent", "displayOptions", "expensePieChart", "incomePieChart", "addStatisticsToPdf", "addTableHeaderCell", "table", "Lcom/itextpdf/text/pdf/PdfPTable;", "text", "boldFont", "Lcom/itextpdf/text/pdf/BaseFont;", "createBitmapWithSize", "Landroid/graphics/Bitmap;", "view", "width", "height", "createFallbackBitmap", "errorMessage", "createPdfReport", "Landroid/net/Uri;", "fileName", "createPdfReportWithMediaStore", "contentValues", "Landroid/content/ContentValues;", "getBitmapFromView", "getMontserratFont", "fontName", "getVietnameseBoldFont", "getVietnameseFont", "getVietnameseItalicFont", "getVietnameseMediumFont", "openPdfFile", "uri", "Companion", "app_debug"})
public final class PdfExportHelper {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "PdfExportHelper";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String FILE_PROVIDER_AUTHORITY = "com.qltc.finace.fileprovider";
    public static final int TYPE_EXPENSE = 0;
    public static final int TYPE_INCOME = 1;
    public static final int TYPE_BOTH = 2;
    public static final int OPTION_SHOW_CHARTS = 1;
    public static final int OPTION_SHOW_DETAILS = 2;
    public static final int OPTION_SHOW_STATISTICS = 4;
    private final java.text.NumberFormat formatter = null;
    private final java.time.format.DateTimeFormatter dateFormatter = null;
    private final java.time.format.DateTimeFormatter monthYearFormatter = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.utils.PdfExportHelper.Companion Companion = null;
    
    public PdfExportHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
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
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri createPdfReport(@org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate endDate, int reportType, int displayOptions, @org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> expenseData, @org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> incomeData, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.charts.PieChart expensePieChart, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.charts.PieChart incomePieChart) {
        return null;
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
    @org.jetbrains.annotations.Nullable()
    public final android.net.Uri createPdfReportWithMediaStore(@org.jetbrains.annotations.NotNull()
    android.content.ContentValues contentValues, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate endDate, int reportType, int displayOptions, @org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> expenseData, @org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> incomeData, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.charts.PieChart expensePieChart, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.charts.PieChart incomePieChart) {
        return null;
    }
    
    /**
     * Add report content to PDF document in the correct order based on report type
     */
    private final void addReportContent(com.itextpdf.text.Document document, int reportType, int displayOptions, java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> expenseData, java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> incomeData, com.github.mikephil.charting.charts.PieChart expensePieChart, com.github.mikephil.charting.charts.PieChart incomePieChart) {
    }
    
    /**
     * Add overview statistics including total expense, income and balance
     */
    private final void addOverviewStatistics(com.itextpdf.text.Document document, java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> expenseData, java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> incomeData) {
    }
    
    private final void addDocumentHeader(com.itextpdf.text.Document document, java.time.LocalDate startDate, java.time.LocalDate endDate, int reportType) {
    }
    
    private final void addChartToPdf(com.itextpdf.text.Document document, com.github.mikephil.charting.charts.PieChart chart, java.lang.String title) {
    }
    
    private final android.graphics.Bitmap getBitmapFromView(com.github.mikephil.charting.charts.PieChart view) {
        return null;
    }
    
    private final android.graphics.Bitmap createBitmapWithSize(com.github.mikephil.charting.charts.PieChart view, int width, int height) {
        return null;
    }
    
    private final android.graphics.Bitmap createFallbackBitmap(java.lang.String errorMessage) {
        return null;
    }
    
    private final void addStatisticsToPdf(com.itextpdf.text.Document document, java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> expenseData, java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> incomeData, int reportType) {
    }
    
    private final void addDetailsToPdf(com.itextpdf.text.Document document, java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> expenseData, java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> incomeData, int reportType) {
    }
    
    private final void addTableHeaderCell(com.itextpdf.text.pdf.PdfPTable table, java.lang.String text, com.itextpdf.text.pdf.BaseFont boldFont) {
    }
    
    /**
     * Open the generated PDF file
     */
    public final void openPdfFile(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri) {
    }
    
    /**
     * Get a font that supports Vietnamese characters
     */
    private final com.itextpdf.text.pdf.BaseFont getVietnameseFont() {
        return null;
    }
    
    /**
     * Get Montserrat bold font
     */
    private final com.itextpdf.text.pdf.BaseFont getVietnameseBoldFont() {
        return null;
    }
    
    /**
     * Get Montserrat medium font
     */
    private final com.itextpdf.text.pdf.BaseFont getVietnameseMediumFont() {
        return null;
    }
    
    /**
     * Get Montserrat italic font
     */
    private final com.itextpdf.text.pdf.BaseFont getVietnameseItalicFont() {
        return null;
    }
    
    /**
     * Helper method to load Montserrat font variants from assets
     * Đảm bảo font hỗ trợ đầy đủ các ký tự Unicode tiếng Việt
     */
    private final com.itextpdf.text.pdf.BaseFont getMontserratFont(java.lang.String fontName) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/qltc/finace/utils/PdfExportHelper$Companion;", "", "()V", "FILE_PROVIDER_AUTHORITY", "", "OPTION_SHOW_CHARTS", "", "OPTION_SHOW_DETAILS", "OPTION_SHOW_STATISTICS", "TAG", "TYPE_BOTH", "TYPE_EXPENSE", "TYPE_INCOME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}