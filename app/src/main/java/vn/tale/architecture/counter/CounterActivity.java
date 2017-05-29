package vn.tale.architecture.counter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.OnClick;
import javax.inject.Inject;
import vn.tale.architecture.App;
import vn.tale.architecture.R;
import vn.tale.architecture.R2;
import vn.tale.architecture.common.base.RvvmActivity;
import vn.tale.architecture.common.dagger.DaggerComponentFactory;
import vn.tale.architecture.common.redux.Store;
import vn.tale.architecture.counter.action.ChangeValueAction;

/**
 * Created by Giang Nguyen on 3/24/17.
 */

public class CounterActivity extends RvvmActivity<CounterComponent, CounterState> {

  @Inject Store<CounterState> store;
  @BindView(R2.id.tvValue) TextView tvValue;

  @Override protected void injectDependencies() {
    daggerComponent().inject(this);
  }

  @Override protected Store<CounterState> store() {
    return store;
  }

  @Override protected DaggerComponentFactory<CounterComponent> daggerComponentFactory() {
    return () -> App.get(this).getAppComponent().plus(new CounterModule());
  }

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);
    bindViews(this);
  }

  @OnClick(R2.id.increase) public void onIncreaseClick() {
    store.dispatch(ChangeValueAction.INCREASE);
  }

  @OnClick(R2.id.decrease) public void onDecreaseClick() {
    store.dispatch(ChangeValueAction.DECREASE);
  }

  @Override protected void onStart() {
    super.onStart();
    disposeOnStop(store.state$()
        .distinctUntilChanged()
        .subscribe((state) -> tvValue.setText(String.valueOf(state.value()))));
  }
}
