package com.qltc.finace.data.entity;

import com.qltc.finace.R;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b*\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u0004J\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000404R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\'\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u001a\u0010.\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u0002000/X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/qltc/finace/data/entity/Icon;", "", "()V", "ic_1", "", "ic_10", "ic_11", "ic_12", "ic_13", "ic_14", "ic_15", "ic_16", "ic_17", "ic_18", "ic_19", "ic_2", "ic_20", "ic_21", "ic_22", "ic_23", "ic_24", "ic_25", "ic_26", "ic_27", "ic_28", "ic_29", "ic_3", "ic_30", "ic_31", "ic_32", "ic_33", "ic_34", "ic_35", "ic_36", "ic_37", "ic_38", "ic_39", "ic_4", "ic_40", "ic_41", "ic_42", "ic_5", "ic_6", "ic_7", "ic_8", "ic_9", "iconMap", "", "", "getIcon", "iconName", "getListIcon", "", "app_debug"})
public final class Icon {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.Map<java.lang.String, java.lang.Integer> iconMap = null;
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_1 = "ic_1";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_2 = "ic_2";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_3 = "ic_3";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_4 = "ic_4";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_5 = "ic_5";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_6 = "ic_6";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_7 = "ic_7";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_8 = "ic_8";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_9 = "ic_9";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_10 = "ic_10";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_11 = "ic_11";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_12 = "ic_12";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_13 = "ic_13";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_14 = "ic_14";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_15 = "ic_15";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_16 = "ic_16";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_17 = "ic_17";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_18 = "ic_18";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_19 = "ic_19";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_20 = "ic_20";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_21 = "ic_21";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_22 = "ic_22";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_23 = "ic_23";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_24 = "ic_24";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_25 = "ic_25";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_26 = "ic_26";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_27 = "ic_27";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_28 = "ic_28";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_29 = "ic_29";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_30 = "ic_30";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_31 = "ic_31";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_32 = "ic_32";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_33 = "ic_33";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_34 = "ic_34";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_35 = "ic_35";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_36 = "ic_36";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_37 = "ic_37";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_38 = "ic_38";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_39 = "ic_39";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_40 = "ic_40";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_41 = "ic_41";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String ic_42 = "ic_42";
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.data.entity.Icon INSTANCE = null;
    
    private Icon() {
        super();
    }
    
    public final int getIcon(@org.jetbrains.annotations.NotNull()
    java.lang.String iconName) {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getListIcon() {
        return null;
    }
}