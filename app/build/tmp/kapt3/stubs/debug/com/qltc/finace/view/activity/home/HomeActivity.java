package com.qltc.finace.view.activity.home;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseActivity;
import com.qltc.finace.databinding.ActivityMainBinding;
import com.qltc.finace.databinding.NavHeaderMainBinding;
import com.qltc.finace.view.activity.authen.AuthenticationActivity;
import com.qltc.finace.view.main.webview.NotebookLMOptionDialog;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import dagger.hilt.android.AndroidEntryPoint;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0014J\b\u0010\u001d\u001a\u00020\u001aH\u0002J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\b\u0010\u001f\u001a\u00020\u001aH\u0002J\u0006\u0010 \u001a\u00020\u001aR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u0014\u0010\r\u001a\u00020\u000eX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\f\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006!"}, d2 = {"Lcom/qltc/finace/view/activity/home/HomeActivity;", "Lcom/qltc/finace/base/BaseActivity;", "Lcom/qltc/finace/databinding/ActivityMainBinding;", "Lcom/qltc/finace/view/activity/home/HomeActivityViewModel;", "()V", "googleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "headerDrawer", "Lcom/qltc/finace/databinding/NavHeaderMainBinding;", "getHeaderDrawer", "()Lcom/qltc/finace/databinding/NavHeaderMainBinding;", "headerDrawer$delegate", "Lkotlin/Lazy;", "layoutId", "", "getLayoutId", "()I", "navController", "Landroidx/navigation/NavController;", "navHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/activity/home/HomeActivityViewModel;", "viewModel$delegate", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupDrawerLayout", "setupKeyboardVisibilityListener", "setupNavigation", "signOutFromGoogle", "app_debug"})
public final class HomeActivity extends com.qltc.finace.base.BaseActivity<com.qltc.finace.databinding.ActivityMainBinding, com.qltc.finace.view.activity.home.HomeActivityViewModel> {
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutId = com.qltc.finace.R.layout.activity_main;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient googleSignInClient;
    @org.jetbrains.annotations.Nullable()
    private androidx.navigation.fragment.NavHostFragment navHostFragment;
    @org.jetbrains.annotations.Nullable()
    private androidx.navigation.NavController navController;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy headerDrawer$delegate = null;
    
    public HomeActivity() {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.activity.home.HomeActivityViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutId() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.databinding.NavHeaderMainBinding getHeaderDrawer() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupNavigation() {
    }
    
    private final void setupKeyboardVisibilityListener() {
    }
    
    private final void setupDrawerLayout() {
    }
    
    public final void signOutFromGoogle() {
    }
}