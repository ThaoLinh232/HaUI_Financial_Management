package com.qltc.finace.utils;

import com.google.firebase.auth.FirebaseUser;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0002\u0012\u0013B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\f2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\r\u001a\u00020\n2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nJ\u0010\u0010\u0010\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0014"}, d2 = {"Lcom/qltc/finace/utils/AuthProviderUtils;", "", "()V", "canUserChangeEmail", "", "user", "Lcom/google/firebase/auth/FirebaseUser;", "getEmailChangeDescription", "", "providerType", "Lcom/qltc/finace/utils/AuthProviderUtils$AuthProviderType;", "getLinkedProviders", "", "getPrimaryAuthProvider", "getProviderCapabilities", "Lcom/qltc/finace/utils/AuthProviderUtils$AuthProviderCapabilities;", "requiresOTPForEmailChange", "requiresPasswordForEmailChange", "AuthProviderCapabilities", "AuthProviderType", "app_debug"})
public final class AuthProviderUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.utils.AuthProviderUtils INSTANCE = null;
    
    private AuthProviderUtils() {
        super();
    }
    
    /**
     * Get the primary authentication provider for a user
     * Priority: Email/Password > Google > Facebook > Phone-only
     */
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.utils.AuthProviderUtils.AuthProviderType getPrimaryAuthProvider(@org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user) {
        return null;
    }
    
    /**
     * Get capabilities for a specific provider type
     */
    @org.jetbrains.annotations.NotNull()
    public final com.qltc.finace.utils.AuthProviderUtils.AuthProviderCapabilities getProviderCapabilities(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.utils.AuthProviderUtils.AuthProviderType providerType) {
        return null;
    }
    
    /**
     * Get user-friendly description for email change restrictions
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getEmailChangeDescription(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.utils.AuthProviderUtils.AuthProviderType providerType) {
        return null;
    }
    
    /**
     * Check if user can change email
     */
    public final boolean canUserChangeEmail(@org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user) {
        return false;
    }
    
    /**
     * Check if user needs password for email change
     */
    public final boolean requiresPasswordForEmailChange(@org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user) {
        return false;
    }
    
    /**
     * Check if user needs OTP for email change
     */
    public final boolean requiresOTPForEmailChange(@org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user) {
        return false;
    }
    
    /**
     * Get all linked providers for debugging
     */
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getLinkedProviders(@org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user) {
        return null;
    }
    
    /**
     * Capabilities for each provider type
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u00a2\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0012\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\bH\u00c6\u0003J;\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bH\u00c6\u0001J\u0013\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0019\u001a\u00020\u001aH\u00d6\u0001J\t\u0010\u001b\u001a\u00020\bH\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b\u00a8\u0006\u001c"}, d2 = {"Lcom/qltc/finace/utils/AuthProviderUtils$AuthProviderCapabilities;", "", "canChangeEmail", "", "requiresPasswordForEmailChange", "requiresOTPForEmailChange", "canChangePassword", "displayName", "", "(ZZZZLjava/lang/String;)V", "getCanChangeEmail", "()Z", "getCanChangePassword", "getDisplayName", "()Ljava/lang/String;", "getRequiresOTPForEmailChange", "getRequiresPasswordForEmailChange", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
    public static final class AuthProviderCapabilities {
        private final boolean canChangeEmail = false;
        private final boolean requiresPasswordForEmailChange = false;
        private final boolean requiresOTPForEmailChange = false;
        private final boolean canChangePassword = false;
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String displayName = null;
        
        public AuthProviderCapabilities(boolean canChangeEmail, boolean requiresPasswordForEmailChange, boolean requiresOTPForEmailChange, boolean canChangePassword, @org.jetbrains.annotations.NotNull()
        java.lang.String displayName) {
            super();
        }
        
        public final boolean getCanChangeEmail() {
            return false;
        }
        
        public final boolean getRequiresPasswordForEmailChange() {
            return false;
        }
        
        public final boolean getRequiresOTPForEmailChange() {
            return false;
        }
        
        public final boolean getCanChangePassword() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDisplayName() {
            return null;
        }
        
        public final boolean component1() {
            return false;
        }
        
        public final boolean component2() {
            return false;
        }
        
        public final boolean component3() {
            return false;
        }
        
        public final boolean component4() {
            return false;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component5() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.qltc.finace.utils.AuthProviderUtils.AuthProviderCapabilities copy(boolean canChangeEmail, boolean requiresPasswordForEmailChange, boolean requiresOTPForEmailChange, boolean canChangePassword, @org.jetbrains.annotations.NotNull()
        java.lang.String displayName) {
            return null;
        }
        
        @java.lang.Override()
        public boolean equals(@org.jetbrains.annotations.Nullable()
        java.lang.Object other) {
            return false;
        }
        
        @java.lang.Override()
        public int hashCode() {
            return 0;
        }
        
        @java.lang.Override()
        @org.jetbrains.annotations.NotNull()
        public java.lang.String toString() {
            return null;
        }
    }
    
    /**
     * Different types of authentication providers
     */
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b\u00a8\u0006\t"}, d2 = {"Lcom/qltc/finace/utils/AuthProviderUtils$AuthProviderType;", "", "(Ljava/lang/String;I)V", "EMAIL_PASSWORD", "EMAIL_PASSWORD_WITH_PHONE", "GOOGLE", "PHONE_ONLY", "FACEBOOK", "UNKNOWN", "app_debug"})
    public static enum AuthProviderType {
        /*public static final*/ EMAIL_PASSWORD /* = new EMAIL_PASSWORD() */,
        /*public static final*/ EMAIL_PASSWORD_WITH_PHONE /* = new EMAIL_PASSWORD_WITH_PHONE() */,
        /*public static final*/ GOOGLE /* = new GOOGLE() */,
        /*public static final*/ PHONE_ONLY /* = new PHONE_ONLY() */,
        /*public static final*/ FACEBOOK /* = new FACEBOOK() */,
        /*public static final*/ UNKNOWN /* = new UNKNOWN() */;
        
        AuthProviderType() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.qltc.finace.utils.AuthProviderUtils.AuthProviderType> getEntries() {
            return null;
        }
    }
}