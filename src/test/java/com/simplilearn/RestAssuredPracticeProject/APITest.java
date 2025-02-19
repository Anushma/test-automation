package com.simplilearn.RestAssuredPracticeProject;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class APITest {
	
	protected static final String AUTH_TOKEN = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJpc1ZlcmlmaWVkIjp0cnVlfQ.AFZ3lxh5h9vm_XFxssBqkHAnD-XJe6w9uYVESKIARmU";
	
	
	
	@Test
	public void getBookings() {
		Response response = given()
	            .header("Authorization", AUTH_TOKEN)
	            .when()
	            .get("http://localhost:3000/bookings")
	            .then()
	            .statusCode(200)
	            .extract().response();
	}
	
	@Test
	public void createBooking() {
		
		 String requestBody = "{ \"restaurantId\": 1, \"user\": \"Jane Doe\", \"date\": \"2025-02-22\" }";

	        given()
	            .header("Content-Type", "application/json")
	            .header("Authorization", AUTH_TOKEN)
	            .body(requestBody)
	            .when()
	            .post("http://localhost:3000/bookings")
	            .then()
	            .statusCode(201);
	         
	           
	}
	 
	
	@Test
	public void updateBooking() {
		String requestBody = "{ \"restaurantId\": 1, \"user\": \"ABC PVT LTD\", \"date\": \"2025-10-25\" }";

	    given()
	        .header("Content-Type", "application/json")
	        .header("Authorization", AUTH_TOKEN)
	        .body(requestBody)
	        .when()
	        .put("http://localhost:3000/bookings/1")
	        .then()
	        .statusCode(200);
	      
	}
	 
	
	@Test
	public void deleteBooking() {

	    given()
	    .header("Authorization", AUTH_TOKEN)
	        .when()
	        .delete("http://localhost:3000/bookings/5")
	        .then()
	        .statusCode(200);
		
	}
	 
	 
}
