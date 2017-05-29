package vn.tale.architecture;

import vn.tale.architecture.common.SchedulerObservableTransformer;
import vn.tale.architecture.common.SchedulerSingleTransformer;
import vn.tale.architecture.model.manager.UserModel;

import static org.mockito.Mockito.mock;

/**
 * Created by Giang Nguyen on 2/27/17.
 */

public class MockApplication extends App {

  private AppComponent appComponent;

  @Override public void onCreate() {
    super.onCreate();
    appComponent = DaggerTestAppComponent.builder()
        .appSingletonModule(new AppSingletonModule() {
          @Override public UserModel provideUserModel() {
            return mock(UserModel.class);
          }
        })
        .appModule(new AppModule() {
          @Override SchedulerObservableTransformer provideSchedulerObservableTransformer() {
            return SchedulerObservableTransformer.TEST;
          }

          @Override SchedulerSingleTransformer provideSchedulerSingleTransformer() {
            return SchedulerSingleTransformer.TEST;
          }
        })
        .build();
  }

  @Override public AppComponent getAppComponent() {
    return appComponent;
  }
}
