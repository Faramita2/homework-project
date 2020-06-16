package app.consumer.job;

import core.framework.scheduler.Job;
import core.framework.scheduler.JobContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;

/**
 * @author zoo
 */
public class DemoJob implements Job {
    private final Logger logger = LoggerFactory.getLogger(DemoJob.class);
    @Override
    public void execute(JobContext context) throws Exception {
        logger.info("current time = {}", LocalDateTime.now());
    }
}
