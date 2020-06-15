package app.second.dog.domain;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import org.bson.types.ObjectId;


/**
 * @author zoo
 */
public class DogView {
    @NotNull
    @Property(name = "id")
    public ObjectId id;

    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "gender")
    public DogGender gender;
}
