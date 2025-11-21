package com.qltc.finace.view.edit_expense_income;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.base.Constant;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.databinding.FragmentEditBinding;
import com.qltc.finace.view.adapter.AdapterCategory;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.LocalDate;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u001e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001d\u001a\u00020\u00102\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u001fH\u0016J\b\u0010 \u001a\u00020\u001bH\u0016J\u0012\u0010!\u001a\u00020\u001b2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001bH\u0016J\u001a\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\'2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010(\u001a\u00020\u001bH\u0016J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020-H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0018X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/qltc/finace/view/edit_expense_income/FragmentEditExpenseIncome;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentEditBinding;", "Lcom/qltc/finace/view/edit_expense_income/EditExpenseIncomeViewModel;", "Lcom/qltc/finace/view/edit_expense_income/EditExpenseIncomeListener;", "Lcom/qltc/finace/view/adapter/AdapterCategory$OnClickListener;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterCategory;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterCategory;", "adapter$delegate", "Lkotlin/Lazy;", "backPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "layoutID", "", "getLayoutID", "()I", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/edit_expense_income/EditExpenseIncomeViewModel;", "viewModel$delegate", "x", "", "Lcom/qltc/finace/data/entity/Category;", "onClickBack", "", "onClickItemCategory", "position", "listCategory", "", "onClickUpdate", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "openDayPicker", "setData", "showSaveConfirmationDialog", "showToastIsUpdate", "message", "", "app_debug"})
public final class FragmentEditExpenseIncome extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentEditBinding, com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel> implements com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener, com.qltc.finace.view.adapter.AdapterCategory.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_edit;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.qltc.finace.data.entity.Category> x;
    @org.jetbrains.annotations.NotNull()
    private final androidx.activity.OnBackPressedCallback backPressedCallback = null;
    
    public FragmentEditExpenseIncome() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    private final com.qltc.finace.view.adapter.AdapterCategory getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void showSaveConfirmationDialog() {
    }
    
    private final void showToastIsUpdate(java.lang.String message) {
    }
    
    @java.lang.Override()
    public void onClickBack() {
    }
    
    @java.lang.Override()
    public void onClickUpdate() {
    }
    
    @java.lang.Override()
    public void openDayPicker() {
    }
    
    private final void setData() {
    }
    
    @java.lang.Override()
    public void onClickItemCategory(int position, @org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Category> listCategory) {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}