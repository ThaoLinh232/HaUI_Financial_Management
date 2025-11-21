package com.qltc.finace.view.main.home;

import com.qltc.finace.data.repository.local.category.CategoryRepository;
import com.qltc.finace.data.repository.local.expense.ExpenseRepository;
import com.qltc.finace.data.repository.local.income.InComeRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava"
})
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  private final Provider<InComeRepository> incomeRepositoryProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public HomeViewModel_Factory(Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    this.expenseRepositoryProvider = expenseRepositoryProvider;
    this.incomeRepositoryProvider = incomeRepositoryProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(expenseRepositoryProvider.get(), incomeRepositoryProvider.get(), categoryRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new HomeViewModel_Factory(expenseRepositoryProvider, incomeRepositoryProvider, categoryRepositoryProvider);
  }

  public static HomeViewModel newInstance(ExpenseRepository expenseRepository,
      InComeRepository incomeRepository, CategoryRepository categoryRepository) {
    return new HomeViewModel(expenseRepository, incomeRepository, categoryRepository);
  }
}
