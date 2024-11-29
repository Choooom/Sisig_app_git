// Generated by data binding compiler. Do not edit!
package com.example.sisig.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.sisig.R;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class DialogBiometricBinding extends ViewDataBinding {
  @NonNull
  public final Button buttonBiometricLogin;

  @Bindable
  protected String mDialogTitle;

  protected DialogBiometricBinding(Object _bindingComponent, View _root, int _localFieldCount,
      Button buttonBiometricLogin) {
    super(_bindingComponent, _root, _localFieldCount);
    this.buttonBiometricLogin = buttonBiometricLogin;
  }

  public abstract void setDialogTitle(@Nullable String dialogTitle);

  @Nullable
  public String getDialogTitle() {
    return mDialogTitle;
  }

  @NonNull
  public static DialogBiometricBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_biometric, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static DialogBiometricBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<DialogBiometricBinding>inflateInternal(inflater, R.layout.dialog_biometric, root, attachToRoot, component);
  }

  @NonNull
  public static DialogBiometricBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.dialog_biometric, null, false, component)
   */
  @NonNull
  @Deprecated
  public static DialogBiometricBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<DialogBiometricBinding>inflateInternal(inflater, R.layout.dialog_biometric, null, false, component);
  }

  public static DialogBiometricBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static DialogBiometricBinding bind(@NonNull View view, @Nullable Object component) {
    return (DialogBiometricBinding)bind(component, view, R.layout.dialog_biometric);
  }
}
