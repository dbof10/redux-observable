package vn.tale.architecture.common.dagger;

import android.support.v7.app.AppCompatActivity;
import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Giang Nguyen on 3/21/17.
 */
public class DaggerLifecycleDelegateTest {

  private DaggerComponentFactory mockedDaggerComponentFactory;
  private DaggerLifecycleDelegate<Object> tested;
  private AppCompatActivity mockedAppCompatActivity;
  private Object mockedDaggerComponent;

  @Before
  public void setUp() throws Exception {
    mockedDaggerComponentFactory = mock(DaggerComponentFactory.class);
    mockedDaggerComponent = mock(Object.class);
    mockedAppCompatActivity = mock(AppCompatActivity.class);

    when(mockedDaggerComponentFactory.makeComponent()).thenReturn(mockedDaggerComponent);

    tested = new DaggerLifecycleDelegate<>(mockedDaggerComponentFactory);
  }

  @Test
  public void onCreate_THEN_create_dagger_component_from_factory() throws Exception {
    tested.onCreate(mockedAppCompatActivity);

    assertThat(tested.daggerComponent()).isEqualTo(mockedDaggerComponent);
  }

  @Test
  public void reCreate_THEN_restore_dagger_component()
      throws Exception {

    final Object daggerComponent = new Object();
    when(mockedAppCompatActivity.getLastCustomNonConfigurationInstance())
        .thenReturn(daggerComponent);

    tested.onCreate(mockedAppCompatActivity);

    assertThat(tested.daggerComponent()).isEqualTo(daggerComponent);
  }

  @Test
  public void onRetainCustomNonConfigurationInstance_THEN_return_dagger_component()
      throws Exception {

    assertThat(tested.onRetainCustomNonConfigurationInstance()).isEqualTo(tested.daggerComponent);
  }

  @Test
  public void daggerComponent_THEN_return_dagger_component() throws Exception {

    assertThat(tested.daggerComponent()).isEqualTo(tested.daggerComponent);
  }
}