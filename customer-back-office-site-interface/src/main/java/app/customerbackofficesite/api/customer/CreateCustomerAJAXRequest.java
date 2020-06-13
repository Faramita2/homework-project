package app.customerbackofficesite.api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

/**
 * @author meow
 */
public class CreateCustomerAJAXRequest {
    @NotNull
    @NotBlank
    @Property(name = "name")
    public String name;

    @NotNull
    @Property(name = "gender")
    public CustomerGenderAJAXView gender;
}
