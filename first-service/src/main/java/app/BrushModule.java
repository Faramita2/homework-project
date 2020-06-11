package app;

import app.first.brush.service.BrushService;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class BrushModule extends Module {
    @Override
    protected void initialize() {
        bind(new BrushService());
    }
}
