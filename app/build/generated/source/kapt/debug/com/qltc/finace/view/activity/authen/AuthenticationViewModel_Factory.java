package com.qltc.finace.view.activity.authen;

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
public final class AuthenticationViewModel_Factory implements Factory<AuthenticationViewModel> {
  private final Provider<Context> applicationContextProvider;

  public AuthenticationViewModel_Factory(Provider<Context> applicationContextProvider) {
    this.applicationContextProvider = applicationContextProvider;
  }

  @Override
  public AuthenticationViewModel get() {
    return newInstance(applicationContextProvider.get());
  }

  public static AuthenticationViewModel_Factory create(
      Provider<Context> applicationContextProvider) {
    return new AuthenticationViewModel_Factory(applicationContextProvider);
  }

  public static AuthenticationViewModel newInstance(Context applicationContext) {
    return new AuthenticationViewModel(applicationContext);
  }
}
