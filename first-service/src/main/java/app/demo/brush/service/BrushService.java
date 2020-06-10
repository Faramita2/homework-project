package app.demo.brush.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zoo
 */
public class BrushService {
    private final Logger logger = LoggerFactory.getLogger(BrushService.class);

    public void print() {
        logger.info("Hello World");
    }
}
