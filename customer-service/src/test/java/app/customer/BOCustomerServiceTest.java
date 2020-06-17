package app.customer;

import app.customer.domain.Customer;
import core.framework.db.Repository;
import core.framework.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author zoo
 */
public class BOCustomerServiceTest extends IntegrationTest {
    @Inject
    Repository<Customer> customerRepository;

    @Test
    public void create() {
        Assertions.assertEquals(0, customerRepository.select().count());
    }
}
