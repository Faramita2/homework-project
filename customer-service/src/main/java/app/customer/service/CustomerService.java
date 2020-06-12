package app.customer.service;

import app.customer.api.customer.BOCreateCustomerRequest;
import app.customer.api.customer.CustomerGenderView;
import app.customer.api.customer.BOUpdateCustomerRequest;
import app.customer.domain.CustomerGender;
import app.customer.api.customer.CustomerView;
import app.customer.domain.Customer;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import core.framework.web.exception.ConflictException;
import core.framework.web.exception.NotFoundException;

import java.time.LocalDateTime;
import java.util.Optional;

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

    public CustomerView create(BOCreateCustomerRequest request) {
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

        customer.id = customerRepository.insert(customer).orElseThrow();

        return view(customer);
    }

    private CustomerView view(Customer customer) {
        CustomerView result = new CustomerView();
        result.id = customer.id;
        result.name = customer.name;
        result.gender = CustomerGenderView.valueOf(customer.gender.name());
        return result;
    }

    public CustomerView update(Long id, BOUpdateCustomerRequest request) {
        Customer customer = customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id = " + id));
        Optional<Customer> existingCustomer = customerRepository.selectOne("name = ?", request.name);
        if (existingCustomer.isPresent()) {
            throw new ConflictException("customer already exists, name = " + request.name);
        }
        customer.name = request.name;
        customer.gender = CustomerGender.valueOf(request.gender.name());
        customer.updatedTime = LocalDateTime.now();
        customer.updatedBy = "CustomerService";
        customerRepository.update(customer);

        return view(customer);
    }

    public void delete(Long id) {
        customerRepository.get(id).orElseThrow(() -> new NotFoundException("customer not found, id = " + id));
        customerRepository.delete(id);
    }
}
