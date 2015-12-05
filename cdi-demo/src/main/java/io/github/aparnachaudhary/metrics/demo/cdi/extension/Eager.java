package io.github.aparnachaudhary.metrics.demo.cdi.extension;

import javax.inject.Qualifier;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Eager initialization.
 *
 * @author Aparna
 */
@Qualifier
@Target(value = {ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER, ElementType.TYPE})
@Retention(value = RetentionPolicy.RUNTIME)
public @interface Eager {
}
