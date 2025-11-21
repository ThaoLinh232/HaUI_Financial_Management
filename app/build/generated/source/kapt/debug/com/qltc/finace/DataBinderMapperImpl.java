package com.qltc.finace;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.qltc.finace.databinding.ActivityAuthenticationBindingImpl;
import com.qltc.finace.databinding.ActivityMainBindingImpl;
import com.qltc.finace.databinding.AddCategoryBindingImpl;
import com.qltc.finace.databinding.FagmentProfileBindingImpl;
import com.qltc.finace.databinding.FagmentReportBindingImpl;
import com.qltc.finace.databinding.FragmentAllDataIncomeExpenseBindingImpl;
import com.qltc.finace.databinding.FragmentAppInformationBindingImpl;
import com.qltc.finace.databinding.FragmentCalendarBindingImpl;
import com.qltc.finace.databinding.FragmentCategoryDetailBindingImpl;
import com.qltc.finace.databinding.FragmentChangeInforBindingImpl;
import com.qltc.finace.databinding.FragmentChangePasswordBindingImpl;
import com.qltc.finace.databinding.FragmentEditBindingImpl;
import com.qltc.finace.databinding.FragmentEnterBindingImpl;
import com.qltc.finace.databinding.FragmentExpenseBindingImpl;
import com.qltc.finace.databinding.FragmentExportPdfConfigBindingImpl;
import com.qltc.finace.databinding.FragmentFaqBindingImpl;
import com.qltc.finace.databinding.FragmentForgotPasswordBindingImpl;
import com.qltc.finace.databinding.FragmentHelperBindingImpl;
import com.qltc.finace.databinding.FragmentHomeBindingImpl;
import com.qltc.finace.databinding.FragmentIncomeBindingImpl;
import com.qltc.finace.databinding.FragmentListDataFromCategoryBindingImpl;
import com.qltc.finace.databinding.FragmentLoginPhoneBindingImpl;
import com.qltc.finace.databinding.FragmentOtpBindingImpl;
import com.qltc.finace.databinding.FragmentReportExpenseBindingImpl;
import com.qltc.finace.databinding.FragmentReportIncomeBindingImpl;
import com.qltc.finace.databinding.FragmentSignInBindingImpl;
import com.qltc.finace.databinding.FragmentSignUpBindingImpl;
import com.qltc.finace.databinding.FragmentWebviewBindingImpl;
import com.qltc.finace.databinding.ItemCategoryBindingImpl;
import com.qltc.finace.databinding.ItemCategoryDetailBindingImpl;
import com.qltc.finace.databinding.ItemDayViewCalendarBindingImpl;
import com.qltc.finace.databinding.ItemFaqBindingImpl;
import com.qltc.finace.databinding.ItemIconBindingImpl;
import com.qltc.finace.databinding.ItemTotalCalendarBindingImpl;
import com.qltc.finace.databinding.ItemTotalCategoryBindingImpl;
import com.qltc.finace.databinding.NavHeaderMainBindingImpl;
import java.lang.IllegalArgumentException;
import java.lang.Integer;
import java.lang.Object;
import java.lang.Override;
import java.lang.RuntimeException;
import java.lang.String;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DataBinderMapperImpl extends DataBinderMapper {
  private static final int LAYOUT_ACTIVITYAUTHENTICATION = 1;

  private static final int LAYOUT_ACTIVITYMAIN = 2;

  private static final int LAYOUT_ADDCATEGORY = 3;

  private static final int LAYOUT_FAGMENTPROFILE = 4;

  private static final int LAYOUT_FAGMENTREPORT = 5;

  private static final int LAYOUT_FRAGMENTALLDATAINCOMEEXPENSE = 6;

  private static final int LAYOUT_FRAGMENTAPPINFORMATION = 7;

  private static final int LAYOUT_FRAGMENTCALENDAR = 8;

  private static final int LAYOUT_FRAGMENTCATEGORYDETAIL = 9;

  private static final int LAYOUT_FRAGMENTCHANGEINFOR = 10;

  private static final int LAYOUT_FRAGMENTCHANGEPASSWORD = 11;

  private static final int LAYOUT_FRAGMENTEDIT = 12;

  private static final int LAYOUT_FRAGMENTENTER = 13;

  private static final int LAYOUT_FRAGMENTEXPENSE = 14;

  private static final int LAYOUT_FRAGMENTEXPORTPDFCONFIG = 15;

  private static final int LAYOUT_FRAGMENTFAQ = 16;

  private static final int LAYOUT_FRAGMENTFORGOTPASSWORD = 17;

  private static final int LAYOUT_FRAGMENTHELPER = 18;

  private static final int LAYOUT_FRAGMENTHOME = 19;

  private static final int LAYOUT_FRAGMENTINCOME = 20;

  private static final int LAYOUT_FRAGMENTLISTDATAFROMCATEGORY = 21;

  private static final int LAYOUT_FRAGMENTLOGINPHONE = 22;

  private static final int LAYOUT_FRAGMENTOTP = 23;

  private static final int LAYOUT_FRAGMENTREPORTEXPENSE = 24;

  private static final int LAYOUT_FRAGMENTREPORTINCOME = 25;

  private static final int LAYOUT_FRAGMENTSIGNIN = 26;

  private static final int LAYOUT_FRAGMENTSIGNUP = 27;

  private static final int LAYOUT_FRAGMENTWEBVIEW = 28;

  private static final int LAYOUT_ITEMCATEGORY = 29;

  private static final int LAYOUT_ITEMCATEGORYDETAIL = 30;

  private static final int LAYOUT_ITEMDAYVIEWCALENDAR = 31;

  private static final int LAYOUT_ITEMFAQ = 32;

  private static final int LAYOUT_ITEMICON = 33;

  private static final int LAYOUT_ITEMTOTALCALENDAR = 34;

  private static final int LAYOUT_ITEMTOTALCATEGORY = 35;

  private static final int LAYOUT_NAVHEADERMAIN = 36;

  private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP = new SparseIntArray(36);

  static {
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.activity_authentication, LAYOUT_ACTIVITYAUTHENTICATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.activity_main, LAYOUT_ACTIVITYMAIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.add_category, LAYOUT_ADDCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fagment_profile, LAYOUT_FAGMENTPROFILE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fagment_report, LAYOUT_FAGMENTREPORT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_all_data_income_expense, LAYOUT_FRAGMENTALLDATAINCOMEEXPENSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_app_information, LAYOUT_FRAGMENTAPPINFORMATION);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_calendar, LAYOUT_FRAGMENTCALENDAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_category_detail, LAYOUT_FRAGMENTCATEGORYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_change_infor, LAYOUT_FRAGMENTCHANGEINFOR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_change_password, LAYOUT_FRAGMENTCHANGEPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_edit, LAYOUT_FRAGMENTEDIT);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_enter, LAYOUT_FRAGMENTENTER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_expense, LAYOUT_FRAGMENTEXPENSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_export_pdf_config, LAYOUT_FRAGMENTEXPORTPDFCONFIG);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_faq, LAYOUT_FRAGMENTFAQ);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_forgot_password, LAYOUT_FRAGMENTFORGOTPASSWORD);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_helper, LAYOUT_FRAGMENTHELPER);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_home, LAYOUT_FRAGMENTHOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_income, LAYOUT_FRAGMENTINCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_list_data_from_category, LAYOUT_FRAGMENTLISTDATAFROMCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_login_phone, LAYOUT_FRAGMENTLOGINPHONE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_otp, LAYOUT_FRAGMENTOTP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_report_expense, LAYOUT_FRAGMENTREPORTEXPENSE);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_report_income, LAYOUT_FRAGMENTREPORTINCOME);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_sign_in, LAYOUT_FRAGMENTSIGNIN);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_sign_up, LAYOUT_FRAGMENTSIGNUP);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.fragment_webview, LAYOUT_FRAGMENTWEBVIEW);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.item_category, LAYOUT_ITEMCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.item_category_detail, LAYOUT_ITEMCATEGORYDETAIL);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.item_day_view_calendar, LAYOUT_ITEMDAYVIEWCALENDAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.item_faq, LAYOUT_ITEMFAQ);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.item_icon, LAYOUT_ITEMICON);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.item_total_calendar, LAYOUT_ITEMTOTALCALENDAR);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.item_total_category, LAYOUT_ITEMTOTALCATEGORY);
    INTERNAL_LAYOUT_ID_LOOKUP.put(com.qltc.finace.R.layout.nav_header_main, LAYOUT_NAVHEADERMAIN);
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = view.getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
        case  LAYOUT_ACTIVITYAUTHENTICATION: {
          if ("layout/activity_authentication_0".equals(tag)) {
            return new ActivityAuthenticationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_authentication is invalid. Received: " + tag);
        }
        case  LAYOUT_ACTIVITYMAIN: {
          if ("layout/activity_main_0".equals(tag)) {
            return new ActivityMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for activity_main is invalid. Received: " + tag);
        }
        case  LAYOUT_ADDCATEGORY: {
          if ("layout/add_category_0".equals(tag)) {
            return new AddCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for add_category is invalid. Received: " + tag);
        }
        case  LAYOUT_FAGMENTPROFILE: {
          if ("layout/fagment_profile_0".equals(tag)) {
            return new FagmentProfileBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fagment_profile is invalid. Received: " + tag);
        }
        case  LAYOUT_FAGMENTREPORT: {
          if ("layout/fagment_report_0".equals(tag)) {
            return new FagmentReportBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fagment_report is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTALLDATAINCOMEEXPENSE: {
          if ("layout/fragment_all_data_income_expense_0".equals(tag)) {
            return new FragmentAllDataIncomeExpenseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_all_data_income_expense is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTAPPINFORMATION: {
          if ("layout/fragment_app_information_0".equals(tag)) {
            return new FragmentAppInformationBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_app_information is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCALENDAR: {
          if ("layout/fragment_calendar_0".equals(tag)) {
            return new FragmentCalendarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_calendar is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCATEGORYDETAIL: {
          if ("layout/fragment_category_detail_0".equals(tag)) {
            return new FragmentCategoryDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_category_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHANGEINFOR: {
          if ("layout/fragment_change_infor_0".equals(tag)) {
            return new FragmentChangeInforBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_change_infor is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTCHANGEPASSWORD: {
          if ("layout/fragment_change_password_0".equals(tag)) {
            return new FragmentChangePasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_change_password is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEDIT: {
          if ("layout/fragment_edit_0".equals(tag)) {
            return new FragmentEditBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_edit is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTENTER: {
          if ("layout/fragment_enter_0".equals(tag)) {
            return new FragmentEnterBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_enter is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEXPENSE: {
          if ("layout/fragment_expense_0".equals(tag)) {
            return new FragmentExpenseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_expense is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTEXPORTPDFCONFIG: {
          if ("layout/fragment_export_pdf_config_0".equals(tag)) {
            return new FragmentExportPdfConfigBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_export_pdf_config is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFAQ: {
          if ("layout/fragment_faq_0".equals(tag)) {
            return new FragmentFaqBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_faq is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTFORGOTPASSWORD: {
          if ("layout/fragment_forgot_password_0".equals(tag)) {
            return new FragmentForgotPasswordBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_forgot_password is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHELPER: {
          if ("layout/fragment_helper_0".equals(tag)) {
            return new FragmentHelperBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_helper is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTHOME: {
          if ("layout/fragment_home_0".equals(tag)) {
            return new FragmentHomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_home is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTINCOME: {
          if ("layout/fragment_income_0".equals(tag)) {
            return new FragmentIncomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_income is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLISTDATAFROMCATEGORY: {
          if ("layout/fragment_list_data_from_category_0".equals(tag)) {
            return new FragmentListDataFromCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_list_data_from_category is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTLOGINPHONE: {
          if ("layout/fragment_login_phone_0".equals(tag)) {
            return new FragmentLoginPhoneBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_login_phone is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTOTP: {
          if ("layout/fragment_otp_0".equals(tag)) {
            return new FragmentOtpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_otp is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREPORTEXPENSE: {
          if ("layout/fragment_report_expense_0".equals(tag)) {
            return new FragmentReportExpenseBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_report_expense is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTREPORTINCOME: {
          if ("layout/fragment_report_income_0".equals(tag)) {
            return new FragmentReportIncomeBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_report_income is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNIN: {
          if ("layout/fragment_sign_in_0".equals(tag)) {
            return new FragmentSignInBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_in is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTSIGNUP: {
          if ("layout/fragment_sign_up_0".equals(tag)) {
            return new FragmentSignUpBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_sign_up is invalid. Received: " + tag);
        }
        case  LAYOUT_FRAGMENTWEBVIEW: {
          if ("layout/fragment_webview_0".equals(tag)) {
            return new FragmentWebviewBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for fragment_webview is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCATEGORY: {
          if ("layout/item_category_0".equals(tag)) {
            return new ItemCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_category is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMCATEGORYDETAIL: {
          if ("layout/item_category_detail_0".equals(tag)) {
            return new ItemCategoryDetailBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_category_detail is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMDAYVIEWCALENDAR: {
          if ("layout/item_day_view_calendar_0".equals(tag)) {
            return new ItemDayViewCalendarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_day_view_calendar is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMFAQ: {
          if ("layout/item_faq_0".equals(tag)) {
            return new ItemFaqBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_faq is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMICON: {
          if ("layout/item_icon_0".equals(tag)) {
            return new ItemIconBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_icon is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMTOTALCALENDAR: {
          if ("layout/item_total_calendar_0".equals(tag)) {
            return new ItemTotalCalendarBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_total_calendar is invalid. Received: " + tag);
        }
        case  LAYOUT_ITEMTOTALCATEGORY: {
          if ("layout/item_total_category_0".equals(tag)) {
            return new ItemTotalCategoryBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for item_total_category is invalid. Received: " + tag);
        }
        case  LAYOUT_NAVHEADERMAIN: {
          if ("layout/nav_header_main_0".equals(tag)) {
            return new NavHeaderMainBindingImpl(component, view);
          }
          throw new IllegalArgumentException("The tag for nav_header_main is invalid. Received: " + tag);
        }
      }
    }
    return null;
  }

  @Override
  public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
    if(views == null || views.length == 0) {
      return null;
    }
    int localizedLayoutId = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
    if(localizedLayoutId > 0) {
      final Object tag = views[0].getTag();
      if(tag == null) {
        throw new RuntimeException("view must have a tag");
      }
      switch(localizedLayoutId) {
      }
    }
    return null;
  }

  @Override
  public int getLayoutId(String tag) {
    if (tag == null) {
      return 0;
    }
    Integer tmpVal = InnerLayoutIdLookup.sKeys.get(tag);
    return tmpVal == null ? 0 : tmpVal;
  }

  @Override
  public String convertBrIdToString(int localId) {
    String tmpVal = InnerBrLookup.sKeys.get(localId);
    return tmpVal;
  }

  @Override
  public List<DataBinderMapper> collectDependencies() {
    ArrayList<DataBinderMapper> result = new ArrayList<DataBinderMapper>(1);
    result.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
    return result;
  }

  private static class InnerBrLookup {
    static final SparseArray<String> sKeys = new SparseArray<String>(7);

    static {
      sKeys.put(0, "_all");
      sKeys.put(1, "adapter");
      sKeys.put(2, "data");
      sKeys.put(3, "item");
      sKeys.put(4, "listener");
      sKeys.put(5, "position");
      sKeys.put(6, "viewModel");
    }
  }

  private static class InnerLayoutIdLookup {
    static final HashMap<String, Integer> sKeys = new HashMap<String, Integer>(36);

    static {
      sKeys.put("layout/activity_authentication_0", com.qltc.finace.R.layout.activity_authentication);
      sKeys.put("layout/activity_main_0", com.qltc.finace.R.layout.activity_main);
      sKeys.put("layout/add_category_0", com.qltc.finace.R.layout.add_category);
      sKeys.put("layout/fagment_profile_0", com.qltc.finace.R.layout.fagment_profile);
      sKeys.put("layout/fagment_report_0", com.qltc.finace.R.layout.fagment_report);
      sKeys.put("layout/fragment_all_data_income_expense_0", com.qltc.finace.R.layout.fragment_all_data_income_expense);
      sKeys.put("layout/fragment_app_information_0", com.qltc.finace.R.layout.fragment_app_information);
      sKeys.put("layout/fragment_calendar_0", com.qltc.finace.R.layout.fragment_calendar);
      sKeys.put("layout/fragment_category_detail_0", com.qltc.finace.R.layout.fragment_category_detail);
      sKeys.put("layout/fragment_change_infor_0", com.qltc.finace.R.layout.fragment_change_infor);
      sKeys.put("layout/fragment_change_password_0", com.qltc.finace.R.layout.fragment_change_password);
      sKeys.put("layout/fragment_edit_0", com.qltc.finace.R.layout.fragment_edit);
      sKeys.put("layout/fragment_enter_0", com.qltc.finace.R.layout.fragment_enter);
      sKeys.put("layout/fragment_expense_0", com.qltc.finace.R.layout.fragment_expense);
      sKeys.put("layout/fragment_export_pdf_config_0", com.qltc.finace.R.layout.fragment_export_pdf_config);
      sKeys.put("layout/fragment_faq_0", com.qltc.finace.R.layout.fragment_faq);
      sKeys.put("layout/fragment_forgot_password_0", com.qltc.finace.R.layout.fragment_forgot_password);
      sKeys.put("layout/fragment_helper_0", com.qltc.finace.R.layout.fragment_helper);
      sKeys.put("layout/fragment_home_0", com.qltc.finace.R.layout.fragment_home);
      sKeys.put("layout/fragment_income_0", com.qltc.finace.R.layout.fragment_income);
      sKeys.put("layout/fragment_list_data_from_category_0", com.qltc.finace.R.layout.fragment_list_data_from_category);
      sKeys.put("layout/fragment_login_phone_0", com.qltc.finace.R.layout.fragment_login_phone);
      sKeys.put("layout/fragment_otp_0", com.qltc.finace.R.layout.fragment_otp);
      sKeys.put("layout/fragment_report_expense_0", com.qltc.finace.R.layout.fragment_report_expense);
      sKeys.put("layout/fragment_report_income_0", com.qltc.finace.R.layout.fragment_report_income);
      sKeys.put("layout/fragment_sign_in_0", com.qltc.finace.R.layout.fragment_sign_in);
      sKeys.put("layout/fragment_sign_up_0", com.qltc.finace.R.layout.fragment_sign_up);
      sKeys.put("layout/fragment_webview_0", com.qltc.finace.R.layout.fragment_webview);
      sKeys.put("layout/item_category_0", com.qltc.finace.R.layout.item_category);
      sKeys.put("layout/item_category_detail_0", com.qltc.finace.R.layout.item_category_detail);
      sKeys.put("layout/item_day_view_calendar_0", com.qltc.finace.R.layout.item_day_view_calendar);
      sKeys.put("layout/item_faq_0", com.qltc.finace.R.layout.item_faq);
      sKeys.put("layout/item_icon_0", com.qltc.finace.R.layout.item_icon);
      sKeys.put("layout/item_total_calendar_0", com.qltc.finace.R.layout.item_total_calendar);
      sKeys.put("layout/item_total_category_0", com.qltc.finace.R.layout.item_total_category);
      sKeys.put("layout/nav_header_main_0", com.qltc.finace.R.layout.nav_header_main);
    }
  }
}
