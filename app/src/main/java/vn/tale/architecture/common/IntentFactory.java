package vn.tale.architecture.common;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Giang Nguyen on 2/21/17.
 */

class IntentFactory {

  Intent create(Context context, Class<? extends Activity> activityClass) {
    return new Intent(context, activityClass);
  }
}
