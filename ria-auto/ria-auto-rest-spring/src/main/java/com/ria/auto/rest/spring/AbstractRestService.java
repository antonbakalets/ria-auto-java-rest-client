package com.ria.auto.rest.spring;

import org.springframework.web.client.RestTemplate;

class AbstractRestService {

    protected RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
