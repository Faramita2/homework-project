package app.producer;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author zoo
 */
public class ProducerServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new ProducerModule());
    }
}
