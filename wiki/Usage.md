# Usage

## Reducer

~~~java

public class TopRepoListReducer implements Reducer<TopRepoListState> {

  @SuppressWarnings("ThrowableResultOfMethodCallIgnored") @Override
  public TopRepoListState apply(TopRepoListState state, Result result)
      throws Exception {
    if (result instanceof LoadResult) {
      final LoadResult topRepoResult = (LoadResult) result;
      if (topRepoResult.loading()) {
        return TopRepoListState.builder(state)
            .loading(true)
            .make();
      } else if (topRepoResult.error() != null) {
        return TopRepoListState.builder(state)
            .loading(false)
            .loadError(topRepoResult.error())
            .make();
      } else {
        return TopRepoListState.builder(state)
            .content(topRepoResult.content())
            .loading(false)
            .make();
      }
    } else if (result instanceof RefreshResult) {
      final RefreshResult refreshResult = (RefreshResult) result;
      if (refreshResult.loading()) {
        return TopRepoListState.builder(state)
            .refreshing(true)
            .make();
      } else if (refreshResult.error() != null) {
        return TopRepoListState.builder(state)
            .refreshing(false)
            .refreshError(refreshResult.error())
            .make();
      } else {
        return TopRepoListState.builder(state)
            .refreshing(false)
            .content(refreshResult.content())
            .make();
      }
    } else if (result instanceof LoadMoreResult) {
      final LoadMoreResult loadMoreResult = (LoadMoreResult) result;
      if (loadMoreResult.loading()) {
        return TopRepoListState.builder(state)
            .loadingMore(true)
            .make();
      } else if (loadMoreResult.error() != null) {
        return TopRepoListState.builder(state)
            .loadingMore(false)
            .loadMoreError(loadMoreResult.error())
            .make();
      } else {
        final List<Repo> repoList = Ix.from(state.content())
            .mergeWith(((LoadMoreResult) result).content())
            .toList();
        return TopRepoListState.builder(state)
            .loadingMore(false)
            .page(((LoadMoreResult) result).page())
            .content(repoList)
            .make();
      }
    }
    throw new IllegalArgumentException("Unknown result");
  }
}
~~~

## Effect

[LoadEffect.java](../app/src/main/java/vn/tale/architecture/top_repos/effect/LoadEffect.java)

~~~java

public class LoadEffect implements Effect<TopRepoListState> {

  private final RepoModel repoModel;

  public LoadEffect(RepoModel repoModel) {
    this.repoModel = repoModel;
  }

  @Override public Observable<Result> apply(Observable<Action> action$,
      Function0<TopRepoListState> getState) {
    return action$
        .filter(action -> action == LoadTopRepoAction.LOAD)
        .filter(ignored -> getState.apply().content().isEmpty())
        .flatMap(ignored -> repoModel.getPublicRepos(false, 1)
            .toObservable()
            .map(LoadResult::success)
            .onErrorReturn(LoadResult::failure)
            .subscribeOn(Schedulers.io())
            .startWith(LoadResult.inProgress()));
  }
}

~~~

[LoadMoreEffect.java](../app/src/main/java/vn/tale/architecture/top_repos/effect/LoadMoreEffect.java)

~~~java

public class LoadMoreEffect implements Effect<TopRepoListState> {

  private final RepoModel repoModel;

  public LoadMoreEffect(RepoModel repoModel) {
    this.repoModel = repoModel;
  }

  @Override public Observable<Result> apply(Observable<Action> action$,
      Function0<TopRepoListState> getState) {
    return action$
        .filter(action -> action == LoadTopRepoAction.LOAD_MORE)
        .filter(ignored -> !getState.apply().loadingMore())
        .flatMap(ignored -> repoModel.getPublicRepos(true, getState.apply().page() + 1)
            .toObservable()
            .map(content -> LoadMoreResult.success(getState.apply().page() + 1, content))
            .onErrorReturn(LoadMoreResult::failure)
            .subscribeOn(Schedulers.io())
            .startWith(LoadMoreResult.inProgress()));
  }
}

~~~

## Create Store
~~~java
final Store<TopRepoListState> store = Store.<TopRepoListState>builder()
        .initialState(TopRepoListState.idle()) // initial state
        .effects( // Effects
            new LoadEffect(repoModel),
            new LoadMoreEffect(repoModel))
        .reducer(new TopRepoListReducer()) // Reducer
        .make()
~~~

## Work with Store

~~~java
class TopRepoListActivity extends AppCompatActivity {
  private Store store; // create store on OnCreate
  
  public void onStart() {
    super.onStart();
    store.startBinding();
    // Dispatch action
    store.dispatch(LoadTopRepoAction.LOAD);

	// Binding 
	disposable = store.state$()
	   .filter(state -> state.loading())
	   .subscribe(ignored -> renderLoading());
  }
  
  public void onStop() {
    super.onStop();
    store.stopBinding();
    if (disposable != null) {
      disposable.dispose();
    }
  }
}
~~~
