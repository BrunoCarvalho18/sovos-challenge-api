package com.challenge.sovos.test;

import org.junit.Test;
import com.challenge.sovos.pojo.CreateUser;
import com.challenge.sovos.services.Responsee;
import com.challenge.sovos.services.ServicesImpl;
import com.github.javafaker.Faker;
import com.google.gson.Gson;



public class AllEndpointsTests {
	
	Gson gson = new Gson();
	ServicesImpl services = new ServicesImpl();
	Responsee assertion = new Responsee();
	Faker faker = new Faker();
	CreateUser createUser = new CreateUser();
	
	
	
	@Test
	public void CreateNewUser() {
	  createUser.setName(faker.name().firstName());
	  createUser.setGender("male");
	  createUser.setEmail(faker.internet().emailAddress());
	  createUser.setStatus("active");
	  String json = gson.toJson(createUser);
	  services.postEndpointWithAuthorization("https://gorest.co.in/public/v1/users", "10c829b3539a4ef003272052a838a06ed496bbbf6fc1ed529a7b82e3de56a553", json);
	}

}
