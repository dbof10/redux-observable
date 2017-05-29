package vn.tale.architecture.common.redux;

import io.reactivex.Observable;

/**
 * Created by Giang Nguyen on 3/24/17.
 */

public interface Effect<State> {

  Observable<Result> apply(Observable<Action> action$, Function0<State> getState);
}
