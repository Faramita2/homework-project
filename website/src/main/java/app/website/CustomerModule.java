package app.website;

import app.customer.api.CustomerWebService;
import app.website.api.CustomerAJAXWebService;
import app.website.api.CustomerAJAXWebServiceImpl;
import app.website.customer.service.CustomerAJAXService;
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
