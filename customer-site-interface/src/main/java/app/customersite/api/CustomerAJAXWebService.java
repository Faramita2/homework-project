package app.customersite.api;

import app.customersite.api.customer.CreateCustomerAJAXRequest;
import app.customersite.api.customer.CustomerView;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;

/**
 * @author zoo
 */
public interface CustomerAJAXWebService {
    @POST
    @Path("/ajax/customer")
    CustomerView create(CreateCustomerAJAXRequest request);
}
