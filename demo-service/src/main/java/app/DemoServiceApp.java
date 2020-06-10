package app;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author zoo
 */
public class DemoServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        load(new DemoModule());
    }
}
