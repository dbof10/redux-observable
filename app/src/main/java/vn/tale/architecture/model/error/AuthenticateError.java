package vn.tale.architecture.model.error;

/**
 * Created by Giang Nguyen on 2/21/17.
 */

public class AuthenticateError extends RuntimeException {

  private static final long serialVersionUID = -7666209496472570517L;
  private final long id = serialVersionUID;

  @Override public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    AuthenticateError that = (AuthenticateError) o;

    return id == that.id;
  }

  @Override public int hashCode() {
    return (int) (id ^ (id >>> 32));
  }
}
