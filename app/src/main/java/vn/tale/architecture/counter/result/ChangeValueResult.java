package vn.tale.architecture.counter.result;

import com.google.auto.value.AutoValue;
import vn.tale.architecture.common.redux.Result;

/**
 * Created by Giang Nguyen on 3/24/17.
 */
@AutoValue
public abstract class ChangeValueResult implements Result {

  public static ChangeValueResult make(int value) {
    return new AutoValue_ChangeValueResult(value);
  }

  public abstract int value();
}
