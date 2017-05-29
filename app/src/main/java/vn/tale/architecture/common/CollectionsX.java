package vn.tale.architecture.common;

import android.support.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Giang Nguyen on 3/8/17.
 */

public final class CollectionsX {

  private CollectionsX() {
    //no instance
  }

  public static <T> List<T> concat(@NonNull List<T> list1, @NonNull List<T> list2) {
    final ArrayList<T> list = new ArrayList<>(list1.size() + list2.size());
    if (!list1.isEmpty()) {
      list.addAll(list1);
    }
    if (!list2.isEmpty()) {
      list.addAll(list2);
    }
    return list;
  }
}
