package com.ria.auto.rest.spring;

import com.ria.auto.api.types.AverageResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestOperations;
import com.ria.auto.api.AverageService;

public class AverageServiceImpl extends AbstractRestService implements AverageService {

    @Override
    public AverageResult calculate(String uri) {
        RestOperations restTemplate = getRestTemplate();
        ResponseEntity<AverageResult> averageResponse = restTemplate.getForEntity(uri, AverageResult.class);
        return averageResponse.getBody();
    }
}
