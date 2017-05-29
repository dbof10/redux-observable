package vn.tale.architecture.common;

import java.util.Arrays;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Giang Nguyen on 3/8/17.
 */
public class CollectionsXTest {
  @Test
  public void should_return_concatenated_list() throws Exception {
    assertThat(CollectionsX.concat(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6)))
        .isEqualTo(Arrays.asList(1, 2, 3, 4, 5, 6));
  }
}