// Generated by view binder compiler. Do not edit!
package com.example.sisig.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sisig.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityResetPasswordBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final Button buttonResetPassword;

  @NonNull
  public final EditText editTextNewPassword;

  @NonNull
  public final EditText editTextUsername;

  @NonNull
  public final ImageView imageViewLogo;

  private ActivityResetPasswordBinding(@NonNull LinearLayout rootView,
      @NonNull Button buttonResetPassword, @NonNull EditText editTextNewPassword,
      @NonNull EditText editTextUsername, @NonNull ImageView imageViewLogo) {
    this.rootView = rootView;
    this.buttonResetPassword = buttonResetPassword;
    this.editTextNewPassword = editTextNewPassword;
    this.editTextUsername = editTextUsername;
    this.imageViewLogo = imageViewLogo;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityResetPasswordBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_reset_password, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityResetPasswordBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonResetPassword;
      Button buttonResetPassword = ViewBindings.findChildViewById(rootView, id);
      if (buttonResetPassword == null) {
        break missingId;
      }

      id = R.id.editTextNewPassword;
      EditText editTextNewPassword = ViewBindings.findChildViewById(rootView, id);
      if (editTextNewPassword == null) {
        break missingId;
      }

      id = R.id.editTextUsername;
      EditText editTextUsername = ViewBindings.findChildViewById(rootView, id);
      if (editTextUsername == null) {
        break missingId;
      }

      id = R.id.imageViewLogo;
      ImageView imageViewLogo = ViewBindings.findChildViewById(rootView, id);
      if (imageViewLogo == null) {
        break missingId;
      }

      return new ActivityResetPasswordBinding((LinearLayout) rootView, buttonResetPassword,
          editTextNewPassword, editTextUsername, imageViewLogo);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
