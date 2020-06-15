package app.customer.web;

import app.customer.api.BOCustomerWebService;
import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.service.BOCustomerService;
import core.framework.inject.Inject;

/**
 * @author zoo
 */
public class BOCustomerWebServiceImpl implements BOCustomerWebService {
    @Inject
    BOCustomerService service;

    @Override
    public GetCustomerResponse get(Long id) {
        return service.get(id);
    }

    @Override
    public void create(BOCreateCustomerRequest request) {
       service.create(request);
    }

    @Override
    public void update(Long id, BOUpdateCustomerRequest request) {
        service.update(id, request);
    }

    @Override
    public void delete(Long id) {
        service.delete(id);
    }

    @Override
    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        return service.search(request);
    }
}
