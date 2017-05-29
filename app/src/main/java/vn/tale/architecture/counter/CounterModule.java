package vn.tale.architecture.counter;

import dagger.Module;
import dagger.Provides;
import vn.tale.architecture.common.redux.Store;
import vn.tale.architecture.counter.effect.ChangeValueEffect;

/**
 * Created by Giang Nguyen on 3/24/17.
 */
@Module
public class CounterModule {

  @Provides Store<CounterState> provideCounterUiModelViewModel() {
    return Store.<CounterState>builder()
        .initialState(CounterState.make(0))
        .effects(new ChangeValueEffect())
        .reducer(new CounterReducer())
        .make();
  }
}
