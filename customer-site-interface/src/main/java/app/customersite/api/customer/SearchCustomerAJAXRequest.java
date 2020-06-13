package app.customersite.api.customer;

import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

/**
 * @author meow
 */
public class SearchCustomerAJAXRequest {
    @NotNull
    @QueryParam(name = "skip")
    public Integer skip = 0;

    @NotNull
    @QueryParam(name = "limit")
    public Integer limit = 1000;

    @QueryParam(name = "gender")
    public CustomerGenderAJAXView gender;
}
