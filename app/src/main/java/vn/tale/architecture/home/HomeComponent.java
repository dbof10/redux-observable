package vn.tale.architecture.home;

import dagger.Subcomponent;
import vn.tale.architecture.ActivityScope;

/**
 * Created by Giang Nguyen on 3/27/17.
 */
@ActivityScope
@Subcomponent(modules = HomeModule.class)
public interface HomeComponent {
  void inject(HomeActivity topRepoListActivity);
}
