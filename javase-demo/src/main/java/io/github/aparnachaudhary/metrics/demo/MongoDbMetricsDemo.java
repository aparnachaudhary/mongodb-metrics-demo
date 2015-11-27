package io.github.aparnachaudhary.metrics.demo;

import com.codahale.metrics.JvmAttributeGaugeSet;
import com.codahale.metrics.MetricRegistry;
import com.mongodb.ServerAddress;
import io.github.aparnachaudhary.metrics.MongoDBReporter;

import java.util.concurrent.TimeUnit;

/**
 * Created by Aparna on 11/27/15.
 *
 * @author Aparna
 */
public class MongoDbMetricsDemo {

    public static void main(String[] args) {
        // configure reporter
        MetricRegistry metricRegistry = new MetricRegistry();
        metricRegistry.register("jvm.attribute", new JvmAttributeGaugeSet());

        MongoDBReporter reporter = MongoDBReporter.forRegistry(metricRegistry)
                .serverAddresses(new ServerAddress[]{new ServerAddress("192.168.99.100", 32768)})
                .withDatabaseName("javasedemo")
                .prefixedWith("javase")
                .build();
        // Report metrics every 5 seconds
        reporter.start(5, TimeUnit.SECONDS);

        // register metric
        metricRegistry.counter("demo.counter").inc();

        // sleep for 10 seconds so that metric is reported to MongoDB store
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }



    }
}
