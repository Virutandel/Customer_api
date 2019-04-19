package com.apex.service.customer.test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;

import com.apex.service.core.ApexBaseServiceTest;
import com.apex.service.core.ApexHttpClientUtil;

public class CustomerServiceTest_POST_NG2 extends ApexBaseServiceTest {

	public static final String BASE_URL = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";

	@Test
	public void testPOSTwithSuccessData() throws ClientProtocolException, IOException {
		String url = BASE_URL + "/10";
		HttpResponse response = ApexHttpClientUtil.sendAndReceivePOSTMessage(url, "");
		// validate
		assertEquals(response.getStatusLine().getStatusCode(), 200);
		assertEquals(response.getStatusLine().getReasonPhrase(), "OK");

		// status code, status message, some test, tag present, tag not present, (IQ)
		// tag repeated,
		// Verify data
		// count
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
		
	}

	@Test
	public void testPOSTwithBlankData() throws ClientProtocolException, IOException {
		String url = BASE_URL + "/";
		HttpResponse response = ApexHttpClientUtil.sendAndReceivePOSTMessage(url, "");
		// validate
		StatusLine Ststus1 = response.getStatusLine();
		System.out.println(Ststus1);
		
		int Code = response.getStatusLine().getStatusCode();
		System.out.println(Code);
				
		assertEquals(response.getStatusLine().getStatusCode(), 400);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Bad Request");

		// status code, status message, some test, tag present, tag not present, (IQ)
		// tag repeated,
		// Verify data
		// count
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);

	}

	@Test
	public void testPOSTwithNonNumeric() throws ClientProtocolException, IOException {
		String url = BASE_URL + "/ABCD";
		HttpResponse response = ApexHttpClientUtil.sendAndReceivePOSTMessage(url, "");
		// validate
		StatusLine Ststus1 = response.getStatusLine();
		System.out.println(Ststus1);
		
		int Code = response.getStatusLine().getStatusCode();
		System.out.println(Code);
				
		assertEquals(response.getStatusLine().getStatusCode(), 400);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Bad Request");

		// status code, status message, some test, tag present, tag not present, (IQ)
		// tag repeated,
		// Verify data
		// count
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
	}

	@Test
	public void testPOSTwith404() throws ClientProtocolException, IOException { //Wrong URL or URL not Found
		String url = "http://www.thomas-bayer.com/sqlrestxyz/CUSTOMER/22"; // wrong URL
		HttpResponse response = ApexHttpClientUtil.sendAndReceivePOSTMessage(url, "");
		// validate
		StatusLine Ststus1 = response.getStatusLine();
		System.out.println(Ststus1);
		
		int Code = response.getStatusLine().getStatusCode();
		System.out.println(Code);
				
		assertEquals(response.getStatusLine().getStatusCode(), 404);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");

		// status code, status message, some test, tag present, tag not present, (IQ)
		// tag repeated,
		// Verify data
		// count
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
	}
}
	/*@Test
	public void testPOSTwith500() throws ClientProtocolException, IOException { // 500 problem with server or file system
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/22";
		
		//	String url = BASE_URL + "/22qwer";
		HttpResponse response = ApexHttpClientUtil.sendAndReceivePOSTMessage(url, "");
		// validate
		StatusLine Ststus1 = response.getStatusLine();
		System.out.println(Ststus1);
		
		int Code = response.getStatusLine().getStatusCode();
		System.out.println(Code);

		assertEquals(response.getStatusLine().getStatusCode(), 500);
		assertEquals(response.getStatusLine().getReasonPhrase(), "Not Found");
		// status code, status message, some test, tag present, tag not present, (IQ)
		// tag repeated,
		// Verify data
		// count
		String result = ApexHttpClientUtil.getResponeString(response);
		System.out.println(result);
	}

	@Test
	public void testPOSTwith403() {// client error page was not found or something wrong with the request
										//403 Forbidden Not allow to access 
	}

}
*/