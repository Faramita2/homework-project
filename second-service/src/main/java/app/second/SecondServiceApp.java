package app.second;

import core.framework.module.App;
import core.framework.module.SystemModule;

/**
 * @author zoo
 */
public class SecondServiceApp extends App {
    @Override
    protected void initialize() {
        load(new SystemModule("sys.properties"));
        loadProperties("app.properties");
//        load(new CatModule());
        load(new DogModule());
    }
}
