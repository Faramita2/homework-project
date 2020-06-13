package app.website;

import app.customer.api.CustomerWebService;
import app.website.api.CustomerAJAXWebService;
import app.website.customer.web.CustomerAJAXWebServiceImpl;
import app.website.customer.service.CustomerAJAXService;
import app.website.customer.web.HomeController;
import app.website.customer.web.WildcardController;
import core.framework.module.Module;

import static core.framework.http.HTTPMethod.GET;

/**
 * @author meow
 */
public class CustomerModule extends Module {
    @Override
    protected void initialize() {
        api().client(CustomerWebService.class, requiredProperty("app.customer.ServiceURL"));
        bind(CustomerAJAXService.class);

        api().service(CustomerAJAXWebService.class, bind(CustomerAJAXWebServiceImpl.class));

        http().route(GET, "/", bind(HomeController.class)::index);
        http().route(GET, "/:all(*)", bind(WildcardController.class)::wildcard);
    }
}
