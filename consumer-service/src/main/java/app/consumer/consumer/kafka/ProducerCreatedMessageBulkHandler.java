package app.consumer.consumer.kafka;

import app.producer.api.producer.kafka.ProducerCreatedMessage;
import core.framework.kafka.BulkMessageHandler;
import core.framework.kafka.Message;
import core.framework.util.Strings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author zoo
 */
public class ProducerCreatedMessageBulkHandler implements BulkMessageHandler<ProducerCreatedMessage> {
    private final Logger logger = LoggerFactory.getLogger(ProducerCreatedMessageBulkHandler.class);

    @Override
    public void handle(List<Message<ProducerCreatedMessage>> messages) throws Exception {
        messages.forEach(message -> {
            logger.info(Strings.format("receive producer created message, id = {}, desc = {}, createdTime = {}",
                message.value.id, message.value.desc, message.value.createdTime));
        });
    }
}
