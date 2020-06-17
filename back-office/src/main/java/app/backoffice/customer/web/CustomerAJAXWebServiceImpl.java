package app.backoffice.customer.web;

import app.backoffice.api.CustomerAJAXWebService;
import app.backoffice.api.customer.CreateCustomerAJAXRequest;
import app.backoffice.api.customer.GetCustomerAJAXResponse;
import app.backoffice.api.customer.SearchCustomerAJAXRequest;
import app.backoffice.api.customer.SearchCustomerAJAXResponse;
import app.backoffice.api.customer.UpdateCustomerAJAXRequest;
import app.backoffice.customer.service.CustomerService;
import core.framework.inject.Inject;
import core.framework.log.ActionLogContext;

/**
 * @author meow
 */
public class CustomerAJAXWebServiceImpl implements CustomerAJAXWebService {
    @Inject
    CustomerService customerService;

    @Override
    public GetCustomerAJAXResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public void create(CreateCustomerAJAXRequest request) {
        customerService.create(request);
    }

    @Override
    public void update(Long id, UpdateCustomerAJAXRequest request) {
        ActionLogContext.put("customerId", id);
        customerService.update(id, request);
    }

    @Override
    public void delete(Long id) {
        ActionLogContext.put("customerId", id);
        customerService.delete(id);
    }

    @Override
    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        return customerService.search(request);
    }
}
