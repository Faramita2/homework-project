package app.backoffice;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author meow
 */
public class BackOfficeApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        loadProperties("app.properties");
        load(new CustomerModule());
    }
}
