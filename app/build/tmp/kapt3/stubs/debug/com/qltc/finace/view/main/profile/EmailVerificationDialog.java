package com.qltc.finace.view.main.profile;

import android.app.Dialog;
import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Toast;
import androidx.core.content.ContextCompat;
import com.qltc.finace.R;
import com.qltc.finace.databinding.DialogEmailVerificationBinding;
import com.qltc.finace.utils.NetworkUtils;
import com.qltc.finace.utils.AuthProviderUtils;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.EmailAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthInvalidUserException;
import kotlinx.coroutines.*;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u00a2\u0006\u0002\u0010\u000bJ\u0006\u0010\u0012\u001a\u00020\bJ\u0014\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u00060\u0015j\u0002`\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002J\b\u0010\u001c\u001a\u00020\bH\u0002J\b\u0010\u001d\u001a\u00020\bH\u0002J\b\u0010\u001e\u001a\u00020\bH\u0002J\b\u0010\u001f\u001a\u00020\bH\u0002J\b\u0010 \u001a\u00020\bH\u0002J\u0018\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0006\u0010&\u001a\u00020\bJ\u0010\u0010\'\u001a\u00020\b2\u0006\u0010(\u001a\u00020\u0018H\u0002J\b\u0010)\u001a\u00020\bH\u0002J\u0010\u0010*\u001a\u00020\b2\u0006\u0010+\u001a\u00020\u0005H\u0002R\u000e\u0010\f\u001a\u00020\rX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/qltc/finace/view/main/profile/EmailVerificationDialog;", "", "context", "Landroid/content/Context;", "newEmail", "", "onEmailConfirmed", "Lkotlin/Function1;", "", "onEmailCancelled", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/qltc/finace/databinding/DialogEmailVerificationBinding;", "dialog", "Landroid/app/Dialog;", "verificationJob", "Lkotlinx/coroutines/Job;", "dismiss", "handleVerificationError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isValidEmail", "", "email", "setLoadingState", "loading", "setupDisabledEmailChangeUI", "setupNoPasswordRequiredUI", "setupOTPRequiredUI", "setupPasswordRequiredUI", "setupUI", "setupUIForProvider", "providerType", "Lcom/qltc/finace/utils/AuthProviderUtils$AuthProviderType;", "capabilities", "Lcom/qltc/finace/utils/AuthProviderUtils$AuthProviderCapabilities;", "show", "updateConfirmButtonState", "enabled", "verifyEmailForPhoneUser", "verifyEmailWithPassword", "password", "app_debug"})
public final class EmailVerificationDialog {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String newEmail = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onEmailConfirmed = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onEmailCancelled = null;
    private com.qltc.finace.databinding.DialogEmailVerificationBinding binding;
    private android.app.Dialog dialog;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job verificationJob;
    
    public EmailVerificationDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String newEmail, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onEmailConfirmed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEmailCancelled) {
        super();
    }
    
    public final void show() {
    }
    
    private final void setupUI() {
    }
    
    private final void setupUIForProvider(com.qltc.finace.utils.AuthProviderUtils.AuthProviderType providerType, com.qltc.finace.utils.AuthProviderUtils.AuthProviderCapabilities capabilities) {
    }
    
    private final void setupDisabledEmailChangeUI() {
    }
    
    private final void setupPasswordRequiredUI() {
    }
    
    private final void setupOTPRequiredUI() {
    }
    
    private final void setupNoPasswordRequiredUI() {
    }
    
    private final void verifyEmailForPhoneUser() {
    }
    
    private final boolean isValidEmail(java.lang.String email) {
        return false;
    }
    
    private final void updateConfirmButtonState(boolean enabled) {
    }
    
    private final void verifyEmailWithPassword(java.lang.String password) {
    }
    
    private final void setLoadingState(boolean loading) {
    }
    
    private final void handleVerificationError(java.lang.Exception exception) {
    }
    
    public final void dismiss() {
    }
}