package app.customersite;

import app.customer.api.CustomerWebService;
import app.customersite.api.CustomerAJAXWebService;
import app.customersite.api.CustomerAJAXWebServiceImpl;
import app.customersite.service.CustomerAJAXService;
import core.framework.module.Module;

/**
 * @author meow
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        api().client(CustomerWebService.class, requiredProperty("app.customer.ServiceURL"));
        bind(CustomerAJAXService.class);

        api().service(CustomerAJAXWebService.class, bind(CustomerAJAXWebServiceImpl.class));
    }
}
