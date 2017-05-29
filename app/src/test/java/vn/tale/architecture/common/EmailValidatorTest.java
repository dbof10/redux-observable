package vn.tale.architecture.common;

import org.junit.Before;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Created by Giang Nguyen on 2/21/17.
 */
public class EmailValidatorTest {

  EmailValidator tested;

  @Before
  public void setUp() throws Exception {
    tested = new EmailValidator();
  }

  @Test
  public void should_return_false_when_email_is_null() throws Exception {
    assertThat(tested.isValid(null)).isFalse();
  }

  @Test
  public void should_return_false_when_email_is_invalid() throws Exception {
    assertThat(tested.isValid("abc")).isFalse();
  }
  @Test
  public void should_return_true_when_email_is_valid() throws Exception {
    assertThat(tested.isValid("foo@bar.com")).isTrue();
  }
}