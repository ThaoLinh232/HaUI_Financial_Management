package com.qltc.finace.view.main.enter;

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
public final class ShareEnterViewModel_Factory implements Factory<ShareEnterViewModel> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  private final Provider<InComeRepository> incomeRepositoryProvider;

  public ShareEnterViewModel_Factory(Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
    this.expenseRepositoryProvider = expenseRepositoryProvider;
    this.incomeRepositoryProvider = incomeRepositoryProvider;
  }

  @Override
  public ShareEnterViewModel get() {
    return newInstance(categoryRepositoryProvider.get(), expenseRepositoryProvider.get(), incomeRepositoryProvider.get());
  }

  public static ShareEnterViewModel_Factory create(
      Provider<CategoryRepository> categoryRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider) {
    return new ShareEnterViewModel_Factory(categoryRepositoryProvider, expenseRepositoryProvider, incomeRepositoryProvider);
  }

  public static ShareEnterViewModel newInstance(CategoryRepository categoryRepository,
      ExpenseRepository expenseRepository, InComeRepository incomeRepository) {
    return new ShareEnterViewModel(categoryRepository, expenseRepository, incomeRepository);
  }
}
