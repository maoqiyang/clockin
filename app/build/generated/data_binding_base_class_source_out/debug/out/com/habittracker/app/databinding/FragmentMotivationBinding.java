// Generated by view binder compiler. Do not edit!
package com.habittracker.app.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.button.MaterialButton;
import com.habittracker.app.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentMotivationBinding implements ViewBinding {
  @NonNull
  private final ScrollView rootView;

  @NonNull
  public final MaterialButton buttonFavorite;

  @NonNull
  public final MaterialButton buttonRefresh;

  @NonNull
  public final ImageView imageMotivation;

  @NonNull
  public final FrameLayout loadingOverlay;

  @NonNull
  public final ProgressBar progressBar;

  @NonNull
  public final TextView textAuthor;

  @NonNull
  public final TextView textQuote;

  private FragmentMotivationBinding(@NonNull ScrollView rootView,
      @NonNull MaterialButton buttonFavorite, @NonNull MaterialButton buttonRefresh,
      @NonNull ImageView imageMotivation, @NonNull FrameLayout loadingOverlay,
      @NonNull ProgressBar progressBar, @NonNull TextView textAuthor, @NonNull TextView textQuote) {
    this.rootView = rootView;
    this.buttonFavorite = buttonFavorite;
    this.buttonRefresh = buttonRefresh;
    this.imageMotivation = imageMotivation;
    this.loadingOverlay = loadingOverlay;
    this.progressBar = progressBar;
    this.textAuthor = textAuthor;
    this.textQuote = textQuote;
  }

  @Override
  @NonNull
  public ScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentMotivationBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentMotivationBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_motivation, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentMotivationBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.button_favorite;
      MaterialButton buttonFavorite = ViewBindings.findChildViewById(rootView, id);
      if (buttonFavorite == null) {
        break missingId;
      }

      id = R.id.button_refresh;
      MaterialButton buttonRefresh = ViewBindings.findChildViewById(rootView, id);
      if (buttonRefresh == null) {
        break missingId;
      }

      id = R.id.image_motivation;
      ImageView imageMotivation = ViewBindings.findChildViewById(rootView, id);
      if (imageMotivation == null) {
        break missingId;
      }

      id = R.id.loading_overlay;
      FrameLayout loadingOverlay = ViewBindings.findChildViewById(rootView, id);
      if (loadingOverlay == null) {
        break missingId;
      }

      id = R.id.progress_bar;
      ProgressBar progressBar = ViewBindings.findChildViewById(rootView, id);
      if (progressBar == null) {
        break missingId;
      }

      id = R.id.text_author;
      TextView textAuthor = ViewBindings.findChildViewById(rootView, id);
      if (textAuthor == null) {
        break missingId;
      }

      id = R.id.text_quote;
      TextView textQuote = ViewBindings.findChildViewById(rootView, id);
      if (textQuote == null) {
        break missingId;
      }

      return new FragmentMotivationBinding((ScrollView) rootView, buttonFavorite, buttonRefresh,
          imageMotivation, loadingOverlay, progressBar, textAuthor, textQuote);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
