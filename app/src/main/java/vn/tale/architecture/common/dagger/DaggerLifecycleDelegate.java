package vn.tale.architecture.common.dagger;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Giang Nguyen on 3/20/17.
 */

public class DaggerLifecycleDelegate<T> {

  @VisibleForTesting T daggerComponent;

  private DaggerComponentFactory<T> daggerComponentFactory;

  public DaggerLifecycleDelegate(@NonNull DaggerComponentFactory<T> daggerComponentFactory) {
    this.daggerComponentFactory = daggerComponentFactory;
  }

  @SuppressWarnings("unchecked") public void onCreate(AppCompatActivity activity) {
    daggerComponent = (T) activity.getLastCustomNonConfigurationInstance();
    if (daggerComponent == null) {
      daggerComponent = daggerComponentFactory.makeComponent();
    }
  }

  public Object onRetainCustomNonConfigurationInstance() {
    return daggerComponent;
  }

  public T daggerComponent() {
    return daggerComponent;
  }
}
