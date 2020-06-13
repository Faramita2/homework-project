package app.backoffice.api;

import app.backoffice.api.customer.CreateCustomerAJAXRequest;
import app.backoffice.api.customer.CustomerAJAXView;
import app.backoffice.api.customer.SearchCustomerAJAXRequest;
import app.backoffice.api.customer.SearchCustomerAJAXResponse;
import app.backoffice.api.customer.UpdateCustomerAJAXRequest;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author meow
 */
public interface CustomerAJAXWebService {
    @GET
    @Path("/ajax/customer/:id")
    CustomerAJAXView get(@PathParam("id") Long id);

    @POST
    @Path("/ajax/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    CustomerAJAXView create(CreateCustomerAJAXRequest request);

    @PUT
    @Path("/ajax/customer/:id")
    CustomerAJAXView update(@PathParam("id") Long id, UpdateCustomerAJAXRequest request);

    @DELETE
    @Path("/ajax/customer/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @GET
    @Path("/ajax/customer")
    SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request);
}
