package com.qltc.finace.view.main.enter;

import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.base.SingleLiveData;
import com.qltc.finace.data.entity.Category;
import java.time.LocalDate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010F\u001a\u00020GJ\u0006\u0010H\u001a\u00020GR(\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR(\u0010\n\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R(\u0010\u0016\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\u001d\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR(\u0010\u001f\u001a\u0010\u0012\f\u0012\n \u0019*\u0004\u0018\u00010\u00180\u00180\u0017X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001a\u0010!\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\'\u001a\u00020\"X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010$\"\u0004\b)\u0010&R&\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,0+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R&\u00101\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040,0+X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010.\"\u0004\b3\u00100R$\u00105\u001a\u0002042\u0006\u0010\u0003\u001a\u000204@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R$\u0010:\u001a\u0002042\u0006\u0010\u0003\u001a\u000204@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b;\u00107\"\u0004\b<\u00109R$\u0010=\u001a\u0002042\u0006\u0010\u0003\u001a\u000204@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u00107\"\u0004\b?\u00109R$\u0010@\u001a\u0002042\u0006\u0010\u0003\u001a\u000204@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u00107\"\u0004\bB\u00109R$\u0010C\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\"@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010$\"\u0004\bE\u0010&\u00a8\u0006I"}, d2 = {"Lcom/qltc/finace/view/main/enter/BaseEnterViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "()V", "value", "Lcom/qltc/finace/data/entity/Category;", "categoryExpenseSelected", "getCategoryExpenseSelected", "()Lcom/qltc/finace/data/entity/Category;", "setCategoryExpenseSelected", "(Lcom/qltc/finace/data/entity/Category;)V", "categoryIncomeSelected", "getCategoryIncomeSelected", "setCategoryIncomeSelected", "dateExpense", "Ljava/time/LocalDate;", "getDateExpense", "()Ljava/time/LocalDate;", "setDateExpense", "(Ljava/time/LocalDate;)V", "dateIncome", "getDateIncome", "setDateIncome", "isEnableButtonAddAtToolbar", "Landroidx/lifecycle/MutableLiveData;", "", "kotlin.jvm.PlatformType", "()Landroidx/lifecycle/MutableLiveData;", "setEnableButtonAddAtToolbar", "(Landroidx/lifecycle/MutableLiveData;)V", "isEnableButtonAddExpense", "setEnableButtonAddExpense", "isEnableButtonAddIncome", "setEnableButtonAddIncome", "itemCategoryExpenseSelected", "", "getItemCategoryExpenseSelected", "()I", "setItemCategoryExpenseSelected", "(I)V", "itemCategoryIncomeSelected", "getItemCategoryIncomeSelected", "setItemCategoryIncomeSelected", "listCategoryExpense", "Lcom/qltc/finace/base/SingleLiveData;", "", "getListCategoryExpense", "()Lcom/qltc/finace/base/SingleLiveData;", "setListCategoryExpense", "(Lcom/qltc/finace/base/SingleLiveData;)V", "listCategoryIncome", "getListCategoryIncome", "setListCategoryIncome", "", "moneyExpense", "getMoneyExpense", "()Ljava/lang/String;", "setMoneyExpense", "(Ljava/lang/String;)V", "moneyIncome", "getMoneyIncome", "setMoneyIncome", "noteExpense", "getNoteExpense", "setNoteExpense", "noteIncome", "getNoteIncome", "setNoteIncome", "typeCurrentFragment", "getTypeCurrentFragment", "setTypeCurrentFragment", "checkValidDataExpense", "", "checkValidDataIncome", "app_debug"})
public abstract class BaseEnterViewModel extends com.qltc.finace.base.BaseViewModel {
    private int typeCurrentFragment = 1;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAddAtToolbar;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAddExpense;
    @org.jetbrains.annotations.NotNull()
    private com.qltc.finace.base.SingleLiveData<java.util.List<com.qltc.finace.data.entity.Category>> listCategoryExpense;
    private int itemCategoryExpenseSelected = -1;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate dateExpense;
    @org.jetbrains.annotations.Nullable()
    private com.qltc.finace.data.entity.Category categoryExpenseSelected;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String noteExpense = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String moneyExpense = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAddIncome;
    @org.jetbrains.annotations.NotNull()
    private com.qltc.finace.base.SingleLiveData<java.util.List<com.qltc.finace.data.entity.Category>> listCategoryIncome;
    private int itemCategoryIncomeSelected = -1;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate dateIncome;
    @org.jetbrains.annotations.Nullable()
    private com.qltc.finace.data.entity.Category categoryIncomeSelected;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String noteIncome = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String moneyIncome = "";
    
    public BaseEnterViewModel() {
        super();
    }
    
    public final int getTypeCurrentFragment() {
        return 0;
    }
    
    public final void setTypeCurrentFragment(int value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAddAtToolbar() {
        return null;
    }
    
    public final void setEnableButtonAddAtToolbar(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAddExpense() {
        return null;
    }
    
    public final void setEnableButtonAddExpense(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.base.SingleLiveData<java.util.List<com.qltc.finace.data.entity.Category>> getListCategoryExpense() {
        return null;
    }
    
    public final void setListCategoryExpense(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.base.SingleLiveData<java.util.List<com.qltc.finace.data.entity.Category>> p0) {
    }
    
    public final int getItemCategoryExpenseSelected() {
        return 0;
    }
    
    public final void setItemCategoryExpenseSelected(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getDateExpense() {
        return null;
    }
    
    public final void setDateExpense(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.data.entity.Category getCategoryExpenseSelected() {
        return null;
    }
    
    public final void setCategoryExpenseSelected(@org.jetbrains.annotations.Nullable()
    com.qltc.finace.data.entity.Category value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNoteExpense() {
        return null;
    }
    
    public final void setNoteExpense(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMoneyExpense() {
        return null;
    }
    
    public final void setMoneyExpense(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void checkValidDataExpense() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonAddIncome() {
        return null;
    }
    
    public final void setEnableButtonAddIncome(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.base.SingleLiveData<java.util.List<com.qltc.finace.data.entity.Category>> getListCategoryIncome() {
        return null;
    }
    
    public final void setListCategoryIncome(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.base.SingleLiveData<java.util.List<com.qltc.finace.data.entity.Category>> p0) {
    }
    
    public final int getItemCategoryIncomeSelected() {
        return 0;
    }
    
    public final void setItemCategoryIncomeSelected(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getDateIncome() {
        return null;
    }
    
    public final void setDateIncome(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.data.entity.Category getCategoryIncomeSelected() {
        return null;
    }
    
    public final void setCategoryIncomeSelected(@org.jetbrains.annotations.Nullable()
    com.qltc.finace.data.entity.Category value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNoteIncome() {
        return null;
    }
    
    public final void setNoteIncome(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMoneyIncome() {
        return null;
    }
    
    public final void setMoneyIncome(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    public final void checkValidDataIncome() {
    }
}