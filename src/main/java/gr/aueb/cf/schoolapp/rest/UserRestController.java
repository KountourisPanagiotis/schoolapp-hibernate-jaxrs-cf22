package gr.aueb.cf.schoolapp.rest;

import gr.aueb.cf.schoolapp.dto.UserCredentialsDTO;
import gr.aueb.cf.schoolapp.model.User;
import gr.aueb.cf.schoolapp.service.IUserService;
import gr.aueb.cf.schoolapp.service.exceptions.EntityAlreadyExistsException;
import gr.aueb.cf.schoolapp.service.exceptions.EntityNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserRestController {
    @Inject
    private IUserService userService;

    @Path("/")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsersByUsername(@QueryParam("username") String username) {
        List<User> users;
        try {
            users = userService.getUsersByUsername(username);
            List<UserCredentialsDTO> userCredentialsDTO = new ArrayList<>();
            for (User user : users) {
                userCredentialsDTO.add(map(user));
            }
            return Response.status(Response.Status.OK).entity(userCredentialsDTO).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("NOT FOUND").build();
        }
    }

    @Path("/{userId}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUser(@PathParam("userId") Long userId) {
        User user;
        try {
            user = userService.getUserById(userId);
            UserCredentialsDTO userCredentialsDTO = map(user);
            return Response.status(Response.Status.OK).entity(userCredentialsDTO).build();
        } catch (EntityNotFoundException e) {
            return Response.status(Response.Status.NOT_FOUND).entity("NOT FOUND").build();
        }
    }

    @Path("/")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUser(UserCredentialsDTO dto, @Context UriInfo uriInfo) {
        try {
            User user = userService.insertUser(dto);
            UserCredentialsDTO userDTO = map(user);
            UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
            return Response.created(uriBuilder.path(Long.toString(userDTO.getId())).build())
                    .entity(userDTO).build();
        } catch (EntityAlreadyExistsException e) {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("User already exists")
                    .build();
        }
    }

    @Path("/{userId}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUser(@PathParam("userId") Long userId) {
        try {
            User user = userService.getUserById(userId);
            userService.deleteUser(userId);
            UserCredentialsDTO userCredentialsDTO = map(user);
            return Response.status(Response.Status.OK).entity(userCredentialsDTO).build();
        } catch (EntityNotFoundException e1) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity("User Not Found")
                    .build();
        }
    }

    @Path("/{userId}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUser(@PathParam("userId") Long userId, UserCredentialsDTO dto) {
        try {
            dto.setId(userId);
            User user = userService.updateUser(dto);
            UserCredentialsDTO userCredentialsDTO = map(user);
            return Response.status(Response.Status.OK).entity(userCredentialsDTO).build();
        } catch (EntityNotFoundException e1) {
            return Response.status(Response.Status.NOT_FOUND).entity("User Not Found").build();
        }
    }

    private UserCredentialsDTO map(User user) {
        UserCredentialsDTO userCredentialsDTO = new UserCredentialsDTO();
        userCredentialsDTO.setId(user.getId());
        userCredentialsDTO.setUsername(user.getUsername());
        userCredentialsDTO.setPassword(user.getPassword());
        return userCredentialsDTO;
    }
}
