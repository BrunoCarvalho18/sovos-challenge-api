package com.challenge.sovos.services;

public interface Services {
	
	Responsee getEndPoint(String endPoint);
    Responsee postEndPoint(String endPoint, Object mensagem);
    Responsee putEndPoint(String endPoint, Object mensagem);
    Responsee deleteEndpoint(String endPoint);
    Responsee postEndpointWithAuthorization(String endPoint, String token, Object mensagem);
    Responsee deleteEndpointWithAuthorization(String endPoint, String token, Object mensagem);
    Responsee putEndpointWithAuthorization(String endPoint, String token, Object mensagem);

}
