package app.customer.api.customer;

import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

/**
 * @author zoo
 */
public class SearchCustomerRequest {
    @NotNull
    @QueryParam(name = "skip")
    public Integer skip = 0;

    @NotNull
    @QueryParam(name = "limit")
    public Integer limit = 1000;

    @QueryParam(name = "name")
    public String name;
}
