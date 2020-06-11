package app;

import core.framework.module.App;

/**
 * @author zoo
 */
public class FirstServiceApp extends App {
    @Override
    protected void initialize() {
        load(new BrushModule());
        load(new PainterModule());
    }
}
