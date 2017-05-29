package vn.tale.architecture.login.epic;

import io.reactivex.Observable;
import timber.log.Timber;
import vn.tale.architecture.common.EmailValidator;
import vn.tale.architecture.common.redux.Action;
import vn.tale.architecture.common.redux.Effect;
import vn.tale.architecture.common.redux.Function0;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.login.LoginState;
import vn.tale.architecture.login.action.CheckEmailAction;
import vn.tale.architecture.login.result.CheckEmailResult;


public class CheckEmailEpic implements Effect<LoginState> {

  private EmailValidator emailValidator;

  public CheckEmailEpic(EmailValidator emailValidator) {
    this.emailValidator = emailValidator;
  }

  @Override public Observable<Result> apply(Observable<Action> action$,
      Function0<LoginState> getState) {
    return action$
        .ofType(CheckEmailAction.class)
        .skip(1)
        .switchMap(action -> emailValidator.checkEmail(action.email)
            .map(ignored -> CheckEmailResult.SUCCESS)
            .onErrorReturn(CheckEmailResult::error)
            .doOnNext(result -> Timber.d("result => %s", result))
        );
  }
}
