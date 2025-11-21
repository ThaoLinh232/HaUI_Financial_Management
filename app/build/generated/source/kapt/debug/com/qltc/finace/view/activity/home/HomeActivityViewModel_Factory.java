package com.qltc.finace.view.activity.home;

import android.content.Context;
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
public final class HomeActivityViewModel_Factory implements Factory<HomeActivityViewModel> {
  private final Provider<Context> applicationContextProvider;

  public HomeActivityViewModel_Factory(Provider<Context> applicationContextProvider) {
    this.applicationContextProvider = applicationContextProvider;
  }

  @Override
  public HomeActivityViewModel get() {
    return newInstance(applicationContextProvider.get());
  }

  public static HomeActivityViewModel_Factory create(Provider<Context> applicationContextProvider) {
    return new HomeActivityViewModel_Factory(applicationContextProvider);
  }

  public static HomeActivityViewModel newInstance(Context applicationContext) {
    return new HomeActivityViewModel(applicationContext);
  }
}
