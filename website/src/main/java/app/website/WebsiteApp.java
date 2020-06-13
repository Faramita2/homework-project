package app.website;

import core.framework.module.App;

/**
 * @author meow
 */
public class WebsiteApp extends App {
    @Override
    protected void initialize() {
        loadProperties("app.properties");
        load(new CustomerModule());

        http().httpPort(8888);
    }
}
