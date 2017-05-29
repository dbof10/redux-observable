package vn.tale.architecture.model;

import com.google.auto.value.AutoValue;

/**
 * Created by Giang Nguyen on 2/21/17.
 */
@AutoValue
public abstract class User {

  public static User user(String email, String name) {
    return new AutoValue_User(email, name);
  }

  public abstract String email();

  public abstract String name();
}
