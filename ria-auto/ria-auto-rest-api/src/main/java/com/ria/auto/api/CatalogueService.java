package com.ria.auto.api;

import com.ria.auto.api.types.BodyStyle;
import com.ria.auto.api.types.Category;

import java.util.List;
import java.util.Map;

public interface CatalogueService {

    List<Category> searchCategories();

    List<BodyStyle> searchBodyStyles();

    List<BodyStyle> searchBodyStyles(Category category);

    Map<BodyStyle, List<BodyStyle>> groupBodyStyles(Category category);
}
