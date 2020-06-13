package app.customersite;

import core.framework.module.App;

/**
 * @author meow
 */
public class CustomerSiteApp extends App {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        load(new CustomerModule());

        http().httpPort(8888);
    }
}
