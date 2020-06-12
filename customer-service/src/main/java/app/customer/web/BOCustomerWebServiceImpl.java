package app.customer.web;

import app.customer.api.BOCustomerWebService;
import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.CustomerView;
import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author zoo
 */
public class BOCustomerWebServiceImpl implements BOCustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public CustomerView get(Long id) {
        return customerService.get(id);
    }

    @Override
    public CustomerView create(BOCreateCustomerRequest request) {
        return customerService.create(request);
    }

    @Override
    public CustomerView update(Long id, BOUpdateCustomerRequest request) {
        return customerService.update(id, request);
    }

    @Override
    public void delete(Long id) {
        customerService.delete(id);
    }

    @Override
    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        return null;
    }
}
