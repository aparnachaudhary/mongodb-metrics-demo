package io.github.aparnachaudhary.metrics.demo.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Aparna
 */
@Path("persons")
public interface PersonResource {

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    Response get(@PathParam("id") String id);

    @GET
    @Path("/test/greet")
    String sayHello();
}
