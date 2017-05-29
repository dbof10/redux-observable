package vn.tale.architecture.common.redux;

import android.support.annotation.NonNull;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.subjects.BehaviorSubject;
import io.reactivex.subjects.PublishSubject;
import vn.tale.architecture.common.Preconditions;

public class Store<State> {

    private final Reducer<State> reducer;
    private final PublishSubject<Action> action$;
    private final BehaviorSubject<State> state$;
    private final Observable<Result> result$;
    private Disposable disposable;

    Store(@NonNull State initialState,
          @NonNull Reducer<State> reducer,
          @NonNull Effect<State>[] effects) {
        this.reducer = reducer;
        this.action$ = PublishSubject.create();
        this.state$ = BehaviorSubject.createDefault(initialState);
        this.result$ = Observable.fromArray(effects)
                .flatMap(transformer -> transformer.apply(action$, this::currentState));
    }

    public static <State> Builder<State> builder() {
        return new Builder<>();
    }

    private State currentState() {
        return state$.getValue();
    }

    public Observable<State> state$() {
        return state$;
    }

    public void dispatch(Action action) {
        action$.onNext(action);
    }

    void startBinding() {
        if (disposable != null) {
            // binding is started already
            return;
        }
        disposable = result$
                .scan(currentState(), reducer)
                .subscribe(state$::onNext);
    }

    void stopBinding() {
        if (disposable != null) {
            disposable.dispose();
            disposable = null;
        }
    }

    public static class Builder<State> {
        private State initialState;
        private Reducer<State> reducer;
        private Effect<State>[] effects;

        Builder() {
            // private constructor
        }

        public Builder<State> initialState(@NonNull State initialState) {
            Preconditions.checkNotNull(initialState, "initialState must not be null");
            this.initialState = initialState;
            return this;
        }

        public Builder<State> reducer(@NonNull Reducer<State> reducer) {
            Preconditions.checkNotNull(reducer, "reducer must not be null");
            this.reducer = reducer;
            return this;
        }

        @SafeVarargs
        public final Builder<State> effects(@NonNull Effect<State>... effects) {
            Preconditions.checkNotNull(effects);
            Preconditions.checkNotEmpty(effects, "effects must not be empty");
            this.effects = effects;
            return this;
        }

        public Store<State> make() {
            return new Store<>(initialState, reducer, effects);
        }
    }
}
