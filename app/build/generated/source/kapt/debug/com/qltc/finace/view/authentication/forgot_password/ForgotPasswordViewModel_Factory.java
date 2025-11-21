package com.qltc.finace.view.authentication.forgot_password;

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
public final class ForgotPasswordViewModel_Factory implements Factory<ForgotPasswordViewModel> {
  private final Provider<Context> applicationContextProvider;

  public ForgotPasswordViewModel_Factory(Provider<Context> applicationContextProvider) {
    this.applicationContextProvider = applicationContextProvider;
  }

  @Override
  public ForgotPasswordViewModel get() {
    return newInstance(applicationContextProvider.get());
  }

  public static ForgotPasswordViewModel_Factory create(
      Provider<Context> applicationContextProvider) {
    return new ForgotPasswordViewModel_Factory(applicationContextProvider);
  }

  public static ForgotPasswordViewModel newInstance(Context applicationContext) {
    return new ForgotPasswordViewModel(applicationContext);
  }
}
