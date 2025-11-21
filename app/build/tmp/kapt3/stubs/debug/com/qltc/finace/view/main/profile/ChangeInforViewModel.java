package com.qltc.finace.view.main.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.entity.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010!\u001a\u00020\u0007J\u0006\u0010\"\u001a\u00020\u0007J\u0006\u0010#\u001a\u00020\u0007J\u0006\u0010$\u001a\u00020\tJ\u0010\u0010%\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0007H\u0002J\u0010\u0010&\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\b\u0010\'\u001a\u00020(H\u0002J\u001e\u0010)\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010+\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007J\u0016\u0010-\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00072\u0006\u0010*\u001a\u00020\u0007J\u001e\u0010.\u001a\u00020(2\u0006\u0010/\u001a\u0002002\u0006\u0010*\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007J\u0016\u00101\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007J\u0016\u00102\u001a\u00020(2\u0006\u0010*\u001a\u00020\u00072\u0006\u00103\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0010R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015\u00a8\u00064"}, d2 = {"Lcom/qltc/finace/view/main/profile/ChangeInforViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "()V", "_currentUser", "Landroidx/lifecycle/MutableLiveData;", "Lcom/qltc/finace/data/entity/User;", "_currentUserName", "", "_isLoading", "", "_showEmailDialog", "_showOtpDialog", "_updateResult", "currentUser", "Landroidx/lifecycle/LiveData;", "getCurrentUser", "()Landroidx/lifecycle/LiveData;", "currentUserName", "getCurrentUserName", "email", "getEmail", "()Landroidx/lifecycle/MutableLiveData;", "isLoading", "phone", "getPhone", "showEmailDialog", "getShowEmailDialog", "showOtpDialog", "getShowOtpDialog", "updateResult", "getUpdateResult", "username", "getUsername", "getCurrentEmail", "getCurrentPhone", "getCurrentUsername", "isGoogleAuthUser", "isValidEmail", "isValidPhoneNumber", "loadCurrentUserInfo", "", "updateUserInfo", "newUsername", "newPhone", "newEmail", "updateWithEmailCredential", "updateWithPhoneCredential", "phoneCredential", "Lcom/google/firebase/auth/PhoneAuthCredential;", "updateWithoutPhone", "updateWithoutPhoneAndEmail", "hasUsernameChange", "app_debug"})
public final class ChangeInforViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<com.qltc.finace.data.entity.User> _currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.qltc.finace.data.entity.User> currentUser = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _currentUserName = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> currentUserName = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> username = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> phone = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> email = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.Boolean> _isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _updateResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> updateResult = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _showOtpDialog = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> showOtpDialog = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.MutableLiveData<java.lang.String> _showEmailDialog = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.lang.String> showEmailDialog = null;
    
    public ChangeInforViewModel() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.qltc.finace.data.entity.User> getCurrentUser() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getCurrentUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.Boolean> isLoading() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getUpdateResult() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getShowOtpDialog() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.lang.String> getShowEmailDialog() {
        return null;
    }
    
    private final void loadCurrentUserInfo() {
    }
    
    public final void updateUserInfo(@org.jetbrains.annotations.NotNull()
    java.lang.String newUsername, @org.jetbrains.annotations.NotNull()
    java.lang.String newPhone, @org.jetbrains.annotations.NotNull()
    java.lang.String newEmail) {
    }
    
    public final void updateWithPhoneCredential(@org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.PhoneAuthCredential phoneCredential, @org.jetbrains.annotations.NotNull()
    java.lang.String newUsername, @org.jetbrains.annotations.NotNull()
    java.lang.String newEmail) {
    }
    
    public final void updateWithEmailCredential(@org.jetbrains.annotations.NotNull()
    java.lang.String newEmail, @org.jetbrains.annotations.NotNull()
    java.lang.String newUsername) {
    }
    
    public final void updateWithoutPhoneAndEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String newUsername, boolean hasUsernameChange) {
    }
    
    public final void updateWithoutPhone(@org.jetbrains.annotations.NotNull()
    java.lang.String newUsername, @org.jetbrains.annotations.NotNull()
    java.lang.String newEmail) {
    }
    
    private final boolean isValidPhoneNumber(java.lang.String phone) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentUsername() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentPhone() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentEmail() {
        return null;
    }
    
    public final boolean isGoogleAuthUser() {
        return false;
    }
    
    private final boolean isValidEmail(java.lang.String email) {
        return false;
    }
}