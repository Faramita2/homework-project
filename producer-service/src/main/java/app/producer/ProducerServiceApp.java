package app.producer;

import app.producer.api.producer.kafka.ProducerCreatedMessage;
import app.producer.api.producer.kafka.ProducerUpdatedMessage;
import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author zoo
 */
public class ProducerServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new ProducerModule());
    }
}
