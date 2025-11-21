package com.qltc.finace.view.main.all_expense_income;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.databinding.FragmentAllDataIncomeExpenseBinding;
import com.qltc.finace.view.adapter.AdapterExpenseIncomeReport;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0014\u0010\f\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001f"}, d2 = {"Lcom/qltc/finace/view/main/all_expense_income/AllIncomeExpenseFragment;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentAllDataIncomeExpenseBinding;", "Lcom/qltc/finace/view/main/all_expense_income/AllIncomeExpenseViewModel;", "Lcom/qltc/finace/view/main/all_expense_income/AllIncomeExpenseListener;", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport$OnClickListener;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "adapter$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/all_expense_income/AllIncomeExpenseViewModel;", "viewModel$delegate", "onClickBack", "", "onClickItemEI", "item", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class AllIncomeExpenseFragment extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentAllDataIncomeExpenseBinding, com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseViewModel> implements com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseListener, com.qltc.finace.view.adapter.AdapterExpenseIncomeReport.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_all_data_income_expense;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    
    public AllIncomeExpenseFragment() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    private final com.qltc.finace.view.adapter.AdapterExpenseIncomeReport getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClickItemEI(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.main.calendar.FinancialRecord item) {
    }
    
    @java.lang.Override()
    public void onClickBack() {
    }
}