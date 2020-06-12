package app.customer;

import app.customer.api.CustomerWebService;
import app.customer.domain.Customer;
import app.customer.service.CustomerService;
import app.customer.web.CustomerServiceImpl;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        db().repository(Customer.class);
        bind(CustomerService.class);
        api().service(CustomerWebService.class, bind(CustomerServiceImpl.class));
    }
}
