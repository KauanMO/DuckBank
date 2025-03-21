package resource;

import entity.dto.user.LoginDTO;
import entity.dto.user.OutUserDTO;
import entity.dto.user.RegisterUserDTO;
import entity.model.Group;
import entity.model.UserGroup;
import io.smallrye.jwt.algorithm.SignatureAlgorithm;
import io.smallrye.jwt.build.Jwt;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import entity.model.User;
import jakarta.ws.rs.core.SecurityContext;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jose4j.lang.StringUtil;
import service.UserService;
import util.JwtUtil;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Path("users")
public class UserResource {
    @Inject
    JwtUtil jwt;

    @Inject
    UserService service;

    @POST
    public Response registerUser(RegisterUserDTO dto) {
        User newUser = service.registerUser(dto);

        return Response.ok(new OutUserDTO(newUser)).build();
    }

    @GET
    @Path("{name}")
//    @RolesAllowed("admin")
    public Response getUserByName(@PathParam("name") String name) {
        System.out.println("teste");

        List<User> usersFound = service.getUsersByName(name);

        return Response.ok().build();
    }

    @POST
    @PermitAll
    @Path("login")
    public Response loginUser(LoginDTO dto) {
        User userFound = service.findByCPF(dto.cpf());

        Set<String> userGroups = userFound
                .getUserGroups()
                .stream()
                .map(ug -> ug.getGroup()
                        .getName())
                .collect(Collectors.toSet());

        var jwt = Jwt
                .claims(Map.of("userId", userFound.getId()))
                .issuer("duckbank")
                .groups(userGroups)
                .jws()
                .sign();

        return Response
                .ok(Map.of("jwt", jwt, "user", new OutUserDTO(userFound)))
                .build();
    }
}