package app.customer;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author zoo
 */
public class CustomerServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        http().httpPort(8080);

        load(new CustomerModule());
    }
}
