package com.qltc.finace.view.main.calendar;

import android.view.View;
import com.qltc.finace.R;
import com.qltc.finace.databinding.ItemDayViewCalendarBinding;
import com.kizitonwose.calendar.core.CalendarDay;
import com.kizitonwose.calendar.core.DayPosition;
import com.kizitonwose.calendar.view.MonthDayBinder;
import com.kizitonwose.calendar.view.ViewContainer;
import java.time.LocalDate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0002\u0014\u0015B\u0015\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\u001c\u0010\f\u001a\u00020\r2\n\u0010\u000e\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0014\u0010\u0011\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\u0016"}, d2 = {"Lcom/qltc/finace/view/main/calendar/MondayView;", "Lcom/kizitonwose/calendar/view/MonthDayBinder;", "Lcom/qltc/finace/view/main/calendar/MondayView$ItemDayViewCalendar;", "viewModel", "Lcom/qltc/finace/view/main/calendar/CalendarViewModel;", "onClickDay", "Lcom/qltc/finace/view/main/calendar/MondayView$OnClickDayListener;", "(Lcom/qltc/finace/view/main/calendar/CalendarViewModel;Lcom/qltc/finace/view/main/calendar/MondayView$OnClickDayListener;)V", "getOnClickDay", "()Lcom/qltc/finace/view/main/calendar/MondayView$OnClickDayListener;", "getViewModel", "()Lcom/qltc/finace/view/main/calendar/CalendarViewModel;", "bind", "", "container", "data", "Lcom/kizitonwose/calendar/core/CalendarDay;", "create", "view", "Landroid/view/View;", "ItemDayViewCalendar", "OnClickDayListener", "app_debug"})
public final class MondayView implements com.kizitonwose.calendar.view.MonthDayBinder<com.qltc.finace.view.main.calendar.MondayView.ItemDayViewCalendar> {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.view.main.calendar.CalendarViewModel viewModel = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.view.main.calendar.MondayView.OnClickDayListener onClickDay = null;
    
    public MondayView(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.main.calendar.CalendarViewModel viewModel, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.main.calendar.MondayView.OnClickDayListener onClickDay) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.view.main.calendar.CalendarViewModel getViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.view.main.calendar.MondayView.OnClickDayListener getOnClickDay() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.qltc.finace.view.main.calendar.MondayView.ItemDayViewCalendar create(@org.jetbrains.annotations.NotNull()
    android.view.View view) {
        return null;
    }
    
    @java.lang.Override()
    public void bind(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.main.calendar.MondayView.ItemDayViewCalendar container, @org.jetbrains.annotations.NotNull()
    com.kizitonwose.calendar.core.CalendarDay data) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u0010\u001a\u00020\u0011R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/qltc/finace/view/main/calendar/MondayView$ItemDayViewCalendar;", "Lcom/kizitonwose/calendar/view/ViewContainer;", "view", "Landroid/view/View;", "(Lcom/qltc/finace/view/main/calendar/MondayView;Landroid/view/View;)V", "binding", "Lcom/qltc/finace/databinding/ItemDayViewCalendarBinding;", "kotlin.jvm.PlatformType", "getBinding", "()Lcom/qltc/finace/databinding/ItemDayViewCalendarBinding;", "day", "Lcom/kizitonwose/calendar/core/CalendarDay;", "getDay", "()Lcom/kizitonwose/calendar/core/CalendarDay;", "setDay", "(Lcom/kizitonwose/calendar/core/CalendarDay;)V", "setUpView", "", "app_debug"})
    public final class ItemDayViewCalendar extends com.kizitonwose.calendar.view.ViewContainer {
        private final com.qltc.finace.databinding.ItemDayViewCalendarBinding binding = null;
        public com.kizitonwose.calendar.core.CalendarDay day;
        
        public ItemDayViewCalendar(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
        
        public final com.qltc.finace.databinding.ItemDayViewCalendarBinding getBinding() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.kizitonwose.calendar.core.CalendarDay getDay() {
            return null;
        }
        
        public final void setDay(@org.jetbrains.annotations.NotNull()
        com.kizitonwose.calendar.core.CalendarDay p0) {
        }
        
        public final void setUpView() {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&\u00a8\u0006\u0007"}, d2 = {"Lcom/qltc/finace/view/main/calendar/MondayView$OnClickDayListener;", "", "onClickDay", "", "selectedDate", "Ljava/time/LocalDate;", "oldDate", "app_debug"})
    public static abstract interface OnClickDayListener {
        
        public abstract void onClickDay(@org.jetbrains.annotations.NotNull()
        java.time.LocalDate selectedDate, @org.jetbrains.annotations.Nullable()
        java.time.LocalDate oldDate);
    }
}