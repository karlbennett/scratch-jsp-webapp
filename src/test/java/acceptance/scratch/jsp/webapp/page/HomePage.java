package acceptance.scratch.jsp.webapp.page;

public interface HomePage {

    void visit();

    boolean isSignedIn(String username);

    boolean isSignedOut();

    void clickRegister();

    void clickSignIn();

    void clickSignOut();

    boolean isCurrentPage();

    String getUsername();

    void clickUsername(String username);
}
