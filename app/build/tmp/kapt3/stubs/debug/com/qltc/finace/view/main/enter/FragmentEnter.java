package com.qltc.finace.view.main.enter;

import android.os.Bundle;
import android.view.View;
import androidx.viewpager2.widget.ViewPager2.OnPageChangeCallback;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.databinding.FragmentEnterBinding;
import com.google.android.material.tabs.TabLayoutMediator;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001a2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\u001aB\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u0011H\u0016J\u001a\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0011H\u0002J\b\u0010\u0019\u001a\u00020\u0011H\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001b"}, d2 = {"Lcom/qltc/finace/view/main/enter/FragmentEnter;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentEnterBinding;", "Lcom/qltc/finace/view/main/enter/BaseEnterViewModel;", "Lcom/qltc/finace/view/main/enter/EnterListener;", "()V", "layoutID", "", "getLayoutID", "()I", "viewModel", "Lcom/qltc/finace/view/main/enter/ShareEnterViewModel;", "getViewModel", "()Lcom/qltc/finace/view/main/enter/ShareEnterViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onBackPressed", "", "onClickInputData", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "onViewPagerChange", "setupViewPager", "Companion", "app_debug"})
public final class FragmentEnter extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentEnterBinding, com.qltc.finace.view.main.enter.BaseEnterViewModel> implements com.qltc.finace.view.main.enter.EnterListener {
    private final int layoutID = com.qltc.finace.R.layout.fragment_enter;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    public static final int FRAGMENT_EXPENSE = 1;
    public static final int FRAGMENT_INCOME = 0;
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.enter.FragmentEnter.Companion Companion = null;
    
    public FragmentEnter() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.enter.ShareEnterViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewPager() {
    }
    
    private final void onViewPagerChange() {
    }
    
    @java.lang.Override()
    public void onClickInputData() {
    }
    
    @java.lang.Override()
    public void onBackPressed() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/qltc/finace/view/main/enter/FragmentEnter$Companion;", "", "()V", "FRAGMENT_EXPENSE", "", "FRAGMENT_INCOME", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}