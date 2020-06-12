package app.customer.api;

import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.CustomerView;
import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.DELETE;
import core.framework.api.web.service.GET;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.PUT;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.PathParam;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author zoo
 */
public interface BOCustomerWebService {
    @GET
    @Path("/bo/customer/:id")
    CustomerView get(@PathParam("id") Long id);

    @POST
    @Path("/bo/customer")
    @ResponseStatus(HTTPStatus.CREATED)
    CustomerView create(BOCreateCustomerRequest request);

    @PUT
    @Path("/bo/customer/:id")
    CustomerView update(@PathParam("id") Long id, BOUpdateCustomerRequest request);

    @DELETE
    @Path("/bo/customer/:id")
    @ResponseStatus(HTTPStatus.NO_CONTENT)
    void delete(@PathParam("id") Long id);

    @GET
    @Path("/bo/customer")
    BOSearchCustomerResponse search(BOSearchCustomerRequest request);
}
