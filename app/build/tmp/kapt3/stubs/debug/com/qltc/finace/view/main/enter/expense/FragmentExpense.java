package com.qltc.finace.view.main.enter.expense;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.data.Fb;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.databinding.FragmentExpenseBinding;
import com.qltc.finace.view.adapter.AdapterExpense;
import com.qltc.finace.view.main.enter.ShareEnterViewModel;
import com.qltc.finace.view.main.enter.category.FragmentCategoryDetail;
import com.qltc.finace.view.main.enter.expense.ExpenseListener;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.LocalDate;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000e2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0016J\u001a\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\u0016H\u0016J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006$"}, d2 = {"Lcom/qltc/finace/view/main/enter/expense/FragmentExpense;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentExpenseBinding;", "Lcom/qltc/finace/view/main/enter/ShareEnterViewModel;", "Lcom/qltc/finace/view/main/enter/expense/ExpenseListener;", "Lcom/qltc/finace/view/adapter/AdapterExpense$OnClickListener;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterExpense;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterExpense;", "adapter$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/enter/ShareEnterViewModel;", "viewModel$delegate", "clearDataInput", "", "onClick", "position", "listCategory", "", "Lcom/qltc/finace/data/entity/Category;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openDayPicker", "setTimeDefault", "submitExpense", "app_debug"})
public final class FragmentExpense extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentExpenseBinding, com.qltc.finace.view.main.enter.ShareEnterViewModel> implements com.qltc.finace.view.main.enter.expense.ExpenseListener, com.qltc.finace.view.adapter.AdapterExpense.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_expense;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    
    public FragmentExpense() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.enter.ShareEnterViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.view.adapter.AdapterExpense getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void openDayPicker() {
    }
    
    @java.lang.Override()
    public void submitExpense() {
    }
    
    private final void setTimeDefault() {
    }
    
    @java.lang.Override()
    public void onClick(int position, @org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Category> listCategory) {
    }
    
    private final void clearDataInput() {
    }
}