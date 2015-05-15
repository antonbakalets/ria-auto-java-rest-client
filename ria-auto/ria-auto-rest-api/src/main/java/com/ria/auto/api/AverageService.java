package com.ria.auto.api;

import com.ria.auto.api.types.AverageResult;
import com.ria.auto.api.types.Criteria;

public interface AverageService {

    AverageResult calculate(Criteria criteria);
}
