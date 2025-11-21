package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentExportPdfConfigBindingImpl extends FragmentExportPdfConfigBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 3);
        sViewsWithIds.put(R.id.tvTimeLabel, 4);
        sViewsWithIds.put(R.id.monthYearPickerContainer, 5);
        sViewsWithIds.put(R.id.monthPicker, 6);
        sViewsWithIds.put(R.id.yearPicker, 7);
        sViewsWithIds.put(R.id.tvTimeRange, 8);
        sViewsWithIds.put(R.id.btnSelectDate, 9);
        sViewsWithIds.put(R.id.tvDataTypeLabel, 10);
        sViewsWithIds.put(R.id.radioGroupDataType, 11);
        sViewsWithIds.put(R.id.rbExpense, 12);
        sViewsWithIds.put(R.id.rbIncome, 13);
        sViewsWithIds.put(R.id.rbBoth, 14);
        sViewsWithIds.put(R.id.tvDisplayOptionsLabel, 15);
        sViewsWithIds.put(R.id.cbShowCharts, 16);
        sViewsWithIds.put(R.id.cbShowStats, 17);
        sViewsWithIds.put(R.id.cbShowDetails, 18);
        sViewsWithIds.put(R.id.tvFileNameLabel, 19);
        sViewsWithIds.put(R.id.edtFileName, 20);
        sViewsWithIds.put(R.id.progressBar, 21);
    }
    // views
    @NonNull
    private final android.widget.ScrollView mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback2;
    @Nullable
    private final android.view.View.OnClickListener mCallback1;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentExportPdfConfigBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }
    private FragmentExportPdfConfigBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[1]
            , (android.widget.Button) bindings[2]
            , (android.widget.Button) bindings[9]
            , (android.widget.CheckBox) bindings[16]
            , (android.widget.CheckBox) bindings[18]
            , (android.widget.CheckBox) bindings[17]
            , (android.widget.EditText) bindings[20]
            , (android.widget.NumberPicker) bindings[6]
            , (android.widget.LinearLayout) bindings[5]
            , (android.widget.ProgressBar) bindings[21]
            , (android.widget.RadioGroup) bindings[11]
            , (android.widget.RadioButton) bindings[14]
            , (android.widget.RadioButton) bindings[12]
            , (android.widget.RadioButton) bindings[13]
            , (androidx.constraintlayout.widget.ConstraintLayout) bindings[3]
            , (android.widget.TextView) bindings[10]
            , (android.widget.TextView) bindings[15]
            , (android.widget.TextView) bindings[19]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[8]
            , (android.widget.NumberPicker) bindings[7]
            );
        this.btnBack.setTag(null);
        this.btnExportPdf.setTag(null);
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback2 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        mCallback1 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x4L;
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
            setListener((com.qltc.finace.view.main.export.ExportPdfListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.export.ExportPdfViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.export.ExportPdfListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.main.export.ExportPdfViewModel ViewModel) {
        this.mViewModel = ViewModel;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
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
        com.qltc.finace.view.main.export.ExportPdfListener listener = mListener;
        // batch finished
        if ((dirtyFlags & 0x4L) != 0) {
            // api target 1

            this.btnBack.setOnClickListener(mCallback1);
            this.btnExportPdf.setOnClickListener(mCallback2);
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
                com.qltc.finace.view.main.export.ExportPdfListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onExportPdfClicked();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.export.ExportPdfListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onBackClicked();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): listener
        flag 1 (0x2L): viewModel
        flag 2 (0x3L): null
    flag mapping end*/
    //end
}