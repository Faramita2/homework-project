package app.consumer.executor.service;

import core.framework.async.Executor;
import core.framework.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zoo
 */
public class ExecutorService {
    private final Logger logger = LoggerFactory.getLogger(ExecutorService.class);
    @Inject
    Executor executor;

    public void async() {
        executor.submit("async-task", () -> logger.info("current time = {}", LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE)));
    }
}
