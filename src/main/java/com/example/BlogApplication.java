package com.example;

import com.example.health.HelloWorldHealthCheck;
import com.example.resources.CoachResource;
import com.example.resources.FunRestResource;
import com.example.service.impl.CricketCoachService;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class BlogApplication extends Application<BlogConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BlogApplication().run(args);
    }

    @Override
    public void initialize(final Bootstrap<BlogConfiguration> bootstrap) {
    }

    @Override
    public void run(final BlogConfiguration configuration, final Environment environment) {
        environment.jersey().register(new FunRestResource());
        environment.jersey().register(new CoachResource(new CricketCoachService()));

        environment.healthChecks().register("hello", new HelloWorldHealthCheck());
    }

}
