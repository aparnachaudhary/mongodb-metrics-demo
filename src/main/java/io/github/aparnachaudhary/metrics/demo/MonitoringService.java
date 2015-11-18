package io.github.aparnachaudhary.metrics.demo;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import com.mongodb.ServerAddress;
import io.github.aparnachaudhary.metrics.MongoDBReporter;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.enterprise.inject.Produces;
import java.util.concurrent.TimeUnit;

/**
 * @author Aparna
 */
@Singleton
@Startup
public class MonitoringService {

    @Produces
    private static MetricRegistry metricRegistry;

    @PostConstruct
    public void init() {
        // configure reporter
        metricRegistry = new MetricRegistry();
        metricRegistry.register("jvm.attribute", new JvmAttributeGaugeSet());

        MongoDBReporter reporter = MongoDBReporter.forRegistry(metricRegistry)
                .serverAddresses(new ServerAddress[]{new ServerAddress("192.168.99.100", 32768)})
                .withDatabaseName("metricstore")
                .prefixedWith("demo")
                .build();
        reporter.start(1, TimeUnit.MINUTES);
    }

}
