package com.qltc.finace.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.qltc.finace.R;
import com.qltc.finace.data.entity.CategoryOverView;
import com.qltc.finace.databinding.ItemTotalCategoryBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0003\u0010\u0011\u0012B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u001c\u0010\f\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterTopCategory;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/qltc/finace/data/entity/CategoryOverView;", "Lcom/qltc/finace/view/adapter/AdapterTopCategory$CategoryViewHolder;", "onClickListener", "Lcom/qltc/finace/view/adapter/AdapterTopCategory$OnClickListener;", "(Lcom/qltc/finace/view/adapter/AdapterTopCategory$OnClickListener;)V", "onBindViewHolder", "", "holder", "position", "", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CategoryViewHolder", "DiffCallback", "OnClickListener", "app_debug"})
public final class AdapterTopCategory extends androidx.recyclerview.widget.ListAdapter<com.qltc.finace.data.entity.CategoryOverView, com.qltc.finace.view.adapter.AdapterTopCategory.CategoryViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private com.qltc.finace.view.adapter.AdapterTopCategory.OnClickListener onClickListener;
    
    public AdapterTopCategory(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.adapter.AdapterTopCategory.OnClickListener onClickListener) {
        super(null);
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.qltc.finace.view.adapter.AdapterTopCategory.CategoryViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.adapter.AdapterTopCategory.CategoryViewHolder holder, int position) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterTopCategory$CategoryViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "viewBinding", "Lcom/qltc/finace/databinding/ItemTotalCategoryBinding;", "(Lcom/qltc/finace/view/adapter/AdapterTopCategory;Lcom/qltc/finace/databinding/ItemTotalCategoryBinding;)V", "getViewBinding", "()Lcom/qltc/finace/databinding/ItemTotalCategoryBinding;", "setViewBinding", "(Lcom/qltc/finace/databinding/ItemTotalCategoryBinding;)V", "bind", "", "item", "Lcom/qltc/finace/data/entity/CategoryOverView;", "app_debug"})
    public final class CategoryViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private com.qltc.finace.databinding.ItemTotalCategoryBinding viewBinding;
        
        public CategoryViewHolder(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.databinding.ItemTotalCategoryBinding viewBinding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.qltc.finace.databinding.ItemTotalCategoryBinding getViewBinding() {
            return null;
        }
        
        public final void setViewBinding(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.databinding.ItemTotalCategoryBinding p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.CategoryOverView item) {
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016\u00a8\u0006\t"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterTopCategory$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/qltc/finace/data/entity/CategoryOverView;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "app_debug"})
    public static final class DiffCallback extends androidx.recyclerview.widget.DiffUtil.ItemCallback<com.qltc.finace.data.entity.CategoryOverView> {
        
        public DiffCallback() {
            super();
        }
        
        @java.lang.Override()
        public boolean areItemsTheSame(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.CategoryOverView oldItem, @org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.CategoryOverView newItem) {
            return false;
        }
        
        @java.lang.Override()
        public boolean areContentsTheSame(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.CategoryOverView oldItem, @org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.CategoryOverView newItem) {
            return false;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&\u00a8\u0006\u0006"}, d2 = {"Lcom/qltc/finace/view/adapter/AdapterTopCategory$OnClickListener;", "", "onClickCategory", "", "item", "Lcom/qltc/finace/data/entity/CategoryOverView;", "app_debug"})
    public static abstract interface OnClickListener {
        
        public abstract void onClickCategory(@org.jetbrains.annotations.NotNull()
        com.qltc.finace.data.entity.CategoryOverView item);
    }
}