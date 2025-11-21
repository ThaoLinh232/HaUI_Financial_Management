package com.qltc.finace.view.authentication.sign_up;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\b\u0010\u0006\u001a\u00020\u0003H&J\b\u0010\u0007\u001a\u00020\u0003H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/qltc/finace/view/authentication/sign_up/SignUpListener;", "", "backSignUp", "", "openApp", "openSignInFacebook", "openSignInGoogle", "openSignInPhone", "signUp", "app_debug"})
public abstract interface SignUpListener {
    
    public abstract void signUp();
    
    public abstract void openSignInGoogle();
    
    public abstract void openSignInFacebook();
    
    public abstract void openSignInPhone();
    
    public abstract void openApp();
    
    public abstract void backSignUp();
}