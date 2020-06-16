package app.producer.producer.service;

import app.producer.api.producer.ProducerCreatedRequest;
import app.producer.api.producer.kafka.ProducerCreatedMessage;
import app.producer.api.producer.kafka.ProducerUpdatedMessage;
import core.framework.inject.Inject;
import core.framework.kafka.MessagePublisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author zoo
 */
public class ProducerService {
    private final Logger logger = LoggerFactory.getLogger(ProducerService.class);
    @Inject
    MessagePublisher<ProducerCreatedMessage> createdMessageMessagePublisher;
    @Inject
    MessagePublisher<ProducerUpdatedMessage> updatedMessageMessagePublisher;

    public void create(ProducerCreatedRequest request) {
        logger.info("===============start publish producer message===============");
        ProducerCreatedMessage createdMessage = new ProducerCreatedMessage();
        createdMessage.id = UUID.randomUUID().toString();

        createdMessage.desc = request.desc != null ? request.desc : "producer message created";
        createdMessage.createdTime = LocalDateTime.now();
        logger.info("created message, id = {}, desc = {}, createdTime = {}", createdMessage.id, createdMessage.desc, createdMessage.createdTime);
        createdMessageMessagePublisher.publish(createdMessage);

        ProducerUpdatedMessage updatedMessage = new ProducerUpdatedMessage();
        updatedMessage.id = UUID.randomUUID().toString();
        updatedMessage.desc = request.desc != null ? request.desc : "producer message updated";
        updatedMessage.updatedTime = LocalDateTime.now();
        logger.info("updated message, id = {}, desc = {}, createdTime = {}", updatedMessage.id, updatedMessage.desc, updatedMessage.updatedTime);
        updatedMessageMessagePublisher.publish(updatedMessage);
        logger.info("===============end publish producer message===============");
    }
}
