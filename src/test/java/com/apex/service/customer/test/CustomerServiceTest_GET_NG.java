package com.apex.service.customer.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.apex.service.core.ApexBaseServiceTest;
import com.apex.service.core.ApexHttpClientUtil;

public class CustomerServiceTest_GET_NG extends ApexBaseServiceTest implements CustomerServiceConstsnt {

	@Test
	public void testGETwithSuccessData() throws ClientProtocolException, IOException {
		String url = BASE_URL + "/20";
		HttpResponse response = ApexHttpClientUtil.sendAndReceiveGETMessage(url);
		// validate
		assertEquals(response.getStatusLine().getStatusCode(), 200);
		assertEquals(response.getStatusLine().getReasonPhrase(), "OK");
		
		//status code, status message, some test, tag present, tag not present, (IQ)
		//tag repeated, 
		//Verify data
		//count		
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
		Assert.assertTrue(result.contains("<FIRSTNAME>Janet</FIRSTNAME>"));
	}

	
	@Test
	public void testGETwithBlankData() throws ClientProtocolException, IOException {
		String url = BASE_URL + "/";
		HttpResponse response = ApexHttpClientUtil.sendAndReceiveGETMessage(url);
		// validate
		
		assertEquals(response.getStatusLine().getStatusCode(), 200);
		assertEquals(response.getStatusLine().getReasonPhrase(), "OK");
		//Verification
		//status code, status message, some test, tag present, tag not present, (IQ)
		//tag repeated, 
		//Verify data
		//count		
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
		Assert.assertTrue(result.contains(""));
	
	}

	@Test
	public void testGETwithNonNumeric() throws ClientProtocolException, IOException { //non Numeric Status 404 - Resource not found
		String url = BASE_URL + "/abcd";
		HttpResponse response = ApexHttpClientUtil.sendAndReceiveGETMessage(url);
		// validate
		
		assertEquals(response.getStatusLine().getStatusCode(), 404);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");
		
		//status code, status message, some test, tag present, tag not present, (IQ)
		//tag repeated, 
		//Verify data
		//count		
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
		Assert.assertTrue(result.contains(""));
	
	}

	@Test
	public void testGETwith404() throws ClientProtocolException, IOException { // Data Not Found  404 data not found
		String url = BASE_URL + "/2000";
		HttpResponse response = ApexHttpClientUtil.sendAndReceiveGETMessage(url);
		// validate
		assertEquals(response.getStatusLine().getStatusCode(), 404);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");
	}

/*	@Test
	public void testGETwith500() throws ClientProtocolException, IOException { // 500 problem with server or file system
		String url = "httpp://www.thomas-bayer.com/sqlrest/CUSTOMER/22";
		HttpResponse response = ApexHttpClientUtil.sendAndReceiveGETMessage(url);
		// validate
		
		int code = response.getStatusLine().getStatusCode();
		System.out.println("Code is: " + code);
		String S1 = response.getStatusLine().getReasonPhrase();
		System.out.println("String is: " + S1);
		
		
		assertEquals(response.getStatusLine().getStatusCode(), 500);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");
		
		//status code, status message, some test, tag present, tag not present, (IQ)
		//tag repeated, 
		//Verify data
		//count		
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
		Assert.assertTrue(result.contains(""));
	
	}

	@Test
	public void testGETwith403() throws ClientProtocolException, IOException { // client error page was not found or something wrong with the request
		String url = BASE_URL+ "/20";						//403 Forbidden, server is Not allow to access the data 
		HttpResponse response = ApexHttpClientUtil.sendAndReceiveGETMessage(url);
		// validate
		
		assertEquals(response.getStatusLine().getStatusCode(), 403);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");
		
		//status code, status message, some test, tag present, tag not present, (IQ)
		//tag repeated, 
		//Verify data
		//count		
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
		Assert.assertTrue(result.contains(" "));

	}
*/
}