package app.producer;

import app.producer.api.ProducerWebService;
import app.producer.api.producer.kafka.ProducerCreatedMessage;
import app.producer.api.producer.kafka.ProducerUpdatedMessage;
import app.producer.producer.service.ProducerService;
import app.producer.producer.web.ProducerWebServiceImpl;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class ProducerModule extends Module {
    @Override
    protected void initialize() {
        kafka().publish("producer-created", ProducerCreatedMessage.class);
        kafka().publish("producer-updated", ProducerUpdatedMessage.class);
        bind(ProducerService.class);
        api().service(ProducerWebService.class, bind(ProducerWebServiceImpl.class));
    }
}
