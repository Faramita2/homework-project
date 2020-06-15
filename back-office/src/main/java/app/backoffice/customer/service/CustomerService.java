package app.backoffice.customer.service;

import app.backoffice.api.customer.CreateCustomerAJAXRequest;
import app.backoffice.api.customer.CustomerGenderAJAXView;
import app.backoffice.api.customer.GetCustomerAJAXResponse;
import app.backoffice.api.customer.SearchCustomerAJAXRequest;
import app.backoffice.api.customer.SearchCustomerAJAXResponse;
import app.backoffice.api.customer.UpdateCustomerAJAXRequest;
import app.customer.api.BOCustomerWebService;
import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.GetCustomerResponse;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author meow
 */
public class CustomerService {
    @Inject
    BOCustomerWebService service;

    public GetCustomerAJAXResponse get(Long id) {
        GetCustomerResponse customerView = service.get(id);
        GetCustomerAJAXResponse result = new GetCustomerAJAXResponse();
        result.id = customerView.id;
        result.name = customerView.name;
        result.gender = CustomerGenderAJAXView.valueOf(customerView.gender.name());

        return result;
    }

    public void create(CreateCustomerAJAXRequest request) {
        BOCreateCustomerRequest boCreateCustomerRequest = new BOCreateCustomerRequest();
        boCreateCustomerRequest.name = request.name;
        boCreateCustomerRequest.gender = CustomerGenderView.valueOf(request.gender.name());

        service.create(boCreateCustomerRequest);
    }

    public void update(Long id, UpdateCustomerAJAXRequest request) {
        BOUpdateCustomerRequest boUpdateCustomerRequest = new BOUpdateCustomerRequest();

        if (request.name != null) {
            boUpdateCustomerRequest.name = request.name;
        }

        if (request.gender != null) {
            boUpdateCustomerRequest.gender = CustomerGenderView.valueOf(request.gender.name());
        }

        service.update(id, boUpdateCustomerRequest);
    }

    public void delete(Long id) {
        service.delete(id);
    }

    public SearchCustomerAJAXResponse search(SearchCustomerAJAXRequest request) {
        BOSearchCustomerRequest boSearchCustomerRequest = new BOSearchCustomerRequest();

        boSearchCustomerRequest.skip = request.skip;
        boSearchCustomerRequest.limit = request.limit;

        if (request.name != null) {
            boSearchCustomerRequest.name = request.name;
        }

        if (request.gender != null) {
            boSearchCustomerRequest.gender = CustomerGenderView.valueOf(request.gender.name());
        }

        BOSearchCustomerResponse boSearchCustomerResponse = service.search(boSearchCustomerRequest);
        SearchCustomerAJAXResponse response = new SearchCustomerAJAXResponse();

        response.total = boSearchCustomerResponse.total;
        response.customers = boSearchCustomerResponse.customers.parallelStream().map(customerView -> {
            SearchCustomerAJAXResponse.CustomerAJAXView customerAJAXView = new SearchCustomerAJAXResponse.CustomerAJAXView();
            customerAJAXView.id = customerView.id;
            customerAJAXView.name = customerView.name;
            customerAJAXView.gender = CustomerGenderAJAXView.valueOf(customerView.gender.name());

            return customerAJAXView;
        }).collect(Collectors.toList());

        return response;
    }
}
