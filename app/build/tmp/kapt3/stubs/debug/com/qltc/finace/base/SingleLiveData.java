package com.qltc.finace.base;

import android.util.Log;
import androidx.annotation.MainThread;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * LiveData triển khai chỉ gửi cập nhật một lần (không lặp lại).
 * Đảm bảo mỗi sự kiện chỉ được xử lý một lần, ngay cả khi Fragment/Activity được tạo lại.
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0003B\u0011\b\u0016\u0012\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000\u00a2\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ \u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u0010\r\u001a\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000eH\u0017J\u0017\u0010\u000f\u001a\u00020\t2\b\u0010\u0004\u001a\u0004\u0018\u00018\u0000H\u0017\u00a2\u0006\u0002\u0010\u0005R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/qltc/finace/base/SingleLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "value", "(Ljava/lang/Object;)V", "pending", "Ljava/util/concurrent/atomic/AtomicBoolean;", "call", "", "observe", "owner", "Landroidx/lifecycle/LifecycleOwner;", "observer", "Landroidx/lifecycle/Observer;", "setValue", "app_debug"})
public final class SingleLiveData<T extends java.lang.Object> extends androidx.lifecycle.MutableLiveData<T> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.concurrent.atomic.AtomicBoolean pending = null;
    
    public SingleLiveData() {
        super(null);
    }
    
    public SingleLiveData(@org.jetbrains.annotations.Nullable()
    T value) {
        super(null);
    }
    
    @java.lang.Override()
    @androidx.annotation.MainThread()
    public void setValue(@org.jetbrains.annotations.Nullable()
    T value) {
    }
    
    @java.lang.Override()
    @androidx.annotation.MainThread()
    public void observe(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.LifecycleOwner owner, @org.jetbrains.annotations.NotNull()
    androidx.lifecycle.Observer<? super T> observer) {
    }
    
    /**
     * Tiện ích để gửi sự kiện null
     */
    public final void call() {
    }
}