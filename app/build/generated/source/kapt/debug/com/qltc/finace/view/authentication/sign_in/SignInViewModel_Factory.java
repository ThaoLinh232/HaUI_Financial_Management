package com.qltc.finace.view.authentication.sign_in;

import android.content.Context;
import com.qltc.finace.data.repository.local.category.CategoryRepository;
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
public final class SignInViewModel_Factory implements Factory<SignInViewModel> {
  private final Provider<Context> applicationContextProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public SignInViewModel_Factory(Provider<Context> applicationContextProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    this.applicationContextProvider = applicationContextProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public SignInViewModel get() {
    return newInstance(applicationContextProvider.get(), categoryRepositoryProvider.get());
  }

  public static SignInViewModel_Factory create(Provider<Context> applicationContextProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new SignInViewModel_Factory(applicationContextProvider, categoryRepositoryProvider);
  }

  public static SignInViewModel newInstance(Context applicationContext,
      CategoryRepository categoryRepository) {
    return new SignInViewModel(applicationContext, categoryRepository);
  }
}
