package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentSignInBindingImpl extends FragmentSignInBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.logo, 9);
        sViewsWithIds.put(R.id.imageView, 10);
        sViewsWithIds.put(R.id.textView5, 11);
        sViewsWithIds.put(R.id.login_with_email, 12);
        sViewsWithIds.put(R.id.user_name, 13);
        sViewsWithIds.put(R.id.password, 14);
        sViewsWithIds.put(R.id.circularRevealLinearLayout, 15);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    @NonNull
    private final com.google.android.material.textfield.TextInputEditText mboundView2;
    @NonNull
    private final com.google.android.material.button.MaterialButton mboundView4;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView7;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback45;
    @Nullable
    private final android.view.View.OnClickListener mCallback43;
    @Nullable
    private final android.view.View.OnClickListener mCallback42;
    @Nullable
    private final android.view.View.OnClickListener mCallback40;
    @Nullable
    private final android.view.View.OnClickListener mCallback44;
    @Nullable
    private final android.view.View.OnClickListener mCallback41;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener mboundView2androidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.passwordInput
            //         is viewModel.setPasswordInput((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(mboundView2);
            // localize variables for thread safety
            // viewModel.passwordInput
            java.lang.String viewModelPasswordInput = null;
            // viewModel
            com.qltc.finace.view.authentication.sign_in.SignInViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setPasswordInput(((java.lang.String) (callbackArg_0)));
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
            com.qltc.finace.view.authentication.sign_in.SignInViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setEmailInput(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentSignInBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }
    private FragmentSignInBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (androidx.appcompat.widget.AppCompatTextView) bindings[8]
            , (com.google.android.material.circularreveal.CircularRevealLinearLayout) bindings[15]
            , (android.widget.ImageView) bindings[10]
            , (androidx.appcompat.widget.LinearLayoutCompat) bindings[12]
            , (com.google.android.material.button.MaterialButton) bindings[5]
            , (com.google.android.material.button.MaterialButton) bindings[6]
            , (android.widget.LinearLayout) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[14]
            , (com.google.android.material.textfield.TextInputEditText) bindings[1]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[3]
            , (com.google.android.material.textfield.TextInputLayout) bindings[13]
            );
        this.button8.setTag(null);
        this.loginWithGoogle.setTag(null);
        this.loginWithPhone.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (com.google.android.material.textfield.TextInputEditText) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView4 = (com.google.android.material.button.MaterialButton) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView7 = (com.google.android.material.textview.MaterialTextView) bindings[7];
        this.mboundView7.setTag(null);
        this.textView3.setTag(null);
        this.tvForgotPassword.setTag(null);
        setRootTag(root);
        // listeners
        mCallback45 = new com.qltc.finace.generated.callback.OnClickListener(this, 6);
        mCallback43 = new com.qltc.finace.generated.callback.OnClickListener(this, 4);
        mCallback42 = new com.qltc.finace.generated.callback.OnClickListener(this, 3);
        mCallback40 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        mCallback44 = new com.qltc.finace.generated.callback.OnClickListener(this, 5);
        mCallback41 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x8L;
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
            setListener((com.qltc.finace.view.authentication.sign_in.SignInListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.authentication.sign_in.SignInViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.authentication.sign_in.SignInListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.authentication.sign_in.SignInViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelIsEnableButton((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsEnableButton(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsEnableButton, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
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
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButton = null;
        com.qltc.finace.view.authentication.sign_in.SignInListener listener = mListener;
        java.lang.Boolean viewModelIsEnableButtonGetValue = null;
        java.lang.String viewModelEmailInput = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonGetValue = false;
        com.qltc.finace.view.authentication.sign_in.SignInViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.passwordInput
                        viewModelPasswordInput = viewModel.getPasswordInput();
                        // read viewModel.emailInput
                        viewModelEmailInput = viewModel.getEmailInput();
                    }
            }

                if (viewModel != null) {
                    // read viewModel.isEnableButton
                    viewModelIsEnableButton = viewModel.isEnableButton();
                }
                updateLiveDataRegistration(0, viewModelIsEnableButton);


                if (viewModelIsEnableButton != null) {
                    // read viewModel.isEnableButton.getValue()
                    viewModelIsEnableButtonGetValue = viewModelIsEnableButton.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isEnableButton.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsEnableButtonGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.button8.setOnClickListener(mCallback45);
            this.loginWithGoogle.setOnClickListener(mCallback42);
            this.loginWithPhone.setOnClickListener(mCallback43);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.mboundView2, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, mboundView2androidTextAttrChanged);
            this.mboundView4.setOnClickListener(mCallback41);
            this.mboundView7.setOnClickListener(mCallback44);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.textView3, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, textView3androidTextAttrChanged);
            this.tvForgotPassword.setOnClickListener(mCallback40);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, viewModelPasswordInput);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.textView3, viewModelEmailInput);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.mboundView4.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 6: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_in.SignInListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openApp();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_in.SignInListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openSignInPhone();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_in.SignInListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openSignInGoogle();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_in.SignInListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onForgotPasswordClick();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_in.SignInListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openSignUp();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.sign_in.SignInListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.signUpWithEmail();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isEnableButton
        flag 1 (0x2L): listener
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}