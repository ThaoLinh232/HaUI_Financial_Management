package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentForgotPasswordBindingImpl extends FragmentForgotPasswordBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvTitle, 4);
        sViewsWithIds.put(R.id.tvDescription, 5);
        sViewsWithIds.put(R.id.tilEmail, 6);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback54;
    @Nullable
    private final android.view.View.OnClickListener mCallback55;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etEmailandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.emailInput
            //         is viewModel.setEmailInput((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etEmail);
            // localize variables for thread safety
            // viewModel.emailInput
            java.lang.String viewModelEmailInput = null;
            // viewModel
            com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setEmailInput(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentForgotPasswordBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private FragmentForgotPasswordBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageButton) bindings[1]
            , (com.google.android.material.button.MaterialButton) bindings[3]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[4]
            );
        this.btnBack.setTag(null);
        this.btnResetPassword.setTag(null);
        this.etEmail.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback54 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        mCallback55 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
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
            setListener((com.qltc.finace.view.authentication.forgot_password.ForgotPasswordListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.authentication.forgot_password.ForgotPasswordListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel ViewModel) {
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
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButton = null;
        java.lang.String viewModelEmailInput = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonGetValue = false;
        com.qltc.finace.view.authentication.forgot_password.ForgotPasswordListener listener = mListener;
        java.lang.Boolean viewModelIsEnableButtonGetValue = null;
        com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdL) != 0) {



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
            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.emailInput
                        viewModelEmailInput = viewModel.getEmailInput();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.btnBack.setOnClickListener(mCallback54);
            this.btnResetPassword.setOnClickListener(mCallback55);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etEmail, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etEmailandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.btnResetPassword.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonGetValue);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etEmail, viewModelEmailInput);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.forgot_password.ForgotPasswordListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onBackClick();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.authentication.forgot_password.ForgotPasswordListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onResetPasswordClick();
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