package app.second;

import app.second.dog.domain.Dog;
import app.second.dog.domain.DogView;
import app.second.dog.service.DogService;
import core.framework.module.Module;
import core.framework.mongo.module.MongoConfig;
import core.framework.web.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author zoo
 */
public class DogModule extends Module {
    private final Logger logger = LoggerFactory.getLogger(DogModule.class);

    @Override
    protected void initialize() {
        MongoConfig config = config(MongoConfig.class);
        String url = "app.mongo.url";
        config.uri(property(url).orElseThrow(() ->new NotFoundException("not found property: " + url)));
        config.collection(Dog.class);
        DogService dogService = bind(DogService.class);
        DogView dog = dogService.create();
        logger.warn("dog name: " + dog.name);

        String dogId = dog.id;
        DogView getDog = dogService.get(dogId);
        logger.warn("get dog name: " + getDog.name);
    }
}
