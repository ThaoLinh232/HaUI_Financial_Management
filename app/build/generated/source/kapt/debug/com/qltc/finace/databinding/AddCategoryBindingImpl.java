package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class AddCategoryBindingImpl extends AddCategoryBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 4);
        sViewsWithIds.put(R.id.textView11, 5);
        sViewsWithIds.put(R.id.constraintLayout, 6);
        sViewsWithIds.put(R.id.textView2, 7);
        sViewsWithIds.put(R.id.textView7, 8);
        sViewsWithIds.put(R.id.rcv, 9);
        sViewsWithIds.put(R.id.guideline, 10);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.ImageButton mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback69;
    @Nullable
    private final android.view.View.OnClickListener mCallback70;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener inputTitleandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.title
            //         is viewModel.setTitle((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(inputTitle);
            // localize variables for thread safety
            // viewModel
            com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel viewModel = mViewModel;
            // viewModel.title
            java.lang.String viewModelTitle = null;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setTitle(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public AddCategoryBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private AddCategoryBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageButton) bindings[1]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[6]
            , (androidx.constraintlayout.widget.Guideline) bindings[10]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[9]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[8]
            , (bindings[4] != null) ? com.qltc.finace.databinding.ToolbarBinding.bind((android.view.View) bindings[4]) : null
            );
        this.btnBack.setTag(null);
        this.inputTitle.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.ImageButton) bindings[2];
        this.mboundView2.setTag(null);
        setRootTag(root);
        // listeners
        mCallback69 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        mCallback70 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
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
            setListener((com.qltc.finace.view.main.enter.add_category.AddCategoryListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.enter.add_category.AddCategoryListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel ViewModel) {
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
                return onChangeViewModelIsEnableButtonAdd((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsEnableButtonAdd(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsEnableButtonAdd, int fieldId) {
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
        java.lang.String viewModelTitle = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButtonAdd = null;
        java.lang.Boolean viewModelIsEnableButtonAddGetValue = null;
        com.qltc.finace.view.main.enter.add_category.AddCategoryListener listener = mListener;
        com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel viewModel = mViewModel;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddGetValue = false;

        if ((dirtyFlags & 0xdL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.title
                        viewModelTitle = viewModel.getTitle();
                    }
            }

                if (viewModel != null) {
                    // read viewModel.isEnableButtonAdd()
                    viewModelIsEnableButtonAdd = viewModel.isEnableButtonAdd();
                }
                updateLiveDataRegistration(0, viewModelIsEnableButtonAdd);


                if (viewModelIsEnableButtonAdd != null) {
                    // read viewModel.isEnableButtonAdd().getValue()
                    viewModelIsEnableButtonAddGetValue = viewModelIsEnableButtonAdd.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isEnableButtonAdd().getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsEnableButtonAddGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.btnBack.setOnClickListener(mCallback69);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inputTitle, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inputTitleandroidTextAttrChanged);
            this.mboundView2.setOnClickListener(mCallback70);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.inputTitle, viewModelTitle);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            com.qltc.finace.AppBindingAdapter.setIconEnableInputData(this.mboundView2, androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddGetValue);
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
                com.qltc.finace.view.main.enter.add_category.AddCategoryListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onClickBack();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.enter.add_category.AddCategoryListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onClickAddNewCategory();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isEnableButtonAdd()
        flag 1 (0x2L): listener
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}