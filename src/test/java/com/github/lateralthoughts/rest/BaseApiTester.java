package com.github.lateralthoughts.rest;

import com.github.lateralthoughts.rest.utils.WebServer;
import com.jayway.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;

public class BaseApiTester {

    private static final int PORT = 9999;
    private WebServer webServer;

    @Before
    public void bootstrapServer() {
        RestAssured.port = PORT;
        RestAssured.baseURI = "http://localhost";
        RestAssured.basePath = "/";

        webServer = new WebServer(9999, "src/main/webapp");
        webServer.start();
    }

    @After
    public void shutdown() {
        webServer.stop();
    }
}
