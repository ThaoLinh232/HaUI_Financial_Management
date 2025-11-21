package com.qltc.finace.view.main.report;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.qltc.finace.R;
import java.time.YearMonth;
import java.util.Calendar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \"2\u00020\u0001:\u0001\"B8\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\u0019\u001a\u00020\u000b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0014J\b\u0010\u001c\u001a\u00020\u000bH\u0002J\b\u0010\u001d\u001a\u00020\u000bH\u0002J\u0014\u0010\u001e\u001a\u00020\u000b*\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u00020\u000b*\u00020\u00152\u0006\u0010\u001f\u001a\u00020 H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\u0005\u00a2\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/qltc/finace/view/main/report/MonthYearPickerDialog;", "Landroid/app/Dialog;", "context", "Landroid/content/Context;", "selectedMonth", "Ljava/time/YearMonth;", "onMonthYearSelected", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "yearMonth", "", "(Landroid/content/Context;Ljava/time/YearMonth;Lkotlin/jvm/functions/Function1;)V", "btnCancel", "Landroid/widget/Button;", "btnConfirm", "monthNames", "", "", "[Ljava/lang/String;", "monthPicker", "Landroid/widget/NumberPicker;", "tvTitle", "Landroid/widget/TextView;", "yearPicker", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setupButtons", "setupPickers", "setDividerColor", "color", "", "setTextColor", "Companion", "app_debug"})
public final class MonthYearPickerDialog extends android.app.Dialog {
    @org.jetbrains.annotations.NotNull()
    private java.time.YearMonth selectedMonth;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.time.YearMonth, kotlin.Unit> onMonthYearSelected = null;
    private static final int MIN_YEAR = 2015;
    private static final int MAX_YEAR = 0;
    private android.widget.NumberPicker monthPicker;
    private android.widget.NumberPicker yearPicker;
    private android.widget.Button btnCancel;
    private android.widget.Button btnConfirm;
    private android.widget.TextView tvTitle;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String[] monthNames = {"Th\u00e1ng 1", "Th\u00e1ng 2", "Th\u00e1ng 3", "Th\u00e1ng 4", "Th\u00e1ng 5", "Th\u00e1ng 6", "Th\u00e1ng 7", "Th\u00e1ng 8", "Th\u00e1ng 9", "Th\u00e1ng 10", "Th\u00e1ng 11", "Th\u00e1ng 12"};
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.report.MonthYearPickerDialog.Companion Companion = null;
    
    public MonthYearPickerDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.time.YearMonth selectedMonth, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.time.YearMonth, kotlin.Unit> onMonthYearSelected) {
        super(null);
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupPickers() {
    }
    
    private final void setupButtons() {
    }
    
    private final void setDividerColor(android.widget.NumberPicker $this$setDividerColor, int color) {
    }
    
    private final void setTextColor(android.widget.NumberPicker $this$setTextColor, int color) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/qltc/finace/view/main/report/MonthYearPickerDialog$Companion;", "", "()V", "MAX_YEAR", "", "MIN_YEAR", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}