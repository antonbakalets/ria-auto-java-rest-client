package com.ria.auto.api;

import com.ria.auto.api.types.Criteria;
import com.ria.auto.api.types.ObjectFactory;

/**
 *
 */
public class CriteriaBuilder {

    private static final ObjectFactory OF = new ObjectFactory();

    private Long category;
    private Long bodyStyle;

    public CriteriaBuilder setCategory(Long value) {
        this.category = value;
        return this;
    }

    public CriteriaBuilder setBodyStyle(Long bodyStyle) {
        this.bodyStyle = bodyStyle;
        return this;
    }

    public Criteria build() {
        Criteria result = OF.createCriteria();
        result.setCategoryId(this.category);
        result.setBodyStyleId(this.bodyStyle);
        return result;
    }
}
