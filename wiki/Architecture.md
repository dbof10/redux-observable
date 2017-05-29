# Architecture

* [Redux](#redux)
  * [Reducer](#reducer)
  * [Effects](#effects)
  * [Store](#store)
* [ViewModel](#viewmodel)

## RVVM
![RVVM](./Rvvm.png "RVVM")

## Redux
See more from [Redux](http://redux.js.org)

### Reducer
See more from [Redux](http://redux.js.org/docs/basics/Reducers.html)

The reducer is a pure function that takes the previous state and a Result, and returns the next state.

It's called a reducer because it's the type of function you would pass to `Observable.reduce(initialValue, reducer)`. It's very important that the reducer stays pure. It only computes the next state. It should be completely predictable: calling it with the same inputs many times should produce the same outputs. Things you should never do inside a reducer:

- Mutate its arguments;
- Perform side effects like API calls and routing transitions;
- Call non-pure functions, e.g. Date.now() or Math.random().

### Effects
Effects is the place where side-effect happens. Idea is pretty same as [Epics](https://redux-observable.js.org/docs/basics/Epics.html) from [redux-observable](https://redux-observable.js.org/). The different is we called the output is Result. 

~~~java
public interface Effect<State> {

  Observable<Result> apply(Observable<Action> action$, Function0<State> getState);
}
~~~

### Store
See more from [Redux](http://redux.js.org/docs/basics/Store.html#store)

In the previous sections, we defined the actions that represent the facts about “what happened”, effects that handle side-effect (e.g. call api, update database or call non-pure functions) then turn those action into results and the reducers that update the state according to those results.

The Store is the object that brings them together. The store has the following responsibilities:

- Holds application state;
- Allows access to state via state$();
- Allows state to be updated via dispatch(action);

It's important to note that you'll have many stores in your application base on your app’s dependencies scopes.

Create store by use its Builder

~~~java
Store.<State> store = Store.<State>builder()
        .initialState(/* initial state */)
        .effects(/* array of effects */)
        .reducer(/* reducer */)
        .make()
~~~

## ViewModel
Handle view’s logic then you can test.

e.g. [LoginViewModel.java](../app/src/main/java/vn/tale/architecture/login/LoginViewModel.java)

~~~java
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
~~~
