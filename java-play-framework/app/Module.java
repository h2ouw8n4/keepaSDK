import com.google.inject.AbstractModule;

import controllers.*;

public class Module extends AbstractModule {

    @Override
    protected void configure() {
        bind(CategoryApiControllerImpInterface.class).to(CategoryApiControllerImp.class);
        bind(ProductApiControllerImpInterface.class).to(ProductApiControllerImp.class);
    }
}