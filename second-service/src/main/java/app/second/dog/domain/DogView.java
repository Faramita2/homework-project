package app.second.dog.domain;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;


/**
 * @author zoo
 */
public class DogView {
    @NotNull
    @Property(name = "id")
    public String id;

    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;
}
