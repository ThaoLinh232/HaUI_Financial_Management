package com.qltc.finace.data.repository.local.income;

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
public final class InComeRepositoryImp_Factory implements Factory<InComeRepositoryImp> {
  @Override
  public InComeRepositoryImp get() {
    return newInstance();
  }

  public static InComeRepositoryImp_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static InComeRepositoryImp newInstance() {
    return new InComeRepositoryImp();
  }

  private static final class InstanceHolder {
    private static final InComeRepositoryImp_Factory INSTANCE = new InComeRepositoryImp_Factory();
  }
}
