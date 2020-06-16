package app.producer;

import app.producer.api.ProducerWebService;
import app.producer.producer.service.ProducerService;
import app.producer.producer.web.ProducerWebServiceImpl;
import core.framework.module.Module;

/**
 * @author zoo
 */
public class ProducerModule extends Module {
    @Override
    protected void initialize() {
        bind(ProducerService.class);

        api().service(ProducerWebService.class, bind(ProducerWebServiceImpl.class));
    }
}
