package vn.tale.architecture.login.epic;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import vn.tale.architecture.common.redux.Action;
import vn.tale.architecture.common.redux.Function0;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.common.redux.Effect;
import vn.tale.architecture.login.LoginState;
import vn.tale.architecture.login.action.SubmitAction;
import vn.tale.architecture.login.result.SubmitResult;
import vn.tale.architecture.model.manager.UserModel;


public class SubmitEpic implements Effect<LoginState> {

  private final UserModel userModel;

  public SubmitEpic(UserModel userModel) {
    this.userModel = userModel;
  }

  @Override public Observable<Result> apply(Observable<Action> action$,
      Function0<LoginState> getState) {
    return action$.ofType(SubmitAction.class)
        .flatMap(action -> userModel.login(action.email, action.password)
            .toObservable()
            .map(user -> SubmitResult.SUCCESS)
            .onErrorReturn(SubmitResult::error)
            .subscribeOn(Schedulers.io())
            .startWith(SubmitResult.IN_FLIGHT));
  }
}
