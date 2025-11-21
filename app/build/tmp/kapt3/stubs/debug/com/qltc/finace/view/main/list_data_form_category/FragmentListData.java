package com.qltc.finace.view.main.list_data_form_category;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.lifecycle.MutableLiveData;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.base.Constant;
import com.qltc.finace.databinding.FragmentListDataFromCategoryBinding;
import com.qltc.finace.view.adapter.AdapterExpenseIncomeReport;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import com.qltc.finace.view.main.report.ReportViewModel;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.YearMonth;
import kotlinx.coroutines.Dispatchers;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020\u001eH\u0002J\b\u0010 \u001a\u00020\u001eH\u0016J\u0010\u0010!\u001a\u00020\u001e2\u0006\u0010\"\u001a\u00020\u0012H\u0016J\b\u0010#\u001a\u00020\u001eH\u0016J\u001a\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u000eX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0019\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\f\u001a\u0004\b\u001a\u0010\u001b\u00a8\u0006)"}, d2 = {"Lcom/qltc/finace/view/main/list_data_form_category/FragmentListData;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentListDataFromCategoryBinding;", "Lcom/qltc/finace/view/main/report/ReportViewModel;", "Lcom/qltc/finace/view/main/list_data_form_category/ListDataListener;", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport$OnClickListener;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "adapter$delegate", "Lkotlin/Lazy;", "dataType", "", "filteredRecords", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "idCategory", "", "layoutID", "getLayoutID", "()I", "titleCategory", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/report/ReportViewModel;", "viewModel$delegate", "debugDataInfo", "", "loadCategoryData", "onClickBack", "onClickItemEI", "item", "onResume", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class FragmentListData extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentListDataFromCategoryBinding, com.qltc.finace.view.main.report.ReportViewModel> implements com.qltc.finace.view.main.list_data_form_category.ListDataListener, com.qltc.finace.view.adapter.AdapterExpenseIncomeReport.OnClickListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_list_data_from_category;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String idCategory = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String titleCategory = "";
    private int dataType = 0;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.view.main.calendar.FinancialRecord>> filteredRecords = null;
    
    public FragmentListData() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.report.ReportViewModel getViewModel() {
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
    
    private final void loadCategoryData() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void debugDataInfo() {
    }
}