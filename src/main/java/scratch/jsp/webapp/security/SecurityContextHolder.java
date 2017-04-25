package scratch.jsp.webapp.security;

import org.springframework.security.core.context.SecurityContext;

public interface SecurityContextHolder {

    SecurityContext getContext();
}
