package com.qltc.finace.view.main.report.income;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.databinding.FragmentReportIncomeBinding;
import com.qltc.finace.view.adapter.AdapterExpenseIncomeReport;
import com.qltc.finace.view.adapter.AdapterTotalCategory;
import com.qltc.finace.data.entity.CategoryOverView;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import com.qltc.finace.view.main.report.chart.PercentFormatter;
import com.qltc.finace.view.main.report.chart.PieChartCustomRendederer;
import com.qltc.finace.view.main.report.ReportViewModel;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.YearMonth;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u001eH\u0016J\b\u0010\"\u001a\u00020\u001eH\u0016J\u001c\u0010#\u001a\u00020\u001e2\b\u0010$\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016J\u001a\u0010(\u001a\u00020\u001e2\u0006\u0010)\u001a\u00020*2\b\u0010+\u001a\u0004\u0018\u00010,H\u0016J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\u0016\u0010/\u001a\u00020\u001e2\f\u00100\u001a\b\u0012\u0004\u0012\u00020201H\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\r\u001a\u0004\b\u0014\u0010\u0015R\u001b\u0010\u0017\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001a\u0010\r\u001a\u0004\b\u0018\u0010\u0019\u00a8\u00063"}, d2 = {"Lcom/qltc/finace/view/main/report/income/FragmentReportInCome;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentReportIncomeBinding;", "Lcom/qltc/finace/view/main/report/ReportViewModel;", "Lcom/qltc/finace/view/main/report/income/ReportIncomeListener;", "Lcom/github/mikephil/charting/listener/OnChartValueSelectedListener;", "Lcom/qltc/finace/view/adapter/AdapterTotalCategory$OnClickListener;", "()V", "adapterRcv", "Lcom/qltc/finace/view/adapter/AdapterTotalCategory;", "getAdapterRcv", "()Lcom/qltc/finace/view/adapter/AdapterTotalCategory;", "adapterRcv$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "valueFormatter", "Lcom/qltc/finace/view/main/report/chart/PercentFormatter;", "getValueFormatter", "()Lcom/qltc/finace/view/main/report/chart/PercentFormatter;", "valueFormatter$delegate", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/report/ReportViewModel;", "viewModel$delegate", "getDescriptionPieChart", "Lcom/github/mikephil/charting/components/Description;", "onClickItemEI", "", "item", "Lcom/qltc/finace/data/entity/CategoryOverView;", "onNothingSelected", "onResume", "onValueSelected", "e", "Lcom/github/mikephil/charting/data/Entry;", "h", "Lcom/github/mikephil/charting/highlight/Highlight;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "setupPieChart", "setupRecyclerView", "updatePieChartData", "entries", "", "Lcom/github/mikephil/charting/data/PieEntry;", "app_debug"})
public final class FragmentReportInCome extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentReportIncomeBinding, com.qltc.finace.view.main.report.ReportViewModel> implements com.qltc.finace.view.main.report.income.ReportIncomeListener, com.github.mikephil.charting.listener.OnChartValueSelectedListener, com.qltc.finace.view.adapter.AdapterTotalCategory.OnClickListener {
    private final int layoutID = com.qltc.finace.R.layout.fragment_report_income;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy valueFormatter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapterRcv$delegate = null;
    
    public FragmentReportInCome() {
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
    
    private final com.qltc.finace.view.main.report.chart.PercentFormatter getValueFormatter() {
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
    
    private final void setupRecyclerView() {
    }
    
    private final void updatePieChartData(java.util.List<? extends com.github.mikephil.charting.data.PieEntry> entries) {
    }
    
    @java.lang.Override()
    public void onValueSelected(@org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.data.Entry e, @org.jetbrains.annotations.Nullable()
    com.github.mikephil.charting.highlight.Highlight h) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    @java.lang.Override()
    public void onNothingSelected() {
    }
    
    private final void setupPieChart() {
    }
    
    @java.lang.Override()
    public void onClickItemEI(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.CategoryOverView item) {
    }
    
    private final com.github.mikephil.charting.components.Description getDescriptionPieChart() {
        return null;
    }
}