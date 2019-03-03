package controllers;

import apimodels.Category;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.*;

@SuppressWarnings("RedundantThrows")
public interface CategoryApiControllerImpInterface {
    List<Category> category( @NotNull String key,  @NotNull Integer domain,  @NotNull Integer category,  @NotNull Integer parents) throws Exception;

}
