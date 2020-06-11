package app.second.cat;

import app.second.cat.domain.Cat;
import app.second.cat.domain.CatView;
import app.second.cat.service.CatService;
import core.framework.module.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zoo
 */
public class CatModule extends Module {
    private final Logger logger = LoggerFactory.getLogger(CatModule.class);

    @Override
    protected void initialize() {
        db().repository(Cat.class);
        CatService cat = bind(CatService.class);
        CatView view = cat.create();
        logger.warn("cat id: " + view.id);
    }
}
