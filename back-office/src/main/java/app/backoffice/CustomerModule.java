package app.backoffice;

import app.customer.api.BOCustomerWebService;
import app.backoffice.api.CustomerAJAXWebService;
import app.backoffice.customer.service.CustomerService;
import app.backoffice.customer.web.CustomerAJAXWebServiceImpl;
import core.framework.module.Module;

/**
 * @author meow
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        api().client(BOCustomerWebService.class, requiredProperty("app.customer.ServiceURL"));
        bind(CustomerService.class);
        api().service(CustomerAJAXWebService.class, bind(CustomerAJAXWebServiceImpl.class));
    }
}
