package com.qltc.finace.view.main.helper;

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
public final class HelperViewModel_Factory implements Factory<HelperViewModel> {
  @Override
  public HelperViewModel get() {
    return newInstance();
  }

  public static HelperViewModel_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static HelperViewModel newInstance() {
    return new HelperViewModel();
  }

  private static final class InstanceHolder {
    private static final HelperViewModel_Factory INSTANCE = new HelperViewModel_Factory();
  }
}
