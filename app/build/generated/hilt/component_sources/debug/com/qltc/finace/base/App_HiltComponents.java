package com.qltc.finace.base;

import com.qltc.finace.data.repository.FirebaseModule;
import com.qltc.finace.data.repository.RepositoryModule;
import com.qltc.finace.view.activity.authen.AuthenticationActivity_GeneratedInjector;
import com.qltc.finace.view.activity.authen.AuthenticationViewModel_HiltModules;
import com.qltc.finace.view.activity.home.HomeActivityViewModel_HiltModules;
import com.qltc.finace.view.activity.home.HomeActivity_GeneratedInjector;
import com.qltc.finace.view.activity.splash.SplashActivity_GeneratedInjector;
import com.qltc.finace.view.activity.splash.SplashViewModel_HiltModules;
import com.qltc.finace.view.authentication.forgot_password.ForgotPasswordViewModel_HiltModules;
import com.qltc.finace.view.authentication.forgot_password.FragmentForgotPassword_GeneratedInjector;
import com.qltc.finace.view.authentication.login_phone.LoginPhoneFragment_GeneratedInjector;
import com.qltc.finace.view.authentication.otp.OtpFragment_GeneratedInjector;
import com.qltc.finace.view.authentication.sign_in.SignInFragment_GeneratedInjector;
import com.qltc.finace.view.authentication.sign_in.SignInViewModel_HiltModules;
import com.qltc.finace.view.authentication.sign_up.SignUpFragment_GeneratedInjector;
import com.qltc.finace.view.authentication.sign_up.SignUpViewModel_HiltModules;
import com.qltc.finace.view.edit_expense_income.EditExpenseIncomeViewModel_HiltModules;
import com.qltc.finace.view.edit_expense_income.FragmentEditExpenseIncome_GeneratedInjector;
import com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseFragment_GeneratedInjector;
import com.qltc.finace.view.main.all_expense_income.AllIncomeExpenseViewModel_HiltModules;
import com.qltc.finace.view.main.calendar.CalendarFragment_GeneratedInjector;
import com.qltc.finace.view.main.calendar.CalendarViewModel_HiltModules;
import com.qltc.finace.view.main.enter.FragmentEnter_GeneratedInjector;
import com.qltc.finace.view.main.enter.ShareEnterViewModel_HiltModules;
import com.qltc.finace.view.main.enter.add_category.AddCategoryViewModel_HiltModules;
import com.qltc.finace.view.main.enter.add_category.FragmentAddCategory_GeneratedInjector;
import com.qltc.finace.view.main.enter.category.CategoryDetailViewModel_HiltModules;
import com.qltc.finace.view.main.enter.category.FragmentCategoryDetail_GeneratedInjector;
import com.qltc.finace.view.main.enter.expense.FragmentExpense_GeneratedInjector;
import com.qltc.finace.view.main.enter.income.IncomeFragment_GeneratedInjector;
import com.qltc.finace.view.main.export.ExportPdfViewModel_HiltModules;
import com.qltc.finace.view.main.export.FragmentExportPdfConfig_GeneratedInjector;
import com.qltc.finace.view.main.helper.HelperViewModel_HiltModules;
import com.qltc.finace.view.main.home.FragmentHome_GeneratedInjector;
import com.qltc.finace.view.main.home.HomeViewModel_HiltModules;
import com.qltc.finace.view.main.list_data_form_category.FragmentListData_GeneratedInjector;
import com.qltc.finace.view.main.profile.ChangePasswordViewModel_HiltModules;
import com.qltc.finace.view.main.profile.FragmentChangePassword_GeneratedInjector;
import com.qltc.finace.view.main.report.FragmentReport_GeneratedInjector;
import com.qltc.finace.view.main.report.ReportViewModel_HiltModules;
import com.qltc.finace.view.main.report.income.FragmentReportInCome_GeneratedInjector;
import dagger.Binds;
import dagger.Component;
import dagger.Module;
import dagger.Subcomponent;
import dagger.hilt.android.components.ActivityComponent;
import dagger.hilt.android.components.ActivityRetainedComponent;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.android.components.ServiceComponent;
import dagger.hilt.android.components.ViewComponent;
import dagger.hilt.android.components.ViewModelComponent;
import dagger.hilt.android.components.ViewWithFragmentComponent;
import dagger.hilt.android.flags.FragmentGetContextFix;
import dagger.hilt.android.flags.HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_DefaultViewModelFactories_ActivityModule;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint;
import dagger.hilt.android.internal.lifecycle.HiltWrapper_HiltViewModelFactory_ViewModelModule;
import dagger.hilt.android.internal.managers.ActivityComponentManager;
import dagger.hilt.android.internal.managers.FragmentComponentManager;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint;
import dagger.hilt.android.internal.managers.HiltWrapper_ActivityRetainedComponentManager_LifecycleModule;
import dagger.hilt.android.internal.managers.HiltWrapper_SavedStateHandleModule;
import dagger.hilt.android.internal.managers.ServiceComponentManager;
import dagger.hilt.android.internal.managers.ViewComponentManager;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.HiltWrapper_ActivityModule;
import dagger.hilt.android.scopes.ActivityRetainedScoped;
import dagger.hilt.android.scopes.ActivityScoped;
import dagger.hilt.android.scopes.FragmentScoped;
import dagger.hilt.android.scopes.ServiceScoped;
import dagger.hilt.android.scopes.ViewModelScoped;
import dagger.hilt.android.scopes.ViewScoped;
import dagger.hilt.components.SingletonComponent;
import dagger.hilt.internal.GeneratedComponent;
import dagger.hilt.migration.DisableInstallInCheck;
import javax.annotation.processing.Generated;
import javax.inject.Singleton;

@Generated("dagger.hilt.processor.internal.root.RootProcessor")
public final class App_HiltComponents {
  private App_HiltComponents() {
  }

  @Module(
      subcomponents = ServiceC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ServiceCBuilderModule {
    @Binds
    ServiceComponentBuilder bind(ServiceC.Builder builder);
  }

  @Module(
      subcomponents = ActivityRetainedC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ActivityRetainedCBuilderModule {
    @Binds
    ActivityRetainedComponentBuilder bind(ActivityRetainedC.Builder builder);
  }

  @Module(
      subcomponents = ActivityC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ActivityCBuilderModule {
    @Binds
    ActivityComponentBuilder bind(ActivityC.Builder builder);
  }

  @Module(
      subcomponents = ViewModelC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewModelCBuilderModule {
    @Binds
    ViewModelComponentBuilder bind(ViewModelC.Builder builder);
  }

  @Module(
      subcomponents = ViewC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewCBuilderModule {
    @Binds
    ViewComponentBuilder bind(ViewC.Builder builder);
  }

  @Module(
      subcomponents = FragmentC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface FragmentCBuilderModule {
    @Binds
    FragmentComponentBuilder bind(FragmentC.Builder builder);
  }

  @Module(
      subcomponents = ViewWithFragmentC.class
  )
  @DisableInstallInCheck
  @Generated("dagger.hilt.processor.internal.root.RootProcessor")
  abstract interface ViewWithFragmentCBuilderModule {
    @Binds
    ViewWithFragmentComponentBuilder bind(ViewWithFragmentC.Builder builder);
  }

  @Component(
      modules = {
          ActivityRetainedCBuilderModule.class,
          ServiceCBuilderModule.class,
          ApplicationContextModule.class,
          FirebaseModule.class,
          HiltWrapper_FragmentGetContextFix_FragmentGetContextFixModule.class,
          RepositoryModule.class
      }
  )
  @Singleton
  public abstract static class SingletonC implements App_GeneratedInjector,
      FragmentGetContextFix.FragmentGetContextFixEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedComponentBuilderEntryPoint,
      ServiceComponentManager.ServiceComponentBuilderEntryPoint,
      SingletonComponent,
      GeneratedComponent {
  }

  @Subcomponent
  @ServiceScoped
  public abstract static class ServiceC implements ServiceComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ServiceComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AddCategoryViewModel_HiltModules.KeyModule.class,
          AllIncomeExpenseViewModel_HiltModules.KeyModule.class,
          ActivityCBuilderModule.class,
          ViewModelCBuilderModule.class,
          AuthenticationViewModel_HiltModules.KeyModule.class,
          CalendarViewModel_HiltModules.KeyModule.class,
          CategoryDetailViewModel_HiltModules.KeyModule.class,
          ChangePasswordViewModel_HiltModules.KeyModule.class,
          EditExpenseIncomeViewModel_HiltModules.KeyModule.class,
          ExportPdfViewModel_HiltModules.KeyModule.class,
          ForgotPasswordViewModel_HiltModules.KeyModule.class,
          HelperViewModel_HiltModules.KeyModule.class,
          HiltWrapper_ActivityRetainedComponentManager_LifecycleModule.class,
          HiltWrapper_SavedStateHandleModule.class,
          HomeActivityViewModel_HiltModules.KeyModule.class,
          HomeViewModel_HiltModules.KeyModule.class,
          ReportViewModel_HiltModules.KeyModule.class,
          ShareEnterViewModel_HiltModules.KeyModule.class,
          SignInViewModel_HiltModules.KeyModule.class,
          SignUpViewModel_HiltModules.KeyModule.class,
          SplashViewModel_HiltModules.KeyModule.class
      }
  )
  @ActivityRetainedScoped
  public abstract static class ActivityRetainedC implements ActivityRetainedComponent,
      ActivityComponentManager.ActivityComponentBuilderEntryPoint,
      HiltWrapper_ActivityRetainedComponentManager_ActivityRetainedLifecycleEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityRetainedComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          FragmentCBuilderModule.class,
          ViewCBuilderModule.class,
          HiltWrapper_ActivityModule.class,
          HiltWrapper_DefaultViewModelFactories_ActivityModule.class
      }
  )
  @ActivityScoped
  public abstract static class ActivityC implements AuthenticationActivity_GeneratedInjector,
      HomeActivity_GeneratedInjector,
      SplashActivity_GeneratedInjector,
      ActivityComponent,
      DefaultViewModelFactories.ActivityEntryPoint,
      HiltWrapper_HiltViewModelFactory_ActivityCreatorEntryPoint,
      FragmentComponentManager.FragmentComponentBuilderEntryPoint,
      ViewComponentManager.ViewComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ActivityComponentBuilder {
    }
  }

  @Subcomponent(
      modules = {
          AddCategoryViewModel_HiltModules.BindsModule.class,
          AllIncomeExpenseViewModel_HiltModules.BindsModule.class,
          AuthenticationViewModel_HiltModules.BindsModule.class,
          CalendarViewModel_HiltModules.BindsModule.class,
          CategoryDetailViewModel_HiltModules.BindsModule.class,
          ChangePasswordViewModel_HiltModules.BindsModule.class,
          EditExpenseIncomeViewModel_HiltModules.BindsModule.class,
          ExportPdfViewModel_HiltModules.BindsModule.class,
          ForgotPasswordViewModel_HiltModules.BindsModule.class,
          HelperViewModel_HiltModules.BindsModule.class,
          HiltWrapper_HiltViewModelFactory_ViewModelModule.class,
          HomeActivityViewModel_HiltModules.BindsModule.class,
          HomeViewModel_HiltModules.BindsModule.class,
          ReportViewModel_HiltModules.BindsModule.class,
          ShareEnterViewModel_HiltModules.BindsModule.class,
          SignInViewModel_HiltModules.BindsModule.class,
          SignUpViewModel_HiltModules.BindsModule.class,
          SplashViewModel_HiltModules.BindsModule.class
      }
  )
  @ViewModelScoped
  public abstract static class ViewModelC implements ViewModelComponent,
      HiltViewModelFactory.ViewModelFactoriesEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewModelComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewC implements ViewComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewComponentBuilder {
    }
  }

  @Subcomponent(
      modules = ViewWithFragmentCBuilderModule.class
  )
  @FragmentScoped
  public abstract static class FragmentC implements FragmentForgotPassword_GeneratedInjector,
      LoginPhoneFragment_GeneratedInjector,
      OtpFragment_GeneratedInjector,
      SignInFragment_GeneratedInjector,
      SignUpFragment_GeneratedInjector,
      FragmentEditExpenseIncome_GeneratedInjector,
      AllIncomeExpenseFragment_GeneratedInjector,
      CalendarFragment_GeneratedInjector,
      FragmentEnter_GeneratedInjector,
      FragmentAddCategory_GeneratedInjector,
      FragmentCategoryDetail_GeneratedInjector,
      FragmentExpense_GeneratedInjector,
      IncomeFragment_GeneratedInjector,
      FragmentExportPdfConfig_GeneratedInjector,
      FragmentHome_GeneratedInjector,
      FragmentListData_GeneratedInjector,
      FragmentChangePassword_GeneratedInjector,
      FragmentReport_GeneratedInjector,
      FragmentReportInCome_GeneratedInjector,
      FragmentComponent,
      DefaultViewModelFactories.FragmentEntryPoint,
      ViewComponentManager.ViewWithFragmentComponentBuilderEntryPoint,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends FragmentComponentBuilder {
    }
  }

  @Subcomponent
  @ViewScoped
  public abstract static class ViewWithFragmentC implements ViewWithFragmentComponent,
      GeneratedComponent {
    @Subcomponent.Builder
    abstract interface Builder extends ViewWithFragmentComponentBuilder {
    }
  }
}
