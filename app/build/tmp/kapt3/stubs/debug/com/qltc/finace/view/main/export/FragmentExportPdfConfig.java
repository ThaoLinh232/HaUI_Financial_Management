package com.qltc.finace.view.main.export;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.databinding.FragmentExportPdfConfigBinding;
import com.qltc.finace.utils.PdfExportHelper;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import android.util.Log;
import android.widget.NumberPicker;
import java.util.Calendar;
import android.graphics.drawable.ColorDrawable;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import java.time.LocalDateTime;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.qltc.finace.data.entity.CategoryExpenseDetail;
import com.qltc.finace.data.entity.CategoryIncomeDetail;
import com.qltc.finace.view.main.report.chart.PercentFormatter;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.FrameLayout;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0007\u0018\u0000 ;2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001;B\u0005\u00a2\u0006\u0002\u0010\u0005J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u001e\u0010\u001a\u001a\u00020\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u000eH\u0002J\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u0011H\u0002J\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\b\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020$H\u0016J\b\u0010&\u001a\u00020$H\u0016J\u001a\u0010\'\u001a\u00020$2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u0010\u0010,\u001a\u00020$2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020$H\u0002J\b\u00100\u001a\u00020$H\u0002J\b\u00101\u001a\u00020$H\u0002J\b\u00102\u001a\u000203H\u0002J\u0014\u00104\u001a\u00020$*\u0002052\u0006\u00106\u001a\u00020\tH\u0002J\u0014\u00107\u001a\u00020$*\u0002052\u0006\u00106\u001a\u00020\tH\u0002J\u0014\u00108\u001a\u00020$*\u0002052\u0006\u00109\u001a\u00020:H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0012\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006<"}, d2 = {"Lcom/qltc/finace/view/main/export/FragmentExportPdfConfig;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentExportPdfConfigBinding;", "Lcom/qltc/finace/view/main/export/ExportPdfViewModel;", "Lcom/qltc/finace/view/main/export/ExportPdfListener;", "()V", "currentTime", "Ljava/time/LocalDateTime;", "layoutID", "", "getLayoutID", "()I", "monthNames", "", "", "[Ljava/lang/String;", "selectedMonth", "Ljava/time/YearMonth;", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/export/ExportPdfViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "createExpensePieChart", "Lcom/github/mikephil/charting/charts/PieChart;", "month", "createFormattedPieChart", "pieEntries", "", "Lcom/github/mikephil/charting/data/PieEntry;", "centerText", "createIncomePieChart", "generateDefaultFileName", "startDate", "Ljava/time/LocalDate;", "generatePDF", "", "onBackClicked", "onExportPdfClicked", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openAndSharePdf", "uri", "Landroid/net/Uri;", "setupInlineMonthYearPickers", "setupObservers", "updateDefaultFileName", "validateFileName", "", "setDividerColor", "Landroid/widget/NumberPicker;", "color", "setTextColor", "setTextSize", "size", "", "Companion", "app_debug"})
public final class FragmentExportPdfConfig extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentExportPdfConfigBinding, com.qltc.finace.view.main.export.ExportPdfViewModel> implements com.qltc.finace.view.main.export.ExportPdfListener {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "FragmentExportPdfConfig";
    private static final int MIN_YEAR = 2015;
    private static final int MAX_YEAR = 0;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_export_pdf_config;
    @org.jetbrains.annotations.NotNull()
    private java.time.YearMonth selectedMonth;
    private java.time.LocalDateTime currentTime;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] monthNames = {"Th\u00e1ng 1", "Th\u00e1ng 2", "Th\u00e1ng 3", "Th\u00e1ng 4", "Th\u00e1ng 5", "Th\u00e1ng 6", "Th\u00e1ng 7", "Th\u00e1ng 8", "Th\u00e1ng 9", "Th\u00e1ng 10", "Th\u00e1ng 11", "Th\u00e1ng 12"};
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.export.FragmentExportPdfConfig.Companion Companion = null;
    
    public FragmentExportPdfConfig() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.export.ExportPdfViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    /**
     * Tạo tên file mặc định cho báo cáo PDF
     *
     * @param startDate Ngày bắt đầu khoảng thời gian báo cáo
     * @param currentTime Thời điểm hiện tại
     * @return Tên file theo định dạng "Báo cáo thu chi_MMYYYY_ddMMyyyyHHmmss.pdf"
     */
    private final java.lang.String generateDefaultFileName(java.time.LocalDate startDate, java.time.LocalDateTime currentTime) {
        return null;
    }
    
    /**
     * Cập nhật tên file mặc định khi thay đổi tháng
     */
    private final void updateDefaultFileName() {
    }
    
    private final void setupInlineMonthYearPickers() {
    }
    
    private final void setDividerColor(android.widget.NumberPicker $this$setDividerColor, int color) {
    }
    
    private final void setTextColor(android.widget.NumberPicker $this$setTextColor, int color) {
    }
    
    private final void setTextSize(android.widget.NumberPicker $this$setTextSize, float size) {
    }
    
    private final void setupObservers() {
    }
    
    private final void openAndSharePdf(android.net.Uri uri) {
    }
    
    @java.lang.Override()
    public void onExportPdfClicked() {
    }
    
    private final boolean validateFileName() {
        return false;
    }
    
    private final void generatePDF() {
    }
    
    /**
     * Tạo biểu đồ chi tiêu cho tháng được chọn
     */
    private final com.github.mikephil.charting.charts.PieChart createExpensePieChart(java.time.YearMonth month) {
        return null;
    }
    
    /**
     * Tạo biểu đồ thu nhập cho tháng được chọn
     */
    private final com.github.mikephil.charting.charts.PieChart createIncomePieChart(java.time.YearMonth month) {
        return null;
    }
    
    /**
     * Tạo và định dạng biểu đồ PieChart với entries và tiêu đề đã cho
     */
    private final com.github.mikephil.charting.charts.PieChart createFormattedPieChart(java.util.List<? extends com.github.mikephil.charting.data.PieEntry> pieEntries, java.lang.String centerText) {
        return null;
    }
    
    @java.lang.Override()
    public void onBackClicked() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/qltc/finace/view/main/export/FragmentExportPdfConfig$Companion;", "", "()V", "MAX_YEAR", "", "MIN_YEAR", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}