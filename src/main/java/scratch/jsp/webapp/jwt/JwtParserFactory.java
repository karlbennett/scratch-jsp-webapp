package scratch.jsp.webapp.jwt;

import io.jsonwebtoken.JwtParser;

public interface JwtParserFactory {
    JwtParser create();
}
