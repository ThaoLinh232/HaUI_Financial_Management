package com.qltc.finace.view.main.export;

import android.content.ContentValues;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.github.mikephil.charting.charts.PieChart;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.base.SingleLiveData;
import com.qltc.finace.data.entity.CategoryExpenseDetail;
import com.qltc.finace.data.entity.CategoryIncomeDetail;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import com.qltc.finace.utils.PdfExportHelper;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import java.io.IOException;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJF\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020/2\n\b\u0002\u00101\u001a\u0004\u0018\u0001022\n\b\u0002\u00103\u001a\u0004\u0018\u000102J\u0016\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00122\u0006\u0010,\u001a\u00020-J\u0016\u00106\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010\u00122\u0006\u0010,\u001a\u00020-J\b\u00108\u001a\u00020(H\u0002J\b\u00109\u001a\u00020(H\u0014J\u0006\u0010:\u001a\u00020(R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000e0\u000e0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00180\u0015X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000e0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010 R\u001d\u0010#\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00130\u00120\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0019\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010 \u00a8\u0006<"}, d2 = {"Lcom/qltc/finace/view/main/export/ExportPdfViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "incomeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;Lcom/qltc/finace/data/repository/local/income/InComeRepository;Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "_errorMessage", "Landroidx/lifecycle/MutableLiveData;", "", "_isDataReady", "Lcom/qltc/finace/base/SingleLiveData;", "", "_isLoading", "kotlin.jvm.PlatformType", "_listCategory", "", "Lcom/qltc/finace/data/entity/Category;", "_listExpense", "", "Lcom/qltc/finace/data/entity/Expense;", "_listIncome", "Lcom/qltc/finace/data/entity/Income;", "_pdfGenerationResult", "Landroid/net/Uri;", "currentJob", "Lkotlinx/coroutines/Job;", "errorMessage", "Landroidx/lifecycle/LiveData;", "getErrorMessage", "()Landroidx/lifecycle/LiveData;", "isDataReady", "isLoading", "listCategory", "getListCategory", "pdfGenerationResult", "getPdfGenerationResult", "generatePdf", "", "context", "Landroid/content/Context;", "fileName", "month", "Ljava/time/YearMonth;", "reportType", "", "displayOptions", "expensePieChart", "Lcom/github/mikephil/charting/charts/PieChart;", "incomePieChart", "getExpenseDataForMonth", "Lcom/qltc/finace/data/entity/CategoryExpenseDetail;", "getIncomeDataForMonth", "Lcom/qltc/finace/data/entity/CategoryIncomeDetail;", "loadAllData", "onCleared", "refreshData", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ExportPdfViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.base.SingleLiveData<android.net.Uri> _pdfGenerationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<android.net.Uri> pdfGenerationResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> errorMessage = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.Category>> _listCategory = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.qltc.finace.data.entity.Category>> listCategory = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Expense> _listExpense;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Income> _listIncome;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.base.SingleLiveData<java.lang.Boolean> _isDataReady = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isDataReady = null;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job currentJob;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "ExportPdfViewModel";
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.export.ExportPdfViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public ExportPdfViewModel(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<android.net.Uri> getPdfGenerationResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getErrorMessage() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.qltc.finace.data.entity.Category>> getListCategory() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isDataReady() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCleared() {
    }
    
    private final void loadAllData() {
    }
    
    public final void generatePdf(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName, @org.jetbrains.annotations.NotNull()
    java.time.YearMonth month, int reportType, int displayOptions, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.charts.PieChart expensePieChart, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.charts.PieChart incomePieChart) {
    }
    
    public final void refreshData() {
    }
    
    /**
     * Lấy dữ liệu chi tiêu cho tháng được chọn
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> getExpenseDataForMonth(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth month) {
        return null;
    }
    
    /**
     * Lấy dữ liệu thu nhập cho tháng được chọn
     */
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> getIncomeDataForMonth(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth month) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/qltc/finace/view/main/export/ExportPdfViewModel$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}