package at.gepaplexx.rest;

import at.gepaplexx.domain.Configuration;
import at.gepaplexx.service.ConfigurationService;
import at.gepaplexx.service.EnvironmentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.InternalServerErrorException;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
public class ConfigurationResource {

    @Inject
    Logger logger;

    @Inject
    ConfigurationService config;

    @Inject
    EnvironmentService env;

    @Inject
    ObjectMapper objectMapper;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String get() {
        logger.info("reading current configuration and environment...");
        try {
            var configuration = objectMapper.writeValueAsString(config.getConfiguration());
            logger.debugf("current configuration: %s", configuration);
            var environment = objectMapper.writeValueAsString(env.getEnvironmentVars());
            logger.debugf("current environment: %s", environment);
            return "{ \"Configuration\": %s, \"Environment\": %s }".formatted(configuration, environment);
        } catch (JsonProcessingException e) {
            logger.error(e);
            throw new InternalServerErrorException("failed to parse json object...");
        }
    }

    @GET
    @Path("/config")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Configuration> config() {
        logger.info("reading current configuration...");
        return config.getConfiguration();
    }

    @GET
    @Path("/env")
    @Produces(MediaType.APPLICATION_JSON)
    public String env() {
        logger.info("reading current environment...");
        try {
            return objectMapper.writeValueAsString(env.getEnvironmentVars());
        } catch (JsonProcessingException e) {
            logger.error(e);
            throw new InternalServerErrorException("failed to parse json object...");
        }
    }
}
