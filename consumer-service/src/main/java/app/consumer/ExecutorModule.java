package app.consumer;

import app.consumer.executor.service.ExecutorService;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class ExecutorModule extends Module {
    @Override
    protected void initialize() {
        executor().add();
        bind(ExecutorService.class);
    }
}
