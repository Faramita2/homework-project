package app.website.customer.web;

import core.framework.web.Request;
import core.framework.web.Response;

/**
 * @author meow
 */
public class HomeController {
    public Response index(Request request) {
        return Response.text("customer index");
    }
}
