package com.qltc.finace.view.main.webview;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import com.qltc.finace.R;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\n\u00a8\u0006\f"}, d2 = {"Lcom/qltc/finace/view/main/webview/ChromeCustomTabHelper;", "", "()V", "isChromeCustomTabsSupported", "", "context", "Landroid/content/Context;", "openInSystemBrowser", "", "url", "", "openUrlInCustomTab", "app_debug"})
public final class ChromeCustomTabHelper {
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.view.main.webview.ChromeCustomTabHelper INSTANCE = null;
    
    private ChromeCustomTabHelper() {
        super();
    }
    
    /**
     * Opens URL in Chrome Custom Tab if available, otherwise fallback to system browser
     */
    public final void openUrlInCustomTab(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    java.lang.String url) {
    }
    
    /**
     * Check if Chrome Custom Tabs is supported
     */
    private final boolean isChromeCustomTabsSupported(android.content.Context context) {
        return false;
    }
    
    /**
     * Fallback to system browser
     */
    private final void openInSystemBrowser(android.content.Context context, java.lang.String url) {
    }
}