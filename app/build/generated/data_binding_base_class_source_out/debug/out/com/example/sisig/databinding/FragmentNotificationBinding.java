// Generated by view binder compiler. Do not edit!
package com.example.sisig.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.sisig.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentNotificationBinding implements ViewBinding {
  @NonNull
  private final LinearLayout rootView;

  @NonNull
  public final ImageView noNotificationIcon;

  @NonNull
  public final LinearLayout noNotificationLayout;

  @NonNull
  public final TextView noNotificationSubtext;

  @NonNull
  public final TextView noNotificationText;

  @NonNull
  public final RecyclerView notificationsList;

  private FragmentNotificationBinding(@NonNull LinearLayout rootView,
      @NonNull ImageView noNotificationIcon, @NonNull LinearLayout noNotificationLayout,
      @NonNull TextView noNotificationSubtext, @NonNull TextView noNotificationText,
      @NonNull RecyclerView notificationsList) {
    this.rootView = rootView;
    this.noNotificationIcon = noNotificationIcon;
    this.noNotificationLayout = noNotificationLayout;
    this.noNotificationSubtext = noNotificationSubtext;
    this.noNotificationText = noNotificationText;
    this.notificationsList = notificationsList;
  }

  @Override
  @NonNull
  public LinearLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentNotificationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_notification, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentNotificationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.no_notification_icon;
      ImageView noNotificationIcon = ViewBindings.findChildViewById(rootView, id);
      if (noNotificationIcon == null) {
        break missingId;
      }

      id = R.id.no_notification_layout;
      LinearLayout noNotificationLayout = ViewBindings.findChildViewById(rootView, id);
      if (noNotificationLayout == null) {
        break missingId;
      }

      id = R.id.no_notification_subtext;
      TextView noNotificationSubtext = ViewBindings.findChildViewById(rootView, id);
      if (noNotificationSubtext == null) {
        break missingId;
      }

      id = R.id.no_notification_text;
      TextView noNotificationText = ViewBindings.findChildViewById(rootView, id);
      if (noNotificationText == null) {
        break missingId;
      }

      id = R.id.notifications_list;
      RecyclerView notificationsList = ViewBindings.findChildViewById(rootView, id);
      if (notificationsList == null) {
        break missingId;
      }

      return new FragmentNotificationBinding((LinearLayout) rootView, noNotificationIcon,
          noNotificationLayout, noNotificationSubtext, noNotificationText, notificationsList);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
