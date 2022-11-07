package edu.examples.orders.httpclients;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import edu.examples.orders.dto.URLConstants;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class OkHttpClientApp {
	
	public void invokeGet() throws URISyntaxException, IOException {
	    OkHttpClient client = new OkHttpClient.Builder()
			    .readTimeout(1000, TimeUnit.MILLISECONDS)
			    .writeTimeout(1000, TimeUnit.MILLISECONDS)
			    .build();

		Request request = new Request.Builder()
			.url(URLConstants.URL_GET)
			.get()
			.addHeader(URLConstants.API_KEY_NAME, URLConstants.API_KEY_VALUE)
			.build();

		Call call = client.newCall(request);
		call.enqueue(new Callback() {
	        public void onResponse(Call call, Response response) 
	          throws IOException {
	        	System.out.println(response.body().string());
//				System.exit(1);
	        }
	        
	        public void onFailure(Call call, IOException e) {
	            // error
	        }
	    });
		System.out.println("invokeGet() completed");
	}
	
	public void invokePost() throws URISyntaxException, IOException {
	    OkHttpClient client = new OkHttpClient.Builder()
			    .readTimeout(1000, TimeUnit.MILLISECONDS)
			    .writeTimeout(1000, TimeUnit.MILLISECONDS)
			    .build();
	    
		String requestBody = prepareRequest();

	    RequestBody body = RequestBody.create(
	      requestBody,
	      MediaType.parse("application/json"));
	    
		Request request = new Request.Builder()
			.url(URLConstants.URL_POST)
			.post(body)
			.addHeader(URLConstants.API_KEY_NAME, URLConstants.API_KEY_VALUE)
			.build();

		Response response = client.newCall(request).execute();
		System.out.println(response.body().string());
		System.out.println("invokePost() completed");
	}

	private String prepareRequest() throws JsonProcessingException {
		Map<String, String> values = new HashMap<String, String>() {
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

		ObjectMapper objectMapper = new ObjectMapper();
		String requestBody = objectMapper.writeValueAsString(values);
		return requestBody;
	}
	
	public static void main(String[] args) throws URISyntaxException, IOException {
		var client = new OkHttpClientApp();
		client.invokeGet();
		System.out.println("OkHttpClientApp().invokeGet()");
		client.invokePost();
		System.out.println("OkHttpClientApp().invokePost()");
	}

}
