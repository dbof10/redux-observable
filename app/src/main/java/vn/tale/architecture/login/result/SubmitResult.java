package vn.tale.architecture.login.result;

import vn.tale.architecture.common.redux.Result;

/**
 * Created by Giang Nguyen on 3/23/17.
 */

public class SubmitResult implements Result {

  public static final SubmitResult SUCCESS = new SubmitResult(null);
  public static final SubmitResult IN_FLIGHT = new SubmitResult(null);

  public final Throwable error;

  public SubmitResult(Throwable throwable) {
    error = throwable;
  }

  public static SubmitResult error(Throwable error) {
    return new SubmitResult(error);
  }

  public Throwable error() {
    return error;
  }
}
