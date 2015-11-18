package io.github.aparnachaudhary.metrics.demo.rest.service;

import com.codahale.metrics.Metric;
import com.codahale.metrics.MetricRegistry;
import io.github.aparnachaudhary.metrics.demo.rest.api.MetricsResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import java.util.Map;

/**
 * @author Aparna
 */
@Stateless
public class MetricsService implements MetricsResource {

    private static final Logger LOGGER = LoggerFactory.getLogger(MetricsService.class);

    @Inject
    private MetricRegistry metricRegistry;

    public Response get() {
        Map<String, Metric> metrics = metricRegistry.getMetrics();
        return Response.ok(metrics).build();
    }
}
