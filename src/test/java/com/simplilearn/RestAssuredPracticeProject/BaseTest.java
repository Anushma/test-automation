package com.simplilearn.RestAssuredPracticeProject;

import java.lang.System.Logger;

import org.testng.annotations.BeforeClass;

import groovyjarjarantlr4.v4.runtime.misc.LogManager;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    protected static RequestSpecification request;
    protected static final String BASE_URL = "http://localhost:3000";
//    protected static final Logger logger = LogManager.getLogger(BaseTest.class);

    @BeforeClass
    public void setup() {
        request = RestAssured.given().baseUri(BASE_URL);
//        logger.info("Base URI Set: " + BASE_URL);
    }
}

