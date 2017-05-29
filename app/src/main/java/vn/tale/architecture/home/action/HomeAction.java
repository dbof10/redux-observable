package vn.tale.architecture.home.action;

import vn.tale.architecture.common.redux.Action;

/**
 * Created by Giang Nguyen on 3/27/17.
 */

public interface HomeAction {
  Action LOAD = new Action() {};
  Action LOAD_MORE = new Action() {};
  Action REFRESH = new Action() {};
}
