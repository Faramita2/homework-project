package app.backoffice.customer.web;

import app.backoffice.api.CustomerAJAXWebService;
import app.backoffice.api.customer.CreateCustomerAJAXRequest;
import app.backoffice.api.customer.CustomerAJAXView;
import app.backoffice.api.customer.SearchCustomerAJAXRequest;
import app.backoffice.api.customer.SearchCustomerAJAXResponse;
import app.backoffice.api.customer.UpdateCustomerAJAXRequest;
import app.backoffice.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author meow
 */
public class CustomerAJAXWebServiceImpl implements CustomerAJAXWebService {
    @Inject
    CustomerService customerService;

    @Override
    public CustomerAJAXView get(Long id) {
        return customerService.get(id);
    }

    @Override
    public CustomerAJAXView create(CreateCustomerAJAXRequest request) {
        return customerService.create(request);
    }

    @Override
    public CustomerAJAXView update(Long id, UpdateCustomerAJAXRequest request) {
        return customerService.update(id, request);
    }

    @Override
    public void delete(Long id) {
        customerService.delete(id);
    }

    @Override
    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        return customerService.search(request);
    }
}
