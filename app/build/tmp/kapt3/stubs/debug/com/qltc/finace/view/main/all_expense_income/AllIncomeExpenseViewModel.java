package com.qltc.finace.view.main.all_expense_income;

import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u001f\u001a\u00020 J\u0006\u0010!\u001a\u00020 R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R4\u0010\t\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\f \r*\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b0\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00130\u001dX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\""}, d2 = {"Lcom/qltc/finace/view/main/all_expense_income/AllIncomeExpenseViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "incomeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;Lcom/qltc/finace/data/repository/local/income/InComeRepository;Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "dataRcv", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "kotlin.jvm.PlatformType", "getDataRcv", "()Landroidx/lifecycle/MutableLiveData;", "setDataRcv", "(Landroidx/lifecycle/MutableLiveData;)V", "listCategory", "Lcom/qltc/finace/data/entity/Category;", "getListCategory", "()Ljava/util/List;", "setListCategory", "(Ljava/util/List;)V", "listExpense", "Lcom/qltc/finace/data/entity/Expense;", "listIncome", "Lcom/qltc/finace/data/entity/Income;", "mapCategory", "", "", "getAll", "", "prepareData", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AllIncomeExpenseViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Expense> listExpense;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Income> listIncome;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Category> listCategory;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, com.qltc.finace.data.entity.Category> mapCategory;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> dataRcv;
    
    @javax.inject.Inject()
    public AllIncomeExpenseViewModel(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.qltc.finace.data.entity.Category> getListCategory() {
        return null;
    }
    
    public final void setListCategory(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Category> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> getDataRcv() {
        return null;
    }
    
    public final void setDataRcv(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> p0) {
    }
    
    public final void getAll() {
    }
    
    public final void prepareData() {
    }
}