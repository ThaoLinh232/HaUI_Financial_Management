package com.qltc.finace.data.repository.local.category;

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
public final class CategoryRepositoryImp_Factory implements Factory<CategoryRepositoryImp> {
  @Override
  public CategoryRepositoryImp get() {
    return newInstance();
  }

  public static CategoryRepositoryImp_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static CategoryRepositoryImp newInstance() {
    return new CategoryRepositoryImp();
  }

  private static final class InstanceHolder {
    private static final CategoryRepositoryImp_Factory INSTANCE = new CategoryRepositoryImp_Factory();
  }
}
