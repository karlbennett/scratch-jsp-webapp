package scratch.jsp.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signIn")
public class SignInController extends HasUsernameController {

    public SignInController() {
        super("signIn");
    }
}
