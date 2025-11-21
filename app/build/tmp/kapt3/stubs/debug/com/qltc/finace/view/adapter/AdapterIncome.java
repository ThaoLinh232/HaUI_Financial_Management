package com.qltc.finace.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.qltc.finace.R;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.databinding.ItemCategoryBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0003\u0010\u0011\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterIncome;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/qltc/finace/data/entity/Category;", "Lcom/qltc/finace/view/adapter/AdapterIncome$CategoryViewHolder;", "onClickListener", "Lcom/qltc/finace/view/adapter/AdapterIncome$OnClickListener;", "(Lcom/qltc/finace/view/adapter/AdapterIncome$OnClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Callback", "CategoryViewHolder", "OnClickListener", "app_debug"})
public final class AdapterIncome extends androidx.recyclerview.widget.ListAdapter<com.qltc.finace.data.entity.Category, com.qltc.finace.view.adapter.AdapterIncome.CategoryViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private com.qltc.finace.view.adapter.AdapterIncome.OnClickListener onClickListener;
    
    public AdapterIncome(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.adapter.AdapterIncome.OnClickListener onClickListener) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.qltc.finace.view.adapter.AdapterIncome.CategoryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.adapter.AdapterIncome.CategoryViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterIncome$Callback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qltc/finace/data/entity/Category;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class Callback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.qltc.finace.data.entity.Category> {
        
        public Callback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.Category oldItem, @org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.Category newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.Category oldItem, @org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.Category newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004\u00a8\u0006\f"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterIncome$CategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Lcom/qltc/finace/databinding/ItemCategoryBinding;", "(Lcom/qltc/finace/databinding/ItemCategoryBinding;)V", "getView", "()Lcom/qltc/finace/databinding/ItemCategoryBinding;", "setView", "bind", "", "item", "Lcom/qltc/finace/data/entity/Category;", "app_debug"})
    public static final class CategoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.qltc.finace.databinding.ItemCategoryBinding view;
        
        public CategoryViewHolder(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.databinding.ItemCategoryBinding view) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.qltc.finace.databinding.ItemCategoryBinding getView() {
            return null;
        }
        
        public final void setView(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.databinding.ItemCategoryBinding p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.Category item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&\u00a8\u0006\t"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterIncome$OnClickListener;", "", "onClick", "", "position", "", "listCategory", "", "Lcom/qltc/finace/data/entity/Category;", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void onClick(int position, @org.jetbrains.annotations.NotNull()
        java.util.List<com.qltc.finace.data.entity.Category> listCategory);
    }
}