package controllers;

import apimodels.Category;

import play.mvc.Http;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.validation.constraints.*;

@SuppressWarnings("RedundantThrows")
public interface ProductApiControllerImpInterface {
    List<Category> product( @NotNull String key,  @NotNull Integer domain, String asin, String code) throws Exception;

}
