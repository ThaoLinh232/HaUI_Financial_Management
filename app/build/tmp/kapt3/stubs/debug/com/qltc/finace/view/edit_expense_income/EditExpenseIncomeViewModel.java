package com.qltc.finace.view.edit_expense_income;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import java.time.LocalDate;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u001c\u0010:\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020;0=H\u0002J\u001c\u0010>\u001a\u00020;2\u0012\u0010<\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020;0=H\u0002J\"\u0010?\u001a\u00020;2\u0006\u0010@\u001a\u00020 2\u0012\u0010A\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020;0=J\b\u0010B\u001a\u00020;H\u0002R(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R4\u0010\u0014\u001a\n \u0013*\u0004\u0018\u00010\u00120\u00122\u000e\u0010\t\u001a\n \u0013*\u0004\u0018\u00010\u00120\u0012@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R(\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u0013*\u0004\u0018\u00010\u001b0\u001b0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020 X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010&X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010(\"\u0004\b)\u0010*R\"\u0010+\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010,X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R$\u00102\u001a\u0002012\u0006\u0010\t\u001a\u000201@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b3\u00104\"\u0004\b5\u00106R$\u00107\u001a\u0002012\u0006\u0010\t\u001a\u000201@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b8\u00104\"\u0004\b9\u00106\u00a8\u0006C"}, d2 = {"Lcom/qltc/finace/view/edit_expense_income/EditExpenseIncomeViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "context", "Landroid/content/Context;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "incomeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "(Landroid/content/Context;Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;Lcom/qltc/finace/data/repository/local/income/InComeRepository;)V", "value", "Lcom/qltc/finace/data/entity/Category;", "categorySelected", "getCategorySelected", "()Lcom/qltc/finace/data/entity/Category;", "setCategorySelected", "(Lcom/qltc/finace/data/entity/Category;)V", "getContext", "()Landroid/content/Context;", "Ljava/time/LocalDate;", "kotlin.jvm.PlatformType", "date", "getDate", "()Ljava/time/LocalDate;", "setDate", "(Ljava/time/LocalDate;)V", "isEnableButtonAdd", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setEnableButtonAdd", "(Landroidx/lifecycle/MutableLiveData;)V", "itemCategorySelected", "", "getItemCategorySelected", "()I", "setItemCategorySelected", "(I)V", "itemData", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "getItemData", "()Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "setItemData", "(Lcom/qltc/finace/view/main/calendar/FinancialRecord;)V", "listCategory", "", "getListCategory", "()Ljava/util/List;", "setListCategory", "(Ljava/util/List;)V", "", "money", "getMoney", "()Ljava/lang/String;", "setMoney", "(Ljava/lang/String;)V", "note", "getNote", "setNote", "updateExpense", "", "callBackIsUpdate", "Lkotlin/Function1;", "updateIncome", "updateItemData", "typeUpdate", "callBack", "validData", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class EditExpenseIncomeViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository = null;
    @org.jetbrains.annotations.Nullable()
    private com.qltc.finace.view.main.calendar.FinancialRecord itemData;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAdd;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.qltc.finace.data.entity.Category> listCategory;
    private int itemCategorySelected = -1;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String money = "";
    private java.time.LocalDate date;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String note = "";
    @org.jetbrains.annotations.Nullable()
    private com.qltc.finace.data.entity.Category categorySelected;
    
    @javax.inject.Inject()
    public EditExpenseIncomeViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepository incomeRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getContext() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.view.main.calendar.FinancialRecord getItemData() {
        return null;
    }
    
    public final void setItemData(@org.jetbrains.annotations.Nullable()
    com.qltc.finace.view.main.calendar.FinancialRecord p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAdd() {
        return null;
    }
    
    public final void setEnableButtonAdd(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.qltc.finace.data.entity.Category> getListCategory() {
        return null;
    }
    
    public final void setListCategory(@org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.Category> p0) {
    }
    
    public final int getItemCategorySelected() {
        return 0;
    }
    
    public final void setItemCategorySelected(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMoney() {
        return null;
    }
    
    public final void setMoney(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final java.time.LocalDate getDate() {
        return null;
    }
    
    public final void setDate(java.time.LocalDate value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNote() {
        return null;
    }
    
    public final void setNote(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.data.entity.Category getCategorySelected() {
        return null;
    }
    
    public final void setCategorySelected(@org.jetbrains.annotations.Nullable()
    com.qltc.finace.data.entity.Category value) {
    }
    
    private final void validData() {
    }
    
    public final void updateItemData(int typeUpdate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> callBack) {
    }
    
    private final void updateExpense(kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> callBackIsUpdate) {
    }
    
    private final void updateIncome(kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> callBackIsUpdate) {
    }
}