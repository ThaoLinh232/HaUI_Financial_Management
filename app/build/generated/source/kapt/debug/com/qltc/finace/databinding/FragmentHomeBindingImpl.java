package com.qltc.finace.databinding;
import com.qltc.finace.R;
import com.qltc.finace.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FragmentHomeBindingImpl extends FragmentHomeBinding implements com.qltc.finace.generated.callback.OnClickListener.Listener {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.progressBar, 15);
        sViewsWithIds.put(R.id.errorLayout, 16);
        sViewsWithIds.put(R.id.tvError, 17);
        sViewsWithIds.put(R.id.btnRetry, 18);
        sViewsWithIds.put(R.id.contentLayout, 19);
        sViewsWithIds.put(R.id.iv_avatar, 20);
        sViewsWithIds.put(R.id.card_balance, 21);
        sViewsWithIds.put(R.id.layout_income, 22);
        sViewsWithIds.put(R.id.layout_expense, 23);
        sViewsWithIds.put(R.id.quick_actions, 24);
        sViewsWithIds.put(R.id.card_monthly_overview, 25);
        sViewsWithIds.put(R.id.tab_overview, 26);
        sViewsWithIds.put(R.id.bar_chart, 27);
        sViewsWithIds.put(R.id.tv_month_1, 28);
        sViewsWithIds.put(R.id.tv_month_2, 29);
        sViewsWithIds.put(R.id.tv_month_3, 30);
        sViewsWithIds.put(R.id.tv_month_4, 31);
        sViewsWithIds.put(R.id.tv_month_5, 32);
        sViewsWithIds.put(R.id.tv_month_6, 33);
        sViewsWithIds.put(R.id.tvEmptyCategories, 34);
        sViewsWithIds.put(R.id.rv_top_categories, 35);
        sViewsWithIds.put(R.id.btn_view_details, 36);
        sViewsWithIds.put(R.id.card_budget, 37);
        sViewsWithIds.put(R.id.card_recent_transactions, 38);
        sViewsWithIds.put(R.id.tvEmptyTransactions, 39);
        sViewsWithIds.put(R.id.rv_recent_transactions, 40);
    }
    // views
    @NonNull
    private final android.widget.FrameLayout mboundView0;
    // variables
    @Nullable
    private final android.view.View.OnClickListener mCallback30;
    @Nullable
    private final android.view.View.OnClickListener mCallback28;
    @Nullable
    private final android.view.View.OnClickListener mCallback32;
    @Nullable
    private final android.view.View.OnClickListener mCallback31;
    @Nullable
    private final android.view.View.OnClickListener mCallback29;
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FragmentHomeBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 41, sIncludes, sViewsWithIds));
    }
    private FragmentHomeBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 9
            , (com.github.mikephil.charting.charts.BarChart) bindings[27]
            , (android.widget.ImageButton) bindings[2]
            , (com.google.android.material.button.MaterialButton) bindings[18]
            , (android.widget.ImageButton) bindings[3]
            , (com.google.android.material.button.MaterialButton) bindings[14]
            , (com.google.android.material.button.MaterialButton) bindings[36]
            , (com.google.android.material.card.MaterialCardView) bindings[21]
            , (com.google.android.material.card.MaterialCardView) bindings[37]
            , (com.google.android.material.card.MaterialCardView) bindings[9]
            , (com.google.android.material.card.MaterialCardView) bindings[8]
            , (com.google.android.material.card.MaterialCardView) bindings[25]
            , (com.google.android.material.card.MaterialCardView) bindings[38]
            , (androidx.core.widget.NestedScrollView) bindings[19]
            , (android.widget.LinearLayout) bindings[16]
            , (de.hdodenhof.circleimageview.CircleImageView) bindings[20]
            , (android.widget.LinearLayout) bindings[23]
            , (android.widget.LinearLayout) bindings[22]
            , (android.widget.ProgressBar) bindings[15]
            , (com.google.android.material.progressindicator.LinearProgressIndicator) bindings[10]
            , (android.widget.LinearLayout) bindings[24]
            , (androidx.recyclerview.widget.RecyclerView) bindings[40]
            , (androidx.recyclerview.widget.RecyclerView) bindings[35]
            , (com.google.android.material.tabs.TabLayout) bindings[26]
            , (android.widget.TextView) bindings[4]
            , (android.widget.TextView) bindings[7]
            , (android.widget.TextView) bindings[34]
            , (android.widget.TextView) bindings[39]
            , (android.widget.TextView) bindings[17]
            , (android.widget.TextView) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (android.widget.TextView) bindings[28]
            , (android.widget.TextView) bindings[29]
            , (android.widget.TextView) bindings[30]
            , (android.widget.TextView) bindings[31]
            , (android.widget.TextView) bindings[32]
            , (android.widget.TextView) bindings[33]
            , (android.widget.TextView) bindings[12]
            , (android.widget.TextView) bindings[13]
            , (android.widget.TextView) bindings[11]
            , (android.widget.TextView) bindings[1]
            );
        this.btnNotification.setTag(null);
        this.btnToggleBalance.setTag(null);
        this.btnViewAllTransactions.setTag(null);
        this.cardExpense.setTag(null);
        this.cardIncome.setTag(null);
        this.mboundView0 = (android.widget.FrameLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.progressBudget.setTag(null);
        this.tvBalance.setTag(null);
        this.tvBalanceChange.setTag(null);
        this.tvExpenseMonth.setTag(null);
        this.tvIncomeMonth.setTag(null);
        this.tvRemainingAmount.setTag(null);
        this.tvRemainingDays.setTag(null);
        this.tvSpentAmount.setTag(null);
        this.tvUsername.setTag(null);
        setRootTag(root);
        // listeners
        mCallback30 = new com.qltc.finace.generated.callback.OnClickListener(this, 3);
        mCallback28 = new com.qltc.finace.generated.callback.OnClickListener(this, 1);
        mCallback32 = new com.qltc.finace.generated.callback.OnClickListener(this, 5);
        mCallback31 = new com.qltc.finace.generated.callback.OnClickListener(this, 4);
        mCallback29 = new com.qltc.finace.generated.callback.OnClickListener(this, 2);
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x800L;
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
            setListener((com.qltc.finace.view.main.home.HomeListener) variable);
        }
        else if (BR.viewModel == variableId) {
            setViewModel((com.qltc.finace.view.main.home.HomeViewModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setListener(@Nullable com.qltc.finace.view.main.home.HomeListener Listener) {
        this.mListener = Listener;
        synchronized(this) {
            mDirtyFlags |= 0x200L;
        }
        notifyPropertyChanged(BR.listener);
        super.requestRebind();
    }
    public void setViewModel(@Nullable com.qltc.finace.view.main.home.HomeViewModel ViewModel) {
        this.mViewModel = ViewModel;
        synchronized(this) {
            mDirtyFlags |= 0x400L;
        }
        notifyPropertyChanged(BR.viewModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0 :
                return onChangeViewModelCurrentBalance((androidx.lifecycle.LiveData<java.lang.Long>) object, fieldId);
            case 1 :
                return onChangeViewModelBalanceChange((androidx.lifecycle.LiveData<java.lang.Double>) object, fieldId);
            case 2 :
                return onChangeViewModelMonthlyIncome((androidx.lifecycle.LiveData<java.lang.Long>) object, fieldId);
            case 3 :
                return onChangeViewModelRemainingBudget((androidx.lifecycle.LiveData<java.lang.Long>) object, fieldId);
            case 4 :
                return onChangeViewModelIsBalanceVisible((androidx.lifecycle.LiveData<java.lang.Boolean>) object, fieldId);
            case 5 :
                return onChangeViewModelRemainingDays((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
            case 6 :
                return onChangeViewModelUsername((androidx.lifecycle.LiveData<java.lang.String>) object, fieldId);
            case 7 :
                return onChangeViewModelBudgetProgress((androidx.lifecycle.LiveData<java.lang.Integer>) object, fieldId);
            case 8 :
                return onChangeViewModelMonthlyExpense((androidx.lifecycle.LiveData<java.lang.Long>) object, fieldId);
        }
        return false;
    }
    private boolean onChangeViewModelCurrentBalance(androidx.lifecycle.LiveData<java.lang.Long> ViewModelCurrentBalance, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x1L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelBalanceChange(androidx.lifecycle.LiveData<java.lang.Double> ViewModelBalanceChange, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x2L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelMonthlyIncome(androidx.lifecycle.LiveData<java.lang.Long> ViewModelMonthlyIncome, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x4L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelRemainingBudget(androidx.lifecycle.LiveData<java.lang.Long> ViewModelRemainingBudget, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x8L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelIsBalanceVisible(androidx.lifecycle.LiveData<java.lang.Boolean> ViewModelIsBalanceVisible, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x10L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelRemainingDays(androidx.lifecycle.LiveData<java.lang.Integer> ViewModelRemainingDays, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x20L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelUsername(androidx.lifecycle.LiveData<java.lang.String> ViewModelUsername, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x40L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelBudgetProgress(androidx.lifecycle.LiveData<java.lang.Integer> ViewModelBudgetProgress, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x80L;
            }
            return true;
        }
        return false;
    }
    private boolean onChangeViewModelMonthlyExpense(androidx.lifecycle.LiveData<java.lang.Long> ViewModelMonthlyExpense, int fieldId) {
        if (fieldId == BR._all) {
            synchronized(this) {
                    mDirtyFlags |= 0x100L;
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
        int viewModelBalanceChangeInt0TvBalanceChangeAndroidColorGreen2D9849TvBalanceChangeAndroidColorRed = 0;
        java.lang.Integer viewModelRemainingDaysGetValue = null;
        double androidxDatabindingViewDataBindingSafeUnboxViewModelBalanceChangeGetValue = 0.0;
        androidx.lifecycle.LiveData<java.lang.Long> viewModelCurrentBalance = null;
        com.qltc.finace.view.main.home.HomeListener listener = mListener;
        androidx.lifecycle.LiveData<java.lang.Double> viewModelBalanceChange = null;
        java.lang.String viewModelRemainingDaysJavaLangStringNgY = null;
        java.lang.Long viewModelMonthlyIncomeGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Long> viewModelMonthlyIncome = null;
        java.lang.Long viewModelCurrentBalanceGetValue = null;
        androidx.lifecycle.LiveData<java.lang.Long> viewModelRemainingBudget = null;
        java.lang.Boolean viewModelIsBalanceVisibleGetValue = null;
        java.lang.Long viewModelRemainingBudgetGetValue = null;
        int androidxDatabindingViewDataBindingSafeUnboxViewModelBudgetProgressGetValue = 0;
        androidx.lifecycle.LiveData<java.lang.Boolean> viewModelIsBalanceVisible = null;
        java.lang.Double viewModelBalanceChangeGetValue = null;
        java.lang.Long viewModelMonthlyExpenseGetValue = null;
        java.lang.Integer viewModelBudgetProgressGetValue = null;
        java.lang.String viewModelUsernameGetValue = null;
        java.lang.String javaLangStringXinChOViewModelUsername = null;
        androidx.lifecycle.LiveData<java.lang.Integer> viewModelRemainingDays = null;
        androidx.lifecycle.LiveData<java.lang.String> viewModelUsername = null;
        androidx.lifecycle.LiveData<java.lang.Integer> viewModelBudgetProgress = null;
        androidx.lifecycle.LiveData<java.lang.Long> viewModelMonthlyExpense = null;
        boolean viewModelBalanceChangeInt0 = false;
        com.qltc.finace.view.main.home.HomeViewModel viewModel = mViewModel;

        if ((dirtyFlags & 0xdffL) != 0) {


            if ((dirtyFlags & 0xc01L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.currentBalance
                        viewModelCurrentBalance = viewModel.getCurrentBalance();
                    }
                    updateLiveDataRegistration(0, viewModelCurrentBalance);


                    if (viewModelCurrentBalance != null) {
                        // read viewModel.currentBalance.getValue()
                        viewModelCurrentBalanceGetValue = viewModelCurrentBalance.getValue();
                    }
            }
            if ((dirtyFlags & 0xc02L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.balanceChange
                        viewModelBalanceChange = viewModel.getBalanceChange();
                    }
                    updateLiveDataRegistration(1, viewModelBalanceChange);


                    if (viewModelBalanceChange != null) {
                        // read viewModel.balanceChange.getValue()
                        viewModelBalanceChangeGetValue = viewModelBalanceChange.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.balanceChange.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelBalanceChangeGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelBalanceChangeGetValue);


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.balanceChange.getValue()) >= 0
                    viewModelBalanceChangeInt0 = (androidxDatabindingViewDataBindingSafeUnboxViewModelBalanceChangeGetValue) >= (0);
                if((dirtyFlags & 0xc02L) != 0) {
                    if(viewModelBalanceChangeInt0) {
                            dirtyFlags |= 0x2000L;
                    }
                    else {
                            dirtyFlags |= 0x1000L;
                    }
                }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.balanceChange.getValue()) >= 0 ? @android:color/green_2D9849 : @android:color/red
                    viewModelBalanceChangeInt0TvBalanceChangeAndroidColorGreen2D9849TvBalanceChangeAndroidColorRed = ((viewModelBalanceChangeInt0) ? (getColorFromResource(tvBalanceChange, R.color.green_2D9849)) : (getColorFromResource(tvBalanceChange, R.color.red)));
            }
            if ((dirtyFlags & 0xc04L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.monthlyIncome
                        viewModelMonthlyIncome = viewModel.getMonthlyIncome();
                    }
                    updateLiveDataRegistration(2, viewModelMonthlyIncome);


                    if (viewModelMonthlyIncome != null) {
                        // read viewModel.monthlyIncome.getValue()
                        viewModelMonthlyIncomeGetValue = viewModelMonthlyIncome.getValue();
                    }
            }
            if ((dirtyFlags & 0xc08L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.remainingBudget
                        viewModelRemainingBudget = viewModel.getRemainingBudget();
                    }
                    updateLiveDataRegistration(3, viewModelRemainingBudget);


                    if (viewModelRemainingBudget != null) {
                        // read viewModel.remainingBudget.getValue()
                        viewModelRemainingBudgetGetValue = viewModelRemainingBudget.getValue();
                    }
            }
            if ((dirtyFlags & 0xc10L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.isBalanceVisible
                        viewModelIsBalanceVisible = viewModel.isBalanceVisible();
                    }
                    updateLiveDataRegistration(4, viewModelIsBalanceVisible);


                    if (viewModelIsBalanceVisible != null) {
                        // read viewModel.isBalanceVisible.getValue()
                        viewModelIsBalanceVisibleGetValue = viewModelIsBalanceVisible.getValue();
                    }
            }
            if ((dirtyFlags & 0xc20L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.remainingDays
                        viewModelRemainingDays = viewModel.getRemainingDays();
                    }
                    updateLiveDataRegistration(5, viewModelRemainingDays);


                    if (viewModelRemainingDays != null) {
                        // read viewModel.remainingDays.getValue()
                        viewModelRemainingDaysGetValue = viewModelRemainingDays.getValue();
                    }


                    // read (viewModel.remainingDays.getValue()) + (" ngày")
                    viewModelRemainingDaysJavaLangStringNgY = (viewModelRemainingDaysGetValue) + (" ngày");
            }
            if ((dirtyFlags & 0xc40L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.username
                        viewModelUsername = viewModel.getUsername();
                    }
                    updateLiveDataRegistration(6, viewModelUsername);


                    if (viewModelUsername != null) {
                        // read viewModel.username.getValue()
                        viewModelUsernameGetValue = viewModelUsername.getValue();
                    }


                    // read ("Xin chào, ") + (viewModel.username.getValue())
                    javaLangStringXinChOViewModelUsername = ("Xin chào, ") + (viewModelUsernameGetValue);
            }
            if ((dirtyFlags & 0xc80L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.budgetProgress
                        viewModelBudgetProgress = viewModel.getBudgetProgress();
                    }
                    updateLiveDataRegistration(7, viewModelBudgetProgress);


                    if (viewModelBudgetProgress != null) {
                        // read viewModel.budgetProgress.getValue()
                        viewModelBudgetProgressGetValue = viewModelBudgetProgress.getValue();
                    }


                    // read androidx.databinding.ViewDataBinding.safeUnbox(viewModel.budgetProgress.getValue())
                    androidxDatabindingViewDataBindingSafeUnboxViewModelBudgetProgressGetValue = androidx.databinding.ViewDataBinding.safeUnbox(viewModelBudgetProgressGetValue);
            }
            if ((dirtyFlags & 0xd00L) != 0) {

                    if (viewModel != null) {
                        // read viewModel.monthlyExpense
                        viewModelMonthlyExpense = viewModel.getMonthlyExpense();
                    }
                    updateLiveDataRegistration(8, viewModelMonthlyExpense);


                    if (viewModelMonthlyExpense != null) {
                        // read viewModel.monthlyExpense.getValue()
                        viewModelMonthlyExpenseGetValue = viewModelMonthlyExpense.getValue();
                    }
            }
        }
        // batch finished
        if ((dirtyFlags & 0x800L) != 0) {
            // api target 1

            this.btnNotification.setOnClickListener(mCallback28);
            this.btnToggleBalance.setOnClickListener(mCallback29);
            this.btnViewAllTransactions.setOnClickListener(mCallback32);
            this.cardExpense.setOnClickListener(mCallback31);
            this.cardIncome.setOnClickListener(mCallback30);
        }
        if ((dirtyFlags & 0xc80L) != 0) {
            // api target 1

            this.progressBudget.setProgress(androidxDatabindingViewDataBindingSafeUnboxViewModelBudgetProgressGetValue);
        }
        if ((dirtyFlags & 0xc01L) != 0) {
            // api target 1

            com.qltc.finace.utils.BindingAdaptersKt.setMoneyBalance(this.tvBalance, viewModelCurrentBalanceGetValue);
        }
        if ((dirtyFlags & 0xc10L) != 0) {
            // api target 1

            com.qltc.finace.utils.BindingAdaptersKt.setBalanceVisibility(this.tvBalance, viewModelIsBalanceVisibleGetValue);
        }
        if ((dirtyFlags & 0xc02L) != 0) {
            // api target 1

            this.tvBalanceChange.setTextColor(viewModelBalanceChangeInt0TvBalanceChangeAndroidColorGreen2D9849TvBalanceChangeAndroidColorRed);
            com.qltc.finace.utils.BindingAdaptersKt.setBalanceChange(this.tvBalanceChange, viewModelBalanceChangeGetValue);
        }
        if ((dirtyFlags & 0xd00L) != 0) {
            // api target 1

            com.qltc.finace.utils.BindingAdaptersKt.setMoneyExpense(this.tvExpenseMonth, viewModelMonthlyExpenseGetValue);
            com.qltc.finace.utils.BindingAdaptersKt.setMoneyExpense(this.tvSpentAmount, viewModelMonthlyExpenseGetValue);
        }
        if ((dirtyFlags & 0xc04L) != 0) {
            // api target 1

            com.qltc.finace.utils.BindingAdaptersKt.setMoneyIncome(this.tvIncomeMonth, viewModelMonthlyIncomeGetValue);
        }
        if ((dirtyFlags & 0xc08L) != 0) {
            // api target 1

            com.qltc.finace.utils.BindingAdaptersKt.setMoneyBalance(this.tvRemainingAmount, viewModelRemainingBudgetGetValue);
        }
        if ((dirtyFlags & 0xc20L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvRemainingDays, viewModelRemainingDaysJavaLangStringNgY);
        }
        if ((dirtyFlags & 0xc40L) != 0) {
            // api target 1

            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.tvUsername, javaLangStringXinChOViewModelUsername);
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
                com.qltc.finace.view.main.home.HomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onExpenseCardClick();
                }
                break;
            }
            case 1: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.home.HomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onNotificationClick();
                }
                break;
            }
            case 5: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.home.HomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onViewAllTransactionsClick();
                }
                break;
            }
            case 4: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.home.HomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onIncomeCardClick();
                }
                break;
            }
            case 2: {
                // localize variables for thread safety
                // listener != null
                boolean listenerJavaLangObjectNull = false;
                // listener
                com.qltc.finace.view.main.home.HomeListener listener = mListener;



                listenerJavaLangObjectNull = (listener) != (null);
                if (listenerJavaLangObjectNull) {


                    listener.onToggleBalanceClick();
                }
                break;
            }
        }
    }
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): viewModel.currentBalance
        flag 1 (0x2L): viewModel.balanceChange
        flag 2 (0x3L): viewModel.monthlyIncome
        flag 3 (0x4L): viewModel.remainingBudget
        flag 4 (0x5L): viewModel.isBalanceVisible
        flag 5 (0x6L): viewModel.remainingDays
        flag 6 (0x7L): viewModel.username
        flag 7 (0x8L): viewModel.budgetProgress
        flag 8 (0x9L): viewModel.monthlyExpense
        flag 9 (0xaL): listener
        flag 10 (0xbL): viewModel
        flag 11 (0xcL): null
        flag 12 (0xdL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.balanceChange.getValue()) >= 0 ? @android:color/green_2D9849 : @android:color/red
        flag 13 (0xeL): androidx.databinding.ViewDataBinding.safeUnbox(viewModel.balanceChange.getValue()) >= 0 ? @android:color/green_2D9849 : @android:color/red
    flag mapping end*/
    //end
}