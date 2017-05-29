package vn.tale.architecture.common.util;

import android.widget.ImageView;

/**
 * Created by Giang Nguyen on 3/27/17.
 */

public interface ImageLoader {
  void cancel(ImageView imageView);

  void downloadInto(String url, ImageView imageView);
}
