package scratch.jsp.webapp.domain;

import acceptance.scratch.jsp.webapp.domain.RandomUserFactory;
import acceptance.scratch.jsp.webapp.domain.User;
import org.junit.Before;
import org.junit.Test;
import scratch.jsp.webapp.data.UserRepository;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static shiver.me.timbers.data.random.RandomStrings.someString;

public class RandomUserFactoryTest {

    private RandomUserFactory factory;
    private UserRepository userRepository;

    @Before
    public void setUp() {
        userRepository = mock(UserRepository.class);
        factory = new RandomUserFactory(userRepository);
    }

    @Test
    public void Can_create_a_random_new_user() {

        // When
        final User actual = factory.createNew();

        // Then
        assertThat(actual.getUsername().length(), allOf(greaterThan(0), lessThanOrEqualTo(10)));
        assertThat(actual.getPassword().length(), allOf(greaterThan(0), lessThanOrEqualTo(255)));
    }

    @Test
    public void Can_create_a_random_existing_user() {

        final scratch.jsp.webapp.domain.User user = mock(scratch.jsp.webapp.domain.User.class);

        final String username = someString();
        final String password = someString();

        // Given
        given(userRepository.save(any(scratch.jsp.webapp.domain.User.class))).willReturn(user);
        given(user.getUsername()).willReturn(username);
        given(user.getPassword()).willReturn(password);

        // When
        final User actual = factory.createExisting();

        // Then
        assertThat(actual.getUsername(), is(username));
        assertThat(actual.getPassword(), is(password));
    }
}