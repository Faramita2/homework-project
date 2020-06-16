package app.producer.producer.web;

import app.producer.api.ProducerWebService;
import app.producer.api.producer.ProducerCreatedRequest;
import app.producer.producer.service.ProducerService;
import core.framework.inject.Inject;

/**
 * @author zoo
 */
public class ProducerWebServiceImpl implements ProducerWebService {
    @Inject
    ProducerService service;

    @Override
    public void create(ProducerCreatedRequest request) {
        service.create(request);
    }
}
