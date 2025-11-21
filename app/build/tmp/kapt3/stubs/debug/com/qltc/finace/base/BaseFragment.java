package com.qltc.finace.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.viewbinding.ViewBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00042\u00020\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J!\u0010\u0015\u001a\u0004\u0018\u0001H\u0016\"\u0010\b\u0002\u0010\u0016*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0017H\u0004\u00a2\u0006\u0002\u0010\u0018J&\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010!\u001a\u00020\"H\u0016R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u0084\u000e\u00a2\u0006\u0010\n\u0002\u0010\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0012\u0010\r\u001a\u00020\u000eX\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00028\u00008DX\u0084\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0012\u0010\tR\u0012\u0010\u0003\u001a\u00028\u0001X\u00a4\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014\u00a8\u0006#"}, d2 = {"Lcom/qltc/finace/base/BaseFragment;", "ViewBinding", "Landroidx/databinding/ViewDataBinding;", "viewModel", "Lcom/qltc/finace/base/BaseViewModel;", "Landroidx/fragment/app/Fragment;", "()V", "_binding", "get_binding", "()Landroidx/databinding/ViewDataBinding;", "set_binding", "(Landroidx/databinding/ViewDataBinding;)V", "Landroidx/databinding/ViewDataBinding;", "layoutID", "", "getLayoutID", "()I", "viewBinding", "getViewBinding", "getViewModel", "()Lcom/qltc/finace/base/BaseViewModel;", "getOwnerActivity", "T", "Lcom/qltc/finace/base/BaseActivity;", "()Lcom/qltc/finace/base/BaseActivity;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "", "app_debug"})
public abstract class BaseFragment<ViewBinding extends androidx.databinding.ViewDataBinding, viewModel extends com.qltc.finace.base.BaseViewModel> extends androidx.fragment.app.Fragment {
    @org.jetbrains.annotations.Nullable()
    private ViewBinding _binding;
    
    public BaseFragment() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final ViewBinding get_binding() {
        return null;
    }
    
    protected final void set_binding(@org.jetbrains.annotations.Nullable()
    ViewBinding p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    protected final ViewBinding getViewBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    protected abstract viewModel getViewModel();
    
    protected abstract int getLayoutID();
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final <T extends com.qltc.finace.base.BaseActivity<?, ?>>T getOwnerActivity() {
        return null;
    }
    
    @java.lang.Override()
    public void onDestroyView() {
    }
}