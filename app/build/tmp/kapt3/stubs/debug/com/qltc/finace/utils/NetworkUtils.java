package com.qltc.finace.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.os.Build;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\n"}, d2 = {"Lcom/qltc/finace/utils/NetworkUtils;", "", "()V", "getNetworkTypeDescription", "", "context", "Landroid/content/Context;", "isFastNetworkAvailable", "", "isNetworkAvailable", "app_debug"})
public final class NetworkUtils {
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.utils.NetworkUtils INSTANCE = null;
    
    private NetworkUtils() {
        super();
    }
    
    /**
     * Check if device has active internet connection
     */
    public final boolean isNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Check if device has fast internet connection (WiFi or fast cellular)
     */
    public final boolean isFastNetworkAvailable(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return false;
    }
    
    /**
     * Get network type description for debugging
     */
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNetworkTypeDescription(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        return null;
    }
}