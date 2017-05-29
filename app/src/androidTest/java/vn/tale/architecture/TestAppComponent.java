package vn.tale.architecture;

import dagger.Component;
import javax.inject.Singleton;

/**
 * Created by Giang Nguyen on 2/27/17.
 */
@Singleton
@Component(modules = {
    AppSingletonModule.class,
    AppModule.class
})
public interface TestAppComponent extends AppComponent {

  void inject(LoginTest loginTest);
}
