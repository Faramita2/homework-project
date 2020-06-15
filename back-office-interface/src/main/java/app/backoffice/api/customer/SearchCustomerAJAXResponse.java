package app.backoffice.api.customer;

import core.framework.api.json.Property;
import core.framework.api.validate.NotBlank;
import core.framework.api.validate.NotNull;

import java.util.List;

/**
 * @author meow
 */
public class SearchCustomerAJAXResponse {
    @Property(name = "total")
    public Long total;

    @Property(name = "customers")
    public List<CustomerAJAXView> customers;

    public static class CustomerAJAXView {
        @NotNull
        @Property(name = "id")
        public Long id;

        @NotNull
        @NotBlank
        @Property(name = "name")
        public String name;

        @NotNull
        @Property(name = "gender")
        public CustomerGenderAJAXView gender;
    }
}
