package app.website.customer.web;

import app.website.api.CustomerAJAXWebService;
import app.website.api.customer.GetCustomerAJAXResponse;
import app.website.api.customer.SearchCustomerAJAXRequest;
import app.website.api.customer.SearchCustomerAJAXResponse;
import app.website.customer.service.CustomerAJAXService;
import core.framework.inject.Inject;

/**
 * @author meow
 */
public class CustomerAJAXWebServiceImpl implements CustomerAJAXWebService {
    @Inject
    CustomerAJAXService service;

    @Override
    public GetCustomerAJAXResponse get(Long id) {
        return service.get(id);
    }

    @Override
    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        return service.search(request);
    }
}
