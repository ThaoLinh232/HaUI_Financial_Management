package com.qltc.finace.view.main.report;

import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.google.android.material.tabs.TabLayout;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.base.Constant;
import com.qltc.finace.data.entity.CategoryOverView;
import com.qltc.finace.databinding.FagmentReportBinding;
import com.qltc.finace.view.adapter.AdapterTotalCategory;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.LocalDate;
import java.time.YearMonth;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 42\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u00014B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0002J\u0010\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u0017H\u0016J\b\u0010\u001e\u001a\u00020\u0017H\u0016J\u001c\u0010\u001f\u001a\u00020\u00172\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\u0012\u0010)\u001a\u00020\u00172\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010*\u001a\u00020\u0017H\u0016J\b\u0010+\u001a\u00020\u0017H\u0016J\b\u0010,\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020\u0017H\u0002J\b\u0010.\u001a\u00020\u0017H\u0002J\b\u0010/\u001a\u00020\u0017H\u0002J\b\u00100\u001a\u00020\u0017H\u0002J\b\u00101\u001a\u00020\u0017H\u0002J\b\u00102\u001a\u00020\u0017H\u0002J\b\u00103\u001a\u00020\u0017H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014\u00a8\u00065"}, d2 = {"Lcom/qltc/finace/view/main/report/FragmentReport;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FagmentReportBinding;", "Lcom/qltc/finace/view/main/report/ReportViewModel;", "Lcom/qltc/finace/view/main/report/ReportListener;", "Lcom/qltc/finace/view/adapter/AdapterTotalCategory$OnClickListener;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "()V", "adapterRcv", "Lcom/qltc/finace/view/adapter/AdapterTotalCategory;", "getAdapterRcv", "()Lcom/qltc/finace/view/adapter/AdapterTotalCategory;", "adapterRcv$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/report/ReportViewModel;", "viewModel$delegate", "notifyRecyclerViewNeedUpdate", "", "observeExpenseData", "observeIncomeData", "onClickItemEI", "item", "Lcom/qltc/finace/data/entity/CategoryOverView;", "onNothingSelected", "onResume", "onValueSelected", "p0", "Lcom/github/mikephil/charting/data/Entry;", "p1", "Lcom/github/mikephil/charting/highlight/Highlight;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewStateRestored", "openDayPicker", "openViewAll", "restoreTabState", "setTimeDefault", "setUpPieChart", "setUpRecyclerView", "setUpTabLayout", "setUpTabLayoutListener", "updateIncomeRecyclerView", "updateMonthDisplay", "Companion", "app_debug"})
public final class FragmentReport extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FagmentReportBinding, com.qltc.finace.view.main.report.ReportViewModel> implements com.qltc.finace.view.main.report.ReportListener, com.qltc.finace.view.adapter.AdapterTotalCategory.OnClickListener, com.github.mikephil.charting.listener.OnChartValueSelectedListener {
    public static final int CHOOSE_EXPENSE = 0;
    public static final int CHOOSE_INCOME = 1;
    private final int layoutID = com.qltc.finace.R.layout.fagment_report;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapterRcv$delegate = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.report.FragmentReport.Companion Companion = null;
    
    public FragmentReport() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.report.ReportViewModel getViewModel() {
        return null;
    }
    
    private final com.qltc.finace.view.adapter.AdapterTotalCategory getAdapterRcv() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onViewStateRestored(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void openDayPicker() {
    }
    
    @java.lang.Override()
    public void openViewAll() {
    }
    
    private final void setTimeDefault() {
    }
    
    @java.lang.Override()
    public void onClickItemEI(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.CategoryOverView item) {
    }
    
    private final void setUpTabLayout() {
    }
    
    private final void setUpTabLayoutListener() {
    }
    
    private final void setUpRecyclerView() {
    }
    
    private final void setUpPieChart() {
    }
    
    private final void notifyRecyclerViewNeedUpdate() {
    }
    
    private final void updateMonthDisplay() {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onValueSelected(@org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.data.Entry p0, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.highlight.Highlight p1) {
    }
    
    @java.lang.Override()
    public void onNothingSelected() {
    }
    
    private final void observeExpenseData() {
    }
    
    private final void observeIncomeData() {
    }
    
    private final void updateIncomeRecyclerView() {
    }
    
    /**
     * Khôi phục trạng thái tab dựa trên viewModel.typeReport.value
     * Được gọi sau khi load dữ liệu xong
     */
    private final void restoreTabState() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/qltc/finace/view/main/report/FragmentReport$Companion;", "", "()V", "CHOOSE_EXPENSE", "", "CHOOSE_INCOME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}