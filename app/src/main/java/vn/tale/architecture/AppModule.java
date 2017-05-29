package vn.tale.architecture;

import dagger.Module;
import dagger.Provides;
import io.reactivex.ObservableTransformer;
import io.reactivex.SingleTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import vn.tale.architecture.common.EmailValidator;
import vn.tale.architecture.common.SchedulerObservableTransformer;
import vn.tale.architecture.common.SchedulerSingleTransformer;
import vn.tale.architecture.common.util.ImageLoader;

/**
 * Created by Giang Nguyen on 2/27/17.
 */
@Module class AppModule {

  @Provides EmailValidator emailValidator() {
    return new EmailValidator();
  }

  @Provides
  SchedulerObservableTransformer provideSchedulerObservableTransformer() {
    return new SchedulerObservableTransformer() {
      @SuppressWarnings("unchecked")
      @Override public <T> ObservableTransformer<T, T> transformer() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }

  @Provides
  SchedulerSingleTransformer provideSchedulerSingleTransformer() {
    return new SchedulerSingleTransformer() {
      @SuppressWarnings("unchecked")
      @Override public <T> SingleTransformer<T, T> transformer() {
        return upstream -> upstream.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread());
      }
    };
  }

  @Provides ImageLoader provideImageLoader() {
    return new GlideImageLoader();
  }
}
