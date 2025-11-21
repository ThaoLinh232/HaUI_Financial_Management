package com.qltc.finace.view.edit_expense_income;

import android.content.Context;
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
public final class EditExpenseIncomeViewModel_Factory implements Factory<EditExpenseIncomeViewModel> {
  private final Provider<Context> contextProvider;

  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  private final Provider<InComeRepository> incomeRepositoryProvider;

  public EditExpenseIncomeViewModel_Factory(Provider<Context> contextProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.expenseRepositoryProvider = expenseRepositoryProvider;
    this.incomeRepositoryProvider = incomeRepositoryProvider;
  }

  @Override
  public EditExpenseIncomeViewModel get() {
    return newInstance(contextProvider.get(), expenseRepositoryProvider.get(), incomeRepositoryProvider.get());
  }

  public static EditExpenseIncomeViewModel_Factory create(Provider<Context> contextProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<InComeRepository> incomeRepositoryProvider) {
    return new EditExpenseIncomeViewModel_Factory(contextProvider, expenseRepositoryProvider, incomeRepositoryProvider);
  }

  public static EditExpenseIncomeViewModel newInstance(Context context,
      ExpenseRepository expenseRepository, InComeRepository incomeRepository) {
    return new EditExpenseIncomeViewModel(context, expenseRepository, incomeRepository);
  }
}
