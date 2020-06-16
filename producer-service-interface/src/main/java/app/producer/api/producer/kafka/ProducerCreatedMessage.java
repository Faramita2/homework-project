package app.producer.api.producer.kafka;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

import java.time.LocalDateTime;

/**
 * @author zoo
 */
public class ProducerCreatedMessage {
    @NotNull
    @Property(name = "id")
    public String id;

    @Property(name = "desc")
    public String desc;

    @NotNull
    @Property(name = "created_time")
    public LocalDateTime createdTime;
}
