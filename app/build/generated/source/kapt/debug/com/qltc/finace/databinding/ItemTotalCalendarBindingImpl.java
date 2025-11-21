package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ItemTotalCalendarBindingImpl extends ItemTotalCalendarBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.bg_icon, 6);
    }
    // views
    @NonNull
    private final androidx.constraintlayout.widget.ConstraintLayout mboundView0;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ItemTotalCalendarBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds));
    }
    private ItemTotalCalendarBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (com.google.android.material.imageview.ShapeableImageView) bindings[6]
            , (com.google.android.material.textview.MaterialTextView) bindings[3]
            , (com.google.android.material.imageview.ShapeableImageView) bindings[1]
            , (com.google.android.material.textview.MaterialTextView) bindings[4]
            , (com.google.android.material.textview.MaterialTextView) bindings[5]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            );
        this.category.setTag(null);
        this.icon.setTag(null);
        this.materialTextView3.setTag(null);
        this.materialTextView4.setTag(null);
        this.mboundView0 = (androidx.constraintlayout.widget.ConstraintLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.name.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
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
        if (BR.item == variableId) {
            setItem((com.qltc.finace.view.main.calendar.FinancialRecord) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setItem(@Nullable com.qltc.finace.view.main.calendar.FinancialRecord Item) {
        this.mItem = Item;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.item);
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
        com.qltc.finace.view.main.calendar.FinancialRecord item = mItem;
        java.lang.String itemDate = null;
        java.lang.String itemNoteExpenseIncome = null;
        java.lang.String itemTitleCategory = null;
        java.lang.String itemIcon = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (item != null) {
                    // read item.date
                    itemDate = item.getDate();
                    // read item.noteExpenseIncome
                    itemNoteExpenseIncome = item.getNoteExpenseIncome();
                    // read item.titleCategory
                    itemTitleCategory = item.getTitleCategory();
                    // read item.icon
                    itemIcon = item.getIcon();
                }
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.category, itemTitleCategory);
            com.qltc.finace.AppBindingAdapter.setIcon(this.icon, itemIcon);
            com.qltc.finace.AppBindingAdapter.setMoney(this.materialTextView3, item);
            com.qltc.finace.AppBindingAdapter.setTimeString(this.materialTextView4, itemDate);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.name, itemNoteExpenseIncome);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): item
        flag 1 (0x2L): null
    flag mapping end*/
    //end
}