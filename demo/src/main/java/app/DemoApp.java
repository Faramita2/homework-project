package app;

import core.framework.module.App;

/**
 * @author zoo
 */
public class DemoApp extends App {
    @Override
    protected void initialize() {
        load(new PainterModule());
    }
}
