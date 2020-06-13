package app.customerbackofficesite.service;

import app.customer.api.BOCustomerWebService;
import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.CustomerView;
import app.customerbackofficesite.api.customer.CreateCustomerAJAXRequest;
import app.customerbackofficesite.api.customer.CustomerAJAXView;
import app.customerbackofficesite.api.customer.CustomerGenderAJAXView;
import app.customerbackofficesite.api.customer.SearchCustomerAJAXRequest;
import app.customerbackofficesite.api.customer.SearchCustomerAJAXResponse;
import app.customerbackofficesite.api.customer.UpdateCustomerAJAXRequest;
import core.framework.inject.Inject;

import java.util.stream.Collectors;

/**
 * @author meow
 */
public class CustomerService {
    @Inject
    BOCustomerWebService service;

    public CustomerAJAXView get(Long id) {
        return view(service.get(id));
    }

    public CustomerAJAXView create(CreateCustomerAJAXRequest request) {
        BOCreateCustomerRequest boCreateCustomerRequest = new BOCreateCustomerRequest();
        boCreateCustomerRequest.name = request.name;
        boCreateCustomerRequest.gender = CustomerGenderView.valueOf(request.gender.name());

        return view(service.create(boCreateCustomerRequest));
    }

    public CustomerAJAXView update(Long id, UpdateCustomerAJAXRequest request) {
        BOUpdateCustomerRequest boUpdateCustomerRequest = new BOUpdateCustomerRequest();

        if (request.name != null) {
            boUpdateCustomerRequest.name = request.name;
        }

        if (request.gender != null) {
            boUpdateCustomerRequest.gender = CustomerGenderView.valueOf(request.gender.name());
        }

        return view(service.update(id, boUpdateCustomerRequest));
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
            CustomerAJAXView customerAJAXView = new CustomerAJAXView();
            customerAJAXView.id = customerView.id;
            customerAJAXView.name = customerView.name;
            customerAJAXView.gender = CustomerGenderAJAXView.valueOf(customerView.gender.name());

            return customerAJAXView;
        }).collect(Collectors.toList());

        return response;
    }

    private CustomerAJAXView view(CustomerView customerView) {
        CustomerAJAXView result = new CustomerAJAXView();
        result.id = customerView.id;
        result.name = customerView.name;
        result.gender = CustomerGenderAJAXView.valueOf(customerView.gender.name());

        return result;
    }
}
