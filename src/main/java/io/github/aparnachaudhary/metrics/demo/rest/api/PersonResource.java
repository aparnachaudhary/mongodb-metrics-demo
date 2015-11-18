package io.github.aparnachaudhary.metrics.demo.rest.api;

import io.github.aparnachaudhary.metrics.demo.Person;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Created by Aparna on 11/18/15.
 */
@Path("persons")
public interface PersonResource {

    @GET
    Person get(@PathParam("id") String id);

    @GET
    @Path("greet") String sayHello();
}
