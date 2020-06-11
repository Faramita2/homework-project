package app;

import app.first.painter.service.PainterService;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class PainterModule extends Module {
    @Override
    protected void initialize() {
        PainterService service = bind(PainterService.class);
        service.draw();
    }
}
