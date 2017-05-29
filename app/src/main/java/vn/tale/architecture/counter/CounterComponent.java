package vn.tale.architecture.counter;

import dagger.Subcomponent;

/**
 * Created by Giang Nguyen on 3/24/17.
 */
@Subcomponent(modules = CounterModule.class)
public interface CounterComponent {

  void inject(CounterActivity counterActivity);
}
