package vn.tale.architecture;

import javax.inject.Singleton;

import dagger.Component;
import vn.tale.architecture.counter.CounterComponent;
import vn.tale.architecture.counter.CounterModule;
import vn.tale.architecture.home.HomeComponent;
import vn.tale.architecture.home.HomeModule;
import vn.tale.architecture.login.LoginComponent;
import vn.tale.architecture.login.LoginModule;

@Singleton
@Component(modules = {
        AppSingletonModule.class,
        AppModule.class
})
public interface AppComponent {

    LoginComponent plus(LoginModule loginModule);

    HomeComponent plus(HomeModule homeModule);

    CounterComponent plus(CounterModule counterModule);
}
