package vn.tale.architecture.counter;

import com.google.auto.value.AutoValue;

/**
 * Created by Giang Nguyen on 3/24/17.
 */
@AutoValue
public abstract class CounterState {

  public static CounterState make(int value) {
    return new AutoValue_CounterState(value);
  }

  public abstract int value();
}
