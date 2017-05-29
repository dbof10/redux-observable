package vn.tale.architecture.home;

import java.util.List;

import ix.Ix;
import vn.tale.architecture.common.redux.Reducer;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.home.result.LoadMoreResult;
import vn.tale.architecture.home.result.LoadResult;
import vn.tale.architecture.home.result.RefreshResult;
import vn.tale.architecture.model.HomeSection;

/**
 Created by Giang Nguyen on 3/28/17.
 */

public class HomeReducer implements Reducer<HomeState> {

    @SuppressWarnings("ThrowableResultOfMethodCallIgnored")
    @Override
    public HomeState apply(HomeState state, Result result)
            throws Exception {
        if (result instanceof LoadResult) {
            final LoadResult topRepoResult = (LoadResult) result;
            if (topRepoResult.loading()) {
                return HomeState.builder(state)
                        .loading(true)
                        .make();
            } else if (topRepoResult.error() != null) {
                return HomeState.builder(state)
                        .loading(false)
                        .loadError(topRepoResult.error())
                        .make();
            } else {
                return HomeState.builder(state)
                        .content(topRepoResult.content())
                        .loading(false)
                        .make();
            }
        } else if (result instanceof RefreshResult) {
            final RefreshResult refreshResult = (RefreshResult) result;
            if (refreshResult.loading()) {
                return HomeState.builder(state)
                        .refreshing(true)
                        .make();
            } else if (refreshResult.error() != null) {
                return HomeState.builder(state)
                        .refreshing(false)
                        .refreshError(refreshResult.error())
                        .make();
            } else {
                return HomeState.builder(state)
                        .refreshing(false)
                        .content(refreshResult.content())
                        .make();
            }
        } else if (result instanceof LoadMoreResult) {
            final LoadMoreResult loadMoreResult = (LoadMoreResult) result;
            if (loadMoreResult.loading()) {
                return HomeState.builder(state)
                        .loadingMore(true)
                        .make();
            } else if (loadMoreResult.error() != null) {
                return HomeState.builder(state)
                        .loadingMore(false)
                        .loadMoreError(loadMoreResult.error())
                        .make();
            } else {
                final List<HomeSection> repoList = Ix.from(state.content())
                        .mergeWith(((LoadMoreResult) result).content())
                        .toList();
                return HomeState.builder(state)
                        .loadingMore(false)
                        .page(((LoadMoreResult) result).page())
                        .content(repoList)
                        .make();
            }
        }
        throw new IllegalArgumentException("Unknown result");
    }
}
