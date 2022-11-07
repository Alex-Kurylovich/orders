package edu.examples.orders.httpclients;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import edu.examples.orders.dto.URLConstants;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.async.methods.SimpleHttpRequest;
import org.apache.hc.client5.http.async.methods.SimpleHttpResponse;
import org.apache.hc.client5.http.async.methods.SimpleRequestBuilder;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.async.CloseableHttpAsyncClient;
import org.apache.hc.client5.http.impl.async.HttpAsyncClients;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.concurrent.FutureCallback;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpResponse;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ApacheHttpClientApp {

	
    public void invokeGet() {
        
            try(
            		CloseableHttpAsyncClient client = HttpAsyncClients.createDefault();) {
            		client.start();
                    
                    final SimpleHttpRequest request = SimpleRequestBuilder.get()
                    		.setUri(URLConstants.URL_GET)
                    		.addHeader(URLConstants.API_KEY_NAME, URLConstants.API_KEY_VALUE)
                            .build();
                    
                    Future<SimpleHttpResponse> future = 
                    		client.execute(request, 
                    				new FutureCallback<SimpleHttpResponse>() {

						@Override
						public void completed(SimpleHttpResponse result) {
							String response = result.getBodyText();
							System.out.println("response::"+response);
						}

						@Override
						public void failed(Exception ex) {
							System.out.println("response::"+ex);
						}

						@Override
						public void cancelled() {
							// TODO Auto-generated method stub
							
						}
                    	
                    });
                    HttpResponse response = future.get();
                    
	                // Get HttpResponse Status
	                System.out.println("version "+ response.getVersion());              // HTTP/1.1
	                System.out.println(response.getCode());   // 200
	                System.out.println(response.getReasonPhrase()); // OK
	
            } catch (InterruptedException | ExecutionException | IOException e) {
				e.printStackTrace();
			} 
    }
    
    public void invokePost() {
    	
    	StringEntity stringEntity = new StringEntity(prepareRequest());
    	HttpPost httpPost = new HttpPost(URLConstants.URL_POST);

        httpPost.setEntity(stringEntity);
        httpPost.setHeader("Content-type", "application/json");

        try(
        		CloseableHttpClient httpClient = HttpClients.createDefault();
        		
                CloseableHttpResponse response = httpClient.execute(httpPost);) {

                // Get HttpResponse Status
                System.out.println("version "+ response.getVersion()); // HTTP/1.1
                System.out.println(response.getCode());   // 200
                System.out.println(response.getReasonPhrase()); // OK

                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    // return it as a String
                    String result = EntityUtils.toString(entity);
                    System.out.println(result);
                }

        } catch (ParseException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
        
    }
    
	private String prepareRequest() {
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
		String requestBody;
		try {
			requestBody = objectMapper.writeValueAsString(values);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		return requestBody;
	}
	public static void main(String[] args) throws ClientProtocolException, IOException, ParseException {
		var client = new ApacheHttpClientApp();
		client.invokeGet();
		client.invokePost();
	}

}
