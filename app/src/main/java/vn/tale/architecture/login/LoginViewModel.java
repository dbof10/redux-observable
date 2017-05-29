package vn.tale.architecture.login;

import io.reactivex.Observable;

/**
 * Created by Giang Nguyen on 3/31/17.
 */
public class LoginViewModel {

  private final Observable<LoginState> state$;

  public LoginViewModel(Observable<LoginState> state$) {
    this.state$ = state$;
  }

  public Observable<LoginState> idle() {
    return state$
        .filter(state -> state.equals(LoginState.idle()));
  }

  public Observable<LoginState> loading() {
    return state$
        .filter(state -> state.inProgress);
  }

  public Observable<LoginState> success() {
    return state$
        .filter(state -> state.success);
  }

  public Observable<Throwable> error() {
    return state$
        .filter(state -> state.error != null)
        .map(state -> state.error);
  }
}
