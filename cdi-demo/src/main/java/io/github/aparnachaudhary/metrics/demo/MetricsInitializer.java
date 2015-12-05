package io.github.aparnachaudhary.metrics.demo;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import com.mongodb.ServerAddress;
import io.github.aparnachaudhary.metrics.MongoDBReporter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import java.util.concurrent.TimeUnit;

/**
 * @author Aparna
 */
public class MetricsInitializer {

    @Produces
    @ApplicationScoped
    public MetricRegistry init() {
        // configure reporter
        MetricRegistry metricRegistry = new MetricRegistry();
        metricRegistry.register("jvm.attribute", new JvmAttributeGaugeSet());

        MongoDBReporter reporter = MongoDBReporter.forRegistry(metricRegistry)
                .serverAddresses(new ServerAddress[]{new ServerAddress("192.168.99.100", 32768)})
                .withDatabaseName("cdidemo")
                .prefixedWith("demo")
                .build();
        reporter.start(1, TimeUnit.MINUTES);
        return metricRegistry;
    }

}
