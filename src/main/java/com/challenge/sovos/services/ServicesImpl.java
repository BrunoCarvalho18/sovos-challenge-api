package com.challenge.sovos.services;

import static io.restassured.RestAssured.given;
import io.restassured.response.Response;

public class ServicesImpl implements Services {
	
	private Response responsee;

	@Override
	public Responsee getEndPoint(String endPoint) {
		 responsee = given().when().log().all().get(endPoint);
			return new Responsee(responsee);
	}

	@Override
	public Responsee postEndPoint(String endPoint, Object mensagem) {
		responsee = given().contentType("application/json").body(mensagem).when().log().all().post(endPoint);
		return new Responsee(responsee);
	}

	@Override
	public Responsee putEndPoint(String endPoint, Object mensagem) {
		responsee = given().contentType("application/json").body(mensagem).when().log().all().put(endPoint);
		return new Responsee(responsee);
	}

	@Override
	public Responsee deleteEndpoint(String endPoint) {
		responsee = given().when().log().all().delete(endPoint);
		return new Responsee(responsee);
	}
	
	public  Responsee postEndpointWithAuthorization(String endPoint, String token, Object mensagem) {
		responsee = given().header("Authorization","Bearer "+token)
				  .contentType("application/json")
				  .body(mensagem).when().log()
				.  all().post(endPoint);
		return new Responsee(responsee);
		
	}

}
