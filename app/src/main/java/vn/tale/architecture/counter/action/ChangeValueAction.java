package vn.tale.architecture.counter.action;

import vn.tale.architecture.common.redux.Action;

/**
 * Created by Giang Nguyen on 3/24/17.
 */
public final class ChangeValueAction implements Action {
  public static final ChangeValueAction INCREASE = new ChangeValueAction();
  public static final ChangeValueAction DECREASE = new ChangeValueAction();

  private ChangeValueAction() {
    //no instance
  }
}
