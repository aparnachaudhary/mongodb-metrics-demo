package io.github.aparnachaudhary.metrics.demo.rest.service;

import io.github.aparnachaudhary.metrics.demo.Person;
import io.github.aparnachaudhary.metrics.demo.rest.api.PersonResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;

/**
 * @author Aparna
 */
@Stateless
public class PersonService implements PersonResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

    @Override
    public Person get(String id) {
        return null;
    }

    @Override
    public String sayHello() {
        return "Hello World!";
    }
}
