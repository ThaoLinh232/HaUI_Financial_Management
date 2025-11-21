package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentEditBindingImpl extends FragmentEditBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 10);
        sViewsWithIds.put(R.id.type_update, 11);
        sViewsWithIds.put(R.id.textView3, 12);
        sViewsWithIds.put(R.id.textView, 13);
        sViewsWithIds.put(R.id.textView8, 14);
        sViewsWithIds.put(R.id.textView10, 15);
        sViewsWithIds.put(R.id.rcv, 16);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback17;
    @Nullable
    private final android.view.View.OnClickListener mCallback15;
    @Nullable
    private final android.view.View.OnClickListener mCallback13;
    @Nullable
    private final android.view.View.OnClickListener mCallback16;
    @Nullable
    private final android.view.View.OnClickListener mCallback14;
    @Nullable
    private final android.view.View.OnClickListener mCallback12;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener edtNoteandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.note
            //         is viewModel.setNote((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtNote);
            // localize variables for thread safety
            // viewModel
            com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.note
            java.lang.String viewModelNote = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setNote(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener inputMoneyandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.money
            //         is viewModel.setMoney((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(inputMoney);
            // localize variables for thread safety
            // viewModel.money
            java.lang.String viewModelMoney = null;
            // viewModel
            com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setMoney(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentEditBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }
    private FragmentEditBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.ImageButton) bindings[2]
            , (com.google.android.material.button.MaterialButton) bindings[9]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[1]
            , (android.widget.ImageButton) bindings[3]
            , (android.widget.ImageView) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[7]
            , (com.google.android.material.textview.MaterialTextView) bindings[6]
            , (androidx.recyclerview.widget.RecyclerView) bindings[16]
            , (android.widget.TextView) bindings[4]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[13]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[15]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[12]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[14]
            , (bindings[10] != null) ? com.qltc.finace.databinding.ToolbarBinding.bind((android.view.View) bindings[10]) : null
            , (android.widget.TextView) bindings[11]
            );
        this.btnBack.setTag(null);
        this.btnSave.setTag(null);
        this.edtNote.setTag(null);
        this.groupToolbar.setTag(null);
        this.imageButton.setTag(null);
        this.imageView3.setTag(null);
        this.inputMoney.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.pickTime.setTag(null);
        this.saveText.setTag(null);
        setRootTag(root);
        // listeners
        mCallback17 = new com.qltc.finace.generated.callback.OnClickListener(this, 6);
        mCallback15 = new com.qltc.finace.generated.callback.OnClickListener(this, 4);
        mCallback13 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        mCallback16 = new com.qltc.finace.generated.callback.OnClickListener(this, 5);
        mCallback14 = new com.qltc.finace.generated.callback.OnClickListener(this, 3);
        mCallback12 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
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
            setListener((com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel ViewModel) {
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
        java.lang.String viewModelMoney = null;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButtonAdd = null;
        com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener listener = mListener;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddGetValue = false;
        java.lang.String viewModelNote = null;
        java.lang.Boolean viewModelIsEnableButtonAddGetValue = null;
        com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.money
                        viewModelMoney = viewModel.getMoney();
                        // read viewModel.note
                        viewModelNote = viewModel.getNote();
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

            this.btnBack.setOnClickListener(mCallback12);
            this.btnSave.setOnClickListener(mCallback17);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtNote, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtNoteandroidTextAttrChanged);
            this.imageButton.setOnClickListener(mCallback13);
            this.imageView3.setOnClickListener(mCallback15);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inputMoney, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inputMoneyandroidTextAttrChanged);
            this.pickTime.setOnClickListener(mCallback16);
            this.saveText.setOnClickListener(mCallback14);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.btnSave.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddGetValue);
            com.qltc.finace.AppBindingAdapter.setIconEnableInputData(this.imageButton, androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddGetValue);
            this.saveText.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddGetValue);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtNote, viewModelNote);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.inputMoney, viewModelMoney);
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
                com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onClickUpdate();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openDayPicker();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onClickUpdate();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openDayPicker();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onClickUpdate();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.edit_expense_income.EditExpenseIncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onClickBack();
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