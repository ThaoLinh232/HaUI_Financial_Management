package com.qltc.finace.view.main.export;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import com.qltc.finace.R;
import java.time.LocalDate;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00126\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000b0\b\u00a2\u0006\u0002\u0010\fJ\b\u0010\u0015\u001a\u00020\u0005H\u0002J\b\u0010\u0016\u001a\u00020\u0005H\u0002J\u0012\u0010\u0017\u001a\u00020\u000b2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R>\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0011X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/qltc/finace/view/main/export/DateRangePickerDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "startDate", "Ljava/time/LocalDate;", "endDate", "onDateRangeSelected", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "", "(Landroid/content/Context;Ljava/time/LocalDate;Ljava/time/LocalDate;Lkotlin/jvm/functions/Function2;)V", "btnApply", "Landroid/widget/Button;", "btnCancel", "endDatePicker", "Landroid/widget/DatePicker;", "startDatePicker", "tvError", "Landroid/widget/TextView;", "getEndDateFromPicker", "getStartDateFromPicker", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "app_debug"})
public final class DateRangePickerDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate startDate;
    @org.jetbrains.annotations.NotNull()
    private java.time.LocalDate endDate;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function2<java.time.LocalDate, java.time.LocalDate, kotlin.Unit> onDateRangeSelected = null;
    private android.widget.Button btnCancel;
    private android.widget.Button btnApply;
    private android.widget.DatePicker startDatePicker;
    private android.widget.DatePicker endDatePicker;
    private android.widget.TextView tvError;
    
    public DateRangePickerDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate endDate, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.time.LocalDate, ? super java.time.LocalDate, kotlin.Unit> onDateRangeSelected) {
        super(null);
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final java.time.LocalDate getStartDateFromPicker() {
        return null;
    }
    
    private final java.time.LocalDate getEndDateFromPicker() {
        return null;
    }
}