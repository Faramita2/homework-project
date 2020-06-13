package app.customer.api.customer;

import core.framework.api.validate.NotNull;
import core.framework.api.web.service.QueryParam;

/**
 * @author zoo
 */
public class BOSearchCustomerRequest {
    @NotNull
    @QueryParam(name = "skip")
    public Integer skip = 0;

    @NotNull
    @QueryParam(name = "limit")
    public Integer limit = 1000;

    @QueryParam(name = "name")
    public String name;

    @QueryParam(name = "gender")
    public CustomerGenderView gender;
}
