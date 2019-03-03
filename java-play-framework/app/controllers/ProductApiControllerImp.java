package controllers;

import apimodels.Category;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileInputStream;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-03-02T22:58:28.211Z[Etc/UTC]")

public class ProductApiControllerImp implements ProductApiControllerImpInterface {
    @Override
    public List<Category> product( @NotNull String key,  @NotNull Integer domain, String asin, String code) throws Exception {
        //Do your magic!!!
        return new ArrayList<Category>();
    }

}
