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
import core.framework.util.Strings;
import core.framework.web.exception.ConflictException;
import core.framework.web.exception.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author zoo
 */
public class BOCustomerService {
    private final Logger logger = LoggerFactory.getLogger(BOCustomerService.class);
    @Inject
    Repository<Customer> customerRepository;

    public GetCustomerResponse get(Long id) {
        Customer customer = findCustomer(id);

        GetCustomerResponse result = new GetCustomerResponse();
        result.id = customer.id;
        result.name = customer.name;
        result.gender = CustomerGenderView.valueOf(customer.gender.name());

        return result;
    }

    public void create(BOCreateCustomerRequest request) {
        checkNameUnique(request.name);

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
        Customer customer = findCustomer(id);

        checkNameUnique(id, request.name);

        customer.name = request.name;
        customer.gender = CustomerGender.valueOf(request.gender.name());
        customer.updatedTime = LocalDateTime.now();
        customer.updatedBy = "CustomerService";

        customerRepository.partialUpdate(customer);
        logger.info("update customer id = {}, name = {}, gender = {}, updatedTime = {}, updatedBy = {}",
            id, customer.name, customer.gender.name(), customer.updatedTime, customer.updatedBy);
    }

    public void delete(Long id) {
        findCustomer(id);
        customerRepository.delete(id);
        logger.info("delete customer id = {}", id);
    }

    public BOSearchCustomerResponse search(BOSearchCustomerRequest request) {
        BOSearchCustomerResponse response = new BOSearchCustomerResponse();
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
            BOSearchCustomerResponse.CustomerAJAXView view = new BOSearchCustomerResponse.CustomerAJAXView();
            view.id = customer.id;
            view.name = customer.name;
            view.gender = CustomerGenderView.valueOf(customer.gender.name());

            return view;
        }).collect(Collectors.toList());
        response.total = query.count();

        return response;
    }

    private Customer findCustomer(Long id) {
        return customerRepository.get(id).orElseThrow(() -> new NotFoundException(Strings.format("customer not found, id = {}", id), "CUSTOMER-NOT-FOUND"));
    }

    private void checkNameUnique(String name) {
        Optional<Customer> existingCustomer = customerRepository.selectOne("name = ?", name);
        if (existingCustomer.isPresent()) {
            throw new ConflictException(Strings.format("customer already exists, name = {}", name), "CUSTOMER-CONFLICT-NAME");
        }
    }

    private void checkNameUnique(Long id, String name) {
        Optional<Customer> existingCustomer = customerRepository.selectOne("id <> ? and name = ?", id, name);
        if (existingCustomer.isPresent()) {
            throw new ConflictException(Strings.format("customer already exists, name = {}", name), "CUSTOMER-CONFLICT-NAME");
        }
    }
}
