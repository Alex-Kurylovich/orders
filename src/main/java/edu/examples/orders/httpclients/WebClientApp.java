/**
 * 
 */
package edu.examples.orders.httpclients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import edu.examples.orders.dto.URLConstants;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.core5.http.ParseException;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author pratikdas
 *
 */
public class WebClientApp {
	
	public void invokeGet() {
		WebClient client = WebClient.create();
/*
		client
		.get()
		.uri(URLConstants.URL_GET)
        .header(URLConstants.API_KEY_NAME, URLConstants.API_KEY_VALUE)
        .retrieve()
        .bodyToMono(String.class)
        .subscribe(result->System.out.println("subscribe::" + result));
*/
		WebClient.ResponseSpec responseSpec = client.get()
				.uri(URLConstants.URL_GET)
				.header(URLConstants.API_KEY_NAME, URLConstants.API_KEY_VALUE)
				.retrieve();
		String responseBody = responseSpec.bodyToMono(String.class).block();

		System.out.println("result get::" + responseBody);
	}
	
	public void invokePost() {
		WebClient client = WebClient.create();
		
		String result = client
				.post()
        		.uri(URLConstants.URL_POST)
				.header("Content-Type", "application/json")
				.body(BodyInserters.fromValue(Objects.requireNonNull(prepareRequest())))
        		.exchange()
        		.flatMap(response -> response.bodyToMono(String.class))
        		.block();
		
		System.out.println("result post::"+result);
	}
	
	private String prepareRequest()  {
		HashMap<String, String> values = new HashMap<>() {
			{
				put("firstName", "Martha");
				put("lastName", "Peck");
				put("email", "manager.martha@gmail.com");
				put("phone", "416-5122-1371");
				put("role", "MANAGER");
				put("status", "ACTIVE");
				put("details", "Manager details - Martha");
			}
		};

		var objectMapper = new ObjectMapper();
		String requestBody;
		try {
			requestBody = objectMapper.writeValueAsString(values);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			return null;
		}
		return requestBody;
	}
	
	public static void main(String[] args) throws ClientProtocolException, IOException, ParseException {
		var client = new WebClientApp();
		client.invokeGet();
		client.invokePost();
	}

}
