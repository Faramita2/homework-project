package app.customer.api;

import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

/**
 * @author zoo
 */
public interface CustomerWebService {
    @GET
    @Path("/customer/:id")
    GetCustomerResponse get(@PathParam("id") Long id);

    @GET
    @Path("/customer")
    SearchCustomerResponse search(SearchCustomerRequest request);
}
