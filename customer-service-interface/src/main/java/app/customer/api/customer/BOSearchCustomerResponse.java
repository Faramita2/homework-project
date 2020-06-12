package app.customer.api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotNull;

import java.util.List;

/**
 * @author zoo
 */
public class BOSearchCustomerResponse {
    @NotNull
    @Property(name = "total")
    public Long total;

    @NotNull
    @Property(name = "customers")
    public List<CustomerView> customers;
}
