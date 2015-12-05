package io.github.aparnachaudhary.metrics.demo.cdi.extension;

import io.github.aparnachaudhary.metrics.demo.cdi.extension.Eager;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.spi.AfterDeploymentValidation;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.Extension;
import javax.enterprise.util.AnnotationLiteral;

/**
 * CDI extenstion to eager initialize ApplicationScoped beans.
 *
 * @author Aparna
 */
public class EagerExtension implements Extension {

    public void afterDeploymentValidation(@Observes AfterDeploymentValidation event, BeanManager beanManager) {
        beanManager.getBeans(Object.class, new AnnotationLiteral<Eager>() {
        }).parallelStream().filter(bean -> bean.getBeanClass().isAnnotationPresent(ApplicationScoped.class)).forEach(bean -> {
            beanManager.getReference(bean, bean.getBeanClass(), beanManager.createCreationalContext(bean)).toString();
        });
    }
}
