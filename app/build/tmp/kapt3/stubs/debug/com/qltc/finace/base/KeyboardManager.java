package com.qltc.finace.base;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.lifecycle.LiveData;
import java.lang.ref.WeakReference;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0013\u0014B\u000f\b\u0012\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\u0002\u0010\u0005B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0006J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u000eH\u0014J\b\u0010\u0010\u001a\u00020\u000eH\u0014J\b\u0010\u0011\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u0004\u0018\u00010\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/qltc/finace/base/KeyboardManager;", "Landroidx/lifecycle/LiveData;", "Lcom/qltc/finace/base/KeyboardManager$KeyboardStatus;", "activity", "Landroid/app/Activity;", "(Landroid/app/Activity;)V", "()V", "activityWeakReference", "Ljava/lang/ref/WeakReference;", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "rootView", "Landroid/view/View;", "addOnGlobalLayoutListener", "", "onActive", "onInactive", "removeOnGlobalLayoutListener", "status", "Companion", "KeyboardStatus", "app_debug"})
@android.annotation.SuppressLint(value = {"StaticFieldLeak"})
public final class KeyboardManager extends androidx.lifecycle.LiveData<com.qltc.finace.base.KeyboardManager.KeyboardStatus> {
    @org.jetbrains.annotations.Nullable()
    private static com.qltc.finace.base.KeyboardManager instance;
    @org.jetbrains.annotations.Nullable()
    private java.lang.ref.WeakReference<android.app.Activity> activityWeakReference;
    @org.jetbrains.annotations.Nullable()
    private android.view.View rootView;
    @org.jetbrains.annotations.Nullable()
    private android.view.ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    @org.jetbrains.annotations.NotNull()
    public static final com.qltc.finace.base.KeyboardManager.Companion Companion = null;
    
    private KeyboardManager() {
        super(null);
    }
    
    private KeyboardManager(android.app.Activity activity) {
        super(null);
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.qltc.finace.base.KeyboardManager status() {
        return null;
    }
    
    private final void addOnGlobalLayoutListener() {
    }
    
    private final void removeOnGlobalLayoutListener() {
    }
    
    @java.lang.Override()
    protected void onActive() {
    }
    
    @java.lang.Override()
    protected void onInactive() {
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/qltc/finace/base/KeyboardManager$Companion;", "", "()V", "instance", "Lcom/qltc/finace/base/KeyboardManager;", "init", "activity", "Landroid/app/Activity;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.qltc.finace.base.KeyboardManager init(@org.jetbrains.annotations.NotNull()
        android.app.Activity activity) {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004\u00a8\u0006\u0005"}, d2 = {"Lcom/qltc/finace/base/KeyboardManager$KeyboardStatus;", "", "(Ljava/lang/String;I)V", "OPEN", "CLOSED", "app_debug"})
    public static enum KeyboardStatus {
        /*public static final*/ OPEN /* = new OPEN() */,
        /*public static final*/ CLOSED /* = new CLOSED() */;
        
        KeyboardStatus() {
        }
        
        @org.jetbrains.annotations.NotNull()
        public static kotlin.enums.EnumEntries<com.qltc.finace.base.KeyboardManager.KeyboardStatus> getEntries() {
            return null;
        }
    }
}