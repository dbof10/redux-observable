package vn.tale.architecture.login;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import vn.tale.architecture.ActivityScope;
import vn.tale.architecture.common.EmailValidator;
import vn.tale.architecture.common.redux.Store;
import vn.tale.architecture.login.effect.CheckEmailEffect;
import vn.tale.architecture.login.effect.SubmitEffect;
import vn.tale.architecture.model.manager.UserModel;

/**
 * Created by Giang Nguyen on 2/27/17.
 */
@Module
public class LoginModule {

  @ActivityScope
  @Provides
  Store<LoginState> provideLoginStore(UserModel userModel,
      EmailValidator emailValidator) {
    return Store.<LoginState>builder()
        .initialState(LoginState.idle())
        .reducer(new LoginReducer())
        .effects(
            new CheckEmailEffect(emailValidator),
            new SubmitEffect(userModel)
        )
        .make();
  }

  @Provides LoginViewModel provideLoginRenderer(Store<LoginState> store) {
    final Observable<LoginState> state$ = store.state$()
        .observeOn(AndroidSchedulers.mainThread());
    return new LoginViewModel(state$);
  }
}
