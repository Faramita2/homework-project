package app.customersite.service;

import app.customer.api.CustomerWebService;
import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.customersite.api.customer.CustomerAJAXView;
import app.customersite.api.customer.CustomerGenderAJAXView;
import app.customersite.api.customer.SearchCustomerAJAXRequest;
import app.customersite.api.customer.SearchCustomerAJAXResponse;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author meow
 */
public class CustomerAJAXService {
    @Inject
    CustomerWebService customerWebService;

    public CustomerAJAXView get(Long id) {
        return view(customerWebService.get(id));
    }

    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        SearchCustomerRequest searchCustomerRequest = new SearchCustomerRequest();
        searchCustomerRequest.skip = request.skip;
        searchCustomerRequest.limit = request.limit;
        if (request.gender != null) {
            searchCustomerRequest.gender = CustomerGenderView.valueOf(request.gender.name());
        }

        SearchCustomerResponse searchCustomerResponse = customerWebService.search(searchCustomerRequest);
        SearchCustomerAJAXResponse response = new SearchCustomerAJAXResponse();

        response.total = searchCustomerResponse.total;
        response.customers = searchCustomerResponse.customers.parallelStream().map(customerView -> {
            CustomerAJAXView customerAJAXView = new CustomerAJAXView();
            customerAJAXView.id = customerView.id;
            customerAJAXView.name = customerView.name;
            customerAJAXView.gender = CustomerGenderAJAXView.valueOf(customerView.gender.name());

            return customerAJAXView;
        }).collect(Collectors.toList());

        return response;
    }

    private CustomerAJAXView view(app.customer.api.customer.CustomerView customerView) {
        CustomerAJAXView result = new CustomerAJAXView();
        result.id = customerView.id;
        result.name = customerView.name;
        result.gender = CustomerGenderAJAXView.valueOf(customerView.gender.name());

        return result;
    }
}
