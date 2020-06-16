package app.consumer;

import app.consumer.executor.service.ExecutorService;
import app.consumer.job.DemoJob;
import core.framework.module.Module;

import java.time.Duration;

/**
 * @author zoo
 */
public class ExecutorModule extends Module {
    @Override
    protected void initialize() {
        executor().add();
        schedule().fixedRate("demo-job", bind(DemoJob.class), Duration.ofSeconds(10));
        bind(ExecutorService.class);
    }
}
