package scratch.jsp.webapp.page;

import cucumber.scratch.jsp.webapp.finder.Finders;
import cucumber.scratch.jsp.webapp.page.SeleniumRegistrationSuccessPage;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class SeleniumRegistrationSuccessPageTest {

    private Finders finders;
    private SeleniumRegistrationSuccessPage page;

    @Before
    public void setUp() {
        finders = mock(Finders.class);
        page = new SeleniumRegistrationSuccessPage(finders);
    }

    @Test
    public void Can_get_the_welcome() {

        final String expected = someString();

        // Given
        given(finders.findTextByClassName("main-heading")).willReturn(expected);

        // When
        final String actual = page.getWelcome();

        // Then
        assertThat(actual, is(expected));
    }

    @Test
    public void Can_get_the_message() {

        final String expected = someString();

        // Given
        given(finders.findTextByClassName("registration-success-message")).willReturn(expected);

        // When
        final String actual = page.getMessage();

        // Then
        assertThat(actual, is(expected));
    }
}