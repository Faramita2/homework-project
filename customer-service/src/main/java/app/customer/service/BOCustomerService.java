package app.customer.service;

import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.GetCustomerResponse;
import app.customer.domain.Customer;
import app.customer.domain.CustomerGender;
import core.framework.db.Query;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.ConflictException;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zoo
 */
public class BOCustomerService {
    @Inject
    Repository<Customer> customerRepository;

    public GetCustomerResponse get(Long id) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id = " + id));

        return view(customer);
    }

    public void create(BOCreateCustomerRequest request) {
        Optional<Customer> existingCustomer = customerRepository.selectOne("name = ?", request.name);
        if (existingCustomer.isPresent()) {
            throw new ConflictException("customer already exists, name = " + request.name);
        }

        Customer customer = new Customer();
        customer.name = request.name;
        customer.gender = CustomerGender.valueOf(request.gender.name());
        customer.createdTime = LocalDateTime.now();
        customer.updatedTime = LocalDateTime.now();
        customer.createdBy = "CustomerService";
        customer.updatedBy = "CustomerService";

        customerRepository.insert(customer).orElseThrow();
    }

    public void update(Long id, BOUpdateCustomerRequest request) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id = " + id));

        if (request.name != null) {
            Optional<Customer> existingCustomer = customerRepository.selectOne("name = ?", request.name);
            if (existingCustomer.isPresent()) {
                throw new ConflictException("customer already exists, name = " + request.name);
            }
            customer.name = request.name;
        }

        if (request.gender != null) {
            customer.gender = CustomerGender.valueOf(request.gender.name());
        }

        if (request.name != null || request.gender != null) {
            customer.updatedTime = LocalDateTime.now();
            customer.updatedBy = "CustomerService";
            customerRepository.update(customer);
        }
    }

    public void delete(Long id) {
        customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id = " + id));
        customerRepository.delete(id);
    }

    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        BOSearchCustomerResponse response = new BOSearchCustomerResponse();
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

    private GetCustomerResponse view(Customer customer) {
        GetCustomerResponse result = new GetCustomerResponse();
        result.id = customer.id;
        result.name = customer.name;
        result.gender = CustomerGenderView.valueOf(customer.gender.name());

        return result;
    }
}
