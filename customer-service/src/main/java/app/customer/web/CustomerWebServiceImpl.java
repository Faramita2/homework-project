package app.customer.web;

import app.customer.api.CustomerWebService;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.customer.service.CustomerService;
import core.framework.inject.Inject;

/**
 * @author zoo
 */
public class CustomerWebServiceImpl implements CustomerWebService {
    @Inject
    CustomerService customerService;

    @Override
    public GetCustomerResponse get(Long id) {
        return customerService.get(id);
    }

    @Override
    public SearchCustomerResponse search(SearchCustomerRequest request) {
        return customerService.search(request);
    }
}
