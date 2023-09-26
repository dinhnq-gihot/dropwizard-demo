package com.example.resources;

import jakarta.ws.rs.core.MediaType;

import com.codahale.metrics.annotation.Timed;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

@Path("hello-world")
@Produces(MediaType.APPLICATION_JSON)
public class FunRestResource {
    @GET
    @Timed
    public String sayHello() {
        return "Hello World";
    }
}
