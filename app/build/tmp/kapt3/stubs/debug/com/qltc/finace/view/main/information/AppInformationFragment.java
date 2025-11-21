package com.qltc.finace.view.main.information;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.qltc.finace.BuildConfig;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.databinding.FragmentAppInformationBinding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\u0010H\u0016J\u001a\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\u0019\u001a\u00020\u00102\u0006\u0010\u001a\u001a\u00020\u001bH\u0002R\u0014\u0010\u0006\u001a\u00020\u0007X\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f\u00a8\u0006\u001c"}, d2 = {"Lcom/qltc/finace/view/main/information/AppInformationFragment;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentAppInformationBinding;", "Lcom/qltc/finace/view/main/information/AppInformationViewModel;", "Lcom/qltc/finace/view/main/information/AppInfoListener;", "()V", "layoutID", "", "getLayoutID", "()I", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/main/information/AppInformationViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "onBackClicked", "", "onPrivacyPolicyClicked", "onRateAppClicked", "onTermsOfServiceClicked", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "openWebPage", "url", "", "app_debug"})
public final class AppInformationFragment extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentAppInformationBinding, com.qltc.finace.view.main.information.AppInformationViewModel> implements com.qltc.finace.view.main.information.AppInfoListener {
    private final int layoutID = com.qltc.finace.R.layout.fragment_app_information;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    
    public AppInformationFragment() {
        super();
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.main.information.AppInformationViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onBackClicked() {
    }
    
    @java.lang.Override()
    public void onPrivacyPolicyClicked() {
    }
    
    @java.lang.Override()
    public void onTermsOfServiceClicked() {
    }
    
    @java.lang.Override()
    public void onRateAppClicked() {
    }
    
    private final void openWebPage(java.lang.String url) {
    }
}