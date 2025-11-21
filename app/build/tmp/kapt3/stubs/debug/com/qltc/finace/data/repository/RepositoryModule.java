package com.qltc.finace.data.repository;

import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.data.repository.local.category.CategoryRepositoryImp;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.expense.ExpenseRepositoryImp;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import com.qltc.finace.data.repository.local.income.InComeRepositoryImp;
import dagger.Binds;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\'\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\'J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\'J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\'\u00a8\u0006\u000f"}, d2 = {"Lcom/qltc/finace/data/repository/RepositoryModule;", "", "()V", "provideCategoryRepository", "Lcom/qltc/finace/data/repository/local/category/CategoryRepository;", "categoryRepositoryImp", "Lcom/qltc/finace/data/repository/local/category/CategoryRepositoryImp;", "provideExpenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepository;", "expenseRepository", "Lcom/qltc/finace/data/repository/local/expense/ExpenseRepositoryImp;", "provideIncomeRepository", "Lcom/qltc/finace/data/repository/local/income/InComeRepository;", "incomeRepositoryImp", "Lcom/qltc/finace/data/repository/local/income/InComeRepositoryImp;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public abstract class RepositoryModule {
    
    public RepositoryModule() {
        super();
    }
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.qltc.finace.data.repository.local.expense.ExpenseRepository provideExpenseRepository(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.expense.ExpenseRepositoryImp expenseRepository);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.qltc.finace.data.repository.local.category.CategoryRepository provideCategoryRepository(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.category.CategoryRepositoryImp categoryRepositoryImp);
    
    @dagger.Binds()
    @org.jetbrains.annotations.NotNull()
    public abstract com.qltc.finace.data.repository.local.income.InComeRepository provideIncomeRepository(@org.jetbrains.annotations.NotNull()
    com.qltc.finace.data.repository.local.income.InComeRepositoryImp incomeRepositoryImp);
}