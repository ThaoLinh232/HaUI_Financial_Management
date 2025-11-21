package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemFaqBindingImpl extends ItemFaqBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = null;
    }
    // views
    @NonNull
    private final com.google.android.material.card.MaterialCardView mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @NonNull
    private final android.widget.TextView mboundView2;
    @NonNull
    private final android.widget.ImageView mboundView3;
    @NonNull
    private final android.widget.TextView mboundView4;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback58;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemFaqBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 5, sIncludes, sViewsWithIds));
    }
    private ItemFaqBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            );
        this.mboundView0 = (com.google.android.material.card.MaterialCardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView2 = (android.widget.TextView) bindings[2];
        this.mboundView2.setTag(null);
        this.mboundView3 = (android.widget.ImageView) bindings[3];
        this.mboundView3.setTag(null);
        this.mboundView4 = (android.widget.TextView) bindings[4];
        this.mboundView4.setTag(null);
        setRootTag(root);
        // listeners
        mCallback58 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
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
        if (BR.position == variableId) {
            setPosition((java.lang.Integer) variable);
        }
        else if (BR.adapter == variableId) {
            setAdapter((com.qltc.finace.view.adapter.FAQAdapter) variable);
        }
        else if (BR.data == variableId) {
            setData((com.qltc.finace.data.entity.FAQItem) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setPosition(@Nullable java.lang.Integer Position) {
        this.mPosition = Position;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.position);
        super.requestRebind();
    }
    public void setAdapter(@Nullable com.qltc.finace.view.adapter.FAQAdapter Adapter) {
        this.mAdapter = Adapter;
        synchronized(this) {
            mDirtyFlags |= 0x2L;
        }
        notifyPropertyChanged(BR.adapter);
        super.requestRebind();
    }
    public void setData(@Nullable com.qltc.finace.data.entity.FAQItem Data) {
        this.mData = Data;
        synchronized(this) {
            mDirtyFlags |= 0x4L;
        }
        notifyPropertyChanged(BR.data);
        super.requestRebind();
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
        java.lang.Integer position = mPosition;
        boolean dataIsExpanded = false;
        java.lang.String dataQuestion = null;
        android.graphics.drawable.Drawable dataIsExpandedMboundView3AndroidDrawableIcUpperMboundView3AndroidDrawableIcDowner = null;
        java.lang.String dataAnswer = null;
        float dataIsExpandedFloat180fFloat0f = 0f;
        int dataIsExpandedViewVISIBLEViewGONE = 0;
        com.qltc.finace.view.adapter.FAQAdapter adapter = mAdapter;
        com.qltc.finace.data.entity.FAQItem data = mData;

        if ((dirtyFlags & 0xcL) != 0) {



                if (data != null) {
                    // read data.isExpanded
                    dataIsExpanded = data.isExpanded();
                    // read data.question
                    dataQuestion = data.getQuestion();
                    // read data.answer
                    dataAnswer = data.getAnswer();
                }
            if((dirtyFlags & 0xcL) != 0) {
                if(dataIsExpanded) {
                        dirtyFlags |= 0x20L;
                        dirtyFlags |= 0x80L;
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x10L;
                        dirtyFlags |= 0x40L;
                        dirtyFlags |= 0x100L;
                }
            }


                // read data.isExpanded ? @android:drawable/ic_upper : @android:drawable/ic_downer
                dataIsExpandedMboundView3AndroidDrawableIcUpperMboundView3AndroidDrawableIcDowner = ((dataIsExpanded) ? (androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView3.getContext(), R.drawable.ic_upper)) : (androidx.appcompat.content.res.AppCompatResources.getDrawable(mboundView3.getContext(), R.drawable.ic_downer)));
                // read data.isExpanded ? 180f : 0f
                dataIsExpandedFloat180fFloat0f = ((dataIsExpanded) ? (180f) : (0f));
                // read data.isExpanded ? View.VISIBLE : View.GONE
                dataIsExpandedViewVISIBLEViewGONE = ((dataIsExpanded) ? (android.view.View.VISIBLE) : (android.view.View.GONE));
        }
        // batch finished
        if ((dirtyFlags & 0x8L) != 0) {
            // api target 1

            this.mboundView1.setOnClickListener(mCallback58);
        }
        if ((dirtyFlags & 0xcL) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView2, dataQuestion);
            androidx.databinding.adapters.ImageViewBindingAdapter.setImageDrawable(this.mboundView3, dataIsExpandedMboundView3AndroidDrawableIcUpperMboundView3AndroidDrawableIcDowner);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView4, dataAnswer);
            this.mboundView4.setVisibility(dataIsExpandedViewVISIBLEViewGONE);
            // api target 11
            if(getBuildSdkInt() >= 11) {

                this.mboundView3.setRotation(dataIsExpandedFloat180fFloat0f);
            }
        }
    }
    // Listener Stub Implementations
    // callback impls
    public final void _internalCallbackOnClick(int sourceId , android.view.View callbackArg_0) {
        // localize variables for thread safety
        // position
        java.lang.Integer position = mPosition;
        // adapter
        com.qltc.finace.view.adapter.FAQAdapter adapter = mAdapter;
        // adapter != null
        boolean adapterJavaLangObjectNull = false;



        adapterJavaLangObjectNull = (adapter) != (null);
        if (adapterJavaLangObjectNull) {



            adapter.toggleExpansion(position);
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): position
        flag 1 (0x2L): adapter
        flag 2 (0x3L): data
        flag 3 (0x4L): null
        flag 4 (0x5L): data.isExpanded ? @android:drawable/ic_upper : @android:drawable/ic_downer
        flag 5 (0x6L): data.isExpanded ? @android:drawable/ic_upper : @android:drawable/ic_downer
        flag 6 (0x7L): data.isExpanded ? 180f : 0f
        flag 7 (0x8L): data.isExpanded ? 180f : 0f
        flag 8 (0x9L): data.isExpanded ? View.VISIBLE : View.GONE
        flag 9 (0xaL): data.isExpanded ? View.VISIBLE : View.GONE
    flag mapping end*/
    //end
}