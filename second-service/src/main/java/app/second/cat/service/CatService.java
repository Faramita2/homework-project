package app.second.cat.service;

import app.second.cat.domain.Cat;
import app.second.cat.domain.CatGender;
import app.second.cat.domain.CatView;
import core.framework.db.Database;
import core.framework.db.Repository;
import core.framework.db.Transaction;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;

/**
 * @author zoo
 */
public class CatService {
    @Inject
    Repository<Cat> catRepository;
    @Inject
    Database catDatabase;

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

    public CatView createWithException() throws Exception {
        create();

        throw new Exception("exception for transaction");
    }

    public CatView get(Long id) {
        Cat cat = catRepository.get(id).orElseThrow(() -> new NotFoundException(Strings.format("cat not found, id = {}", id)));

        return view(cat);
    }

    public CatView partialUpdate(Long id) {
        Cat cat = catRepository.get(id).orElseThrow(() -> new NotFoundException(Strings.format("cat not found, id = {}", id)));
        cat.updatedTime = LocalDateTime.now();
        cat.gender = CatGender.FEMALE;
        catRepository.partialUpdate(cat);

        return view(cat);
    }

    public CatView update(Long id) {
        catRepository.get(id).orElseThrow(() -> new NotFoundException(Strings.format("cat not found, id = {}", id)));
        Cat newCat = new Cat();
        newCat.id = id;
        newCat.name = "han";
        newCat.gender = CatGender.MALE;
        newCat.age = 1;
        newCat.createdBy = "CatService";
        newCat.updatedBy = "CatService";
        newCat.createdTime = LocalDateTime.now();
        newCat.updatedTime = LocalDateTime.now();
        catRepository.update(newCat);

        return view(newCat);
    }

    public void delete(Long id) {
        catRepository.get(id).orElseThrow(() -> new NotFoundException(Strings.format("cat not found, id = {}", id)));
        catRepository.delete(id);
    }

    public Transaction startTrans() {
        return catDatabase.beginTransaction();
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
