package com.qltc.finace.view.authentication.sign_in;

import android.content.Context;
import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.google.android.material.snackbar.ContentViewCallback;
import com.google.firebase.auth.FirebaseAuth;
import dagger.hilt.android.lifecycle.HiltViewModel;
import dagger.hilt.android.qualifiers.ApplicationContext;
import io.reactivex.internal.operators.maybe.MaybeDoAfterSuccess;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\u001c\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u00142\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001c0 J \u0010!\u001a\u00020\u001c2\u0018\u0010\"\u001a\u0014\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u001c0#R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R$\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@FX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011\u00a8\u0006$"}, d2 = {"Lcom/qltc/finace/view/authentication/sign_in/SignInViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "applicationContext", "Landroid/content/Context;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Landroid/content/Context;Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "auth", "Lcom/google/firebase/auth/FirebaseAuth;", "getAuth", "()Lcom/google/firebase/auth/FirebaseAuth;", "value", "", "emailInput", "getEmailInput", "()Ljava/lang/String;", "setEmailInput", "(Ljava/lang/String;)V", "isEnableButton", "Landroidx/lifecycle/MutableLiveData;", "", "()Landroidx/lifecycle/MutableLiveData;", "setEnableButton", "(Landroidx/lifecycle/MutableLiveData;)V", "passwordInput", "getPasswordInput", "setPasswordInput", "checkInput", "", "insertDefaultCategory", "isNewsUser", "success", "Lkotlin/Function0;", "signInWithEmail", "callback", "Lkotlin/Function2;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class SignInViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context applicationContext = null;
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.FirebaseAuth auth = null;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String emailInput = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String passwordInput = "";
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButton;
    
    @javax.inject.Inject()
    public SignInViewModel(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context applicationContext, @org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
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
    public final androidx.lifecycle.MutableLiveData<java.lang.Boolean> isEnableButton() {
        return null;
    }
    
    public final void setEnableButton(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Boolean> p0) {
    }
    
    private final void checkInput() {
    }
    
    public final void insertDefaultCategory(boolean isNewsUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> success) {
    }
    
    public final void signInWithEmail(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function2<? super java.lang.Boolean, ? super java.lang.String, kotlin.Unit> callback) {
    }
}