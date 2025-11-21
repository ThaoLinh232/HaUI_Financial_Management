package com.qltc.finace.extension;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Patterns;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.annotation.IdRes;
import androidx.core.content.ContextCompat;
import androidx.navigation.NavController;
import com.qltc.finace.R;
import com.qltc.finace.base.Constant;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.entity.Expense;
import com.qltc.finace.data.entity.Income;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000v\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0019\u0010\u0003\u001a\u00020\u0001\"\b\b\u0000\u0010\u0004*\u00020\u0005*\u0002H\u0004\u00a2\u0006\u0002\u0010\u0006\u001a\n\u0010\u0007\u001a\u00020\u0001*\u00020\b\u001a\u0016\u0010\t\u001a\u00020\n*\u00020\u000b2\b\b\u0001\u0010\f\u001a\u00020\nH\u0000\u001a\f\u0010\r\u001a\u00020\u000e*\u0004\u0018\u00010\u000f\u001a\n\u0010\u0010\u001a\u00020\u000e*\u00020\u0001\u001a\n\u0010\u0011\u001a\u00020\u000e*\u00020\u0001\u001a\u001e\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\b\b\u0001\u0010\u0015\u001a\u00020\n2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u0013*\u00020\u00192\b\b\u0001\u0010\f\u001a\u00020\nH\u0000\u001a&\u0010\u001a\u001a\u00020\u0013*\u00020\u00192\b\u0010\u001b\u001a\u0004\u0018\u00010\u00022\b\u0010\u001c\u001a\u0004\u0018\u00010\b2\u0006\u0010\u001d\u001a\u00020\u000e\u001a\u0010\u0010\u001e\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020!0 \u001a\u0010\u0010\"\u001a\u00020\u001f*\b\u0012\u0004\u0012\u00020#0 \u001a\f\u0010$\u001a\u00020\u0002*\u0004\u0018\u00010\u0001\u001a\n\u0010%\u001a\u00020\u0001*\u00020\u0002\u001a.\u0010&\u001a\u0016\u0012\u0006\b\u0001\u0012\u00020(0\'j\n\u0012\u0006\b\u0001\u0012\u00020(`)\"\b\b\u0000\u0010\u0004*\u00020(*\b\u0012\u0004\u0012\u0002H\u00040*\u00a8\u0006+"}, d2 = {"formatDateTime", "", "Ljava/time/LocalDate;", "formatMoney", "T", "", "(Ljava/lang/Number;)Ljava/lang/String;", "formatMonthVN", "Ljava/time/YearMonth;", "getColorCompat", "", "Landroid/content/Context;", "color", "isNotNullAndNotEmpty", "", "", "isPasswordValid", "isValidEmail", "navigateWithAnim", "", "Landroidx/navigation/NavController;", "resId", "args", "Landroid/os/Bundle;", "setTextColorRes", "Landroid/widget/TextView;", "setTimeSelected", "time", "yearMonth", "isSelectedDay", "sumExpenseMoney", "", "", "Lcom/qltc/finace/data/entity/Expense;", "sumIncomeMoney", "Lcom/qltc/finace/data/entity/Income;", "toLocalDate", "toMonthYearString", "toParcelableArrayList", "Ljava/util/ArrayList;", "Landroid/os/Parcelable;", "Lkotlin/collections/ArrayList;", "", "app_debug"})
public final class ExtensionKt {
    
    public static final void navigateWithAnim(@org.jetbrains.annotations.NotNull()
    androidx.navigation.NavController $this$navigateWithAnim, @androidx.annotation.IdRes()
    int resId, @org.jetbrains.annotations.Nullable()
    android.os.Bundle args) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatMonthVN(@org.jetbrains.annotations.NotNull()
    java.time.YearMonth $this$formatMonthVN) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String formatDateTime(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate $this$formatDateTime) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String toMonthYearString(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate $this$toMonthYearString) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends java.lang.Number>java.lang.String formatMoney(@org.jetbrains.annotations.NotNull()
    T $this$formatMoney) {
        return null;
    }
    
    public static final boolean isPasswordValid(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$isPasswordValid) {
        return false;
    }
    
    public static final boolean isValidEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String $this$isValidEmail) {
        return false;
    }
    
    public static final boolean isNotNullAndNotEmpty(@org.jetbrains.annotations.Nullable()
    java.lang.CharSequence $this$isNotNullAndNotEmpty) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final java.time.LocalDate toLocalDate(@org.jetbrains.annotations.Nullable()
    java.lang.String $this$toLocalDate) {
        return null;
    }
    
    public static final int getColorCompat(@org.jetbrains.annotations.NotNull()
    android.content.Context $this$getColorCompat, @androidx.annotation.ColorRes()
    int color) {
        return 0;
    }
    
    public static final void setTextColorRes(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setTextColorRes, @androidx.annotation.ColorRes()
    int color) {
    }
    
    public static final void setTimeSelected(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setTimeSelected, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate time, @org.jetbrains.annotations.Nullable()
    java.time.YearMonth yearMonth, boolean isSelectedDay) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static final <T extends android.os.Parcelable>java.util.ArrayList<? extends android.os.Parcelable> toParcelableArrayList(@org.jetbrains.annotations.NotNull()
    java.util.List<T> $this$toParcelableArrayList) {
        return null;
    }
    
    public static final long sumExpenseMoney(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Expense> $this$sumExpenseMoney) {
        return 0L;
    }
    
    public static final long sumIncomeMoney(@org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Income> $this$sumIncomeMoney) {
        return 0L;
    }
}