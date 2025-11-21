package com.qltc.finace.utils;

import android.view.View;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.google.android.material.tabs.TabLayout;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0007\u00a2\u0006\u0002\u0010\u0006\u001a\u001f\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007\u00a2\u0006\u0002\u0010\n\u001a\u001f\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007\u00a2\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007\u00a2\u0006\u0002\u0010\u000e\u001a\u001f\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0007\u00a2\u0006\u0002\u0010\u000e\u00a8\u0006\u0011"}, d2 = {"setBalanceChange", "", "textView", "Landroid/widget/TextView;", "change", "", "(Landroid/widget/TextView;Ljava/lang/Double;)V", "setBalanceVisibility", "isVisible", "", "(Landroid/widget/TextView;Ljava/lang/Boolean;)V", "setMoneyBalance", "amount", "", "(Landroid/widget/TextView;Ljava/lang/Long;)V", "setMoneyExpense", "setMoneyIncome", "app_debug"})
public final class BindingAdaptersKt {
    
    @androidx.databinding.BindingAdapter(value = {"setMoneyBalance"})
    public static final void setMoneyBalance(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.Long amount) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"setBalanceVisibility"})
    public static final void setBalanceVisibility(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.Boolean isVisible) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"setMoneyIncome"})
    public static final void setMoneyIncome(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.Long amount) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"setMoneyExpense"})
    public static final void setMoneyExpense(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.Long amount) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"setBalanceChange"})
    public static final void setBalanceChange(@org.jetbrains.annotations.NotNull()
    android.widget.TextView textView, @org.jetbrains.annotations.Nullable()
    java.lang.Double change) {
    }
}