package app.customer.web;

import app.customer.api.CustomerWebService;
import app.customer.api.customer.CreateCustomerRequest;
import app.customer.api.customer.CustomerView;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.customer.api.customer.UpdateCustomerRequest;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author zoo
 */
public class CustomerServiceImpl implements CustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public CustomerView get(Long id) {
        return customerService.get(id);
    }

    @Override
    public CustomerView create(CreateCustomerRequest request) {
        return customerService.create(request);
    }

    @Override
    public CustomerView update(Long id, UpdateCustomerRequest request) {
        return customerService.update(id, request);
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public SearchCustomerResponse search(SearchCustomerRequest request) {
        return null;
    }
}
