package app.website.api;

import app.website.api.customer.CustomerAJAXView;
import app.website.api.customer.SearchCustomerAJAXRequest;
import app.website.api.customer.SearchCustomerAJAXResponse;
import app.website.customer.service.CustomerAJAXService;
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
