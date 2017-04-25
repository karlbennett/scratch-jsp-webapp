package scratch.jsp.webapp.jwt;

public interface JwtDecoder {
    String decodeUsername(String jwtToken);
}
