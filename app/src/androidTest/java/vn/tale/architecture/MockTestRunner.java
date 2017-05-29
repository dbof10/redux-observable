package vn.tale.architecture;

import android.app.Application;
import android.content.Context;
import android.support.test.runner.AndroidJUnitRunner;

/**
 * Created by Giang Nguyen on 2/27/17.
 */

public class MockTestRunner extends AndroidJUnitRunner {

  @Override public Application newApplication(ClassLoader cl, String className, Context context)
      throws InstantiationException, IllegalAccessException, ClassNotFoundException {
    return super.newApplication(cl, MockApplication.class.getName(), context);
  }
}
