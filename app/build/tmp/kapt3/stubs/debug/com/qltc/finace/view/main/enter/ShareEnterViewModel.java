package com.qltc.finace.view.main.enter;

import com.qltc.finace.base.SingleLiveData;
import com.qltc.finace.data.Fb;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u0012J\u0006\u0010\u0015\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\f\"\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000e\u00a8\u0006\u0016"}, d2 = {"Lcom/qltc/finace/view/main/enter/ShareEnterViewModel;", "Lcom/qltc/finace/view/main/enter/BaseEnterViewModel;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "incomeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "(Lcom/qltc/finace/data/repository/local/category/CategoryRepository;Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;Lcom/qltc/finace/data/repository/local/income/InComeRepository;)V", "isAddExpense", "Lcom/qltc/finace/base/SingleLiveData;", "", "()Lcom/qltc/finace/base/SingleLiveData;", "setAddExpense", "(Lcom/qltc/finace/base/SingleLiveData;)V", "isAddIncome", "setAddIncome", "getCategoryExpense", "", "getCategoryIncome", "submitExpense", "submitIncome", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ShareEnterViewModel extends com.qltc.finace.view.main.enter.BaseEnterViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private com.qltc.finace.base.SingleLiveData<java.lang.Boolean> isAddExpense;
    @org.jetbrains.annotations.NotNull()
    private com.qltc.finace.base.SingleLiveData<java.lang.Boolean> isAddIncome;
    
    @javax.inject.Inject()
    public ShareEnterViewModel(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.base.SingleLiveData<java.lang.Boolean> isAddExpense() {
        return null;
    }
    
    public final void setAddExpense(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.base.SingleLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.base.SingleLiveData<java.lang.Boolean> isAddIncome() {
        return null;
    }
    
    public final void setAddIncome(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.base.SingleLiveData<java.lang.Boolean> p0) {
    }
    
    public final void getCategoryExpense() {
    }
    
    public final void getCategoryIncome() {
    }
    
    public final void submitExpense() {
    }
    
    public final void submitIncome() {
    }
}