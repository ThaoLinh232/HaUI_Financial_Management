package com.qltc.finace.view.main.calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.base.Constant;
import com.qltc.finace.databinding.DayOfWeekHeaderBinding;
import com.qltc.finace.databinding.FragmentCalendarBinding;
import com.qltc.finace.view.adapter.AdapterExpenseIncomeReport;
import com.kizitonwose.calendar.core.CalendarMonth;
import com.kizitonwose.calendar.view.MonthHeaderFooterBinder;
import com.kizitonwose.calendar.view.ViewContainer;
import dagger.hilt.android.AndroidEntryPoint;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.YearMonth;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006B\u0005\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\u0016\u001a\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u0017H\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\u001a\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u001fH\u0016J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\"\u001a\u00020#H\u0016J\u001a\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010(H\u0016R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0015\u0010\r\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006)"}, d2 = {"Lcom/qltc/finace/view/main/calendar/CalendarFragment;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentCalendarBinding;", "Lcom/qltc/finace/view/main/calendar/CalendarViewModel;", "Lcom/qltc/finace/view/main/calendar/CalendarListener;", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport$OnClickListener;", "Lcom/qltc/finace/view/main/calendar/MondayView$OnClickDayListener;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterExpenseIncomeReport;", "adapter$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/calendar/CalendarViewModel;", "viewModel$delegate", "configureBinders", "", "daysOfWeek", "", "Ljava/time/DayOfWeek;", "exFiveNextMonthImage", "exFivePreviousMonthImage", "onClickDay", "selectedDate", "Ljava/time/LocalDate;", "oldDate", "onClickItemEI", "item", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class CalendarFragment extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentCalendarBinding, com.qltc.finace.view.main.calendar.CalendarViewModel> implements com.qltc.finace.view.main.calendar.CalendarListener, com.qltc.finace.view.adapter.AdapterExpenseIncomeReport.OnClickListener, com.qltc.finace.view.main.calendar.MondayView.OnClickDayListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_calendar;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    
    public CalendarFragment() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.calendar.CalendarViewModel getViewModel() {
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
    
    private final void configureBinders(java.util.List<? extends java.time.DayOfWeek> daysOfWeek) {
    }
    
    @java.lang.Override()
    public void onClickDay(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate selectedDate, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate oldDate) {
    }
    
    @java.lang.Override()
    public void exFiveNextMonthImage() {
    }
    
    @java.lang.Override()
    public void exFivePreviousMonthImage() {
    }
    
    @java.lang.Override()
    public void onClickItemEI(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.main.calendar.FinancialRecord item) {
    }
}