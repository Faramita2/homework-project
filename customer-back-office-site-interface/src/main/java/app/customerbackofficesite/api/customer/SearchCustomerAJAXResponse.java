package app.customerbackofficesite.api.customer;

import core.framework.api.json.Property;

import java.util.List;

/**
 * @author meow
 */
public class SearchCustomerAJAXResponse {
    @Property(name = "total")
    public Long total;

    @Property(name = "customers")
    public List<CustomerAJAXView> customers;
}
