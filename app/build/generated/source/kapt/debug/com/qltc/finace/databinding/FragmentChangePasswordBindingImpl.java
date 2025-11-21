package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentChangePasswordBindingImpl extends FragmentChangePasswordBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.tvTitle, 6);
        sViewsWithIds.put(R.id.tilOldPassword, 7);
        sViewsWithIds.put(R.id.tilNewPassword, 8);
        sViewsWithIds.put(R.id.tilConfirmPassword, 9);
        sViewsWithIds.put(R.id.tvPasswordHint, 10);
        sViewsWithIds.put(R.id.tvAuthError, 11);
    }
    // views
    @NonNull
    private final androidx.core.widget.NestedScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback27;
    @Nullable
    private final android.view.View.OnClickListener mCallback26;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener etConfirmPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.confirmPassword.getValue()
            //         is viewModel.confirmPassword.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etConfirmPassword);
            // localize variables for thread safety
            // viewModel.confirmPassword != null
            boolean viewModelConfirmPasswordJavaLangObjectNull = false;
            // viewModel.confirmPassword
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelConfirmPassword = null;
            // viewModel
            com.qltc.finace.view.main.profile.ChangePasswordViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.confirmPassword.getValue()
            java.lang.String viewModelConfirmPasswordGetValue = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelConfirmPassword = viewModel.getConfirmPassword();

                viewModelConfirmPasswordJavaLangObjectNull = (viewModelConfirmPassword) != (null);
                if (viewModelConfirmPasswordJavaLangObjectNull) {




                    viewModelConfirmPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etNewPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.newPassword.getValue()
            //         is viewModel.newPassword.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etNewPassword);
            // localize variables for thread safety
            // viewModel.newPassword
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelNewPassword = null;
            // viewModel.newPassword.getValue()
            java.lang.String viewModelNewPasswordGetValue = null;
            // viewModel
            com.qltc.finace.view.main.profile.ChangePasswordViewModel viewModel = mViewModel;
            // viewModel.newPassword != null
            boolean viewModelNewPasswordJavaLangObjectNull = false;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelNewPassword = viewModel.getNewPassword();

                viewModelNewPasswordJavaLangObjectNull = (viewModelNewPassword) != (null);
                if (viewModelNewPasswordJavaLangObjectNull) {




                    viewModelNewPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };
    private androidx.databinding.InverseBindingListener etOldPasswordandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.oldPassword.getValue()
            //         is viewModel.oldPassword.setValue((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(etOldPassword);
            // localize variables for thread safety
            // viewModel.oldPassword.getValue()
            java.lang.String viewModelOldPasswordGetValue = null;
            // viewModel
            com.qltc.finace.view.main.profile.ChangePasswordViewModel viewModel = mViewModel;
            // viewModel.oldPassword
            androidx.lifecycle.MutableLiveData<java.lang.String> viewModelOldPassword = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.oldPassword != null
            boolean viewModelOldPasswordJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {


                viewModelOldPassword = viewModel.getOldPassword();

                viewModelOldPasswordJavaLangObjectNull = (viewModelOldPassword) != (null);
                if (viewModelOldPasswordJavaLangObjectNull) {




                    viewModelOldPassword.setValue(((java.lang.String) (callbackArg_0)));
                }
            }
        }
    };

    public FragmentChangePasswordBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }
    private FragmentChangePasswordBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 3
            , (android.widget.ImageButton) bindings[1]
            , (com.google.android.material.button.MaterialButton) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textfield.TextInputEditText) bindings[2]
            , (com.google.android.material.textfield.TextInputLayout) bindings[9]
            , (com.google.android.material.textfield.TextInputLayout) bindings[8]
            , (com.google.android.material.textfield.TextInputLayout) bindings[7]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[6]
            );
        this.btnBack.setTag(null);
        this.btnConfirm.setTag(null);
        this.etConfirmPassword.setTag(null);
        this.etNewPassword.setTag(null);
        this.etOldPassword.setTag(null);
        this.mboundView0 = (androidx.core.widget.NestedScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback27 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        mCallback26 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x20L;
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
            setListener((com.qltc.finace.view.main.profile.ChangePasswordListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.profile.ChangePasswordViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.profile.ChangePasswordListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.main.profile.ChangePasswordViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x10L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelConfirmPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 1 :
                return onChangeViewModelNewPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
            case 2 :
                return onChangeViewModelOldPassword((androidx.lifecycle.MutableLiveData<java.lang.String>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelConfirmPassword(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelConfirmPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelNewPassword(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelNewPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelOldPassword(androidx.lifecycle.MutableLiveData<java.lang.String> ViewModelOldPassword, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
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
        java.lang.String viewModelNewPasswordGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelConfirmPassword = null;
        com.qltc.finace.view.main.profile.ChangePasswordListener listener = mListener;
        java.lang.String viewModelOldPasswordGetValue = null;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelNewPassword = null;
        java.lang.String viewModelConfirmPasswordGetValue = null;
        com.qltc.finace.view.main.profile.ChangePasswordViewModel viewModel = mViewModel;
        androidx.lifecycle.MutableLiveData<java.lang.String> viewModelOldPassword = null;

        if ((dirtyFlags & 0x37L) != 0) {


            if ((dirtyFlags & 0x31L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.confirmPassword
                        viewModelConfirmPassword = viewModel.getConfirmPassword();
                    }
                    updateLiveDataRegistration(0, viewModelConfirmPassword);


                    if (viewModelConfirmPassword != null) {
                        // read viewModel.confirmPassword.getValue()
                        viewModelConfirmPasswordGetValue = viewModelConfirmPassword.getValue();
                    }
            }
            if ((dirtyFlags & 0x32L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.newPassword
                        viewModelNewPassword = viewModel.getNewPassword();
                    }
                    updateLiveDataRegistration(1, viewModelNewPassword);


                    if (viewModelNewPassword != null) {
                        // read viewModel.newPassword.getValue()
                        viewModelNewPasswordGetValue = viewModelNewPassword.getValue();
                    }
            }
            if ((dirtyFlags & 0x34L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.oldPassword
                        viewModelOldPassword = viewModel.getOldPassword();
                    }
                    updateLiveDataRegistration(2, viewModelOldPassword);


                    if (viewModelOldPassword != null) {
                        // read viewModel.oldPassword.getValue()
                        viewModelOldPasswordGetValue = viewModelOldPassword.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x20L) != 0) {
            // api target 1

            this.btnBack.setOnClickListener(mCallback26);
            this.btnConfirm.setOnClickListener(mCallback27);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etConfirmPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etConfirmPasswordandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etNewPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etNewPasswordandroidTextAttrChanged);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.etOldPassword, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, etOldPasswordandroidTextAttrChanged);
        }
        if ((dirtyFlags & 0x31L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etConfirmPassword, viewModelConfirmPasswordGetValue);
        }
        if ((dirtyFlags & 0x32L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etNewPassword, viewModelNewPasswordGetValue);
        }
        if ((dirtyFlags & 0x34L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.etOldPassword, viewModelOldPasswordGetValue);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.profile.ChangePasswordListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onConfirmClick();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.profile.ChangePasswordListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onBackClick();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.confirmPassword
        flag 1 (0x2L): viewModel.newPassword
        flag 2 (0x3L): viewModel.oldPassword
        flag 3 (0x4L): listener
        flag 4 (0x5L): viewModel
        flag 5 (0x6L): null
    flag mapping end*/
    //end
}