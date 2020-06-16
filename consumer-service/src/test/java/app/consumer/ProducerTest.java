package app.consumer;

import app.consumer.executor.service.ExecutorService;
import core.framework.inject.Inject;
import org.junit.jupiter.api.Test;

/**
 * @author zoo
 */
public class ProducerTest extends IntegrationTest {
    @Inject
    ExecutorService service;

    @Test
    public void async() {
        service.async();
    }
}
