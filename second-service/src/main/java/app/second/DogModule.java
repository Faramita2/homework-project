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
        config.uri(property(url).orElseThrow(() -> new NotFoundException("not found property: " + url)));
        config.collection(Dog.class);
        DogService dogService = bind(DogService.class);

        logger.warn("====================create action====================");
        DogView dog = dogService.create();
        logger.warn("dog name: " + dog.name);
        logger.warn("dog gender: " + dog.gender);

        logger.warn("====================query action====================");
        String dogId = dog.id;
        DogView getDog = dogService.get(dogId);
        logger.warn("get dog name: " + getDog.name);
        logger.warn("get dog gender: " + getDog.gender);

        logger.warn("====================update action====================");
        dogService.update(dogId);
        DogView newDog = dogService.get(dogId);
        logger.warn("new dog name: " + newDog.name);
        logger.warn("new dog gender: " + newDog.gender);

        logger.warn("====================replace action====================");
        dogService.replace(dogId);
        DogView newDog2 = dogService.get(dogId);
        logger.warn("new dog2 name: " + newDog2.name);
        logger.warn("new dog2 gender: " + newDog2.gender);
    }
}
