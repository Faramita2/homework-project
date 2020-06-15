package app.website.customer.service;

import app.customer.api.CustomerWebService;
import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.website.api.customer.CustomerGenderAJAXView;
import app.website.api.customer.GetCustomerAJAXResponse;
import app.website.api.customer.SearchCustomerAJAXRequest;
import app.website.api.customer.SearchCustomerAJAXResponse;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author meow
 */
public class CustomerAJAXService {
    @Inject
    CustomerWebService customerWebService;

    public GetCustomerAJAXResponse get(Long id) {
        GetCustomerResponse getCustomerResponse = customerWebService.get(id);
        GetCustomerAJAXResponse response = new GetCustomerAJAXResponse();
        response.id = getCustomerResponse.id;
        response.name = getCustomerResponse.name;
        response.gender = CustomerGenderAJAXView.valueOf(getCustomerResponse.gender.name());

        return response;
    }

    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        SearchCustomerRequest searchCustomerRequest = new SearchCustomerRequest();
        searchCustomerRequest.skip = request.skip;
        searchCustomerRequest.limit = request.limit;

        if (request.name != null) {
            searchCustomerRequest.name = request.name;
        }

        if (request.gender != null) {
            searchCustomerRequest.gender = CustomerGenderView.valueOf(request.gender.name());
        }

        SearchCustomerResponse searchCustomerResponse = customerWebService.search(searchCustomerRequest);
        SearchCustomerAJAXResponse response = new SearchCustomerAJAXResponse();

        response.total = searchCustomerResponse.total;
        response.customers = searchCustomerResponse.customers.parallelStream().map(customerView -> {
            SearchCustomerAJAXResponse.CustomerAJAXView customerAJAXView = new SearchCustomerAJAXResponse.CustomerAJAXView();
            customerAJAXView.id = customerView.id;
            customerAJAXView.name = customerView.name;
            customerAJAXView.gender = CustomerGenderAJAXView.valueOf(customerView.gender.name());

            return customerAJAXView;
        }).collect(Collectors.toList());

        return response;
    }
}
