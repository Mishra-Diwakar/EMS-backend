package com.clickncash;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Iserveu {

	private static final String CLIENT_ID = "";
	private static final String CLIENT_SECRET = "";

	private static final String PAYOUT_CLIENT_ID = "";
	private static final String PAYOUT_CLIENT_SECRET = "";
	
	private static final String CONTENT_TYPE = "application/json";
//	private static final String URL = "https://apiprod.iserveu.tech/production/";
	private static final String URL = "";

	public static HashMap<String, Object> onboarding1(String requestData) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, requestData);
					Request request = new Request.Builder()
					  .url(URL+ "apiAgentOnboarding/externalonboard")
					  .method("POST", body)
					  .addHeader("client_id", CLIENT_ID)
					  .addHeader("client_secret", CLIENT_SECRET)
					  .addHeader("Content-Type", CONTENT_TYPE).build();
					Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
	    	returnMap = new Gson().fromJson(jsonData, HashMap.class);
		} catch (Exception e) {

		}
		return returnMap;
	}
	
	public static HashMap<String, Object> onboarding2(String requestData) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder()
					  .build();
					MediaType mediaType = MediaType.parse("application/json");
					RequestBody body = RequestBody.create(mediaType, requestData);
					Request request = new Request.Builder()
					  .url(URL+ "api/upi/composer/selfonboarding")
					  .method("POST", body)
					  .addHeader("client_id", CLIENT_ID)
					  .addHeader("client_secret", CLIENT_SECRET)
					  .addHeader("Content-Type", CONTENT_TYPE).build();
					Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
	    	returnMap = new Gson().fromJson(jsonData, HashMap.class);
		} catch (Exception e) {

		}
		return returnMap;
	}
	
	public static HashMap<String, Object> generatePaymentLinkAmount(String data) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, data);
			Request request = new Request.Builder()
					.url(URL+ "api/upi/initiate-dynamic-transaction").method("POST", body)
					.addHeader("client_id", CLIENT_ID)
					.addHeader("client_secret", CLIENT_SECRET)
					.addHeader("Content-Type", CONTENT_TYPE).build();
			Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
	    	returnMap = new Gson().fromJson(jsonData, HashMap.class);
		} catch (Exception e) {

		}
		return returnMap;
	}

	public static HashMap<String, Object> txnCheckPayInStatus(String requestData) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestData);
			Request request = new Request.Builder()
					.url("https://apiprod.iserveu.tech/production/statuscheck/txnreport").method("POST", body)
					.addHeader("client_id", CLIENT_ID)
					.addHeader("client_secret", CLIENT_SECRET)
					.addHeader("Content-Type", CONTENT_TYPE).build();
			Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
	    	returnMap = new Gson().fromJson(jsonData, HashMap.class);
		} catch (Exception e) {

		}
		return returnMap;
	}
	
	public static HashMap<String, Object> txnCheckPayOutStatus(String requestData) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestData);
			Request request = new Request.Builder()
					.url("https://apiprod.iserveu.tech/production/statuscheck/txnreport").method("POST", body)
					.addHeader("client_id", PAYOUT_CLIENT_ID)
					.addHeader("client_secret", PAYOUT_CLIENT_SECRET)
					.addHeader("Content-Type", CONTENT_TYPE).build();
			Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
	    	returnMap = new Gson().fromJson(jsonData, HashMap.class);
		} catch (Exception e) {

		}
		return returnMap;
	}

	public static String payout(String requestData) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestData);
			Request request = new Request.Builder()
					.url("https://apiprod.iserveu.tech/production/prod-apiusercashout/cashtransfer").method("POST", body)
					.addHeader("client_id", PAYOUT_CLIENT_ID)
					.addHeader("client_secret", PAYOUT_CLIENT_SECRET)
					.addHeader("Content-Type", CONTENT_TYPE).build();
			Response response = client.newCall(request).execute();
			return response.body().string();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String callbackToClient(String payinCallbackURL, String json) {		
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient().newBuilder().build();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, json);
			Request request = new Request.Builder()
					.url(payinCallbackURL).method("POST", body)
					.build();
			Response response = client.newCall(request).execute();
			return response.body().string();
		} catch (Exception egnored) {
			
		}
		return null;
	}
}
