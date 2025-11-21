package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentEnterBindingImpl extends FragmentEnterBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.appBarLayout, 3);
        sViewsWithIds.put(R.id.materialToolbar, 4);
        sViewsWithIds.put(R.id.tvTitle, 5);
        sViewsWithIds.put(R.id.tabLayout, 6);
        sViewsWithIds.put(R.id.vpg_home, 7);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback72;
    @Nullable
    private final android.view.View.OnClickListener mCallback71;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentEnterBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private FragmentEnterBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 1
            , (com.google.android.material.appbar.AppBarLayout) bindings[3]
            , (android.widget.ImageButton) bindings[2]
            , (android.widget.ImageButton) bindings[1]
            , (com.google.android.material.appbar.MaterialToolbar) bindings[4]
            , (com.google.android.material.tabs.TabLayout) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (androidx.viewpager2.widget.ViewPager2) bindings[7]
            );
        this.btnAdd.setTag(null);
        this.btnBack.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        setRootTag(root);
        // listeners
        mCallback72 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        mCallback71 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
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
            setListener((com.qltc.finace.view.main.enter.EnterListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.enter.ShareEnterViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.enter.EnterListener Listener) {
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
                return onChangeViewModelIsEnableButtonAddAtToolbar((androidx.lifecycle.MutableLiveData<java.lang.Boolean>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelIsEnableButtonAddAtToolbar(androidx.lifecycle.MutableLiveData<java.lang.Boolean> ViewModelIsEnableButtonAddAtToolbar, int fieldId) {
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
        androidx.lifecycle.MutableLiveData<java.lang.Boolean> viewModelIsEnableButtonAddAtToolbar = null;
        boolean androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddAtToolbarGetValue = false;
        com.qltc.finace.view.main.enter.EnterListener listener = mListener;
        com.qltc.finace.view.main.enter.ShareEnterViewModel viewModel = mViewModel;
        java.lang.Boolean viewModelIsEnableButtonAddAtToolbarGetValue = null;

        if ((dirtyFlags & 0xdL) != 0) {



                if (viewModel != null) {
                    // read viewModel.isEnableButtonAddAtToolbar()
                    viewModelIsEnableButtonAddAtToolbar = viewModel.isEnableButtonAddAtToolbar();
                }
                updateLiveDataRegistration(0, viewModelIsEnableButtonAddAtToolbar);


                if (viewModelIsEnableButtonAddAtToolbar != null) {
                    // read viewModel.isEnableButtonAddAtToolbar().getValue()
                    viewModelIsEnableButtonAddAtToolbarGetValue = viewModelIsEnableButtonAddAtToolbar.getValue();
                }


                // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.isEnableButtonAddAtToolbar().getValue())
                androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddAtToolbarGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelIsEnableButtonAddAtToolbarGetValue);
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.btnAdd.setOnClickListener(mCallback72);
            this.btnBack.setOnClickListener(mCallback71);
        }
        if ((dirtyFlags & 0xdL) != 0) {
            // api target 1

            com.qltc.finace.AppBindingAdapter.setIconEnableInputData(this.btnAdd, androidxDatabindingViewDataBindingSafeUnboxViewModelIsEnableButtonAddAtToolbarGetValue);
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
                com.qltc.finace.view.main.enter.EnterListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onClickInputData();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.enter.EnterListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onBackPressed();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.isEnableButtonAddAtToolbar()
        flag 1 (0x2L): listener
        flag 2 (0x3L): viewModel
        flag 3 (0x4L): null
    flag mapping end*/
    //end
}