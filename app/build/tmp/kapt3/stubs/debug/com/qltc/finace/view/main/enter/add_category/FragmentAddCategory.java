package com.qltc.finace.view.main.enter.add_category;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.data.Fb;
import com.qltc.finace.databinding.AddCategoryBinding;
import com.qltc.finace.view.adapter.AdapterIcon;
import com.qltc.finace.view.main.enter.category.FragmentCategoryDetail;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u000e2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00120\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0018H\u0016J\b\u0010\u001d\u001a\u00020\u0018H\u0016J\u0012\u0010\u001e\u001a\u00020\u00182\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\u00182\u0006\u0010\"\u001a\u00020#2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\u0018H\u0002R\u001b\u0010\u0007\u001a\u00020\b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0016\u0010\f\u001a\u0004\b\u0014\u0010\u0015\u00a8\u0006%"}, d2 = {"Lcom/qltc/finace/view/main/enter/add_category/FragmentAddCategory;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/AddCategoryBinding;", "Lcom/qltc/finace/view/main/enter/add_category/AddCategoryViewModel;", "Lcom/qltc/finace/view/main/enter/add_category/AddCategoryListener;", "Lcom/qltc/finace/view/adapter/AdapterIcon$IconOnClickListener;", "()V", "adapter", "Lcom/qltc/finace/view/adapter/AdapterIcon;", "getAdapter", "()Lcom/qltc/finace/view/adapter/AdapterIcon;", "adapter$delegate", "Lkotlin/Lazy;", "layoutID", "", "getLayoutID", "()I", "typeCategory", "", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/enter/add_category/AddCategoryViewModel;", "viewModel$delegate", "onClick", "", "position", "listIcon", "", "onClickAddNewCategory", "onClickBack", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "Landroid/view/View;", "showToast", "app_debug"})
public final class FragmentAddCategory extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.AddCategoryBinding, com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel> implements com.qltc.finace.view.main.enter.add_category.AddCategoryListener, com.qltc.finace.view.adapter.AdapterIcon.IconOnClickListener {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.add_category;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy adapter$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String typeCategory = "CategoryIncome";
    
    public FragmentAddCategory() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    private final com.qltc.finace.view.adapter.AdapterIcon getAdapter() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onClick(int position, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> listIcon) {
    }
    
    @java.lang.Override()
    public void onClickAddNewCategory() {
    }
    
    private final void showToast() {
    }
    
    @java.lang.Override()
    public void onClickBack() {
    }
}