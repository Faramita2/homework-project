package app.second;

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

        logger.warn("====================create action====================");
        CatView view = catService.create();
        Long catId = view.id;
        logger.warn("cat id: " + catId);

        logger.warn("====================query action====================");
        CatView cat = catService.get(catId);
        logger.warn("cat name: " + cat.name);

        logger.warn("====================partialUpdate action====================");
        logger.warn("cat gender: " + cat.gender);
        CatView newCat = catService.partialUpdate(catId);
        logger.warn("new cat gender: " + newCat.gender);

        logger.warn("====================update action====================");
        CatView newCat2 = catService.update(catId);
        logger.warn("new cat2 name: " + newCat2.name);

        logger.warn("====================delete action====================");
        catService.delete(catId);
        try {
            CatView notExistedCat = catService.get(catId);
            logger.warn("cat name: " + notExistedCat.name);
        } catch (NotFoundException nfe) {
            logger.warn(nfe.getMessage());
        }
    }
}
