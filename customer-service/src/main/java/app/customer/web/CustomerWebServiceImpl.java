package app.customer.web;

import app.customer.api.CustomerWebService;
import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.CustomerView;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author zoo
 */
public class CustomerWebServiceImpl implements CustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public CustomerView get(Long id) {
        return customerService.get(id);
    }

    @Override
    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        return null;
    }
}
