package scratch.jsp.webapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import scratch.jsp.webapp.controller.ProfileUserArgumentResolver;
import scratch.jsp.webapp.data.UserRepository;

import java.util.List;

@Configuration
public class ControllerConfiguration extends WebMvcConfigurerAdapter {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(new ProfileUserArgumentResolver(userRepository));
    }
}
