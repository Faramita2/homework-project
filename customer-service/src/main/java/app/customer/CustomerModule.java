package app.customer;

import app.customer.api.BOCustomerWebService;
import app.customer.domain.Customer;
import app.customer.service.CustomerService;
import app.customer.web.BOCustomerWebServiceImpl;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        db().repository(Customer.class);
        bind(CustomerService.class);
        api().service(BOCustomerWebService.class, bind(BOCustomerWebServiceImpl.class));
    }
}
