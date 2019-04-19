package com.apex.service.core;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

public class ApexHttpClientUtil {
	public static String getResponeString(HttpResponse response) throws IOException {
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line + "\n");
		}
		return result.toString();
	}

	public static HttpResponse sendAndReceiveGETMessage(String url) throws IOException, ClientProtocolException {
		// create apache client
		HttpClient client = HttpClientBuilder.create().build();
		// create request message
		HttpGet request = new HttpGet(url);
		// send and receive the response
		HttpResponse response = client.execute(request);
		return response;
	}

	
	public static HttpResponse sendAndReceivePOSTMessage(String url, String requestMessage) throws IOException, ClientProtocolException {
		// create apache client
		HttpClient client = HttpClientBuilder.create().build();
		// create request message
		HttpPost request = new HttpPost(url);
		StringEntity entity = new StringEntity(requestMessage);
		request.setEntity(entity);
		
		// send and receive the response
		HttpResponse response = client.execute(request);
		return response;
	}
	public static HttpResponse sendAndReceivePUTMessage(String url, String requestMessage) throws IOException, ClientProtocolException {
		// create apache client
		HttpClient client = HttpClientBuilder.create().build();
		// create request message
		HttpPut request = new HttpPut(url);
		StringEntity entity = new StringEntity(requestMessage);
		request.setEntity(entity);
		
		// send and receive the response
		HttpResponse response = client.execute(request);
		return response;
	}
	public static HttpResponse sendAndReceiveDELETEMessage(String url) throws IOException, ClientProtocolException {
		// create apache client
		HttpClient client = HttpClientBuilder.create().build();
		// create request message
		HttpDelete request = new HttpDelete(url);
		// send and receive the response
		HttpResponse response = client.execute(request);
		return response;
	}
}
