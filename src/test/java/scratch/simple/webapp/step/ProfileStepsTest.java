package scratch.simple.webapp.step;

import cucumber.scratch.simple.webapp.domain.User;
import cucumber.scratch.simple.webapp.page.HomePage;
import cucumber.scratch.simple.webapp.page.ProfilePage;
import cucumber.scratch.simple.webapp.step.ProfileSteps;
import cucumber.scratch.simple.webapp.step.UserHolder;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class ProfileStepsTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private ProfilePage profilePage;
    private UserHolder userHolder;
    private ProfileSteps steps;
    private HomePage homePage;

    @Before
    public void setUp() {
        profilePage = mock(ProfilePage.class);
        userHolder = mock(UserHolder.class);
        homePage = mock(HomePage.class);
        steps = new ProfileSteps(homePage, profilePage, userHolder);
    }

    @Test
    public void Can_view_the_profile_page() {

        final String username = someString();
        final User user = mock(User.class);

        // Given
        given(profilePage.getUsername()).willReturn(username);
        given(userHolder.get()).willReturn(user);
        given(user.getUsername()).willReturn(username);

        // When
        steps.I_view_my_profile();

        // Then
        verify(homePage).clickUsername(username);
    }

    @Test
    public void Can_check_the_profile_details_are_correct() {

        final String username = someString();
        final User user = mock(User.class);

        // Given
        given(profilePage.getUsername()).willReturn(username);
        given(userHolder.get()).willReturn(user);
        given(user.getUsername()).willReturn(username);

        // When
        steps.I_should_see_my_details();

        // Then
        verify(profilePage).getUsername();
        verify(user).getUsername();
    }

    @Test
    public void Can_check_the_profile_details_are_incorrect() {

        final User user = mock(User.class);

        // Given
        given(profilePage.getUsername()).willReturn(someString());
        given(userHolder.get()).willReturn(user);
        given(user.getUsername()).willReturn(someString());
        expectedException.expect(AssertionError.class);

        // When
        steps.I_should_see_my_details();
    }
}