package cucumber.scratch.simple.webapp.page;

import cucumber.scratch.simple.webapp.domain.User;
import cucumber.scratch.simple.webapp.finder.Finders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SeleniumSignInPage implements SignInPage {

    private final Finders finders;

    @Autowired
    public SeleniumSignInPage(Finders finders) {
        this.finders = finders;
    }

    @Override
    public void signIn(User user) {
        finders.setTextByLabel("Username", user.getUsername());
        finders.setTextByLabel("Password", user.getPassword());
        finders.clickByValue("Sign In");
    }
}
