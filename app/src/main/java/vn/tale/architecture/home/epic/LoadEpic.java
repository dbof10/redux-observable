package vn.tale.architecture.home.epic;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import vn.tale.architecture.common.redux.Action;
import vn.tale.architecture.common.redux.Effect;
import vn.tale.architecture.common.redux.Function0;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.home.HomeState;
import vn.tale.architecture.home.action.HomeAction;
import vn.tale.architecture.home.result.LoadResult;
import vn.tale.architecture.model.manager.HomeModel;



public class LoadEpic implements Effect<HomeState> {

    private final HomeModel homeModel;

    public LoadEpic(HomeModel homeModel) {
        this.homeModel = homeModel;
    }

    @Override
    public Observable<Result> apply(Observable<Action> action$,
                                    Function0<HomeState> getState) {
        return action$
                .filter(action -> action == HomeAction.LOAD)
                .filter(ignored -> getState.apply().content().isEmpty())
                .flatMap(ignored -> homeModel.getHome(1)
                        .map(LoadResult::success)
                        .onErrorReturn(LoadResult::failure)
                        .subscribeOn(Schedulers.io())
                        .startWith(LoadResult.inProgress()));
    }
}
