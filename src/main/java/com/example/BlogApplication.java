package com.example;

import com.example.db.UserDAO;
import com.example.entity.UserEntity;
import com.example.health.HelloWorldHealthCheck;
import com.example.resources.FunRestResource;
import com.example.resources.UserResource;
import com.example.service.impl.UserServiceImpl;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;

public class BlogApplication extends Application<BlogConfiguration> {

    public static void main(final String[] args) throws Exception {
        new BlogApplication().run(args);
    }

    private final HibernateBundle<BlogConfiguration> hibernateBundle = new HibernateBundle<BlogConfiguration>(
            UserEntity.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(BlogConfiguration configuration) {
            return configuration.getDataSourceFactory();
        }
    };

    @Override
    public void initialize(final Bootstrap<BlogConfiguration> bootstrap) {
        bootstrap.addBundle(hibernateBundle);
        
        
    }

    @Override
    public void run(final BlogConfiguration configuration, final Environment environment) {
        // DAO
        final UserDAO dao = new UserDAO(hibernateBundle.getSessionFactory());

        // Resource
        environment.jersey().register(new FunRestResource());
        environment.jersey().register(new UserResource(new UserServiceImpl(dao)));

        environment.healthChecks().register("hello", new HelloWorldHealthCheck());
    }
}
