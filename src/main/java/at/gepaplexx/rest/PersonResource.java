package at.gepaplexx.rest;

import at.gepaplexx.domain.Person;
import at.gepaplexx.service.PersonService;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
public class PersonResource {

    @Inject
    Logger logger;

    @Inject
    PersonService personService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getAll() {
        logger.info("read all person entities...");
        return personService.findAll();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response savePerson(Person person) {
        logger.info("persisting new person...");
        personService.createNew(person);
        logger.infof("persisted person: %s", person);
        return Response.ok(person).build();
    }

    @POST
    @Path("/initialize")
    @Produces(MediaType.APPLICATION_JSON)
    public Response generateTestData() {
        logger.info("generating some testdata...");
        personService.initialize();
        return Response.ok(getAll()).build();
    }
}
