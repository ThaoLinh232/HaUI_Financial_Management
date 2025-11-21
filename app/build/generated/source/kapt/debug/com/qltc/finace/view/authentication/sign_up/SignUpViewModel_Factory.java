package com.qltc.finace.view.authentication.sign_up;

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
public final class SignUpViewModel_Factory implements Factory<SignUpViewModel> {
  private final Provider<Context> applicationContextProvider;

  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public SignUpViewModel_Factory(Provider<Context> applicationContextProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    this.applicationContextProvider = applicationContextProvider;
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public SignUpViewModel get() {
    return newInstance(applicationContextProvider.get(), categoryRepositoryProvider.get());
  }

  public static SignUpViewModel_Factory create(Provider<Context> applicationContextProvider,
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new SignUpViewModel_Factory(applicationContextProvider, categoryRepositoryProvider);
  }

  public static SignUpViewModel newInstance(Context applicationContext,
      CategoryRepository categoryRepository) {
    return new SignUpViewModel(applicationContext, categoryRepository);
  }
}
