package com.ria.auto.rest.spring;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import com.ria.auto.api.AverageService;
import com.ria.auto.api.types.AverageResult;
import com.ria.auto.api.types.Criteria;

public class AverageServiceImpl extends AbstractRestService implements AverageService {

    private CriteriaConverter criteriaConverter = new CriteriaConverter();

    @Override
    public AverageResult calculate(Criteria criteria) {
        String uri = criteriaConverter.buildUri(criteria);
        RestOperations restTemplate = getRestTemplate();
        ResponseEntity<AverageResult> averageResponse = restTemplate.getForEntity(uri, AverageResult.class);
        return averageResponse.getBody();
    }
}
