package com.example.resources;

import java.util.OptionalLong;

import com.codahale.metrics.annotation.Timed;
import com.example.entity.UserEntity;
import com.example.service.IUserService;

import io.dropwizard.hibernate.UnitOfWork;
import jakarta.validation.Valid;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("user")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private IUserService service;

    public UserResource(IUserService service) {
        this.service = service;
    }

    @GET
    @Path("/{id}")
    @Timed
    @UnitOfWork
    public UserEntity getUserById(@PathParam("id") OptionalLong id) {
        return service.getUserById(id.getAsLong());
    }

    @POST
    @Path("")
    @Timed
    @UnitOfWork
    public UserEntity createUser(@Valid UserEntity userEntity) {
        return service.createUser(userEntity);
    }
}
