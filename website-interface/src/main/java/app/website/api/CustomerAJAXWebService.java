package app.website.api;

import app.website.api.customer.CustomerAJAXView;
import app.website.api.customer.SearchCustomerAJAXRequest;
import app.website.api.customer.SearchCustomerAJAXResponse;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;

/**
 * @author zoo
 */
public interface CustomerAJAXWebService {
    @GET
    @Path("/ajax/customer/:id")
    CustomerAJAXView get(@PathParam("id") Long id);

    @GET
    @Path("/ajax/customer")
    SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request);
}
