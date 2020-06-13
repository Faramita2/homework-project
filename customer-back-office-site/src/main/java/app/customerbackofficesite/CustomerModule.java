package app.customerbackofficesite;

import app.customer.api.BOCustomerWebService;
import app.customerbackofficesite.api.CustomerAJAXWebService;
import app.customerbackofficesite.service.CustomerService;
import app.customerbackofficesite.web.CustomerAJAXWebServiceImpl;
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
