package com.qltc.finace.view.authentication.otp;

import com.qltc.finace.data.repository.local.category.CategoryRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class OtpFragment_MembersInjector implements MembersInjector<OtpFragment> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public OtpFragment_MembersInjector(Provider<CategoryRepository> categoryRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  public static MembersInjector<OtpFragment> create(
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new OtpFragment_MembersInjector(categoryRepositoryProvider);
  }

  @Override
  public void injectMembers(OtpFragment instance) {
    injectCategoryRepository(instance, categoryRepositoryProvider.get());
  }

  @InjectedFieldSignature("com.qltc.finace.view.authentication.otp.OtpFragment.categoryRepository")
  public static void injectCategoryRepository(OtpFragment instance,
      CategoryRepository categoryRepository) {
    instance.categoryRepository = categoryRepository;
  }
}
