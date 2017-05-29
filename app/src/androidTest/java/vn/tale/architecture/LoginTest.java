package vn.tale.architecture;

import android.app.Instrumentation;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import io.reactivex.Single;
import javax.inject.Inject;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import vn.tale.architecture.login.LoginActivity;
import vn.tale.architecture.model.User;
import vn.tale.architecture.model.error.AuthenticateError;
import vn.tale.architecture.model.manager.UserModel;

import static android.support.test.espresso.Espresso.closeSoftKeyboard;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Giang Nguyen on 2/27/17.
 */
@RunWith(AndroidJUnit4.class)
public class LoginTest {

  private static final String INVALID_EMAIL = "foo@bar";
  private static final String VALID_EMAIL = "foo@tiki.vn";
  private static final String VALID_PASSWORD = "123456";
  private static final String INVALID_PASSWORD = "123";

  @Rule public ActivityTestRule<LoginActivity> activityTestRule = new ActivityTestRule<>(
      LoginActivity.class,
      true,
      true);

  @Inject UserModel mockedUserModel;

  @Before
  public void setUp() throws Exception {
    Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
    App app = (App) instrumentation.getTargetContext().getApplicationContext();
    ((TestAppComponent) app.getAppComponent()).inject(this);

    when(mockedUserModel.login(eq(VALID_EMAIL), eq(VALID_PASSWORD)))
        .thenReturn(Single.just(mock(User.class)));
    when(mockedUserModel.login(eq(VALID_EMAIL), eq(INVALID_PASSWORD)))
        .thenReturn(Single.error(new AuthenticateError()));
  }

  @Test
  public void should_disable_login_button_by_default() throws Exception {
    loginScreen()
        .assertLoginView()
        .loginButtonDisabled();
  }

  @Test
  public void should_validate_invalid_email_realtime() throws Exception {
    loginScreen()
        .inputEmail(INVALID_EMAIL)
        .assertLoginView()
        .invalidEmailMessageShowed();
  }

  @Test
  public void should_validate_valid_email_realtime() throws Exception {
    loginScreen()
        .inputEmail(VALID_EMAIL)
        .assertLoginView()
        .invalidEmailMessageNotShowed()
        .loginButtonEnabled();
  }

  @Test
  public void should_show_error_when_login_fail() throws Exception {
    loginScreen()
        .inputEmail(VALID_EMAIL)
        .inputPassword(INVALID_PASSWORD)
        .submit()
        .assertLoginView()
        .loginFailMessageShowed();
  }

  @Test
  public void should_hide_when_login_success() throws Exception {
    loginScreen()
        .inputEmail(VALID_EMAIL)
        .inputPassword(VALID_PASSWORD)
        .submit()
        .assertLoginView()
        .loginSuccessMessageShowed()
        .hidden();
  }

  private LoginRobot loginScreen() {
    return new LoginRobot();
  }

  private static class LoginRobot {

    LoginRobot inputEmail(String email) {
      onView(withId(R2.id.etEmail))
          .perform(ViewActions.typeText(email));
      return this;
    }

    LoginRobot inputPassword(String password) {
      closeSoftKeyboard();
      onView(withId(R2.id.etPassword))
          .perform(ViewActions.typeText(password));
      return this;
    }

    LoginRobot submit() {
      closeSoftKeyboard();
      onView(withText(R.string.sign_in))
          .perform(click());
      return this;
    }

    LoginAssertion assertLoginView() {
      closeSoftKeyboard();
      return new LoginAssertion();
    }
  }

  private static class LoginAssertion {

    LoginAssertion invalidEmailMessageShowed() {
      onView(withText(R.string.email_is_invalid))
          .check(matches(isDisplayed()));
      return this;
    }

    LoginAssertion invalidEmailMessageNotShowed() {
      onView(withText(R.string.email_is_invalid))
          .check(doesNotExist());
      return this;
    }

    LoginAssertion loginFailMessageShowed() {
      onView(withText(R.string.email_and_password_are_mismatched))
          .check(matches(isDisplayed()));
      return this;
    }

    LoginAssertion loginSuccessMessageShowed() {
      onView(withText(R.string.successfully))
          .check(matches(isDisplayed()));
      return this;
    }

    LoginAssertion loginButtonEnabled() {
      onView(withText(R.string.sign_in))
          .check(matches(isEnabled()));
      return this;
    }

    LoginAssertion loginButtonDisabled() {
      onView(withText(R.string.sign_in))
          .check(matches(not(isEnabled())));
      return this;
    }

    void hidden() {
    }
  }
}
