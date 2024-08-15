package org.example;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import org.example.controllers.ProjectController;
import org.example.daos.ClientDao;
import org.example.daos.ProjectDao;
import org.example.services.ClientService;
import org.example.services.ProjectService;
import org.example.validators.ProjectValidator;
import io.jsonwebtoken.Jwts;
import org.example.controllers.AuthController;
import org.example.daos.AuthDao;
import org.example.services.AuthService;
import org.example.validators.AuthValidator;

import java.security.Key;

public class TestApplication extends Application<TestConfiguration> {
    public static void main(final String[] args) throws Exception {
        new TestApplication().run(args);
    }
    @Override
    public String getName() {
        return "Test";
    }
    @Override
    public void initialize(final Bootstrap<TestConfiguration> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(
                    final TestConfiguration configuration) {
                return configuration.getSwagger();
            }
        });
    }
    @Override
    public void run(final TestConfiguration configuration,
                    final Environment environment) {
        Key jwtKey = Jwts.SIG.HS256.key().build();
        environment.jersey()
                .register(new ProjectController(
                        new ProjectService(new ProjectDao(),
                                new ProjectValidator(new ClientService(
                                        new ClientDao())))));
        environment.jersey().register(new AuthController(new AuthService(
                new AuthDao(), new AuthValidator(), jwtKey)));
    }

}
