package vn.tale.architecture.common.redux;

/**
 * Created by Giang Nguyen on 3/23/17.
 */

public class LifecycleDelegate<State> {

  private final Store<State> store;

  public LifecycleDelegate(Store<State> store) {
    this.store = store;
  }

  public void onStart() {
    store.startBinding();
  }

  public void onStop(boolean finishing) {
    if (finishing) {
      store.stopBinding();
    }
  }
}
