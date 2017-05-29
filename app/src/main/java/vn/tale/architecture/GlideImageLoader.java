package vn.tale.architecture;

import android.support.annotation.NonNull;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import vn.tale.architecture.common.util.ImageLoader;

class GlideImageLoader implements ImageLoader {

  @Override public void cancel(@NonNull ImageView imageView) {
    Glide.clear(imageView);
  }

  @Override public void downloadInto(@NonNull String url, @NonNull ImageView imageView) {
    Glide.with(imageView.getContext())
        .load(url)
        .placeholder(R.drawable.ic_placeholder_24dp)
        .into(imageView);
  }
}