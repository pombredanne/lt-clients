package com.github.lateralthoughts.rest;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.expect;
import static org.hamcrest.core.IsCollectionContaining.hasItems;

public class CompaniesApiIT extends BaseApiTester {

    @Test
    public void should_request_companies_base_api_successfully() {
        expect()
            .statusCode(200)
            .and().body("links.href", hasItems("http://localhost:9999/companies/search"))
            .when()
            .get("/companies");
    }

    @Test
    public void should_request_companies_search_api_successfully() {
        expect()
            .statusCode(200)
            .and().body("links.rel", hasItems("companies.findByName"))
            .when()
            .get("/companies/search");
    }


}
