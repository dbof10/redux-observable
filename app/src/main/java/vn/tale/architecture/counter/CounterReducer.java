package vn.tale.architecture.counter;

import vn.tale.architecture.common.redux.Reducer;
import vn.tale.architecture.common.redux.Result;
import vn.tale.architecture.counter.result.ChangeValueResult;

/**
 * Created by Giang Nguyen on 3/24/17.
 */

public class CounterReducer implements Reducer<CounterState> {

  @Override public CounterState apply(CounterState counterState, Result result)
      throws Exception {
    if (result instanceof ChangeValueResult) {
      return CounterState.make(((ChangeValueResult) result).value());
    }

    throw new IllegalArgumentException("Unknown result " + result);
  }
}
