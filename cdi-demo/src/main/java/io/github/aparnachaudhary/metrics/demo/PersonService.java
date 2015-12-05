package io.github.aparnachaudhary.metrics.demo;

import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Timed;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Aparna
 */
@RequestScoped
@Named("personService")
public class PersonService {

    @Timed(name = "get.timed")
    @Counted(name = "get.counted")
    public Person getPerson() {
        return new Person(1L, "Aparna", "Chaudhary");
    }
}
