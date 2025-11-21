package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentIncomeBindingImpl extends FragmentIncomeBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

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
        sViewsWithIds.put(R.id.rcv_income, 10);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback67;
    @Nullable
    private final android.view.View.OnClickListener mCallback68;
    @Nullable
    private final android.view.View.OnClickListener mCallback66;
    // values
    // listeners
    // Inverse Binding Event Handlers
    private androidx.databinding.InverseBindingListener edtNoteandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.noteIncome
            //         is viewModel.setNoteIncome((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(edtNote);
            // localize variables for thread safety
            // viewModel.noteIncome
            java.lang.String viewModelNoteIncome = null;
            // viewModel
            com.qltc.finace.view.main.enter.ShareEnterViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setNoteIncome(((java.lang.String) (callbackArg_0)));
            }
        }
    };
    private androidx.databinding.InverseBindingListener inputMoneyandroidTextAttrChanged = new androidx.databinding.InverseBindingListener() {
        @Override
        public void onChange() {
            // Inverse of viewModel.moneyIncome
            //         is viewModel.setMoneyIncome((java.lang.String) callbackArg_0)
            java.lang.String callbackArg_0 = androidx.databinding.adapters.TextViewBindingAdapter.getTextString(inputMoney);
            // localize variables for thread safety
            // viewModel.moneyIncome
            java.lang.String viewModelMoneyIncome = null;
            // viewModel
            com.qltc.finace.view.main.enter.ShareEnterViewModel viewModel = mViewModel;
            // viewModel != null
            boolean viewModelJavaLangObjectNull = false;



            viewModelJavaLangObjectNull = (viewModel) != (null);
            if (viewModelJavaLangObjectNull) {




                viewModel.setMoneyIncome(((java.lang.String) (callbackArg_0)));
            }
        }
    };

    public FragmentIncomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }
    private FragmentIncomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.button.MaterialButton) bindings[2]
            , (androidx.appcompat.widget.AppCompatEditText) bindings[4]
            , (android.widget.ImageView) bindings[5]
            , (com.google.android.material.textfield.TextInputEditText) bindings[3]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            , (androidx.recyclerview.widget.RecyclerView) bindings[10]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[7]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[9]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[6]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[8]
            );
        this.button.setTag(null);
        this.edtNote.setTag(null);
        this.imageView3.setTag(null);
        this.inputMoney.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.pickTime.setTag(null);
        setRootTag(root);
        // listeners
        mCallback67 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        mCallback68 = new com.qltc.finace.generated.callback.OnClickListener(this, 3);
        mCallback66 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
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
            setListener((com.qltc.finace.view.main.enter.income.IncomeListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.enter.ShareEnterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.enter.income.IncomeListener Listener) {
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
                return onChangeViewModelIsEnableButtonAddIncome((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsEnableButtonAddIncome(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsEnableButtonAddIncome, int fieldId) {
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
        java.lang.String viewModelNoteIncome = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddIncomeGetValue = false;
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButtonAddIncome = null;
        com.qltc.finace.view.main.enter.income.IncomeListener listener = mListener;
        java.lang.Boolean viewModelIsEnableButtonAddIncomeGetValue = null;
        java.lang.String viewModelMoneyIncome = null;
        com.qltc.finace.view.main.enter.ShareEnterViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdL) != 0) {


            if ((dirtyFlags & 0xcL) != 0) {

                    if (viewModel != null) {
                        // read viewModel.noteIncome
                        viewModelNoteIncome = viewModel.getNoteIncome();
                        // read viewModel.moneyIncome
                        viewModelMoneyIncome = viewModel.getMoneyIncome();
                    }
            }

                if (viewModel != null) {
                    // read viewModel.isEnableButtonAddIncome()
                    viewModelIsEnableButtonAddIncome = viewModel.isEnableButtonAddIncome();
                }
                updateLiveDataRegistration(0, viewModelIsEnableButtonAddIncome);


                if (viewModelIsEnableButtonAddIncome != null) {
                    // read viewModel.isEnableButtonAddIncome().getValue()
                    viewModelIsEnableButtonAddIncomeGetValue = viewModelIsEnableButtonAddIncome.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isEnableButtonAddIncome().getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddIncomeGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsEnableButtonAddIncomeGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.button.setOnClickListener(mCallback67);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.edtNote, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, edtNoteandroidTextAttrChanged);
            this.imageView3.setOnClickListener(mCallback68);
            androidx.databinding.adapters.TextViewBindingAdapter.setTextWatcher(this.inputMoney, (androidx.databinding.adapters.TextViewBindingAdapter.BeforeTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.OnTextChanged)null, (androidx.databinding.adapters.TextViewBindingAdapter.AfterTextChanged)null, inputMoneyandroidTextAttrChanged);
            this.pickTime.setOnClickListener(mCallback66);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            this.button.setEnabled(androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddIncomeGetValue);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.edtNote, viewModelNoteIncome);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.inputMoney, viewModelMoneyIncome);
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
                com.qltc.finace.view.main.enter.income.IncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.submitIncome();
                }
                break;
            }
            case 3: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.enter.income.IncomeListener listener = mListener;



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
                com.qltc.finace.view.main.enter.income.IncomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openDayPicker();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isEnableButtonAddIncome()
        flag 1 (0x2L): listener
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}