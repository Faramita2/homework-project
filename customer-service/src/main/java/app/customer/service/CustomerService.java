package app.customer.service;

import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.CustomerView;
import app.customer.api.customer.SearchCustomerRequest;
import app.customer.api.customer.SearchCustomerResponse;
import app.customer.domain.Customer;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.NotFoundException;

import java.util.stream.Collectors;

/**
 * @author zoo
 */
public class CustomerService {
    @Inject
    Repository<Customer> customerRepository;

    public CustomerView get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id = " + id));

        return view(customer);
    }

    public SearchCustomerResponse search(SearchCustomerRequest request) {
        SearchCustomerResponse response = new SearchCustomerResponse();
        Query<Customer> query = customerRepository.select();
        query.skip(request.skip);
        query.limit(request.limit);

        if (request.gender != null) {
            query.where("gender = ?", request.gender);
        }

        response.customers = query.fetch().stream().map(this::view).collect(Collectors.toList());
        response.total = query.count();

        return response;
    }

    private CustomerView view(Customer customer) {
        CustomerView result = new CustomerView();
        result.id = customer.id;
        result.name = customer.name;
        result.gender = CustomerGenderView.valueOf(customer.gender.name());

        return result;
    }
}
