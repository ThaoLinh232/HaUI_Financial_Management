package com.qltc.finace.data.repository.local.expense;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class ExpenseRepositoryImp_Factory implements Factory<ExpenseRepositoryImp> {
  @Override
  public ExpenseRepositoryImp get() {
    return newInstance();
  }

  public static ExpenseRepositoryImp_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ExpenseRepositoryImp newInstance() {
    return new ExpenseRepositoryImp();
  }

  private static final class InstanceHolder {
    private static final ExpenseRepositoryImp_Factory INSTANCE = new ExpenseRepositoryImp_Factory();
  }
}
