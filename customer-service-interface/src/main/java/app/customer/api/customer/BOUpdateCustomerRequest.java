package app.customer.api.customer;

import core.framework.api.json.Property;

/**
 * @author zoo
 */
public class BOUpdateCustomerRequest {
    @Property(name = "name")
    public String name;

    @Property(name = "gender")
    public CustomerGenderView gender;
}
