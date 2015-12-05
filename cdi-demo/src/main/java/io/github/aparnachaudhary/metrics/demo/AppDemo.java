package io.github.aparnachaudhary.metrics.demo;

import io.github.aparnachaudhary.metrics.demo.cdi.extension.Eager;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

/**
 * Application bootstrap to invoke the personService on startup.
 */
@ApplicationScoped
@Eager
public class AppDemo {

    @Inject
    private PersonService personService;

    @PostConstruct
    protected void initialize() {
        personService.getPerson();
    }
}
