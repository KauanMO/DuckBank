package service.exception;

import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

public class GlobalExceptionMapper {
    @ServerExceptionMapper
    public Response exception(JsonWebTokenException e) {
        return Response
                .status(Response.Status.UNAUTHORIZED)
                .entity(e.getMessage())
                .build();
    }
}
