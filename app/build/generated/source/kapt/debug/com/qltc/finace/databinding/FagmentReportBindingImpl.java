package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FagmentReportBindingImpl extends FagmentReportBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.materialToolbar2, 5);
        sViewsWithIds.put(R.id.textView9, 6);
        sViewsWithIds.put(R.id.button2, 7);
        sViewsWithIds.put(R.id.gr_3, 8);
        sViewsWithIds.put(R.id.textView14, 9);
        sViewsWithIds.put(R.id.materialTextView5, 10);
        sViewsWithIds.put(R.id.view2, 11);
        sViewsWithIds.put(R.id.imageView5, 12);
        sViewsWithIds.put(R.id.group_day, 13);
        sViewsWithIds.put(R.id.btn_back_day, 14);
        sViewsWithIds.put(R.id.btn_next_day, 15);
        sViewsWithIds.put(R.id.tab_layout_report, 16);
        sViewsWithIds.put(R.id.m_chart, 17);
        sViewsWithIds.put(R.id.month_selected, 18);
        sViewsWithIds.put(R.id.rcv, 19);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    @NonNull
    private final android.widget.TextView mboundView2;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback4;
    @Nullable
    private final android.view.View.OnClickListener mCallback5;
    @Nullable
    private final android.view.View.OnClickListener mCallback3;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FagmentReportBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }
    private FagmentReportBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (android.widget.Button) bindings[14]
            , (androidx.appcompat.widget.AppCompatButton) bindings[15]
            , (android.widget.ImageButton) bindings[7]
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            , (android.widget.LinearLayout) bindings[8]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[13]
            , (android.widget.ImageView) bindings[12]
            , (com.qltc.finace.view.main.report.chart.PieChartReport) bindings[17]
            , (com.google.android.material.textview.MaterialTextView) bindings[10]
            , (com.google.android.material.textview.MaterialTextView) bindings[1]
            , (bindings[5] != null) ? com.qltc.finace.databinding.ToolbarBinding.bind((android.view.View) bindings[5]) : null
            , (com.google.android.material.textview.MaterialTextView) bindings[18]
            , (androidx.appcompat.widget.AppCompatTextView) bindings[3]
            , (androidx.recyclerview.widget.RecyclerView) bindings[19]
            , (com.google.android.material.tabs.TabLayout) bindings[16]
            , (android.widget.LinearLayout) bindings[9]
            , (com.google.android.material.textview.MaterialTextView) bindings[6]
            , (android.view.View) bindings[11]
            );
        this.filter.setTag(null);
        this.materialTextView6.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.pickTime.setTag(null);
        setRootTag(root);
        // listeners
        mCallback4 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        mCallback5 = new com.qltc.finace.generated.callback.OnClickListener(this, 3);
        mCallback3 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
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
            setListener((com.qltc.finace.view.main.report.ReportListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.report.ReportViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.report.ReportListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.main.report.ReportViewModel ViewModel) {
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
                return onChangeViewModelTotal((androidx.lifecycle.MutableLiveData<java.lang.Long>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelTotal(androidx.lifecycle.MutableLiveData<java.lang.Long> ViewModelTotal, int fieldId) {
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
        long androidxDatabindingViewDataBindingSafeUnboxViewModelTotalGetValue = 0;
        com.qltc.finace.view.main.report.ReportListener listener = mListener;
        androidx.lifecycle.MutableLiveData<java.lang.Long> viewModelTotal = null;
        java.lang.Long viewModelTotalGetValue = null;
        com.qltc.finace.view.main.report.ReportViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdL) != 0) {



                if (viewModel != null) {
                    // read viewModel.total
                    viewModelTotal = viewModel.getTotal();
                }
                updateLiveDataRegistration(0, viewModelTotal);


                if (viewModelTotal != null) {
                    // read viewModel.total.getValue()
                    viewModelTotalGetValue = viewModelTotal.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.total.getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelTotalGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelTotalGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.filter.setOnClickListener(mCallback5);
            this.materialTextView6.setOnClickListener(mCallback3);
            this.pickTime.setOnClickListener(mCallback4);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            com.qltc.finace.AppBindingAdapter.setMoneyTotalReport(this.mboundView2, androidxDatabindingViewDataBindingSafeUnboxViewModelTotalGetValue);
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
                com.qltc.finace.view.main.report.ReportListener listener = mListener;



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
                com.qltc.finace.view.main.report.ReportListener listener = mListener;



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
                com.qltc.finace.view.main.report.ReportListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.openViewAll();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.total
        flag 1 (0x2L): listener
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}