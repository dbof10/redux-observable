package vn.tale.architecture.login;

import vn.tale.architecture.common.redux.Reducer;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.login.result.CheckEmailResult;
import vn.tale.architecture.login.result.SubmitResult;

/**
 * Created by Giang Nguyen on 3/23/17.
 */

public class LoginReducer implements Reducer<LoginState> {

  @Override public LoginState apply(LoginState loginState, Result result) {
    if (result == SubmitResult.IN_FLIGHT) {
      return LoginState.inProgress();
    } else if (result == CheckEmailResult.SUCCESS) {
      return LoginState.idle();
    } else if (result == SubmitResult.SUCCESS) {
      return LoginState.success();
    }
    final Throwable error;
    if (result instanceof SubmitResult) {
      error = ((SubmitResult) result).error();
    } else if (result instanceof CheckEmailResult) {
      error = ((CheckEmailResult) result).error();
    } else {
      return loginState;
    }
    return LoginState.error(error);
  }
}
