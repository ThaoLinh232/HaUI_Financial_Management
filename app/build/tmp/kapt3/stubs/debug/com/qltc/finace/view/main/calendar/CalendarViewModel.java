package com.qltc.finace.view.main.calendar;

import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.base.SingleLiveData;
import com.qltc.finace.data.Fb;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import java.time.LocalDate;
import java.time.YearMonth;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010D\u001a\u00020EH\u0002J\u0014\u0010F\u001a\b\u0012\u0004\u0012\u00020\"0!2\u0006\u0010G\u001a\u00020HJ\u000e\u0010I\u001a\u00020E2\u0006\u0010J\u001a\u00020\nJ\u000e\u0010K\u001a\u00020E2\u0006\u0010L\u001a\u00020MJ\u0006\u0010N\u001a\u00020EJ\u0006\u0010O\u001a\u00020ER\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\"\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00120\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0017\u001a\u0010\u0012\f\u0012\n \u000b*\u0004\u0018\u00010\u00120\u00120\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0014\"\u0004\b\u0019\u0010\u0016R \u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001d\"\u0004\b\u001e\u0010\u001fR \u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010\'\u001a\b\u0012\u0004\u0012\u00020(0!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010$\"\u0004\b*\u0010&R \u0010+\u001a\b\u0012\u0004\u0012\u00020,0!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R4\u0010/\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u000200 \u000b*\n\u0012\u0004\u0012\u000200\u0018\u00010!0!0\u0011X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0014\"\u0004\b2\u0010\u0016R&\u00103\u001a\u000e\u0012\u0004\u0012\u000205\u0012\u0004\u0012\u00020\"04X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R,\u0010:\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020(0;04X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u00107\"\u0004\b=\u00109R,\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\n\u0012\b\u0012\u0004\u0012\u00020,0;04X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u00107\"\u0004\b@\u00109R\u001c\u0010A\u001a\u0004\u0018\u00010\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000f\u00a8\u0006P"}, d2 = {"Lcom/qltc/finace/view/main/calendar/CalendarViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "incomeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;Lcom/qltc/finace/data/repository/local/income/InComeRepository;Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "date", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "getDate", "()Ljava/time/LocalDate;", "setDate", "(Ljava/time/LocalDate;)V", "expenseTotal", "Landroidx/lifecycle/MutableLiveData;", "", "getExpenseTotal", "()Landroidx/lifecycle/MutableLiveData;", "setExpenseTotal", "(Landroidx/lifecycle/MutableLiveData;)V", "incomeTotal", "getIncomeTotal", "setIncomeTotal", "isGetDataByMonth", "Lcom/qltc/finace/base/SingleLiveData;", "", "()Lcom/qltc/finace/base/SingleLiveData;", "setGetDataByMonth", "(Lcom/qltc/finace/base/SingleLiveData;)V", "listCategory", "", "Lcom/qltc/finace/data/entity/Category;", "getListCategory", "()Ljava/util/List;", "setListCategory", "(Ljava/util/List;)V", "listExpense", "Lcom/qltc/finace/data/entity/Expense;", "getListExpense", "setListExpense", "listIncome", "Lcom/qltc/finace/data/entity/Income;", "getListIncome", "setListIncome", "listSyntheticByDate", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "getListSyntheticByDate", "setListSyntheticByDate", "mapCategory", "", "", "getMapCategory", "()Ljava/util/Map;", "setMapCategory", "(Ljava/util/Map;)V", "mapGroupExpenseToShowDayView", "", "getMapGroupExpenseToShowDayView", "setMapGroupExpenseToShowDayView", "mapGroupIncomeToShowDayView", "getMapGroupIncomeToShowDayView", "setMapGroupIncomeToShowDayView", "selectedDate", "getSelectedDate", "setSelectedDate", "clearDataTotal", "", "filterListCategory", "type", "", "filterListSyntheticByDate", "dateSelecting", "filterListSyntheticByMonth", "monthSelecting", "Ljava/time/YearMonth;", "getDataByDate", "resetData", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CalendarViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    private java.time.LocalDate date;
    @org.jetbrains.annotations.Nullable()
    private java.time.LocalDate selectedDate;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Long> incomeTotal;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Long> expenseTotal;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Expense> listExpense;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Income> listIncome;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Category> listCategory;
    @org.jetbrains.annotations.NotNull()
    private com.qltc.finace.base.SingleLiveData<java.lang.Boolean> isGetDataByMonth;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.time.LocalDate, ? extends java.util.List<com.qltc.finace.data.entity.Expense>> mapGroupExpenseToShowDayView;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.time.LocalDate, ? extends java.util.List<com.qltc.finace.data.entity.Income>> mapGroupIncomeToShowDayView;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, com.qltc.finace.data.entity.Category> mapCategory;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> listSyntheticByDate;
    
    @javax.inject.Inject()
    public CalendarViewModel(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    public final java.time.LocalDate getDate() {
        return null;
    }
    
    public final void setDate(java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getSelectedDate() {
        return null;
    }
    
    public final void setSelectedDate(@org.jetbrains.annotations.Nullable()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getIncomeTotal() {
        return null;
    }
    
    public final void setIncomeTotal(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Long> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Long> getExpenseTotal() {
        return null;
    }
    
    public final void setExpenseTotal(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Long> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Expense> getListExpense() {
        return null;
    }
    
    public final void setListExpense(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Expense> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Income> getListIncome() {
        return null;
    }
    
    public final void setListIncome(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Income> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Category> getListCategory() {
        return null;
    }
    
    public final void setListCategory(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Category> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.base.SingleLiveData<java.lang.Boolean> isGetDataByMonth() {
        return null;
    }
    
    public final void setGetDataByMonth(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.base.SingleLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.time.LocalDate, java.util.List<com.qltc.finace.data.entity.Expense>> getMapGroupExpenseToShowDayView() {
        return null;
    }
    
    public final void setMapGroupExpenseToShowDayView(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.time.LocalDate, ? extends java.util.List<com.qltc.finace.data.entity.Expense>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.time.LocalDate, java.util.List<com.qltc.finace.data.entity.Income>> getMapGroupIncomeToShowDayView() {
        return null;
    }
    
    public final void setMapGroupIncomeToShowDayView(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.time.LocalDate, ? extends java.util.List<com.qltc.finace.data.entity.Income>> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.String, com.qltc.finace.data.entity.Category> getMapCategory() {
        return null;
    }
    
    public final void setMapCategory(@org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.String, com.qltc.finace.data.entity.Category> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> getListSyntheticByDate() {
        return null;
    }
    
    public final void setListSyntheticByDate(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> p0) {
    }
    
    public final void getDataByDate() {
    }
    
    public final void filterListSyntheticByDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate dateSelecting) {
    }
    
    public final void filterListSyntheticByMonth(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth monthSelecting) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Category> filterListCategory(int type) {
        return null;
    }
    
    public final void resetData() {
    }
    
    private final void clearDataTotal() {
    }
}