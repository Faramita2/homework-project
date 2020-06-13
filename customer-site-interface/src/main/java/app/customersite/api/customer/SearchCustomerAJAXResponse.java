package app.customersite.api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

import java.util.List;

/**
 * @author meow
 */
public class SearchCustomerAJAXResponse {
    @NotNull
    @Property(name = "total")
    public Long total;

    @NotNull
    @Property(name = "customers")
    public List<CustomerAJAXView> customers;
}
