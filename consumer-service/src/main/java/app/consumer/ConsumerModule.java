package app.consumer;

import app.consumer.consumer.kafka.ProducerCreatedMessageHandler;
import app.consumer.consumer.kafka.ProducerUpdatedMessageHandler;
import app.producer.api.producer.kafka.ProducerCreatedMessage;
import app.producer.api.producer.kafka.ProducerUpdatedMessage;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class ConsumerModule extends Module {
    @Override
    protected void initialize() {
        kafka().subscribe("producer-created", ProducerCreatedMessage.class, bind(ProducerCreatedMessageHandler.class));
        kafka().subscribe("producer-updated", ProducerUpdatedMessage.class, bind(ProducerUpdatedMessageHandler.class));
    }
}
