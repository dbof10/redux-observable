package vn.tale.architecture.login.action;

import vn.tale.architecture.common.redux.Action;

/**
 * Created by Giang Nguyen on 3/23/17.
 */

public class CheckEmailAction implements Action {
  public final String email;

  public CheckEmailAction(String email) {
    this.email = email;
  }
}
