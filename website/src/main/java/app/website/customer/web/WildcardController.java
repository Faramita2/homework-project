package app.website.customer.web;

import core.framework.http.ContentType;
import core.framework.web.Request;
import core.framework.web.Response;

/**
 * @author neo
 */
public class WildcardController {
    public Response wildcard(Request request) {
        return Response.text("catch all url").contentType(ContentType.TEXT_HTML);
    }
}
