package vn.tale.architecture.home.effect;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import vn.tale.architecture.common.redux.Action;
import vn.tale.architecture.common.redux.Effect;
import vn.tale.architecture.common.redux.Function0;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.home.HomeState;
import vn.tale.architecture.home.action.HomeAction;
import vn.tale.architecture.home.result.LoadMoreResult;
import vn.tale.architecture.model.manager.HomeModel;

public class LoadMoreEffect implements Effect<HomeState> {

  private final HomeModel homeModel;

  public LoadMoreEffect(HomeModel homeModel) {
    this.homeModel = homeModel;
  }

  @Override public Observable<Result> apply(Observable<Action> action$,
      Function0<HomeState> getState) {
    return action$
        .filter(action -> action == HomeAction.LOAD_MORE)
        .filter(ignored -> !getState.apply().loadingMore())
        .flatMap(ignored -> homeModel.getHome(getState.apply().page() + 1)
            .map(content -> LoadMoreResult.success(getState.apply().page() + 1, content))
            .onErrorReturn(LoadMoreResult::failure)
            .subscribeOn(Schedulers.io())
            .startWith(LoadMoreResult.inProgress()));
  }
}
