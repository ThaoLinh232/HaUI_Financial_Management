package com.qltc.finace.view.main.profile;

import android.app.Dialog;
import android.content.Context;
import android.os.CountDownTimer;
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
import com.qltc.finace.databinding.DialogOtpEmailVerificationBinding;
import com.qltc.finace.utils.NetworkUtils;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.*;
import kotlinx.coroutines.*;
import java.util.concurrent.TimeUnit;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000e\u0018\u0000 -2\u00020\u0001:\u0001-B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\u0002\u0010\fJ\u0006\u0010\u001a\u001a\u00020\tJ\u0014\u0010\u001b\u001a\u00020\t2\n\u0010\u001c\u001a\u00060\u001dj\u0002`\u001eH\u0002J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002J\b\u0010\"\u001a\u00020\tH\u0002J\b\u0010#\u001a\u00020\tH\u0002J\u0010\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020 H\u0002J\b\u0010&\u001a\u00020\tH\u0002J\u0006\u0010\'\u001a\u00020\tJ\b\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020 H\u0002J\u0010\u0010+\u001a\u00020\t2\u0006\u0010,\u001a\u00020\u0005H\u0002R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/qltc/finace/view/main/profile/OTPEmailVerificationDialog;", "", "context", "Landroid/content/Context;", "newEmail", "", "phoneNumber", "onEmailConfirmed", "Lkotlin/Function1;", "", "onEmailCancelled", "Lkotlin/Function0;", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "binding", "Lcom/qltc/finace/databinding/DialogOtpEmailVerificationBinding;", "dialog", "Landroid/app/Dialog;", "phoneAuthCallbacks", "Lcom/google/firebase/auth/PhoneAuthProvider$OnVerificationStateChangedCallbacks;", "resendTimer", "Landroid/os/CountDownTimer;", "resendToken", "Lcom/google/firebase/auth/PhoneAuthProvider$ForceResendingToken;", "verificationId", "verificationJob", "Lkotlinx/coroutines/Job;", "dismiss", "handleVerificationError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "isValidEmail", "", "email", "resendOTP", "sendOTP", "setLoadingState", "loading", "setupUI", "show", "startResendTimer", "updateVerifyButtonState", "enabled", "verifyOTPAndUpdateEmail", "otp", "Companion", "app_debug"})
public final class OTPEmailVerificationDialog {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String newEmail = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String phoneNumber = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<java.lang.String, kotlin.Unit> onEmailConfirmed = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function0<kotlin.Unit> onEmailCancelled = null;
    private com.qltc.finace.databinding.DialogOtpEmailVerificationBinding binding;
    private android.app.Dialog dialog;
    @org.jetbrains.annotations.Nullable()
    private kotlinx.coroutines.Job verificationJob;
    @org.jetbrains.annotations.Nullable()
    private android.os.CountDownTimer resendTimer;
    @org.jetbrains.annotations.Nullable()
    private java.lang.String verificationId;
    @org.jetbrains.annotations.Nullable()
    private com.google.firebase.auth.PhoneAuthProvider.ForceResendingToken resendToken;
    private static final long OTP_TIMEOUT = 60L;
    private static final int OTP_LENGTH = 6;
    @org.jetbrains.annotations.NotNull()
    private final com.google.firebase.auth.PhoneAuthProvider.OnVerificationStateChangedCallbacks phoneAuthCallbacks = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.profile.OTPEmailVerificationDialog.Companion Companion = null;
    
    public OTPEmailVerificationDialog(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String newEmail, @org.jetbrains.annotations.NotNull()
    java.lang.String phoneNumber, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onEmailConfirmed, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onEmailCancelled) {
        super();
    }
    
    public final void show() {
    }
    
    private final void setupUI() {
    }
    
    private final boolean isValidEmail(java.lang.String email) {
        return false;
    }
    
    private final void sendOTP() {
    }
    
    private final void resendOTP() {
    }
    
    private final void verifyOTPAndUpdateEmail(java.lang.String otp) {
    }
    
    private final void handleVerificationError(java.lang.Exception exception) {
    }
    
    private final void updateVerifyButtonState(boolean enabled) {
    }
    
    private final void setLoadingState(boolean loading) {
    }
    
    private final void startResendTimer() {
    }
    
    public final void dismiss() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0007"}, d2 = {"Lcom/qltc/finace/view/main/profile/OTPEmailVerificationDialog$Companion;", "", "()V", "OTP_LENGTH", "", "OTP_TIMEOUT", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}