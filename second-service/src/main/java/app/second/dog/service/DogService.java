package app.second.dog.service;

import app.second.dog.domain.Dog;
import app.second.dog.domain.DogGender;
import app.second.dog.domain.DogView;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
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

    public void update(String id) {
        dogCollection.get(id).orElseThrow(() -> new NotFoundException("dog not found, id = " + id));
        dogCollection.update(Filters.eq("_id", id), Updates.combine(
            Updates.set("name", "moneymoney"), Updates.set("gender", DogGender.MALE)));
    }

    public void replace(String id) {
        dogCollection.get(id).orElseThrow(() -> new NotFoundException("dog not found, id = " + id));
        Dog newDog = new Dog();
        newDog.id = id;
        newDog.name = "gold";
        newDog.gender = DogGender.FEMALE;
        newDog.age = 2;
        newDog.createdTime = LocalDateTime.now();
        newDog.updatedTime = LocalDateTime.now();
        dogCollection.replace(newDog);
    }

    private DogView view(Dog dog) {
        DogView result = new DogView();
        result.id = dog.id;
        result.name = dog.name;
        result.gender = dog.gender;

        return result;
    }
}
