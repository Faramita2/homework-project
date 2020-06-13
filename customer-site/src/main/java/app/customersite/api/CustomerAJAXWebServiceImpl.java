package app.customersite.api;

import app.customersite.api.customer.CustomerAJAXView;
import app.customersite.api.customer.SearchCustomerAJAXRequest;
import app.customersite.api.customer.SearchCustomerAJAXResponse;
import app.customersite.service.CustomerAJAXService;
import core.framework.inject.Inject;

/**
 * @author meow
 */
public class CustomerAJAXWebServiceImpl implements CustomerAJAXWebService {
    @Inject
    CustomerAJAXService customerService;

    @Override
    public CustomerAJAXView get(Long id) {
        return customerService.get(id);
    }

    @Override
    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        return customerService.search(request);
    }
}
