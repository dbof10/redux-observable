package vn.tale.architecture.home;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import vn.tale.architecture.model.HomeSection;

public class HomeViewModel {

    private final Observable<HomeState> state$;

    public HomeViewModel(Observable<HomeState> state$) {
        this.state$ = state$;
    }

    Observable<HomeState> loading$() {
        return state$
                .filter(HomeState::loading);
    }

    Observable<HomeState> refreshing$() {
        return state$
                .filter(HomeState::refreshing);
    }

    Observable<HomeState> loadingMore$() {
        return state$
                .filter(HomeState::loadingMore);
    }

    Observable<Throwable> loadError$() {
        return state$
                .filter(state -> state.loadError() != null)
                .map(HomeState::loadError);
    }

    public Observable<Throwable> refreshError$() {
        return state$
                .filter(state -> state.refreshError() != null)
                .map(HomeState::refreshError);
    }

    public Observable<Throwable> loadMoreError$() {
        return state$
                .filter(state -> state.loadMoreError() != null)
                .map(HomeState::loadMoreError);
    }

    public Observable<List<HomeSection>> content$() {
        return state$
                .filter(state -> !state.loading()
                        && !state.refreshing()
                        && state.loadError() == null
                        && state.refreshError() == null)
                .map(HomeState::content);
    }
}
