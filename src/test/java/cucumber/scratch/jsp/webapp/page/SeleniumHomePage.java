package cucumber.scratch.jsp.webapp.page;

import cucumber.scratch.jsp.webapp.finder.Finders;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import static java.lang.String.format;

@Component
public class SeleniumHomePage implements HomePage {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private final WebDriver driver;
    private final String homePageUrl;
    private final Finders finders;

    @Autowired
    public SeleniumHomePage(WebDriver driver, @Value("${home.page.url}") String homePageUrl, Finders finders) {
        this.driver = driver;
        this.homePageUrl = homePageUrl;
        this.finders = finders;
    }

    @Override
    public void visit() {
        driver.get(homePageUrl);
    }

    @Override
    public boolean isSignedIn(String username) {
        try {
            finders.findByText("a", username);
            return true;
        } catch (NoSuchElementException e) {
            log.warn(format("Not signed in as %s.", username), e);
            return false;
        }
    }

    @Override
    public boolean isSignedOut() {
        try {
            finders.findByText("a", "Sign In");
            return true;
        } catch (NoSuchElementException e) {
            log.warn("Not signed out.", e);
            return false;
        }
    }

    @Override
    public void clickRegister() {
        clickLinkByText("Register");
    }

    @Override
    public void clickSignIn() {
        clickLinkByText("Sign In");
    }

    @Override
    public void clickSignOut() {
        clickLinkByText("Sign Out");
    }

    @Override
    public boolean isCurrentPage() {
        return "Simple Webapp (Home)".equals(driver.getTitle());
    }

    @Override
    public String getUsername() {
        return finders.findByClassName("username").getText();
    }

    @Override
    public void clickUsername(String username) {
        finders.clickByText("a", username);
    }

    private void clickLinkByText(String text) {
        finders.clickByText("a", text);
    }
}
