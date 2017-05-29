package vn.tale.architecture.model.error;

/**
 * Created by Giang Nguyen on 3/21/17.
 */

public class InvalidEmailError extends RuntimeException {

  private static final long serialVersionUID = 7075042945055393445L;
  private final long id = serialVersionUID;

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    InvalidEmailError that = (InvalidEmailError) o;

    return id == that.id;
  }

  @Override public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }
}
