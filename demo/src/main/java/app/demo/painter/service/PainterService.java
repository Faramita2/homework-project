package app.demo.painter.service;


import app.demo.brush.service.BrushService;
import core.framework.inject.Inject;


/**
 * @author zoo
 */
public class PainterService {
    private final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(PainterService.class);
    @Inject
    BrushService brushService;

    public void draw() {
        logger.warn("drawing picture...");
        brushService.print();
    }
}
