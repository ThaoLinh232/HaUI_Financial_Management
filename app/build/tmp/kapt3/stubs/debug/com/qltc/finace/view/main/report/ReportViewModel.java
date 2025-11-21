package com.qltc.finace.view.main.report;

import android.content.Context;
import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.github.mikephil.charting.data.PieEntry;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.base.SingleLiveData;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.entity.CategoryExpenseDetail;
import com.qltc.finace.data.entity.CategoryIncomeDetail;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.CategoryOverView;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import java.time.LocalDate;
import java.time.YearMonth;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u00b4\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0013\b\u0007\u0018\u0000 u2\u00020\u0001:\u0001uB)\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nJ\u001c\u0010P\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002070\u0013H\u0002J\u0018\u0010R\u001a\u0004\u0018\u00010\u00142\f\u0010S\u001a\b\u0012\u0004\u0012\u0002070\u0013H\u0002J\u001c\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\f\u0010U\u001a\b\u0012\u0004\u0012\u00020V0\u0013H\u0002J\u0018\u0010W\u001a\u0004\u0018\u00010\u00142\f\u0010S\u001a\b\u0012\u0004\u0012\u00020V0\u0013H\u0002J\b\u0010X\u001a\u00020YH\u0002J\u000e\u0010Z\u001a\u00020D2\u0006\u0010[\u001a\u00020\\J\u000e\u0010]\u001a\u00020Y2\u0006\u0010[\u001a\u00020\\J\u001a\u0010^\u001a\u00020Y2\u0012\u0010_\u001a\u000e\u0012\u0004\u0012\u00020M\u0012\u0004\u0012\u00020Y0`J\u0010\u0010a\u001a\u0004\u0018\u0001072\u0006\u0010b\u001a\u00020cJ\u0012\u0010d\u001a\u0002012\b\u0010e\u001a\u0004\u0018\u00010cH\u0002J\u0016\u0010f\u001a\b\u0012\u0004\u0012\u00020;0E2\u0006\u0010g\u001a\u000201H\u0002J\u0016\u0010h\u001a\b\u0012\u0004\u0012\u00020;0E2\u0006\u0010[\u001a\u00020\\H\u0002J\u0016\u0010i\u001a\b\u0012\u0004\u0012\u0002070\u00132\u0006\u0010[\u001a\u00020\\H\u0002J\u001c\u0010j\u001a\b\u0012\u0004\u0012\u00020;0E2\u0006\u0010b\u001a\u00020c2\u0006\u0010k\u001a\u00020\\J\u0016\u0010l\u001a\b\u0012\u0004\u0012\u00020?0E2\u0006\u0010g\u001a\u000201H\u0002J\u0016\u0010m\u001a\b\u0012\u0004\u0012\u00020?0E2\u0006\u0010[\u001a\u00020\\H\u0002J\u0016\u0010n\u001a\b\u0012\u0004\u0012\u00020V0\u00132\u0006\u0010[\u001a\u00020\\H\u0002J\u0010\u0010o\u001a\u00020\\2\u0006\u0010#\u001a\u00020$H\u0002J\u000e\u0010p\u001a\u00020Y2\u0006\u0010[\u001a\u00020\\J\u000e\u0010q\u001a\u00020Y2\u0006\u0010k\u001a\u00020\\J\u000e\u0010r\u001a\u00020Y2\u0006\u0010k\u001a\u00020\\J\u0006\u0010s\u001a\u00020YJ\u0006\u0010t\u001a\u00020YR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00130\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R&\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u0018R&\u0010 \u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00130\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018R\u001a\u0010#\u001a\u00020$X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b\'\u0010(R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u0017\u0010-\u001a\b\u0012\u0004\u0012\u00020\r0.\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010/R \u00100\u001a\b\u0012\u0004\u0012\u0002010\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u00103\"\u0004\b4\u00105R \u00106\u001a\b\u0012\u0004\u0012\u0002070\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00103\"\u0004\b9\u00105R \u0010:\u001a\b\u0012\u0004\u0012\u00020;0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00103\"\u0004\b=\u00105R \u0010>\u001a\b\u0012\u0004\u0012\u00020?0\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u00103\"\u0004\bA\u00105R>\u0010B\u001a&\u0012\"\u0012 \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020D\u0012\n\u0012\b\u0012\u0004\u0012\u00020?0E0C0\u00130\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0016\"\u0004\bG\u0010\u0018R(\u0010H\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010D0D0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010\u0018R(\u0010L\u001a\u0010\u0012\f\u0012\n I*\u0004\u0018\u00010M0M0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bN\u0010\u0016\"\u0004\bO\u0010\u0018\u00a8\u0006v"}, d2 = {"Lcom/qltc/finace/view/main/report/ReportViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "applicationContext", "Landroid/content/Context;", "inComeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Landroid/content/Context;Lcom/qltc/finace/data/repository/local/income/InComeRepository;Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "_isDataRefreshed", "Landroidx/lifecycle/MutableLiveData;", "", "getApplicationContext", "()Landroid/content/Context;", "getCategoryRepository", "()Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "dataIncomePieChar", "", "Lcom/github/mikephil/charting/data/PieEntry;", "getDataIncomePieChar", "()Landroidx/lifecycle/MutableLiveData;", "setDataIncomePieChar", "(Landroidx/lifecycle/MutableLiveData;)V", "dataIncomeRcv", "Lcom/qltc/finace/data/entity/CategoryOverView;", "getDataIncomeRcv", "setDataIncomeRcv", "dataPieChar", "getDataPieChar", "setDataPieChar", "dataRcv", "getDataRcv", "setDataRcv", "date", "Ljava/time/LocalDate;", "getDate", "()Ljava/time/LocalDate;", "setDate", "(Ljava/time/LocalDate;)V", "getExpenseRepository", "()Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "getInComeRepository", "()Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "isDataRefreshed", "Landroidx/lifecycle/LiveData;", "()Landroidx/lifecycle/LiveData;", "listCategory", "Lcom/qltc/finace/data/entity/Category;", "getListCategory", "()Ljava/util/List;", "setListCategory", "(Ljava/util/List;)V", "listCategoryExpenseDetailDec", "Lcom/qltc/finace/data/entity/CategoryExpenseDetail;", "getListCategoryExpenseDetailDec", "setListCategoryExpenseDetailDec", "listExpense", "Lcom/qltc/finace/data/entity/Expense;", "getListExpense", "setListExpense", "listIncome", "Lcom/qltc/finace/data/entity/Income;", "getListIncome", "setListIncome", "listIncomeWithCategoryDec", "Lkotlin/Triple;", "", "", "getListIncomeWithCategoryDec", "setListIncomeWithCategoryDec", "total", "kotlin.jvm.PlatformType", "getTotal", "setTotal", "typeReport", "", "getTypeReport", "setTypeReport", "addItemEntry", "listCategoryExpenseDetail", "addItemEntryOther", "list", "addItemIncomeEntry", "listCategoryIncomeDetail", "Lcom/qltc/finace/data/entity/CategoryIncomeDetail;", "addItemIncomeEntryOther", "calculateTotal", "", "calculateTotalIncomeByMonth", "month", "Ljava/time/YearMonth;", "filterDataIncomeByMonth", "getAllData", "callBack", "Lkotlin/Function1;", "getCategoryExpenseDetailByID", "categoryID", "", "getCategoryObject", "idCategory", "getExpenseByCategory", "category", "getExpenseByMonth", "getExpenseWithCategoryOfMonth", "getExpensesByCategoryAndMonth", "yearMonth", "getIncomeByCategory", "getIncomeByMonth", "getIncomeWithCategoryOfMonth", "getYearMonth", "prepareDataPieChartExpenseByMonth", "prepareRecyclerViewExpense", "rcvIncomePrepare", "refreshData", "test", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ReportViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context applicationContext = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.income.InComeRepository inComeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> typeReport;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate date;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Income> listIncome;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Expense> listExpense;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.PieEntry>> dataPieChar;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Category> listCategory;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Long> total;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> listCategoryExpenseDetailDec;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<kotlin.Triple<com.qltc.finace.data.entity.Category, java.lang.Long, java.util.List<com.qltc.finace.data.entity.Income>>>> listIncomeWithCategoryDec;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> dataRcv;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isDataRefreshed = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isDataRefreshed = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.PieEntry>> dataIncomePieChar;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> dataIncomeRcv;
    public static final int MAX_ITEM_IN_PIE_CHART = 6;
    public static final int POSITION_ITEM_OTHER = 2;
    public static final int COUNT_ITEM_PIE_CHART = 4;
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.report.ReportViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public ReportViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context applicationContext, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepository inComeRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getApplicationContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.data.repository.local.income.InComeRepository getInComeRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.data.repository.local.expense.ExpenseRepository getExpenseRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.data.repository.local.category.CategoryRepository getCategoryRepository() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getTypeReport() {
        return null;
    }
    
    public final void setTypeReport(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getDate() {
        return null;
    }
    
    public final void setDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Income> getListIncome() {
        return null;
    }
    
    public final void setListIncome(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Income> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Expense> getListExpense() {
        return null;
    }
    
    public final void setListExpense(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Expense> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.PieEntry>> getDataPieChar() {
        return null;
    }
    
    public final void setDataPieChar(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.PieEntry>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Category> getListCategory() {
        return null;
    }
    
    public final void setListCategory(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Category> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getTotal() {
        return null;
    }
    
    public final void setTotal(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Long> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> getListCategoryExpenseDetailDec() {
        return null;
    }
    
    public final void setListCategoryExpenseDetailDec(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<kotlin.Triple<com.qltc.finace.data.entity.Category, java.lang.Long, java.util.List<com.qltc.finace.data.entity.Income>>>> getListIncomeWithCategoryDec() {
        return null;
    }
    
    public final void setListIncomeWithCategoryDec(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<kotlin.Triple<com.qltc.finace.data.entity.Category, java.lang.Long, java.util.List<com.qltc.finace.data.entity.Income>>>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> getDataRcv() {
        return null;
    }
    
    public final void setDataRcv(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isDataRefreshed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.PieEntry>> getDataIncomePieChar() {
        return null;
    }
    
    public final void setDataIncomePieChar(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.github.mikephil.charting.data.PieEntry>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> getDataIncomeRcv() {
        return null;
    }
    
    public final void setDataIncomeRcv(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> p0) {
    }
    
    public final void getAllData(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> callBack) {
    }
    
    private final java.util.List<com.qltc.finace.data.entity.Expense> getExpenseByCategory(com.qltc.finace.data.entity.Category category) {
        return null;
    }
    
    private final java.util.List<com.qltc.finace.data.entity.Expense> getExpenseByMonth(java.time.YearMonth month) {
        return null;
    }
    
    public final void prepareDataPieChartExpenseByMonth(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth month) {
    }
    
    private final java.util.List<com.github.mikephil.charting.data.PieEntry> addItemEntry(java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> listCategoryExpenseDetail) {
        return null;
    }
    
    private final java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> getExpenseWithCategoryOfMonth(java.time.YearMonth month) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.data.entity.CategoryExpenseDetail getCategoryExpenseDetailByID(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryID) {
        return null;
    }
    
    public final void refreshData() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Expense> getExpensesByCategoryAndMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String categoryID, @org.jetbrains.annotations.NotNull()
    java.time.YearMonth yearMonth) {
        return null;
    }
    
    private final com.qltc.finace.data.entity.Category getCategoryObject(java.lang.String idCategory) {
        return null;
    }
    
    private final com.github.mikephil.charting.data.PieEntry addItemEntryOther(java.util.List<com.qltc.finace.data.entity.CategoryExpenseDetail> list) {
        return null;
    }
    
    public final void prepareRecyclerViewExpense(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth yearMonth) {
    }
    
    private final void calculateTotal() {
    }
    
    public final void test() {
    }
    
    private final java.time.YearMonth getYearMonth(java.time.LocalDate date) {
        return null;
    }
    
    private final java.util.List<com.qltc.finace.data.entity.Income> getIncomeByCategory(com.qltc.finace.data.entity.Category category) {
        return null;
    }
    
    private final java.util.List<com.qltc.finace.data.entity.Income> getIncomeByMonth(java.time.YearMonth month) {
        return null;
    }
    
    public final void filterDataIncomeByMonth(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth month) {
    }
    
    private final java.util.List<com.github.mikephil.charting.data.PieEntry> addItemIncomeEntry(java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> listCategoryIncomeDetail) {
        return null;
    }
    
    private final java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> getIncomeWithCategoryOfMonth(java.time.YearMonth month) {
        return null;
    }
    
    private final com.github.mikephil.charting.data.PieEntry addItemIncomeEntryOther(java.util.List<com.qltc.finace.data.entity.CategoryIncomeDetail> list) {
        return null;
    }
    
    public final void rcvIncomePrepare(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth yearMonth) {
    }
    
    public final long calculateTotalIncomeByMonth(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth month) {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/qltc/finace/view/main/report/ReportViewModel$Companion;", "", "()V", "COUNT_ITEM_PIE_CHART", "", "MAX_ITEM_IN_PIE_CHART", "POSITION_ITEM_OTHER", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}