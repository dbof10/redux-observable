package vn.tale.architecture.common;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.VisibleForTesting;
import vn.tale.architecture.login.LoginActivity;

/**
 * Created by Giang Nguyen on 2/21/17.
 */

public class AppRouter {
  private final IntentFactory intentFactory;

  public AppRouter() {
    intentFactory = new IntentFactory();
  }

  @VisibleForTesting AppRouter(IntentFactory intentFactory) {
    this.intentFactory = intentFactory;
  }

  public Intent loginIntent(Context context) {
    return intentFactory.create(context, LoginActivity.class);
  }

}
