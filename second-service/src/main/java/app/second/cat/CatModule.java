package app.second.cat;

import app.second.cat.domain.Cat;
import app.second.cat.domain.CatView;
import app.second.cat.service.CatService;
import core.framework.module.Module;
import core.framework.web.exception.NotFoundException;
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
        CatService catService = bind(CatService.class);
        CatView view = catService.create();
        Long catId = view.id;
        logger.warn("cat id: " + catId);

        CatView cat = catService.get(catId);
        logger.warn("cat name: " + cat.name);

        logger.warn("cat gender: " + cat.gender);
        CatView newCat = catService.update(catId);
        logger.warn("new cat gender: " + newCat.gender);

        catService.delete(catId);

        try {
            CatView notExistedCat = catService.get(catId);
            logger.warn("cat name: " + notExistedCat.name);
        } catch (NotFoundException nfe) {
            logger.warn(nfe.getMessage());
        }
    }
}
