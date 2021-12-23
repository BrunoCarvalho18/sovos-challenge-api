package com.challenge.sovos.test;

import org.junit.Assert;
import org.junit.Test;
import com.challenge.sovos.pojo.CreateUser;
import com.challenge.sovos.services.Responsee;
import com.challenge.sovos.services.ServicesImpl;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.restassured.RestAssured;

public class AllEndpointsTests {

	Gson gson = new Gson();
	ServicesImpl services = new ServicesImpl();
	Responsee assertion = new Responsee();
	Faker faker = new Faker();
	CreateUser createUser = new CreateUser();
	String search;

	public AllEndpointsTests() {
		RestAssured.baseURI = "https://gorest.co.in/public/v1";
	}

	@Test
	public void CreateNewUser() {
		String name = faker.name().firstName();
		createUser.setName(name);
		createUser.setGender("male");
		createUser.setEmail(faker.internet().emailAddress());
		createUser.setStatus("active");
		String json = gson.toJson(createUser);
		services.postEndpointWithAuthorization("/users","10c829b3539a4ef003272052a838a06ed496bbbf6fc1ed529a7b82e3de56a553", json);
		assertion.getResponsee().statusCode(201);
		Assert.assertEquals(assertion.saveObjectsBody("data.name"), name);
	}

	@Test
	public void SearchUser() {
		String id = "1901";
		services.getEndPoint("/users" + "/" + id);
		assertion.getResponsee().statusCode(200);
		Assert.assertEquals(assertion.saveObjectsBody("data.name"), "Juan");
	}

	@Test
	public void UpdateUser() {
		String id = "2622";
		String name = faker.name().firstName();
		createUser.setName(name);
		createUser.setGender("male");
		createUser.setEmail(faker.internet().emailAddress());
		createUser.setStatus("active");
		String json = gson.toJson(createUser);
        services.putEndpointWithAuthorization("users" + "/" + id, "10c829b3539a4ef003272052a838a06ed496bbbf6fc1ed529a7b82e3de56a553", json);
	}

	@Test
	public void DeleteUser() {
		String name = faker.name().firstName();
		createUser.setName(name);
		createUser.setGender("male");
		createUser.setEmail(faker.internet().emailAddress());
		createUser.setStatus("active");
		String json = gson.toJson(createUser);
		services.postEndpointWithAuthorization("/users","10c829b3539a4ef003272052a838a06ed496bbbf6fc1ed529a7b82e3de56a553", json);
		//delete with id created before
		services.deleteEndpointWithAuthorization("/users" +"/" + assertion.saveObjectsBody("data.id"), "10c829b3539a4ef003272052a838a06ed496bbbf6fc1ed529a7b82e3de56a553");
		assertion.getResponsee().statusCode(204);

	}

}
