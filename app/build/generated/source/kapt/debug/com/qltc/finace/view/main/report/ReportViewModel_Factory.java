package com.qltc.finace.view.main.report;

import android.content.Context;
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
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class ReportViewModel_Factory implements Factory<ReportViewModel> {
  private final Provider<Context> applicationContextProvider;

  private final Provider<InComeRepository> inComeRepositoryProvider;

  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public ReportViewModel_Factory(Provider<Context> applicationContextProvider,
      Provider<InComeRepository> inComeRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    this.applicationContextProvider = applicationContextProvider;
    this.inComeRepositoryProvider = inComeRepositoryProvider;
    this.expenseRepositoryProvider = expenseRepositoryProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public ReportViewModel get() {
    return newInstance(applicationContextProvider.get(), inComeRepositoryProvider.get(), expenseRepositoryProvider.get(), categoryRepositoryProvider.get());
  }

  public static ReportViewModel_Factory create(Provider<Context> applicationContextProvider,
      Provider<InComeRepository> inComeRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new ReportViewModel_Factory(applicationContextProvider, inComeRepositoryProvider, expenseRepositoryProvider, categoryRepositoryProvider);
  }

  public static ReportViewModel newInstance(Context applicationContext,
      InComeRepository inComeRepository, ExpenseRepository expenseRepository,
      CategoryRepository categoryRepository) {
    return new ReportViewModel(applicationContext, inComeRepository, expenseRepository, categoryRepository);
  }
}
