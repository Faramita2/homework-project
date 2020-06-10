package app;

import app.demo.brush.service.BrushService;
import app.demo.painter.service.PainterService;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class PainterModule extends Module {
    @Override
    protected void initialize() {
        bind(BrushService.class);
        PainterService service = bind(PainterService.class);
        service.draw();
    }
}
