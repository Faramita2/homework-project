package app.second.cat.service;

import app.second.cat.domain.Cat;
import app.second.cat.domain.CatGender;
import app.second.cat.domain.CatView;
import core.framework.db.Repository;
import core.framework.inject.Inject;

import java.time.LocalDateTime;

/**
 * @author zoo
 */
public class CatService {
    @Inject
    Repository<Cat> catRepository;

    public CatView create() {
        Cat cat = new Cat();
        cat.name = "hanhan";
        cat.gender = CatGender.MALE;
        cat.age = 1;
        cat.createdBy = "CatService";
        cat.updatedBy = "CatService";
        cat.createdTime = LocalDateTime.now();
        cat.updatedTime = LocalDateTime.now();
        cat.id = catRepository.insert(cat).orElseThrow();

        return view(cat);
    }

    private CatView view(Cat cat) {
        CatView result = new CatView();
        result.id = cat.id;
        result.name = cat.name;
        result.age = cat.age;
        result.createdTime = cat.createdTime;
        result.updatedTime = cat.updatedTime;
        result.createdBy = cat.createdBy;
        result.updatedBy = cat.updatedBy;

        return result;
    }
}
