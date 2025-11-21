package com.qltc.finace.view.activity.home;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseViewModel;
import com.google.firebase.auth.FirebaseAuth;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0006\u0010\u000e\u001a\u00020\u000fR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/qltc/finace/view/activity/home/HomeActivityViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "applicationContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getApplicationContext", "()Landroid/content/Context;", "userName", "Landroidx/lifecycle/MutableLiveData;", "", "getUserName", "()Landroidx/lifecycle/MutableLiveData;", "setUserName", "(Landroidx/lifecycle/MutableLiveData;)V", "getUserNameCurrent", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeActivityViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context applicationContext = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> userName;
    
    @javax.inject.Inject()
    public HomeActivityViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context applicationContext) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getApplicationContext() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getUserName() {
        return null;
    }
    
    public final void setUserName(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    public final void getUserNameCurrent() {
    }
}