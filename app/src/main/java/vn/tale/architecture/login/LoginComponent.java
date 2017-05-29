package vn.tale.architecture.login;

import dagger.Subcomponent;
import vn.tale.architecture.ActivityScope;

/**
 * Created by Giang Nguyen on 2/21/17.
 */
@ActivityScope
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {

  void inject(LoginActivity loginActivity);
}
