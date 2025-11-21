package com.qltc.finace.view.main.enter.category;

import android.util.Log;
import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.Fb;
import com.qltc.finace.data.entity.Category;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import dagger.hilt.android.lifecycle.HiltViewModel;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u000eJ$\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\b2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00140\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R&\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012\u00a8\u0006\u001a"}, d2 = {"Lcom/qltc/finace/view/main/enter/category/CategoryDetailViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "listCategory", "Landroidx/lifecycle/MutableLiveData;", "", "Lcom/qltc/finace/data/entity/Category;", "getListCategory", "()Landroidx/lifecycle/MutableLiveData;", "setListCategory", "(Landroidx/lifecycle/MutableLiveData;)V", "nameCategory", "", "getNameCategory", "()Ljava/lang/String;", "setNameCategory", "(Ljava/lang/String;)V", "getCategory", "", "typeCategory", "removeCategory", "category", "callback", "Lkotlin/Function0;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CategoryDetailViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.Category>> listCategory;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String nameCategory;
    
    @javax.inject.Inject()
    public CategoryDetailViewModel(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.Category>> getListCategory() {
        return null;
    }
    
    public final void setListCategory(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.util.List<com.qltc.finace.data.entity.Category>> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNameCategory() {
        return null;
    }
    
    public final void setNameCategory(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final void getCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String typeCategory) {
    }
    
    public final void removeCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String typeCategory, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.Category category, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> callback) {
    }
}