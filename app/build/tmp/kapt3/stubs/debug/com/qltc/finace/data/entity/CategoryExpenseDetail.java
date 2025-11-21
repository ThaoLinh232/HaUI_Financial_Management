package com.qltc.finace.data.entity;

import com.github.mikephil.charting.data.PieEntry;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\tJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0003J1\u0010\u0019\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006!"}, d2 = {"Lcom/qltc/finace/data/entity/CategoryExpenseDetail;", "", "category", "Lcom/qltc/finace/data/entity/Category;", "totalAmount", "", "listExpense", "", "Lcom/qltc/finace/data/entity/Expense;", "(Lcom/qltc/finace/data/entity/Category;JLjava/util/List;)V", "getCategory", "()Lcom/qltc/finace/data/entity/Category;", "setCategory", "(Lcom/qltc/finace/data/entity/Category;)V", "getListExpense", "()Ljava/util/List;", "setListExpense", "(Ljava/util/List;)V", "getTotalAmount", "()J", "setTotalAmount", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class CategoryExpenseDetail {
    @org.jetbrains.annotations.Nullable()
    private com.qltc.finace.data.entity.Category category;
    private long totalAmount;
    @org.jetbrains.annotations.Nullable()
    private java.util.List<com.qltc.finace.data.entity.Expense> listExpense;
    
    public CategoryExpenseDetail(@org.jetbrains.annotations.Nullable()
    com.qltc.finace.data.entity.Category category, long totalAmount, @org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.Expense> listExpense) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.data.entity.Category getCategory() {
        return null;
    }
    
    public final void setCategory(@org.jetbrains.annotations.Nullable()
    com.qltc.finace.data.entity.Category p0) {
    }
    
    public final long getTotalAmount() {
        return 0L;
    }
    
    public final void setTotalAmount(long p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.qltc.finace.data.entity.Expense> getListExpense() {
        return null;
    }
    
    public final void setListExpense(@org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.Expense> p0) {
    }
    
    public CategoryExpenseDetail() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.data.entity.Category component1() {
        return null;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<com.qltc.finace.data.entity.Expense> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.data.entity.CategoryExpenseDetail copy(@org.jetbrains.annotations.Nullable()
    com.qltc.finace.data.entity.Category category, long totalAmount, @org.jetbrains.annotations.Nullable()
    java.util.List<com.qltc.finace.data.entity.Expense> listExpense) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}