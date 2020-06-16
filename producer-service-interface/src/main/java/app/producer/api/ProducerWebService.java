package app.producer.api;

import core.framework.api.http.HTTPStatus;
import core.framework.api.web.service.POST;
import core.framework.api.web.service.Path;
import core.framework.api.web.service.ResponseStatus;

/**
 * @author zoo
 */
public interface ProducerWebService {
    @POST
    @Path("/producer")
    @ResponseStatus(HTTPStatus.CREATED)
    void create();
}
