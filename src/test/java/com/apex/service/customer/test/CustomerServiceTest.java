package com.apex.service.customer.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class CustomerServiceTest {

	public static void main(String[] args) throws ClientProtocolException, IOException {

		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/20";

		// create apache client
		HttpClient client = HttpClientBuilder.create().build();

		// create request message
		HttpGet request = new HttpGet(url);

		// send and receive the response
		HttpResponse response = client.execute(request);

		// validate
		int statusCode = response.getStatusLine().getStatusCode();
		String statusMessages = response.getStatusLine().getReasonPhrase();

		System.out.println(statusCode);
		System.out.println(statusMessages);

		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line + "\n");
		}
		System.out.println(result.toString());

	}
}
