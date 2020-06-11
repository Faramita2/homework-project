package app.first;

import app.FirstServiceApp;
import core.framework.test.module.AbstractTestModule;

/**
 * @author neo
 */
public class TestModule extends AbstractTestModule {
    @Override
    protected void initialize() {
        load(new FirstServiceApp());
    }
}
