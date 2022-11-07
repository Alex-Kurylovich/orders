/**
 * 
 */
package edu.examples.orders.httpclients;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import edu.examples.orders.dto.URLConstants;

public class HttpClientApp {

	public void invokeGet() throws URISyntaxException {

		HttpClient client = HttpClient.newBuilder().version(Version.HTTP_2).followRedirects(Redirect.NORMAL).build();

		HttpRequest request = HttpRequest.newBuilder().uri(new URI(URLConstants.URL_GET)).GET()
				.header(URLConstants.API_KEY_NAME, URLConstants.API_KEY_VALUE).timeout(Duration.ofSeconds(10)).build();

		client.sendAsync(request, BodyHandlers.ofString())
		      .thenApply(HttpResponse::body)
		      .thenAccept(System.out::println)
			  .join();
	}

	public void invokePost() {
		try {
			String requestBody = prepareRequest();

			var client = HttpClient.newBuilder()
//					.sslContext(insecureContext())
					.build();

			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(URLConstants.URL_POST))
					.POST(HttpRequest.BodyPublishers.ofString(requestBody))
					.header("Content-Type", "application/json")
					.build();

			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

			System.out.println(response.statusCode() + "\n" + response.body());
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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

	public static void main(String[] args) throws URISyntaxException {
//		System.setProperty("jdk.internal.httpclient.disableHostnameVerification", Boolean.TRUE.toString());
//		System.setProperty("maven.wagon.http.ssl.insecure", Boolean.TRUE.toString());
//		System.setProperty("maven.wagon.http.ssl.allowall", Boolean.TRUE.toString());
//		System.setProperty("maven.wagon.http.ssl.ignore.validity.dates", Boolean.TRUE.toString());
		var client = new HttpClientApp();
		client.invokeGet();
		client.invokePost();
	}

//	static SSLContext insecureContext() {
//		TrustManager[] noopTrustManager = new TrustManager[]{
//				new X509TrustManager() {
//					public void checkClientTrusted(X509Certificate[] xcs, String string) {}
//					public void checkServerTrusted(X509Certificate[] xcs, String string) {}
//					public X509Certificate[] getAcceptedIssuers() {
//						return null;
//					}
//				}
//		};
//		try {
//			SSLContext sc = SSLContext.getInstance("ssl");
//			sc.init(null, noopTrustManager, null);
//			return sc;
//		} catch (KeyManagementException | NoSuchAlgorithmException ex) {}
//		return null;
//	}
}
