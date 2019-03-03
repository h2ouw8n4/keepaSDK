package controllers;

import apimodels.Category;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.FileInputStream;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaPlayFrameworkCodegen", date = "2019-03-02T22:58:28.211Z[Etc/UTC]")

public class CategoryApiControllerImp implements CategoryApiControllerImpInterface {
    @Override
    public List<Category> category( @NotNull String key,  @NotNull Integer domain,  @NotNull Integer category,  @NotNull Integer parents) throws Exception {
        //Do your magic!!!
        return new ArrayList<Category>();
    }

}
