package app.second.cat.domain;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.time.LocalDateTime;

/**
 * @author zoo
 */
public class CatView {
    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "gender")
    public CatGender gender;

    @NotNull
    @Property(name = "age")
    public Integer age;

    @NotNull
    @NotBlank
    @Property(name = "first_name")
    public String firstName;

    @NotBlank
    @Property(name = "last_name")
    public String lastName;

    @NotNull
    @Property(name = "created_time")
    public LocalDateTime createdTime;

    @NotNull
    @Property(name = "updated_time")
    public LocalDateTime updatedTime;

    @NotNull
    @NotBlank
    @Property(name = "created_by")
    public String createdBy;

    @NotNull
    @NotBlank
    @Property(name = "updated_by")
    public String updatedBy;
}
