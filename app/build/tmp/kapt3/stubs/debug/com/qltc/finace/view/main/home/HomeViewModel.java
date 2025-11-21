package com.qltc.finace.view.main.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import com.qltc.finace.data.entity.CategoryOverView;
import com.qltc.finace.data.Fb;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import java.time.YearMonth;
import javax.inject.Inject;
import com.google.firebase.auth.FirebaseAuth;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0014\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0007\u0018\u0000 Y2\u00020\u0001:\u0001YB\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010G\u001a\u00020HH\u0002J\b\u0010I\u001a\u00020HH\u0002J\b\u0010J\u001a\u00020HH\u0002J\u000e\u00105\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020LJ\u000e\u00107\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020LJ\b\u0010M\u001a\u00020HH\u0002J\b\u0010N\u001a\u00020HH\u0002J\u0006\u0010O\u001a\u00020HJ\u0006\u0010P\u001a\u00020HJ\u0006\u0010Q\u001a\u00020HJ\u000e\u0010R\u001a\u00020H2\u0006\u0010S\u001a\u00020\rJ\u0006\u0010T\u001a\u00020HJ\b\u0010U\u001a\u00020HH\u0002J\b\u0010V\u001a\u00020HH\u0002J\b\u0010W\u001a\u00020HH\u0002J\b\u0010X\u001a\u00020HH\u0002R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n \u0012*\u0004\u0018\u00010\u00110\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00110\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000f0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010$R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\'\u001a\b\u0012\u0004\u0012\u00020\u000f0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010$R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00110\"\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010$R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00110\"\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010$R\u0014\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u00020/0,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u00100\u001a\b\u0012\u0004\u0012\u0002010,X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u00102\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020-03X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0017\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010$R\u0017\u00106\u001a\b\u0012\u0004\u0012\u00020\u000f0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010$R\u001d\u00108\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180\u00170\"\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010$R\u0017\u0010:\u001a\b\u0012\u0004\u0012\u00020\u000f0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010$R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\r0\"\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010$R\u001a\u0010>\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b?\u0010@\"\u0004\bA\u0010BR\u001d\u0010C\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001c0\u00170\"\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010$R\u0017\u0010E\u001a\b\u0012\u0004\u0012\u00020 0\"\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010$\u00a8\u0006Z"}, d2 = {"Lcom/qltc/finace/view/main/home/HomeViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "incomeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;Lcom/qltc/finace/data/repository/local/income/InComeRepository;Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "_balanceChange", "Landroidx/lifecycle/MutableLiveData;", "", "_budgetProgress", "", "_currentBalance", "", "_isBalanceVisible", "", "kotlin.jvm.PlatformType", "_isDataRefreshed", "_monthlyExpense", "_monthlyIncome", "_recentTransactions", "", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "_remainingBudget", "_remainingDays", "_topCategories", "Lcom/qltc/finace/data/entity/CategoryOverView;", "_topExpenseCategories", "_topIncomeCategories", "_username", "", "balanceChange", "Landroidx/lifecycle/LiveData;", "getBalanceChange", "()Landroidx/lifecycle/LiveData;", "budgetProgress", "getBudgetProgress", "currentBalance", "getCurrentBalance", "isBalanceVisible", "isDataRefreshed", "listCategory", "", "Lcom/qltc/finace/data/entity/Category;", "listExpense", "Lcom/qltc/finace/data/entity/Expense;", "listIncome", "Lcom/qltc/finace/data/entity/Income;", "mapCategory", "", "monthlyExpense", "getMonthlyExpense", "monthlyIncome", "getMonthlyIncome", "recentTransactions", "getRecentTransactions", "remainingBudget", "getRemainingBudget", "remainingDays", "getRemainingDays", "selectedTabIndex", "getSelectedTabIndex", "()I", "setSelectedTabIndex", "(I)V", "topCategories", "getTopCategories", "username", "getUsername", "calculateBalanceChange", "", "calculateBudgetProgress", "calculateTotalBalance", "yearMonth", "Ljava/time/YearMonth;", "loadData", "loadUsername", "refreshData", "refreshExpenseData", "refreshIncomeData", "selectTab", "position", "toggleBalanceVisibility", "updateCurrentMonthData", "updateRecentTransactions", "updateTopExpenseCategories", "updateTopIncomeCategories", "Companion", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    public static final int TAB_INCOME = 0;
    public static final int TAB_EXPENSE = 1;
    private int selectedTabIndex = 0;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Expense> listExpense;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Income> listIncome;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.qltc.finace.data.entity.Category> listCategory;
    @org.jetbrains.annotations.NotNull()
    private java.util.Map<java.lang.String, com.qltc.finace.data.entity.Category> mapCategory;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isDataRefreshed = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isDataRefreshed = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _currentBalance = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> currentBalance = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _monthlyIncome = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> monthlyIncome = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _monthlyExpense = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> monthlyExpense = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> _recentTransactions = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> recentTransactions = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> _topExpenseCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> _topIncomeCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> _topCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> topCategories = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isBalanceVisible = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isBalanceVisible = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _username = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> username = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Double> _balanceChange = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Double> balanceChange = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _budgetProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> budgetProgress = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Long> _remainingBudget = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Long> remainingBudget = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Integer> _remainingDays = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Integer> remainingDays = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.home.HomeViewModel.Companion Companion = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    public final int getSelectedTabIndex() {
        return 0;
    }
    
    public final void setSelectedTabIndex(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isDataRefreshed() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getCurrentBalance() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getMonthlyIncome() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getMonthlyExpense() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> getRecentTransactions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.qltc.finace.data.entity.CategoryOverView>> getTopCategories() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isBalanceVisible() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Double> getBalanceChange() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getBudgetProgress() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Long> getRemainingBudget() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Integer> getRemainingDays() {
        return null;
    }
    
    private final void loadData() {
    }
    
    private final void updateCurrentMonthData() {
    }
    
    private final void updateRecentTransactions() {
    }
    
    private final void calculateTotalBalance() {
    }
    
    private final void calculateBalanceChange() {
    }
    
    private final void calculateBudgetProgress() {
    }
    
    public final void selectTab(int position) {
    }
    
    public final void toggleBalanceVisibility() {
    }
    
    public final void refreshData() {
    }
    
    /**
     * Refreshes only the expense data, optimized for when the expense tab is active
     */
    public final void refreshExpenseData() {
    }
    
    /**
     * Refreshes only the income data, optimized for when the income tab is active
     */
    public final void refreshIncomeData() {
    }
    
    private final void loadUsername() {
    }
    
    private final void updateTopExpenseCategories() {
    }
    
    private final void updateTopIncomeCategories() {
    }
    
    /**
     * Lấy tổng chi tiêu trong một tháng cụ thể
     */
    public final long getMonthlyExpense(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth yearMonth) {
        return 0L;
    }
    
    /**
     * Lấy tổng thu nhập trong một tháng cụ thể
     */
    public final long getMonthlyIncome(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth yearMonth) {
        return 0L;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/qltc/finace/view/main/home/HomeViewModel$Companion;", "", "()V", "TAB_EXPENSE", "", "TAB_INCOME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}