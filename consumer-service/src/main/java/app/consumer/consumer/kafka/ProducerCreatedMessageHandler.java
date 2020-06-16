package app.consumer.consumer.kafka;

import app.producer.api.producer.kafka.ProducerCreatedMessage;
import core.framework.kafka.MessageHandler;
import core.framework.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zoo
 */
public class ProducerCreatedMessageHandler implements MessageHandler<ProducerCreatedMessage> {
    private final Logger logger = LoggerFactory.getLogger(ProducerCreatedMessageHandler.class);

    @Override
    public void handle(String key, ProducerCreatedMessage value) {
        logger.info(
            Strings.format("receive producer created message, id = {}, desc = {}, createdTime = {}",
                value.id, value.desc, value.createdTime));
    }
}
