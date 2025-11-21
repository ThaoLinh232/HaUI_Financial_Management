package com.qltc.finace.view.authentication.otp;

import com.qltc.finace.base.BaseViewModel;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.google.firebase.auth.FirebaseAuth;
import kotlinx.coroutines.Dispatchers;

/**
 * ViewModel cho màn hình OTP, không sử dụng Hilt mà dùng Factory thủ công để khởi tạo
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/qltc/finace/view/authentication/otp/OtpViewModel;", "Lcom/qltc/finace/base/BaseViewModel;", "categoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "(Lcom/qltc/finace/data/repository/local/category/CategoryRepository;)V", "insertDefaultCategory", "", "isNewUser", "", "success", "Lkotlin/Function0;", "app_debug"})
public final class OtpViewModel extends com.qltc.finace.base.BaseViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository = null;
    
    public OtpViewModel(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepository categoryRepository) {
        super();
    }
    
    /**
     * Thêm danh mục mặc định cho người dùng mới
     * @param isNewUser Có phải người dùng mới đăng ký không
     * @param success Callback khi thêm thành công
     */
    public final void insertDefaultCategory(boolean isNewUser, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> success) {
    }
}