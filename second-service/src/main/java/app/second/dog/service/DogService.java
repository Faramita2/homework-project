package app.second.dog.service;

import app.second.dog.domain.Dog;
import app.second.dog.domain.DogGender;
import app.second.dog.domain.DogView;
import core.framework.inject.Inject;
import core.framework.mongo.MongoCollection;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * @author zoo
 */
public class DogService {
    @Inject
    MongoCollection<Dog> dogCollection;

    public DogView create() {
        Dog dog = new Dog();
        dog.age = 1;
        dog.name = "qianqian";
        dog.createdTime = LocalDateTime.now();
        dog.updatedTime = LocalDateTime.now();
        dog.gender = DogGender.MALE;
        dog.id = UUID.randomUUID().toString();
        dogCollection.insert(dog);

        return view(dog);
    }

    public DogView get(String id) {
        Dog dog = dogCollection.get(id).orElseThrow(() -> new NotFoundException("dog not found, id = " + id));

        return view(dog);
    }

    private DogView view(Dog dog) {
        DogView result = new DogView();
        result.id = dog.id;
        result.name = dog.name;

        return result;
    }
}
