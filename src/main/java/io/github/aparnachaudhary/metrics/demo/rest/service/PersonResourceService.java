package io.github.aparnachaudhary.metrics.demo.rest.service;

import io.github.aparnachaudhary.metrics.demo.PersonService;
import io.github.aparnachaudhary.metrics.demo.rest.api.PersonResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;

/**
 * @author Aparna
 */
@Stateless
public class PersonResourceService implements PersonResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonResourceService.class);

    @Inject
    private PersonService personService;

    @Override
    public Response get(String id) {
        return Response.ok(personService.getPerson(id)).build();
    }

    @Override
    public String sayHello() {
        return "Hello World!";
    }
}
