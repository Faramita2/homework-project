package app.customer.api;

import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.CustomerView;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

/**
 * @author zoo
 */
public interface CustomerWebService {
    @GET
    @Path("/customer/:id")
    CustomerView get(@PathParam("id") Long id);

    @GET
    @Path("/customer")
    BOSearchCustomerResponse search(BOSearchCustomerRequest request);
}
