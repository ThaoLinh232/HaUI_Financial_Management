package com.qltc.finace.data.repository.local.income;

import com.qltc.finace.data.entity.Income;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bH\u00a6@\u00a2\u0006\u0002\u0010\tJ\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\f\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\u0006\u0010\u0010\u001a\u00020\rH\u00a6@\u00a2\u0006\u0002\u0010\u000eJ\u0016\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006J\u0016\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a6@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0013"}, d2 = {"Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "", "deleteIncome", "", "income", "Lcom/qltc/finace/data/entity/Income;", "(Lcom/qltc/finace/data/entity/Income;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllIncome", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncomeByDate", "", "date", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getIncomeByMonth", "month", "insertIncome", "updateIncome", "app_debug"})
public abstract interface InComeRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getAllIncome(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.qltc.finace.data.entity.Income>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertIncome(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.Income income, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getIncomeByDate(@org.jetbrains.annotations.NotNull()
    java.lang.String date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.qltc.finace.data.entity.Income>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getIncomeByMonth(@org.jetbrains.annotations.NotNull()
    java.lang.String month, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.qltc.finace.data.entity.Income>> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteIncome(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.Income income, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object updateIncome(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.entity.Income income, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
}