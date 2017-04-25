package scratch.jsp.webapp.security;

import org.springframework.security.core.userdetails.UserDetails;
import scratch.jsp.webapp.domain.User;

public interface UserDetailsFactory {

    UserDetails create(User user);
}
