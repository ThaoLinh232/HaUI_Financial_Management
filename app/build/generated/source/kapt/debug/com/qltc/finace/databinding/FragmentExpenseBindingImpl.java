package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentExpenseBindingImpl extends FragmentExpenseBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.textView3, 6);
        sViewsWithIds.put(R.id.textView, 7);
        sViewsWithIds.put(R.id.textView8, 8);
        sViewsWithIds.put(R.id.textView10, 9);
        sViewsWithIds.put(R.id.rcv_expense, 10);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback21;
    @Nullable
    private final android.view.View.OnClickListener mCallback19;
    @Nullable
    private final android.view.View.OnClickListener mCallback20;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener edtNoteExpenseandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.noteExpense
            //         is viewModel.setNoteExpense((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtNoteExpense);
            // localize variables for thread safety
            // viewModel
            com.qltc.finace.view.main.enter.ShareEnterViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;
            // viewModel.noteExpense
            java.lang.String viewModelNoteExpense = null;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setNoteExpense(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener inputMoneyExpenseandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.moneyExpense
            //         is viewModel.setMoneyExpense((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(inputMoneyExpense);
            // localize variables for thread safety
            // viewModel.moneyExpense
            java.lang.String viewModelMoneyExpense = null;
            // viewModel
            com.qltc.finace.view.main.enter.ShareEnterViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setMoneyExpense(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentExpenseBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentExpenseBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.button.MaterialButton) bindings[2]
            , (com.google.android.material.textfield.TextInputEditText) bindings[4]
            , (android.widget.ImageButton) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (com.google.android.material.textview.MaterialTextView) bindings[7]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[9]
            , (com.google.android.material.textview.MaterialTextView) bindings[6]
            , (com.google.android.material.textview.MaterialTextView) bindings[8]
            );
        this.button.setTag(null);
        this.edtNoteExpense.setTag(null);
        this.imageView2.setTag(null);
        this.inputMoneyExpense.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.pickTime.setTag(null);
        setRootTag(root);
        // listeners
        mCallback21 = new com.qltc.finace.generated.callback.OnClickListener(this, 3);
        mCallback19 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        mCallback20 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
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
            setListener((com.qltc.finace.view.main.enter.expense.ExpenseListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.enter.ShareEnterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.enter.expense.ExpenseListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.main.enter.ShareEnterViewModel ViewModel) {
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
                return onChangeViewModelIsEnableButtonAddExpense((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsEnableButtonAddExpense(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsEnableButtonAddExpense, int fieldId) {
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
        java.lang.Boolean viewModelIsEnableButtonAddExpenseGetValue = null;
        com.qltc.finace.view.main.enter.expense.ExpenseListener listener = mListener;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButtonAddExpense = null;
        java.lang.String viewModelMoneyExpense = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddExpenseGetValue = false;
        com.qltc.finace.view.main.enter.ShareEnterViewModel viewModel = mViewModel;
        java.lang.String viewModelNoteExpense = null;

        if ((dirtyFlags & 0xdL) != 0) {



                if (viewModel != null) {
                    // read viewModel.isEnableButtonAddExpense()
                    viewModelIsEnableButtonAddExpense = viewModel.isEnableButtonAddExpense();
                }
                updateLiveDataRegistration(0, viewModelIsEnableButtonAddExpense);


                if (viewModelIsEnableButtonAddExpense != null) {
                    // read viewModel.isEnableButtonAddExpense().getValue()
                    viewModelIsEnableButtonAddExpenseGetValue = viewModelIsEnableButtonAddExpense.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isEnableButtonAddExpense().getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddExpenseGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsEnableButtonAddExpenseGetValue);
            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.moneyExpense
                        viewModelMoneyExpense = viewModel.getMoneyExpense();
                        // read viewModel.noteExpense
                        viewModelNoteExpense = viewModel.getNoteExpense();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.button.setOnClickListener(mCallback20);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtNoteExpense, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtNoteExpenseandroidTextAttrChanged);
            this.imageView2.setOnClickListener(mCallback21);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inputMoneyExpense, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inputMoneyExpenseandroidTextAttrChanged);
            this.pickTime.setOnClickListener(mCallback19);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.button.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddExpenseGetValue);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtNoteExpense, viewModelNoteExpense);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.inputMoneyExpense, viewModelMoneyExpense);
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        switch(sourceId) {
            case 3: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.enter.expense.ExpenseListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openDayPicker();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.enter.expense.ExpenseListener listener = mListener;



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
                com.qltc.finace.view.main.enter.expense.ExpenseListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.submitExpense();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isEnableButtonAddExpense()
        flag 1 (0x2L): listener
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}