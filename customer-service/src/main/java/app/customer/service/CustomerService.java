package app.customer.service;

import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.customer.domain.Customer;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.util.Strings;
import core.framework.web.exception.NotFoundException;

import java.util.stream.Collectors;

/**
 * @author zoo
 */
public class CustomerService {
    @Inject
    Repository<Customer> customerRepository;

    public GetCustomerResponse get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(
            () -> new NotFoundException(Strings.format("customer not found, id = {}", id), "CUSTOMER_NOT_FOUND"));

        GetCustomerResponse result = new GetCustomerResponse();
        result.id = customer.id;
        result.name = customer.name;
        result.gender = CustomerGenderView.valueOf(customer.gender.name());

        return result;
    }

    public SearchCustomerResponse search(SearchCustomerRequest request) {
        SearchCustomerResponse response = new SearchCustomerResponse();
        Query<Customer> query = customerRepository.select();
        query.skip(request.skip);
        query.limit(request.limit);

        if (request.name != null) {
            query.where("name = ?", request.name);
        }

        if (request.gender != null) {
            query.where("gender = ?", request.gender.name());
        }

        response.customers = query.fetch().stream().map(customer -> {
            SearchCustomerResponse.CustomerView view = new SearchCustomerResponse.CustomerView();
            view.id = customer.id;
            view.name = customer.name;
            view.gender = CustomerGenderView.valueOf(customer.gender.name());

            return view;
        }).collect(Collectors.toList());
        response.total = query.count();

        return response;
    }
}
