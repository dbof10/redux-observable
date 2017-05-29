package vn.tale.architecture.common;

import android.content.Context;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import vn.tale.architecture.login.LoginActivity;

import static org.mockito.Mockito.verify;

/**
 * Created by Giang Nguyen on 2/21/17.
 */
public class AppRouterTest {

  AppRouter tested;
  Context mockedContext;
  IntentFactory mockedIntentFactory;

  @Before
  public void setUp() throws Exception {
    mockedContext = Mockito.mock(Context.class);
    mockedIntentFactory = Mockito.mock(IntentFactory.class);
    tested = new AppRouter(mockedIntentFactory);
  }

  @Test
  public void should_return_loginIntent() throws Exception {
    tested.loginIntent(mockedContext);
    verify(mockedIntentFactory).create(mockedContext, LoginActivity.class);
  }
}