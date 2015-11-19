package io.github.aparnachaudhary.metrics.demo;

import com.codahale.metrics.annotation.Counted;
import com.codahale.metrics.annotation.Timed;

/**
 * @author Aparna
 */
public class PersonService {

    @Timed(name = "get.timed")
    @Counted(name = "get.counted")
    public Person getPerson(String id) {
        return new Person(1L, "Aparna", "Chaudhary");
    }
}
