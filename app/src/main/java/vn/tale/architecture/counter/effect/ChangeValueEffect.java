package vn.tale.architecture.counter.effect;

import io.reactivex.Observable;
import vn.tale.architecture.common.redux.Action;
import vn.tale.architecture.common.redux.Function0;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.common.redux.Effect;
import vn.tale.architecture.counter.CounterState;
import vn.tale.architecture.counter.action.ChangeValueAction;
import vn.tale.architecture.counter.result.ChangeValueResult;

/**
 * Created by Giang Nguyen on 3/24/17.
 */

public class ChangeValueEffect implements Effect<CounterState> {

  @Override public Observable<Result> apply(Observable<Action> action$,
      Function0<CounterState> getState) {
    return action$
        .ofType(ChangeValueAction.class)
        .map(action -> {
          final CounterState uiModel = getState.apply();
          if (action == ChangeValueAction.INCREASE) {
            return ChangeValueResult.make(uiModel.value() + 1);
          } else {
            return ChangeValueResult.make(uiModel.value() - 1);
          }
        });
  }
}
