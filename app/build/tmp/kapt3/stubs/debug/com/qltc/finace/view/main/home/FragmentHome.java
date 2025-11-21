package com.qltc.finace.view.main.home;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.databinding.FragmentHomeBinding;
import dagger.hilt.android.AndroidEntryPoint;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.ValueFormatter;
import com.google.android.material.tabs.TabLayout;
import com.qltc.finace.view.adapter.AdapterTotalCategory;
import com.qltc.finace.data.entity.CategoryOverView;
import com.qltc.finace.view.adapter.AdapterExpenseIncomeReport;
import com.qltc.finace.view.adapter.AdapterTopCategory;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import com.qltc.finace.data.Resource;
import java.text.NumberFormat;
import java.time.YearMonth;
import java.util.Locale;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\b\u0010%\u001a\u00020&H\u0002J\u0010\u0010\'\u001a\u00020&2\u0006\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020&2\u0006\u0010(\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020&H\u0016J\b\u0010-\u001a\u00020&H\u0016J\b\u0010.\u001a\u00020&H\u0016J\b\u0010/\u001a\u00020&H\u0016J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u000fH\u0016J\b\u00102\u001a\u00020&H\u0016J\b\u00103\u001a\u00020&H\u0016J\u001a\u00104\u001a\u00020&2\u0006\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u000108H\u0016J\u001c\u00109\u001a\u00020&2\u0006\u0010:\u001a\u00020\u000f2\n\b\u0002\u0010;\u001a\u0004\u0018\u000108H\u0002J\b\u0010<\u001a\u00020&H\u0002J\u0010\u0010=\u001a\u00020&2\u0006\u0010>\u001a\u00020\"H\u0002J\u0010\u0010?\u001a\u00020&2\u0006\u0010@\u001a\u00020AH\u0002R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0012\u001a\n \u0014*\u0004\u0018\u00010\u00130\u00138BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u001c\u0010\r\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001d\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b \u0010\r\u001a\u0004\b\u001e\u0010\u001f\u00a8\u0006B"}, d2 = {"Lcom/qltc/finace/view/main/home/FragmentHome;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentHomeBinding;", "Lcom/qltc/finace/view/main/home/HomeViewModel;", "Lcom/qltc/finace/view/main/home/HomeListener;", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport$OnClickListener;", "Lcom/qltc/finace/view/adapter/AdapterTopCategory$OnClickListener;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "adapter$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "numberFormat", "Ljava/text/NumberFormat;", "kotlin.jvm.PlatformType", "getNumberFormat", "()Ljava/text/NumberFormat;", "numberFormat$delegate", "topCategoryAdapter", "Lcom/qltc/finace/view/adapter/AdapterTopCategory;", "getTopCategoryAdapter", "()Lcom/qltc/finace/view/adapter/AdapterTopCategory;", "topCategoryAdapter$delegate", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/home/HomeViewModel;", "viewModel$delegate", "formatCurrency", "", "amount", "", "observeData", "", "onClickCategory", "item", "Lcom/qltc/finace/data/entity/CategoryOverView;", "onClickItemEI", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "onExpenseCardClick", "onIncomeCardClick", "onNotificationClick", "onResume", "onTabSelected", "position", "onToggleBalanceClick", "onViewAllTransactionsClick", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "safeNavigate", "destinationId", "args", "setupViews", "showError", "message", "updateBarChart", "isExpenseTab", "", "app_debug"})
public final class FragmentHome extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentHomeBinding, com.qltc.finace.view.main.home.HomeViewModel> implements com.qltc.finace.view.main.home.HomeListener, com.qltc.finace.view.adapter.AdapterExpenseIncomeReport.OnClickListener, com.qltc.finace.view.adapter.AdapterTopCategory.OnClickListener {
    private final int layoutID = com.qltc.finace.R.layout.fragment_home;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy topCategoryAdapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy numberFormat$delegate = null;
    
    public FragmentHome() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.home.HomeViewModel getViewModel() {
        return null;
    }
    
    private final com.qltc.finace.view.adapter.AdapterTopCategory getTopCategoryAdapter() {
        return null;
    }
    
    private final com.qltc.finace.view.adapter.AdapterExpenseIncomeReport getAdapter() {
        return null;
    }
    
    private final java.text.NumberFormat getNumberFormat() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onResume() {
    }
    
    private final void setupViews() {
    }
    
    private final void observeData() {
    }
    
    private final java.lang.String formatCurrency(long amount) {
        return null;
    }
    
    private final void showError(java.lang.String message) {
    }
    
    private final void safeNavigate(int destinationId, android.os.Bundle args) {
    }
    
    @java.lang.Override()
    public void onNotificationClick() {
    }
    
    @java.lang.Override()
    public void onToggleBalanceClick() {
    }
    
    @java.lang.Override()
    public void onTabSelected(int position) {
    }
    
    @java.lang.Override()
    public void onViewAllTransactionsClick() {
    }
    
    @java.lang.Override()
    public void onClickItemEI(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.main.calendar.FinancialRecord item) {
    }
    
    @java.lang.Override()
    public void onIncomeCardClick() {
    }
    
    @java.lang.Override()
    public void onExpenseCardClick() {
    }
    
    @java.lang.Override()
    public void onClickCategory(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.CategoryOverView item) {
    }
    
    /**
     * Cập nhật BarChart để hiển thị thu nhập hoặc chi tiêu 6 tháng gần nhất
     *
     * @param isExpenseTab true nếu đang hiển thị tab Chi tiêu, false nếu đang hiển thị tab Thu nhập
     */
    private final void updateBarChart(boolean isExpenseTab) {
    }
}