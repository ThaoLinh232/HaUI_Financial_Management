package com.qltc.finace.base;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.qltc.finace.data.repository.FirebaseModule;
import com.qltc.finace.data.repository.local.category.CategoryRepositoryImp;
import com.qltc.finace.data.repository.local.expense.ExpenseRepositoryImp;
import com.qltc.finace.data.repository.local.income.InComeRepositoryImp;
import com.qltc.finace.view.activity.authen.AuthenticationActivity;
import com.qltc.finace.view.activity.authen.AuthenticationViewModel;
import com.qltc.finace.view.activity.authen.AuthenticationViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.activity.home.HomeActivity;
import com.qltc.finace.view.activity.home.HomeActivityViewModel;
import com.qltc.finace.view.activity.home.HomeActivityViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.activity.splash.SplashActivity;
import com.qltc.finace.view.activity.splash.SplashViewModel;
import com.qltc.finace.view.activity.splash.SplashViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel;
import com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.authentication.forgot_password.FragmentForgotPassword;
import com.qltc.finace.view.authentication.login_phone.LoginPhoneFragment;
import com.qltc.finace.view.authentication.otp.OtpFragment;
import com.qltc.finace.view.authentication.otp.OtpFragment_MembersInjector;
import com.qltc.finace.view.authentication.sign_in.SignInFragment;
import com.qltc.finace.view.authentication.sign_in.SignInViewModel;
import com.qltc.finace.view.authentication.sign_in.SignInViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.authentication.sign_up.SignUpFragment;
import com.qltc.finace.view.authentication.sign_up.SignUpViewModel;
import com.qltc.finace.view.authentication.sign_up.SignUpViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel;
import com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.edit_expense_income.FragmentEditExpenseIncome;
import com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseFragment;
import com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseViewModel;
import com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.calendar.CalendarFragment;
import com.qltc.finace.view.main.calendar.CalendarViewModel;
import com.qltc.finace.view.main.calendar.CalendarViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.enter.FragmentEnter;
import com.qltc.finace.view.main.enter.ShareEnterViewModel;
import com.qltc.finace.view.main.enter.ShareEnterViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel;
import com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.enter.add_category.FragmentAddCategory;
import com.qltc.finace.view.main.enter.category.CategoryDetailViewModel;
import com.qltc.finace.view.main.enter.category.CategoryDetailViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.enter.category.FragmentCategoryDetail;
import com.qltc.finace.view.main.enter.expense.FragmentExpense;
import com.qltc.finace.view.main.enter.income.IncomeFragment;
import com.qltc.finace.view.main.export.ExportPdfViewModel;
import com.qltc.finace.view.main.export.ExportPdfViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.export.FragmentExportPdfConfig;
import com.qltc.finace.view.main.helper.HelperViewModel;
import com.qltc.finace.view.main.helper.HelperViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.home.FragmentHome;
import com.qltc.finace.view.main.home.HomeViewModel;
import com.qltc.finace.view.main.home.HomeViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.list_data_form_category.FragmentListData;
import com.qltc.finace.view.main.profile.ChangePasswordViewModel;
import com.qltc.finace.view.main.profile.ChangePasswordViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.profile.FragmentChangePassword;
import com.qltc.finace.view.main.report.FragmentReport;
import com.qltc.finace.view.main.report.ReportViewModel;
import com.qltc.finace.view.main.report.ReportViewModel_HiltModules_KeyModule_ProvideFactory;
import com.qltc.finace.view.main.report.income.FragmentReportInCome;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class DaggerApp_HiltComponents_SingletonC {
  private DaggerApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder firebaseModule(FirebaseModule firebaseModule) {
      Preconditions.checkNotNull(firebaseModule);
      return this;
    }

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This method is a no-op. For more, see https://dagger.dev/unused-modules.
     */
    @Deprecated
    public Builder hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule(
        HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule) {
      Preconditions.checkNotNull(hiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule);
      return this;
    }

    public App_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements App_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public App_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements App_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public App_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements App_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public App_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements App_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements App_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public App_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements App_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public App_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements App_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public App_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends App_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends App_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public void injectFragmentForgotPassword(FragmentForgotPassword fragmentForgotPassword) {
    }

    @Override
    public void injectLoginPhoneFragment(LoginPhoneFragment loginPhoneFragment) {
    }

    @Override
    public void injectOtpFragment(OtpFragment otpFragment) {
      injectOtpFragment2(otpFragment);
    }

    @Override
    public void injectSignInFragment(SignInFragment signInFragment) {
    }

    @Override
    public void injectSignUpFragment(SignUpFragment signUpFragment) {
    }

    @Override
    public void injectFragmentEditExpenseIncome(
        FragmentEditExpenseIncome fragmentEditExpenseIncome) {
    }

    @Override
    public void injectAllIncomeExpenseFragment(AllIncomeExpenseFragment allIncomeExpenseFragment) {
    }

    @Override
    public void injectCalendarFragment(CalendarFragment calendarFragment) {
    }

    @Override
    public void injectFragmentEnter(FragmentEnter fragmentEnter) {
    }

    @Override
    public void injectFragmentAddCategory(FragmentAddCategory fragmentAddCategory) {
    }

    @Override
    public void injectFragmentCategoryDetail(FragmentCategoryDetail fragmentCategoryDetail) {
    }

    @Override
    public void injectFragmentExpense(FragmentExpense fragmentExpense) {
    }

    @Override
    public void injectIncomeFragment(IncomeFragment incomeFragment) {
    }

    @Override
    public void injectFragmentExportPdfConfig(FragmentExportPdfConfig fragmentExportPdfConfig) {
    }

    @Override
    public void injectFragmentHome(FragmentHome fragmentHome) {
    }

    @Override
    public void injectFragmentListData(FragmentListData fragmentListData) {
    }

    @Override
    public void injectFragmentChangePassword(FragmentChangePassword fragmentChangePassword) {
    }

    @Override
    public void injectFragmentReport(FragmentReport fragmentReport) {
    }

    @Override
    public void injectFragmentReportInCome(FragmentReportInCome fragmentReportInCome) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }

    @CanIgnoreReturnValue
    private OtpFragment injectOtpFragment2(OtpFragment instance) {
      OtpFragment_MembersInjector.injectCategoryRepository(instance, new CategoryRepositoryImp());
      return instance;
    }
  }

  private static final class ViewCImpl extends App_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends App_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectAuthenticationActivity(AuthenticationActivity authenticationActivity) {
    }

    @Override
    public void injectHomeActivity(HomeActivity homeActivity) {
    }

    @Override
    public void injectSplashActivity(SplashActivity splashActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Set<String> getViewModelKeys() {
      return ImmutableSet.<String>of(AddCategoryViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AllIncomeExpenseViewModel_HiltModules_KeyModule_ProvideFactory.provide(), AuthenticationViewModel_HiltModules_KeyModule_ProvideFactory.provide(), CalendarViewModel_HiltModules_KeyModule_ProvideFactory.provide(), CategoryDetailViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ChangePasswordViewModel_HiltModules_KeyModule_ProvideFactory.provide(), EditExpenseIncomeViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ExportPdfViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ForgotPasswordViewModel_HiltModules_KeyModule_ProvideFactory.provide(), HelperViewModel_HiltModules_KeyModule_ProvideFactory.provide(), HomeActivityViewModel_HiltModules_KeyModule_ProvideFactory.provide(), HomeViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ReportViewModel_HiltModules_KeyModule_ProvideFactory.provide(), ShareEnterViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SignInViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SignUpViewModel_HiltModules_KeyModule_ProvideFactory.provide(), SplashViewModel_HiltModules_KeyModule_ProvideFactory.provide());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }
  }

  private static final class ViewModelCImpl extends App_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AddCategoryViewModel> addCategoryViewModelProvider;

    private Provider<AllIncomeExpenseViewModel> allIncomeExpenseViewModelProvider;

    private Provider<AuthenticationViewModel> authenticationViewModelProvider;

    private Provider<CalendarViewModel> calendarViewModelProvider;

    private Provider<CategoryDetailViewModel> categoryDetailViewModelProvider;

    private Provider<ChangePasswordViewModel> changePasswordViewModelProvider;

    private Provider<EditExpenseIncomeViewModel> editExpenseIncomeViewModelProvider;

    private Provider<ExportPdfViewModel> exportPdfViewModelProvider;

    private Provider<ForgotPasswordViewModel> forgotPasswordViewModelProvider;

    private Provider<HelperViewModel> helperViewModelProvider;

    private Provider<HomeActivityViewModel> homeActivityViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<ReportViewModel> reportViewModelProvider;

    private Provider<ShareEnterViewModel> shareEnterViewModelProvider;

    private Provider<SignInViewModel> signInViewModelProvider;

    private Provider<SignUpViewModel> signUpViewModelProvider;

    private Provider<SplashViewModel> splashViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addCategoryViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.allIncomeExpenseViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.authenticationViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.calendarViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.categoryDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.changePasswordViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.editExpenseIncomeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.exportPdfViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.forgotPasswordViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.helperViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
      this.homeActivityViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 10);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 11);
      this.reportViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 12);
      this.shareEnterViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 13);
      this.signInViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 14);
      this.signUpViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 15);
      this.splashViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 16);
    }

    @Override
    public Map<String, Provider<ViewModel>> getHiltViewModelMap() {
      return ImmutableMap.<String, Provider<ViewModel>>builderWithExpectedSize(17).put("com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel", ((Provider) addCategoryViewModelProvider)).put("com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseViewModel", ((Provider) allIncomeExpenseViewModelProvider)).put("com.qltc.finace.view.activity.authen.AuthenticationViewModel", ((Provider) authenticationViewModelProvider)).put("com.qltc.finace.view.main.calendar.CalendarViewModel", ((Provider) calendarViewModelProvider)).put("com.qltc.finace.view.main.enter.category.CategoryDetailViewModel", ((Provider) categoryDetailViewModelProvider)).put("com.qltc.finace.view.main.profile.ChangePasswordViewModel", ((Provider) changePasswordViewModelProvider)).put("com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel", ((Provider) editExpenseIncomeViewModelProvider)).put("com.qltc.finace.view.main.export.ExportPdfViewModel", ((Provider) exportPdfViewModelProvider)).put("com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel", ((Provider) forgotPasswordViewModelProvider)).put("com.qltc.finace.view.main.helper.HelperViewModel", ((Provider) helperViewModelProvider)).put("com.qltc.finace.view.activity.home.HomeActivityViewModel", ((Provider) homeActivityViewModelProvider)).put("com.qltc.finace.view.main.home.HomeViewModel", ((Provider) homeViewModelProvider)).put("com.qltc.finace.view.main.report.ReportViewModel", ((Provider) reportViewModelProvider)).put("com.qltc.finace.view.main.enter.ShareEnterViewModel", ((Provider) shareEnterViewModelProvider)).put("com.qltc.finace.view.authentication.sign_in.SignInViewModel", ((Provider) signInViewModelProvider)).put("com.qltc.finace.view.authentication.sign_up.SignUpViewModel", ((Provider) signUpViewModelProvider)).put("com.qltc.finace.view.activity.splash.SplashViewModel", ((Provider) splashViewModelProvider)).build();
    }

    @Override
    public Map<String, Object> getHiltViewModelAssistedMap() {
      return ImmutableMap.<String, Object>of();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel 
          return (T) new AddCategoryViewModel(new CategoryRepositoryImp());

          case 1: // com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseViewModel 
          return (T) new AllIncomeExpenseViewModel(new ExpenseRepositoryImp(), new InComeRepositoryImp(), new CategoryRepositoryImp());

          case 2: // com.qltc.finace.view.activity.authen.AuthenticationViewModel 
          return (T) new AuthenticationViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.qltc.finace.view.main.calendar.CalendarViewModel 
          return (T) new CalendarViewModel(new ExpenseRepositoryImp(), new InComeRepositoryImp(), new CategoryRepositoryImp());

          case 4: // com.qltc.finace.view.main.enter.category.CategoryDetailViewModel 
          return (T) new CategoryDetailViewModel(new CategoryRepositoryImp());

          case 5: // com.qltc.finace.view.main.profile.ChangePasswordViewModel 
          return (T) new ChangePasswordViewModel();

          case 6: // com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel 
          return (T) new EditExpenseIncomeViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), new ExpenseRepositoryImp(), new InComeRepositoryImp());

          case 7: // com.qltc.finace.view.main.export.ExportPdfViewModel 
          return (T) new ExportPdfViewModel(new ExpenseRepositoryImp(), new InComeRepositoryImp(), new CategoryRepositoryImp());

          case 8: // com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel 
          return (T) new ForgotPasswordViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 9: // com.qltc.finace.view.main.helper.HelperViewModel 
          return (T) new HelperViewModel();

          case 10: // com.qltc.finace.view.activity.home.HomeActivityViewModel 
          return (T) new HomeActivityViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 11: // com.qltc.finace.view.main.home.HomeViewModel 
          return (T) new HomeViewModel(new ExpenseRepositoryImp(), new InComeRepositoryImp(), new CategoryRepositoryImp());

          case 12: // com.qltc.finace.view.main.report.ReportViewModel 
          return (T) new ReportViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), new InComeRepositoryImp(), new ExpenseRepositoryImp(), new CategoryRepositoryImp());

          case 13: // com.qltc.finace.view.main.enter.ShareEnterViewModel 
          return (T) new ShareEnterViewModel(new CategoryRepositoryImp(), new ExpenseRepositoryImp(), new InComeRepositoryImp());

          case 14: // com.qltc.finace.view.authentication.sign_in.SignInViewModel 
          return (T) new SignInViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), new CategoryRepositoryImp());

          case 15: // com.qltc.finace.view.authentication.sign_up.SignUpViewModel 
          return (T) new SignUpViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), new CategoryRepositoryImp());

          case 16: // com.qltc.finace.view.activity.splash.SplashViewModel 
          return (T) new SplashViewModel();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends App_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends App_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends App_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;

    }

    @Override
    public void injectApp(App app) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return ImmutableSet.<Boolean>of();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }
  }
}
