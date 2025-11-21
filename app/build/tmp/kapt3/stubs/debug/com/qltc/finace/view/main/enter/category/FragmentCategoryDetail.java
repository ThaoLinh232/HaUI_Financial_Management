package com.qltc.finace.view.main.enter.category;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.data.Fb;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.databinding.FragmentCategoryDetailBinding;
import com.qltc.finace.view.adapter.AdapterCategoryDetail;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 (2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u00052\u00020\u0006:\u0001(B\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u0019H\u0016J\u001e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001c\u001a\u00020\u000f2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eH\u0016J\u0010\u0010 \u001a\u00020\u00192\u0006\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\'H\u0016R\u001b\u0010\b\u001a\u00020\t8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u000e\u001a\u00020\u000fX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006)"}, d2 = {"Lcom/qltc/finace/view/main/enter/category/FragmentCategoryDetail;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentCategoryDetailBinding;", "Lcom/qltc/finace/view/main/enter/category/CategoryDetailViewModel;", "Lcom/qltc/finace/view/main/enter/category/CategoryDetailListener;", "Lcom/qltc/finace/view/adapter/AdapterCategoryDetail$OnClickListener;", "Lcom/qltc/finace/view/main/enter/category/OnSwipeItemCategoryDetail;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterCategoryDetail;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterCategoryDetail;", "adapter$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "typeCategory", "", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/enter/category/CategoryDetailViewModel;", "viewModel$delegate", "addCategory", "", "backPress", "onClick", "position", "listCategory", "", "Lcom/qltc/finace/data/entity/Category;", "onSwipe", "viewHolder", "Lcom/qltc/finace/view/adapter/AdapterCategoryDetail$CategoryDetailViewHolder;", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "app_debug"})
public final class FragmentCategoryDetail extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentCategoryDetailBinding, com.qltc.finace.view.main.enter.category.CategoryDetailViewModel> implements com.qltc.finace.view.main.enter.category.CategoryDetailListener, com.qltc.finace.view.adapter.AdapterCategoryDetail.OnClickListener, com.qltc.finace.view.main.enter.category.OnSwipeItemCategoryDetail {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_category_detail;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String typeCategory = "CategoryIncome";
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String KEY_CATEGORY = "KEY_CATEGORY";
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.enter.category.FragmentCategoryDetail.Companion Companion = null;
    
    public FragmentCategoryDetail() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.enter.category.CategoryDetailViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.view.adapter.AdapterCategoryDetail getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(int position, @org.jetbrains.annotations.NotNull()
    java.util.List<com.qltc.finace.data.entity.Category> listCategory) {
    }
    
    @java.lang.Override()
    public void backPress() {
    }
    
    @java.lang.Override()
    public void addCategory() {
    }
    
    @java.lang.Override()
    public void onSwipe(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.view.adapter.AdapterCategoryDetail.CategoryDetailViewHolder viewHolder) {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/qltc/finace/view/main/enter/category/FragmentCategoryDetail$Companion;", "", "()V", "KEY_CATEGORY", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}