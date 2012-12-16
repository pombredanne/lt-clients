package com.github.lateralthoughts.rest;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class WorkersApiIT extends BaseApiTester {

    @Test
    public void should_request_workers_base_api_successfully() {
        expect()
            .statusCode(200)
            .and().body("links.href", hasItems("http://localhost:9999/workers/search"))
        .when()
            .get("/workers");
    }

    @Test
    public void should_request_workers_search_api_successfully() {
        expect()
            .statusCode(200)
            .and().body("links.rel", hasItems("workers.findByLastName"))
        .when()
            .get("/workers/search");
    }
}
