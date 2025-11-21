package com.qltc.finace.view.main.report.chart;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.qltc.finace.R;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\u001b\u001a\u00020\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u0019H\u0002J\u0014\u0010\u001f\u001a\u00020\u00192\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006 "}, d2 = {"Lcom/qltc/finace/view/main/report/chart/PieChartReport;", "Lcom/github/mikephil/charting/charts/PieChart;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "pieDataSet", "Lcom/github/mikephil/charting/data/PieDataSet;", "getPieDataSet", "()Lcom/github/mikephil/charting/data/PieDataSet;", "valueFormatter", "Lcom/qltc/finace/view/main/report/chart/PercentFormatter;", "getValueFormatter", "()Lcom/qltc/finace/view/main/report/chart/PercentFormatter;", "valueFormatter$delegate", "Lkotlin/Lazy;", "createPieData", "Lcom/github/mikephil/charting/data/PieData;", "list", "", "Lcom/github/mikephil/charting/data/PieEntry;", "formatText", "", "setLinePart", "setPieChartReportDefault", "centerTextLabel", "", "sliceSpace", "submitList", "app_debug"})
public final class PieChartReport extends com.github.mikephil.charting.charts.PieChart {
    @org.jetbrains.annotations.NotNull()
    private final com.github.mikephil.charting.data.PieDataSet pieDataSet = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy valueFormatter$delegate = null;
    
    @kotlin.jvm.JvmOverloads()
    public PieChartReport(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs, int defStyleAttr) {
        super(null);
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.github.mikephil.charting.data.PieDataSet getPieDataSet() {
        return null;
    }
    
    private final com.qltc.finace.view.main.report.chart.PercentFormatter getValueFormatter() {
        return null;
    }
    
    public final void setPieChartReportDefault(@org.jetbrains.annotations.NotNull()
    java.lang.String centerTextLabel) {
    }
    
    public final void submitList(@org.jetbrains.annotations.NotNull()
    java.util.List<com.github.mikephil.charting.data.PieEntry> list) {
    }
    
    private final void formatText() {
    }
    
    private final void sliceSpace() {
    }
    
    private final void setLinePart() {
    }
    
    private final com.github.mikephil.charting.data.PieData createPieData(java.util.List<com.github.mikephil.charting.data.PieEntry> list) {
        return null;
    }
    
    @kotlin.jvm.JvmOverloads()
    public PieChartReport(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null);
    }
    
    @kotlin.jvm.JvmOverloads()
    public PieChartReport(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.Nullable()
    android.util.AttributeSet attrs) {
        super(null);
    }
}