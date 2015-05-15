package com.ria.auto.rest.spring;

import org.springframework.http.ResponseEntity;
import com.ria.auto.api.CatalogueService;
import com.ria.auto.api.types.BodyStyle;
import com.ria.auto.api.types.Category;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CatalogueServiceImpl extends AbstractRestService implements CatalogueService {

    public static final String URI_CATEGORIES = "http://api.auto.ria.com/categories";
    public static final String URI_BODY_STYLES = "http://api.auto.ria.com/bodystyles";
    public static final String URI_BODY_STYLES_CATEGORIES = "http://api.auto.ria.com/categories/%d/bodystyles";
    public static final String URI_BODY_STYLES_GROUPED = "http://api.auto.ria.com/categories/%d/bodystyles/_group";

    @Override
    public List<Category> searchCategories() {
        ResponseEntity<Category[]> categoryResponse = getRestTemplate().getForEntity(URI_CATEGORIES, Category[].class);
        return Arrays.asList(categoryResponse.getBody());
    }

    @Override
    public List<BodyStyle> searchBodyStyles() {
        ResponseEntity<BodyStyle[]> bodyStyleResponse = getRestTemplate().getForEntity(URI_BODY_STYLES, BodyStyle[].class);
        return Arrays.asList(bodyStyleResponse.getBody());
    }

    @Override
    public List<BodyStyle> searchBodyStyles(Category category) {
        String uri = String.format(URI_BODY_STYLES_CATEGORIES, category.getValue());
        ResponseEntity<BodyStyle[]> bodyStyleResponse = getRestTemplate().getForEntity(uri, BodyStyle[].class);
        return Arrays.asList(bodyStyleResponse.getBody());
    }

    @Override
    public Map<BodyStyle, List<BodyStyle>> groupBodyStyles(Category category) {
        String uri = String.format(URI_BODY_STYLES_GROUPED, category.getValue());
        ResponseEntity<BodyStyle[][]> bodyStyleResponse = getRestTemplate().getForEntity(uri, BodyStyle[][].class);
        Map<BodyStyle, List<BodyStyle>> result = new HashMap<BodyStyle, List<BodyStyle>>(bodyStyleResponse.getBody().length);
        for (BodyStyle[] bodyStylesGroup : bodyStyleResponse.getBody()) {
            BodyStyle key = bodyStylesGroup[0];
            List<BodyStyle> value = Arrays.asList(Arrays.copyOfRange(bodyStylesGroup, 1, bodyStylesGroup.length - 1));
            result.put(key, value);
        }
        return result;
    }

}
