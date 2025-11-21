package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSignUpBindingImpl extends FragmentSignUpBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.logo, 11);
        sViewsWithIds.put(R.id.imageView, 12);
        sViewsWithIds.put(R.id.textView5, 13);
        sViewsWithIds.put(R.id.login_with_email, 14);
        sViewsWithIds.put(R.id.sign_in_with_mxh, 15);
        sViewsWithIds.put(R.id.circularRevealLinearLayout, 16);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView10;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView4;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView6;
    @NonNull
    private final com.google.android.material.button.MaterialButton mboundView7;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback11;
    @Nullable
    private final android.view.View.OnClickListener mCallback8;
    @Nullable
    private final android.view.View.OnClickListener mCallback10;
    @Nullable
    private final android.view.View.OnClickListener mCallback9;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView4androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.passwordInput
            //         is viewModel.setPasswordInput((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView4);
            // localize variables for thread safety
            // viewModel.passwordInput
            java.lang.String viewModelPasswordInput = null;
            // viewModel
            com.qltc.finace.view.authentication.sign_up.SignUpViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setPasswordInput(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener mboundView6androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.confirmPassword
            //         is viewModel.setConfirmPassword((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView6);
            // localize variables for thread safety
            // viewModel.confirmPassword
            java.lang.String viewModelConfirmPassword = null;
            // viewModel
            com.qltc.finace.view.authentication.sign_up.SignUpViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setConfirmPassword(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener textView3androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.emailInput
            //         is viewModel.setEmailInput((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(textView3);
            // localize variables for thread safety
            // viewModel.emailInput
            java.lang.String viewModelEmailInput = null;
            // viewModel
            com.qltc.finace.view.authentication.sign_up.SignUpViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setEmailInput(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentSignUpBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private FragmentSignUpBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 4
            , (com.google.android.material.circularreveal.CircularRevealLinearLayout) bindings[16]
            , (com.google.android.material.textfield.TextInputLayout) bindings[5]
            , (android.widget.ImageView) bindings[12]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[14]
            , (com.google.android.material.button.MaterialButton) bindings[8]
            , (com.google.android.material.button.MaterialButton) bindings[9]
            , (android.widget.LinearLayout) bindings[11]
            , (com.google.android.material.textfield.TextInputLayout) bindings[3]
            , (android.widget.LinearLayout) bindings[15]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (android.widget.TextView) bindings[13]
            , (com.google.android.material.textfield.TextInputLayout) bindings[1]
            );
        this.confirmPassword.setTag(null);
        this.loginWithGoogle.setTag(null);
        this.loginWithPhone.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView10 = (com.google.android.material.textview.MaterialTextView) bindings[10];
        this.mboundView10.setTag(null);
        this.mboundView4 = (com.google.android.material.textfield.TextInputEditText) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView6 = (com.google.android.material.textfield.TextInputEditText) bindings[6];
        this.mboundView6.setTag(null);
        this.mboundView7 = (com.google.android.material.button.MaterialButton) bindings[7];
        this.mboundView7.setTag(null);
        this.password.setTag(null);
        this.textView3.setTag(null);
        this.userName.setTag(null);
        setRootTag(root);
        // listeners
        mCallback11 = new com.qltc.finace.generated.callback.OnClickListener(this, 4);
        mCallback8 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        mCallback10 = new com.qltc.finace.generated.callback.OnClickListener(this, 3);
        mCallback9 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x40L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.listener == variableId) {
            setListener((com.qltc.finace.view.authentication.sign_up.SignUpListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.authentication.sign_up.SignUpViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.authentication.sign_up.SignUpListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.authentication.sign_up.SignUpViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x20L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelErrorEmail((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelIsEnableButtonSignUp((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
            case 2 :
                return onChangeViewModelErrorPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 3 :
                return onChangeViewModelErrorConfirmPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelErrorEmail(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelErrorEmail, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIsEnableButtonSignUp(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsEnableButtonSignUp, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelErrorPassword(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelErrorPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelErrorConfirmPassword(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelErrorConfirmPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String viewModelPasswordInput = null;
        java.lang.String viewModelConfirmPassword = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelErrorEmail = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButtonSignUp = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelErrorPassword = null;
        java.lang.Boolean viewModelIsEnableButtonSignUpGetValue = null;
        com.qltc.finace.view.authentication.sign_up.SignUpListener listener = mListener;
        java.lang.String viewModelErrorPasswordGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelErrorConfirmPassword = null;
        java.lang.String viewModelEmailInput = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonSignUpGetValue = false;
        java.lang.String viewModelErrorEmailGetValue = null;
        java.lang.String viewModelErrorConfirmPasswordGetValue = null;
        com.qltc.finace.view.authentication.sign_up.SignUpViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x6fL) != 0) {


            if ((dirtyFlags & 0x60L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.passwordInput
                        viewModelPasswordInput = viewModel.getPasswordInput();
                        // read viewModel.confirmPassword
                        viewModelConfirmPassword = viewModel.getConfirmPassword();
                        // read viewModel.emailInput
                        viewModelEmailInput = viewModel.getEmailInput();
                    }
            }
            if ((dirtyFlags & 0x61L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.errorEmail
                        viewModelErrorEmail = viewModel.getErrorEmail();
                    }
                    updateLiveDataRegistration(0, viewModelErrorEmail);


                    if (viewModelErrorEmail != null) {
                        // read viewModel.errorEmail.getValue()
                        viewModelErrorEmailGetValue = viewModelErrorEmail.getValue();
                    }
            }
            if ((dirtyFlags & 0x62L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isEnableButtonSignUp()
                        viewModelIsEnableButtonSignUp = viewModel.isEnableButtonSignUp();
                    }
                    updateLiveDataRegistration(1, viewModelIsEnableButtonSignUp);


                    if (viewModelIsEnableButtonSignUp != null) {
                        // read viewModel.isEnableButtonSignUp().getValue()
                        viewModelIsEnableButtonSignUpGetValue = viewModelIsEnableButtonSignUp.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isEnableButtonSignUp().getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonSignUpGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsEnableButtonSignUpGetValue);
            }
            if ((dirtyFlags & 0x64L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.errorPassword
                        viewModelErrorPassword = viewModel.getErrorPassword();
                    }
                    updateLiveDataRegistration(2, viewModelErrorPassword);


                    if (viewModelErrorPassword != null) {
                        // read viewModel.errorPassword.getValue()
                        viewModelErrorPasswordGetValue = viewModelErrorPassword.getValue();
                    }
            }
            if ((dirtyFlags & 0x68L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.errorConfirmPassword
                        viewModelErrorConfirmPassword = viewModel.getErrorConfirmPassword();
                    }
                    updateLiveDataRegistration(3, viewModelErrorConfirmPassword);


                    if (viewModelErrorConfirmPassword != null) {
                        // read viewModel.errorConfirmPassword.getValue()
                        viewModelErrorConfirmPasswordGetValue = viewModelErrorConfirmPassword.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x68L) != 0) {
            // api target 1

            this.confirmPassword.setHelperText(viewModelErrorConfirmPasswordGetValue);
        }
        if ((dirtyFlags & 0x40L) != 0) {
            // api target 1

            this.loginWithGoogle.setOnClickListener(mCallback9);
            this.loginWithPhone.setOnClickListener(mCallback10);
            this.mboundView10.setOnClickListener(mCallback11);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView4, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView4androidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView6, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView6androidTextAttrChanged);
            this.mboundView7.setOnClickListener(mCallback8);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textView3androidTextAttrChanged);
        }
        if ((dirtyFlags & 0x60L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, viewModelPasswordInput);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView6, viewModelConfirmPassword);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView3, viewModelEmailInput);
        }
        if ((dirtyFlags & 0x62L) != 0) {
            // api target 1

            this.mboundView7.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonSignUpGetValue);
        }
        if ((dirtyFlags & 0x64L) != 0) {
            // api target 1

            this.password.setHelperText(viewModelErrorPasswordGetValue);
        }
        if ((dirtyFlags & 0x61L) != 0) {
            // api target 1

            this.userName.setHelperText(viewModelErrorEmailGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 4: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_up.SignUpListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.backSignUp();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_up.SignUpListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.signUp();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_up.SignUpListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openSignInPhone();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_up.SignUpListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openSignInGoogle();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.errorEmail
        flag 1 (0x2L): viewModel.isEnableButtonSignUp()
        flag 2 (0x3L): viewModel.errorPassword
        flag 3 (0x4L): viewModel.errorConfirmPassword
        flag 4 (0x5L): listener
        flag 5 (0x6L): viewModel
        flag 6 (0x7L): null
    flag mapping end*/
    //end
}