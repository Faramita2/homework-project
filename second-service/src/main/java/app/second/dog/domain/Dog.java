package app.second.dog.domain;

import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;
import core.framework.mongo.Collection;
import core.framework.mongo.Field;
import core.framework.mongo.Id;

import java.time.LocalDateTime;

/**
 * @author zoo
 */
@Collection(name = "dogs")
public class Dog {
    @Id
    public String id;

    @NotNull
    @NotBlank
    @Field(name = "name")
    public String name;

    @NotNull
    @Field(name = "gender")
    public DogGender gender;

    @NotNull
    @Field(name = "age")
    public Integer age;

    @NotNull
    @Field(name = "created_time")
    public LocalDateTime createdTime;

    @NotNull
    @Field(name = "updated_time")
    public LocalDateTime updatedTime;
}
