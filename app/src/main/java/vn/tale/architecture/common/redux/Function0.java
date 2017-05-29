package vn.tale.architecture.common.redux;

/**
 * A functional interface that returns a value, allows throwing a checked exception.
 *
 * @param <R> the output value type
 */
public interface Function0<R> {
  /**
   * Apply some calculation to the input value and return some other value.
   *
   * @return the output value
   * @throws Exception on error
   */
  R apply() throws Exception;
}
