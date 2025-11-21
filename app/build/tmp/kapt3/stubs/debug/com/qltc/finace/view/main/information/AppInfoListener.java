package com.qltc.finace.view.main.information;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&\u00a8\u0006\u0007"}, d2 = {"Lcom/qltc/finace/view/main/information/AppInfoListener;", "", "onBackClicked", "", "onPrivacyPolicyClicked", "onRateAppClicked", "onTermsOfServiceClicked", "app_debug"})
public abstract interface AppInfoListener {
    
    public abstract void onBackClicked();
    
    public abstract void onPrivacyPolicyClicked();
    
    public abstract void onTermsOfServiceClicked();
    
    public abstract void onRateAppClicked();
}