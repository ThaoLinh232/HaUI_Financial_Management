package com.qltc.finace.view.authentication.otp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Toast;
import androidx.lifecycle.ViewModelProvider;
import com.qltc.finace.base.Constant;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseFragment;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.databinding.FragmentOtpBinding;
import com.qltc.finace.view.activity.authen.AuthenticationActivity;
import com.qltc.finace.view.activity.home.HomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;
import dagger.hilt.android.AndroidEntryPoint;
import javax.inject.Inject;

@dagger.hilt.android.AndroidEntryPoint()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001c\u001a\u00020\u001dH\u0016J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u001dH\u0016J\u001a\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010\'\u001a\u00020\u001dH\u0016J\b\u0010(\u001a\u00020\u001dH\u0016J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020\u001dH\u0002R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\rX\u0094D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00038TX\u0094\u0084\u0002\u00a2\u0006\f\n\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/qltc/finace/view/authentication/otp/OtpFragment;", "Lcom/qltc/finace/base/BaseFragment;", "Lcom/qltc/finace/databinding/FragmentOtpBinding;", "Lcom/qltc/finace/view/authentication/otp/OtpViewModel;", "Lcom/qltc/finace/view/authentication/otp/OtpListener;", "()V", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "getCategoryRepository", "()Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "setCategoryRepository", "(Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "layoutID", "", "getLayoutID", "()I", "phoneNumber", "", "resendTimer", "Landroid/os/CountDownTimer;", "verificationId", "viewModel", "getViewModel", "()Lcom/qltc/finace/view/authentication/otp/OtpViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "viewModelFactory", "Landroidx/lifecycle/ViewModelProvider$Factory;", "backLoginPhone", "", "navigateToHome", "isNewUser", "", "onDestroy", "onViewCreated", "view", "Landroid/view/View;", "savedInstanceState", "Landroid/os/Bundle;", "resendOtp", "senOtp", "setupOtpInput", "setupResendButton", "signInWithPhoneAuthCredential", "credential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "startResendTimer", "app_debug"})
public final class OtpFragment extends com.qltc.finace.base.BaseFragment<com.qltc.finace.databinding.FragmentOtpBinding, com.qltc.finace.view.authentication.otp.OtpViewModel> implements com.qltc.finace.view.authentication.otp.OtpListener {
    @javax.inject.Inject()
    public com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.ViewModelProvider.Factory viewModelFactory = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.Lazy viewModel$delegate = null;
    private final int layoutID = com.qltc.finace.R.layout.fragment_otp;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String verificationId;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String phoneNumber;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer resendTimer;
    
    public OtpFragment() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.data.repository.local.category.CategoryRepository getCategoryRepository() {
        return null;
    }
    
    public final void setCategoryRepository(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository p0) {
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    protected com.qltc.finace.view.authentication.otp.OtpViewModel getViewModel() {
        return null;
    }
    
    @java.lang.Override()
    protected int getLayoutID() {
        return 0;
    }
    
    @java.lang.Override()
    public void onViewCreated(@org.jetbrains.annotations.NotNull()
    android.view.View view, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupOtpInput() {
    }
    
    private final void setupResendButton() {
    }
    
    private final void startResendTimer() {
    }
    
    @java.lang.Override()
    public void senOtp() {
    }
    
    private final void signInWithPhoneAuthCredential(com.google.firebase.auth.PhoneAuthCredential credential) {
    }
    
    private final void navigateToHome(boolean isNewUser) {
    }
    
    @java.lang.Override()
    public void backLoginPhone() {
    }
    
    @java.lang.Override()
    public void resendOtp() {
    }
    
    @java.lang.Override()
    public void onDestroy() {
    }
}