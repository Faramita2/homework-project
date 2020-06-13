package app.customerbackofficesite.api.customer;

import core.framework.api.json.Property;

/**
 * @author meow
 */
public class UpdateCustomerAJAXRequest {
    @Property(name = "name")
    public String name;

    @Property(name = "gender")
    public String gender;
}
