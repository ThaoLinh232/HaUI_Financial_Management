package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentCalendarBindingImpl extends FragmentCalendarBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.exFiveAppBarLayout, 6);
        sViewsWithIds.put(R.id.month_year_text, 7);
        sViewsWithIds.put(R.id.calendarView, 8);
        sViewsWithIds.put(R.id.filter, 9);
        sViewsWithIds.put(R.id.group_total, 10);
        sViewsWithIds.put(R.id.line, 11);
        sViewsWithIds.put(R.id.list_income_and_expense, 12);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView3;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView4;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView5;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback57;
    @Nullable
    private final android.view.View.OnClickListener mCallback56;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentCalendarBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }
    private FragmentCalendarBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 2
            , (com.kizitonwose.calendar.view.CalendarView) bindings[8]
            , (com.google.android.material.appbar.AppBarLayout) bindings[6]
            , (android.widget.ImageView) bindings[2]
            , (android.widget.ImageView) bindings[1]
            , (android.widget.TextView) bindings[9]
            , (android.widget.LinearLayout) bindings[10]
            , (android.view.View) bindings[11]
            , (androidx.recyclerview.widget.RecyclerView) bindings[12]
            , (android.widget.TextView) bindings[7]
            );
        this.exFiveNextMonthImage.setTag(null);
        this.exFivePreviousMonthImage.setTag(null);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView3 = (com.google.android.material.textview.MaterialTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (com.google.android.material.textview.MaterialTextView) bindings[4];
        this.mboundView4.setTag(null);
        this.mboundView5 = (com.google.android.material.textview.MaterialTextView) bindings[5];
        this.mboundView5.setTag(null);
        setRootTag(root);
        // listeners
        mCallback57 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        mCallback56 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x10L;
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
            setListener((com.qltc.finace.view.main.calendar.CalendarListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.calendar.CalendarViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.calendar.CalendarListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.main.calendar.CalendarViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x8L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelExpenseTotal((androidx.lifecycle.MutableLiveData<java.lang.Long>) object, fieldId);
            case 1 :
                return onChangeViewModelIncomeTotal((androidx.lifecycle.MutableLiveData<java.lang.Long>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelExpenseTotal(androidx.lifecycle.MutableLiveData<java.lang.Long> ViewModelExpenseTotal, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIncomeTotal(androidx.lifecycle.MutableLiveData<java.lang.Long> ViewModelIncomeTotal, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
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
        long androidxDatabindingViewDataBindingSafeUnboxViewModelIncomeTotalGetValue = 0;
        androidx.lifecycle.MutableLiveData<java.lang.Long> viewModelExpenseTotal = null;
        androidx.lifecycle.MutableLiveData<java.lang.Long> viewModelIncomeTotal = null;
        long androidxDatabindingViewDataBindingSafeUnboxViewModelIncomeTotalViewModelExpenseTotal = 0;
        com.qltc.finace.view.main.calendar.CalendarListener listener = mListener;
        java.lang.Long viewModelIncomeTotalGetValue = null;
        long viewModelIncomeTotalViewModelExpenseTotal = 0;
        java.lang.Long viewModelExpenseTotalGetValue = null;
        long androidxDatabindingViewDataBindingSafeUnboxViewModelExpenseTotalGetValue = 0;
        long androidxDatabindingViewDataBindingSafeUnboxViewModelExpenseTotal = 0;
        long ViewModelExpenseTotal1 = 0;
        com.qltc.finace.view.main.calendar.CalendarViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0x1bL) != 0) {



                if (viewModel != null) {
                    // read viewModel.expenseTotal
                    viewModelExpenseTotal = viewModel.getExpenseTotal();
                    // read viewModel.incomeTotal
                    viewModelIncomeTotal = viewModel.getIncomeTotal();
                }
                updateLiveDataRegistration(0, viewModelExpenseTotal);
                updateLiveDataRegistration(1, viewModelIncomeTotal);


                if (viewModelExpenseTotal != null) {
                    // read viewModel.expenseTotal.getValue()
                    viewModelExpenseTotalGetValue = viewModelExpenseTotal.getValue();
                }
                if (viewModelIncomeTotal != null) {
                    // read viewModel.incomeTotal.getValue()
                    viewModelIncomeTotalGetValue = viewModelIncomeTotal.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.expenseTotal.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelExpenseTotalGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelExpenseTotalGetValue);
                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.incomeTotal.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIncomeTotalGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIncomeTotalGetValue);

            if ((dirtyFlags & 0x19L) != 0) {

                    // read -androidx.databinding.ViewDataBinding.safeUnbox(viewModel.expenseTotal.getValue())
                    ViewModelExpenseTotal1 = -androidxDatabindingViewDataBindingSafeUnboxViewModelExpenseTotalGetValue;


                    // read androidx.databinding.ViewDataBinding.safeUnbox(-androidx.databinding.ViewDataBinding.safeUnbox(viewModel.expenseTotal.getValue()))
                    androidxDatabindingViewDataBindingSafeUnboxViewModelExpenseTotal = androidx.databinding.ViewDataBinding.safeUnbox(ViewModelExpenseTotal1);
            }

                // read (androidx.databinding.ViewDataBinding.safeUnbox(viewModel.incomeTotal.getValue())) - (androidx.databinding.ViewDataBinding.safeUnbox(viewModel.expenseTotal.getValue()))
                viewModelIncomeTotalViewModelExpenseTotal = (androidxDatabindingViewDataBindingSafeUnboxViewModelIncomeTotalGetValue) - (androidxDatabindingViewDataBindingSafeUnboxViewModelExpenseTotalGetValue);


                // read androidx.databinding.ViewDataBinding.safeUnbox((androidx.databinding.ViewDataBinding.safeUnbox(viewModel.incomeTotal.getValue())) - (androidx.databinding.ViewDataBinding.safeUnbox(viewModel.expenseTotal.getValue())))
                androidxDatabindingViewDataBindingSafeUnboxViewModelIncomeTotalViewModelExpenseTotal = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIncomeTotalViewModelExpenseTotal);
        }
        // batch finished
        if ((dirtyFlags & 0x10L) != 0) {
            // api target 1

            this.exFiveNextMonthImage.setOnClickListener(mCallback57);
            this.exFivePreviousMonthImage.setOnClickListener(mCallback56);
        }
        if ((dirtyFlags & 0x1aL) != 0) {
            // api target 1

            com.qltc.finace.AppBindingAdapter.setTextWithTotalMoney(this.mboundView3, androidxDatabindingViewDataBindingSafeUnboxViewModelIncomeTotalGetValue);
        }
        if ((dirtyFlags & 0x19L) != 0) {
            // api target 1

            com.qltc.finace.AppBindingAdapter.setTextWithTotalMoney(this.mboundView4, androidxDatabindingViewDataBindingSafeUnboxViewModelExpenseTotal);
        }
        if ((dirtyFlags & 0x1bL) != 0) {
            // api target 1

            com.qltc.finace.AppBindingAdapter.setTextWithTotalMoney(this.mboundView5, androidxDatabindingViewDataBindingSafeUnboxViewModelIncomeTotalViewModelExpenseTotal);
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
                com.qltc.finace.view.main.calendar.CalendarListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.exFiveNextMonthImage();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.calendar.CalendarListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.exFivePreviousMonthImage();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.expenseTotal
        flag 1 (0x2L): viewModel.incomeTotal
        flag 2 (0x3L): listener
        flag 3 (0x4L): viewModel
        flag 4 (0x5L): null
    flag mapping end*/
    //end
}