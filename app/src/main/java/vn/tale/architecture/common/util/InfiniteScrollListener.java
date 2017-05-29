package vn.tale.architecture.common.util;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class InfiniteScrollListener extends RecyclerView.OnScrollListener {

  private final LinearLayoutManager linearLayoutManager;
  private final int visibleThreshold;
  private final Runnable callbacks;
  private int previousTotal = 0; // The total number of items in the dataset after the last load
  private boolean loading = true; // True if we are still waiting for the last set of data to load.

  public InfiniteScrollListener(LinearLayoutManager linearLayoutManager, int visibleThreshold,
      Runnable callbacks) {
    this.linearLayoutManager = linearLayoutManager;
    this.visibleThreshold = visibleThreshold;
    this.callbacks = callbacks;
  }

  @Override public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);
    final int visibleItemCount = recyclerView.getChildCount();
    final int totalItemCount = linearLayoutManager.getItemCount();
    final int firstVisibleItem = linearLayoutManager.findFirstVisibleItemPosition();

    if (loading) {
      if (totalItemCount > previousTotal || totalItemCount == 0) {
        loading = false;
        previousTotal = totalItemCount;
      }
    }

    // End has been reached
    if (!loading && totalItemCount - visibleItemCount <= firstVisibleItem + visibleThreshold) {
      recyclerView.post(callbacks);
      loading = true;
    }
  }
}