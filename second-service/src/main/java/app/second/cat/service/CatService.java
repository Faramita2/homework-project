package app.second.cat.service;

import app.second.cat.domain.Cat;
import app.second.cat.domain.CatGender;
import app.second.cat.domain.CatView;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

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

    public CatView get(Long id) {
        Cat cat = catRepository.get(id).orElseThrow(() -> new NotFoundException("cat not found, id = " + id));

        return view(cat);
    }

    public CatView update(Long id) {
        Cat cat = catRepository.get(id).orElseThrow(() -> new NotFoundException("cat not found, id = " + id));
        cat.updatedTime = LocalDateTime.now();
        cat.gender = CatGender.FEMALE;
        catRepository.partialUpdate(cat);

        return view(cat);
    }

    public void delete(Long id) {
        catRepository.get(id).orElseThrow(() -> new NotFoundException("cat not found, id = " + id));
        catRepository.delete(id);
    }

    private CatView view(Cat cat) {
        CatView result = new CatView();
        result.id = cat.id;
        result.name = cat.name;
        result.age = cat.age;
        result.gender = cat.gender;
        result.createdTime = cat.createdTime;
        result.updatedTime = cat.updatedTime;
        result.createdBy = cat.createdBy;
        result.updatedBy = cat.updatedBy;

        return result;
    }
}
