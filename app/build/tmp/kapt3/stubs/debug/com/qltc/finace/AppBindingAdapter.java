package com.qltc.finace;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.databinding.BindingAdapter;
import com.qltc.finace.data.Fb;
import com.qltc.finace.data.entity.Icon;
import com.qltc.finace.data.entity.CategoryOverView;
import com.qltc.finace.view.main.calendar.FinancialRecord;
import com.google.android.material.imageview.ShapeableImageView;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Locale;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007J\u0014\u0010\b\u001a\u00020\u0004*\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0014\u0010\f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\u0014\u0010\f\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0010H\u0007J\u0014\u0010\u0011\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J#\u0010\u0014\u001a\u00020\u0004\"\b\b\u0000\u0010\u0015*\u00020\u0016*\u00020\r2\u0006\u0010\u0017\u001a\u0002H\u0015H\u0007\u00a2\u0006\u0002\u0010\u0018J\u0014\u0010\u0019\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0014\u0010\u001a\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001cH\u0007J\u0014\u0010\u001d\u001a\u00020\u0004*\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0007H\u0007J\u0014\u0010\u001e\u001a\u00020\u0004*\u00020\u001f2\u0006\u0010 \u001a\u00020\u000bH\u0007\u00a8\u0006!"}, d2 = {"Lcom/qltc/finace/AppBindingAdapter;", "", "()V", "setIcon", "", "Lcom/google/android/material/imageview/ShapeableImageView;", "name", "", "setIconEnableInputData", "Landroid/widget/ImageButton;", "flag", "", "setMoney", "Landroid/widget/TextView;", "item", "Lcom/qltc/finace/data/entity/CategoryOverView;", "Lcom/qltc/finace/view/main/calendar/FinancialRecord;", "setMoneyTotalReport", "long", "", "setTextFormat", "T", "", "money", "(Landroid/widget/TextView;Ljava/lang/Number;)V", "setTextWithTotalMoney", "setTimeFormatter", "time", "Ljava/time/LocalDate;", "setTimeString", "setVisible", "Landroid/view/View;", "boolean", "app_debug"})
public final class AppBindingAdapter {
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.AppBindingAdapter INSTANCE = null;
    
    private AppBindingAdapter() {
        super();
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setVisible"})
    public static final void setVisible(@org.jetbrains.annotations.NotNull()
    android.view.View $this$setVisible, boolean p1_32355860) {
    }
    
    @androidx.databinding.BindingAdapter(value = {"setTextFormat"})
    public final <T extends java.lang.Number>void setTextFormat(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setTextFormat, @org.jetbrains.annotations.NotNull()
    T money) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setIcon"})
    public static final void setIcon(@org.jetbrains.annotations.NotNull()
    com.google.android.material.imageview.ShapeableImageView $this$setIcon, @org.jetbrains.annotations.Nullable()
    java.lang.String name) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setIconEnableInputData"})
    public static final void setIconEnableInputData(@org.jetbrains.annotations.NotNull()
    android.widget.ImageButton $this$setIconEnableInputData, boolean flag) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setTimeFormatter"})
    public static final void setTimeFormatter(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setTimeFormatter, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate time) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setTimeString"})
    public static final void setTimeString(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setTimeString, @org.jetbrains.annotations.NotNull()
    java.lang.String time) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setMoney"})
    public static final void setMoney(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setMoney, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.main.calendar.FinancialRecord item) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setMoney"})
    public static final void setMoney(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setMoney, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.CategoryOverView item) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setTextWithTotalMoney"})
    public static final void setTextWithTotalMoney(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setTextWithTotalMoney, long p1_1663806) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"setMoneyTotalReport"})
    public static final void setMoneyTotalReport(@org.jetbrains.annotations.NotNull()
    android.widget.TextView $this$setMoneyTotalReport, long p1_1663806) {
    }
}