package app.consumer;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author zoo
 */
public class ConsumerServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new ConsumerModule());
        load(new ExecutorModule());
    }
}
