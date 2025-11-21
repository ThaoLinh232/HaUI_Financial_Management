package com.qltc.finace.view.main.calendar;

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
public final class CalendarViewModel_Factory implements Factory<CalendarViewModel> {
  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  private final Provider<InComeRepository> incomeRepositoryProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public CalendarViewModel_Factory(Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    this.expenseRepositoryProvider = expenseRepositoryProvider;
    this.incomeRepositoryProvider = incomeRepositoryProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public CalendarViewModel get() {
    return newInstance(expenseRepositoryProvider.get(), incomeRepositoryProvider.get(), categoryRepositoryProvider.get());
  }

  public static CalendarViewModel_Factory create(
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new CalendarViewModel_Factory(expenseRepositoryProvider, incomeRepositoryProvider, categoryRepositoryProvider);
  }

  public static CalendarViewModel newInstance(ExpenseRepository expenseRepository,
      InComeRepository incomeRepository, CategoryRepository categoryRepository) {
    return new CalendarViewModel(expenseRepository, incomeRepository, categoryRepository);
  }
}
