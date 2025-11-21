package com.qltc.finace.view.main.enter.category;

import com.qltc.finace.data.repository.local.category.CategoryRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class CategoryDetailViewModel_Factory implements Factory<CategoryDetailViewModel> {
  private final Provider<CategoryRepository> categoryRepositoryProvider;

  public CategoryDetailViewModel_Factory(Provider<CategoryRepository> categoryRepositoryProvider) {
    this.categoryRepositoryProvider = categoryRepositoryProvider;
  }

  @Override
  public CategoryDetailViewModel get() {
    return newInstance(categoryRepositoryProvider.get());
  }

  public static CategoryDetailViewModel_Factory create(
      Provider<CategoryRepository> categoryRepositoryProvider) {
    return new CategoryDetailViewModel_Factory(categoryRepositoryProvider);
  }

  public static CategoryDetailViewModel newInstance(CategoryRepository categoryRepository) {
    return new CategoryDetailViewModel(categoryRepository);
  }
}
