package app.consumer.consumer.kafka;

import app.producer.api.producer.kafka.ProducerUpdatedMessage;
import core.framework.kafka.MessageHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zoo
 */
public class ProducerUpdatedMessageHandler implements MessageHandler<ProducerUpdatedMessage> {
    private final Logger logger = LoggerFactory.getLogger(ProducerUpdatedMessageHandler.class);

    @Override
    public void handle(String key, ProducerUpdatedMessage value) throws Exception {
        logger.info("receive producer created message, id = {} , desc = {}, createdTime = {}", value.id, value.desc, value.updatedTime);
    }
}
