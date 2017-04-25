package scratch.jsp.webapp.jwt;

import io.jsonwebtoken.JwtBuilder;

public interface JwtBuilderFactory {
    JwtBuilder create();
}
