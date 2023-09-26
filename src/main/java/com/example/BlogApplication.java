package com.example;

import com.example.health.HelloWorldHealthCheck;
import com.example.resources.FunRestResource;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class BlogApplication extends Application<BlogConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BlogApplication().run(args);
    }

    @Override
    public String getName() {
        return "Blog";
    }

    @Override
    public void initialize(final Bootstrap<BlogConfiguration> bootstrap) {
    }

    @Override
    public void run(final BlogConfiguration configuration, final Environment environment) {
        environment.jersey().register(new FunRestResource());
        environment.healthChecks().register("hello", new HelloWorldHealthCheck());
    }

}
