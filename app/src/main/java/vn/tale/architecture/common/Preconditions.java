package vn.tale.architecture.common;

import android.support.annotation.RestrictTo;

import static android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP;

@RestrictTo(LIBRARY_GROUP)
public final class Preconditions {
  private Preconditions() {
    throw new AssertionError("No instances.");
  }

  public static void checkNotNull(Object value) {
    if (value == null) {
      throw new NullPointerException();
    }
  }

  public static void checkNotNull(Object value, String message) {
    if (value == null) {
      throw new NullPointerException(message);
    }
  }

  public static void checkNotEmpty(Object[] array, String message) {
    if (array.length == 0) {
      throw new IllegalArgumentException(message);
    }
  }
}