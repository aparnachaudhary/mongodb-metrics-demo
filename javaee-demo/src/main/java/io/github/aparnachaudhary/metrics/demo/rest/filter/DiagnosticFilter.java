package io.github.aparnachaudhary.metrics.demo.rest.filter;

import com.codahale.metrics.MetricRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

/**
 * @author Aparna
 */
@Provider
public class DiagnosticFilter implements ContainerRequestFilter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DiagnosticFilter.class);

    @Inject
    private MetricRegistry metricRegistry;

    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        String path = containerRequestContext.getUriInfo().getAbsolutePath().getPath();
        LOGGER.info("Invoking request {}", path);
        metricRegistry.counter(path).inc();
        LOGGER.info("Finished request {}", path);
    }
}
