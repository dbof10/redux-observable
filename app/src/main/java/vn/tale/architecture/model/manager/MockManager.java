package vn.tale.architecture.model.manager;

import android.support.v4.util.ArrayMap;
import android.support.v4.util.Pair;
import java.util.Map;
import vn.tale.architecture.model.User;

import static vn.tale.architecture.model.User.user;

/**
 * Created by Giang Nguyen on 3/27/17.
 */

class MockManager {
  static final Map<Pair<String, String>, User> USER_MAP;

  static {
    USER_MAP = new ArrayMap<>();
    USER_MAP.put(new Pair<>("foo@tiki.vn", "foo123"), user("foo@tiki.vn", "Mr. Foo"));
    USER_MAP.put(new Pair<>("bar@tiki.vn", "bar123"), user("bar@tiki.vn", "Mr. Bar"));
  }

}
