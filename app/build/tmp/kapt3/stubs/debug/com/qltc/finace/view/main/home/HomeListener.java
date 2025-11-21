package com.qltc.finace.view.main.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&J\b\u0010\n\u001a\u00020\u0003H&\u00a8\u0006\u000b"}, d2 = {"Lcom/qltc/finace/view/main/home/HomeListener;", "", "onExpenseCardClick", "", "onIncomeCardClick", "onNotificationClick", "onTabSelected", "position", "", "onToggleBalanceClick", "onViewAllTransactionsClick", "app_debug"})
public abstract interface HomeListener {
    
    public abstract void onToggleBalanceClick();
    
    public abstract void onNotificationClick();
    
    public abstract void onIncomeCardClick();
    
    public abstract void onExpenseCardClick();
    
    public abstract void onViewAllTransactionsClick();
    
    public abstract void onTabSelected(int position);
}