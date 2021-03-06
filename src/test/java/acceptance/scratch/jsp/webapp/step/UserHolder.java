package acceptance.scratch.jsp.webapp.step;

import acceptance.scratch.jsp.webapp.domain.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("cucumber-glue")
public class UserHolder extends GenericHolder<User> {
}
