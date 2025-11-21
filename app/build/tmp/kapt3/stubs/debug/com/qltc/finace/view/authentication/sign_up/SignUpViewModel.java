package com.qltc.finace.view.authentication.sign_up;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.R;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.google.firebase.auth.FirebaseAuth;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import kotlinx.coroutines.Dispatchers;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010,\u001a\u00020-H\u0002J\b\u0010.\u001a\u00020-H\u0002J\b\u0010/\u001a\u00020-H\u0002J\b\u00100\u001a\u00020-H\u0002J\u0014\u00101\u001a\u00020-2\f\u00102\u001a\b\u0012\u0004\u0012\u00020-03J \u00104\u001a\u00020-2\u0018\u00105\u001a\u0014\u0012\u0004\u0012\u00020\'\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020-06R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R$\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R(\u0010\u0019\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00100\u00100\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR(\u0010 \u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00100\u00100\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR(\u0010#\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\u00100\u00100\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u001d\"\u0004\b%\u0010\u001fR(\u0010&\u001a\u0010\u0012\f\u0012\n \u001b*\u0004\u0018\u00010\'0\'0\u001aX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b(\u0010\u001fR$\u0010)\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0013\"\u0004\b+\u0010\u0015\u00a8\u00067"}, d2 = {"Lcom/qltc/finace/view/authentication/sign_up/SignUpViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "applicationContext", "Landroid/content/Context;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Landroid/content/Context;Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "value", "", "confirmPassword", "getConfirmPassword", "()Ljava/lang/String;", "setConfirmPassword", "(Ljava/lang/String;)V", "emailInput", "getEmailInput", "setEmailInput", "errorConfirmPassword", "Landroidx/lifecycle/MutableLiveData;", "kotlin.jvm.PlatformType", "getErrorConfirmPassword", "()Landroidx/lifecycle/MutableLiveData;", "setErrorConfirmPassword", "(Landroidx/lifecycle/MutableLiveData;)V", "errorEmail", "getErrorEmail", "setErrorEmail", "errorPassword", "getErrorPassword", "setErrorPassword", "isEnableButtonSignUp", "", "setEnableButtonSignUp", "passwordInput", "getPasswordInput", "setPasswordInput", "checkEnableButtonSignUp", "", "checkValidConfirmPassword", "checkValidEmail", "checkValidPassword", "insertDefaultCategory", "success", "Lkotlin/Function0;", "signUp", "callback", "Lkotlin/Function2;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SignUpViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private android.content.Context applicationContext;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String emailInput = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String passwordInput = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String confirmPassword = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> errorEmail;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> errorPassword;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.String> errorConfirmPassword;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonSignUp;
    
    @javax.inject.Inject()
    public SignUpViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context applicationContext, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final android.content.Context getApplicationContext() {
        return null;
    }
    
    public final void setApplicationContext(@org.jetbrains.annotations.NotNull()
    android.content.Context p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.google.firebase.auth.FirebaseAuth getAuth() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmailInput() {
        return null;
    }
    
    public final void setEmailInput(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getPasswordInput() {
        return null;
    }
    
    public final void setPasswordInput(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getConfirmPassword() {
        return null;
    }
    
    public final void setConfirmPassword(@org.jetbrains.annotations.NotNull()
    java.lang.String value) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorEmail() {
        return null;
    }
    
    public final void setErrorEmail(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorPassword() {
        return null;
    }
    
    public final void setErrorPassword(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getErrorConfirmPassword() {
        return null;
    }
    
    public final void setErrorConfirmPassword(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.String> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButtonSignUp() {
        return null;
    }
    
    public final void setEnableButtonSignUp(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    private final void checkValidEmail() {
    }
    
    private final void checkValidPassword() {
    }
    
    private final void checkValidConfirmPassword() {
    }
    
    private final void checkEnableButtonSignUp() {
    }
    
    public final void signUp(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> callback) {
    }
    
    public final void insertDefaultCategory(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> success) {
    }
}