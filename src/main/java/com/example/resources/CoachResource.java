package com.example.resources;

import com.codahale.metrics.annotation.Timed;
import com.example.service.CoachService;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/coach")
@Produces(MediaType.APPLICATION_JSON)
public class CoachResource {
    private CoachService coach;

    public CoachResource(CoachService service) {
        this.coach = service;
    }

    @GET
    @Timed
    public String getDailyWorkout() {
        System.out.println("aaaaaaaaaaa");
        return coach.getDailyWorkout();
    }
}
