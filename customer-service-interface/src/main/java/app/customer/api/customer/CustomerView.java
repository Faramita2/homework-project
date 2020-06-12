package app.customer.api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.time.LocalDateTime;

/**
 * @author zoo
 */
public class CustomerView {
    @NotNull
    @Property(name = "id")
    public Long id;

    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "gender")
    public CustomerGender gender;

    @NotNull
    @Property(name = "created_time")
    public LocalDateTime createdTime;

    @NotNull
    @Property(name = "updated_time")
    public LocalDateTime updatedTime;
}