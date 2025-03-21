package util;

import io.smallrye.jwt.auth.principal.JWTParser;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.JsonWebToken;
import service.exception.JsonWebTokenException;

@RequestScoped
public class JwtUtil {
    @Inject
    JsonWebToken jwt;

    @Inject
    JWTParser parser;

    private final String SECRET = "FIUSABIBFIU213B2O8F732O8F23O87F2F2LU32A";

    public void validate() {
        System.out.println(jwt.getClaimNames());

        if (jwt.getClaimNames() == null) throw new JsonWebTokenException("blank");
    }
}