package com.clickncash;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class InstantPay {

	private static final String CLIENT_ID= "YWY3OTAzYzNlM2ExZTJlOZjSSgWhZkV27xMQ2xyiR1g=";
	private static final String CLIENT_SECRET= "0755161137bf3a6e1ebcebf359bfb2e0f0e705521e64ffef57235f631eb315f0";
	private static final String ENDPOINT = "43.224.137.96";
	private static final String CONTENT_TYPE = "application/json";
	
	public static String payout(String requestData) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestData);
			Request request = new Request.Builder()
					.url("https://api.instantpay.in/payments/payout").method("POST", body)
					.addHeader("X-Ipay-Auth-Code", "1")
					.addHeader("X-Ipay-Client-Id", CLIENT_ID)
					.addHeader("X-Ipay-Client-Secret", CLIENT_SECRET)
					.addHeader("Accept", CONTENT_TYPE)
					.addHeader("Content-Type", CONTENT_TYPE)
					.addHeader("X-Ipay-Endpoint-Ip", "122.161.72.167").build();
			Response response = client.newCall(request).execute();
			return response.body().string();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static String checkStatus(String requestData) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestData);
			Request request = new Request.Builder()
					.url("https://api.instantpay.in/reports/txnStatus").method("POST", body)
					.addHeader("X-Ipay-Auth-Code", "1")
					.addHeader("X-Ipay-Client-Id", CLIENT_ID)
					.addHeader("X-Ipay-Client-Secret", CLIENT_SECRET)
					.addHeader("Accept", CONTENT_TYPE)
					.addHeader("Content-Type", CONTENT_TYPE)
					.addHeader("X-Ipay-Endpoint-Ip", "122.161.72.167").build();
			Response response = client.newCall(request).execute();
			return response.body().string();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(payout(null));
	}
}
