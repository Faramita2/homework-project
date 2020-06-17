package app.customer;

import app.customer.api.customer.BOSearchCustomerRequest;
import app.customer.api.customer.BOSearchCustomerResponse;
import app.customer.service.BOCustomerService;
import core.framework.util.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


/**
 * @author zoo
 */
public class CustomerServiceTest extends IntegrationTest {

    @Test
    public void test() {
        BOCustomerService service = Mockito.mock(BOCustomerService.class);
        BOSearchCustomerResponse response = new BOSearchCustomerResponse();
        response.total = 0L;
        response.customers = Lists.newArrayList();
        Mockito.when(service.search(Mockito.any())).thenReturn(response);

        Assertions.assertEquals(0L, service.search(new BOSearchCustomerRequest()).total);
    }
}
