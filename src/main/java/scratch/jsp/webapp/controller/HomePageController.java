package scratch.jsp.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomePageController extends HasUsernameController {

    public HomePageController() {
        super("homepage");
    }
}
