package app.customerbackofficesite.web;

import app.customerbackofficesite.api.CustomerAJAXWebService;
import app.customerbackofficesite.api.customer.CreateCustomerAJAXRequest;
import app.customerbackofficesite.api.customer.CustomerAJAXView;
import app.customerbackofficesite.api.customer.SearchCustomerAJAXRequest;
import app.customerbackofficesite.api.customer.SearchCustomerAJAXResponse;
import app.customerbackofficesite.api.customer.UpdateCustomerAJAXRequest;
import app.customerbackofficesite.service.CustomerService;
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
