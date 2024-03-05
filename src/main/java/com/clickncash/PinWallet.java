package com.clickncash;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class PinWallet {

	public static void main(String[] args) throws IOException {
	
	}
	
	public static int generateRandomNumber(){
		int min = 50000000;  
		int max = 99999999;  
		int b = (int)(Math.random()*(max-min+1)+min);  
		return b;
	}
	
	public static String generateToken() throws IOException {
		String token = "";
		OkHttpClient client = new OkHttpClient();
		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType, "{\"userName\":\"9267940975\",\"password\":\"bc1ca224e7dcfcff2904790aa71915ea7e05d33213f4bf5152d58770a62cb424\"}");
    	Request request = new Request.Builder()
    	  .url("https://app.pinwallet.in/api/token/create")
    	  .post(body)
    	  .addHeader("accept", "application/json")
    	  .addHeader("Content-Type", "application/json")
    	  .build();
    	Response response = client.newCall(request).execute();
    	String jsonData = response.body().string();
    	HashMap<String, Object> returnMap = new Gson().fromJson(jsonData, HashMap.class);
    	Map<String, Object> tokenMap = (Map<String, Object>) returnMap.get("data");
    	token = (String) tokenMap.get("token");
		System.out.println(jsonData);
		return token;
	}

	public static HashMap<String, Object> createUpi(String requestData) {
    	HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, requestData);
	    	Request request = new Request.Builder()
	    	  .url("https://app.pinwallet.in/api/Dyupi/V1/GenerateUPI")
	    	  .post(body)
	    	  .addHeader("cache-control", "no-cache")
	    	  .addHeader("Content-Type", "application/json")
	    	  .addHeader("authorization", "Bearer "+ generateToken())
	    	  .addHeader("IPAddress", "103.205.64.251")
	    	  .build();
	    	Response response = client.newCall(request).execute();
	    	String jsonData = response.body().string();
	    	System.out.println(jsonData);
	    	returnMap = new Gson().fromJson(jsonData, HashMap.class);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return returnMap;
	}

	public static HashMap<String, Object> payOut(String payInRequest) {
		HashMap<String, Object> returnMap = new HashMap<>();
		try {
			OkHttpClient client = new OkHttpClient();
			MediaType mediaType = MediaType.parse("application/json");
			RequestBody body = RequestBody.create(mediaType, payInRequest);
	    	Request request = new Request.Builder()
	    	  .url("https://app.pinwallet.in/api/payout/dotransaction")
	    	  .post(body)
	    	  .addHeader("cache-control", "no-cache")
	    	  .addHeader("Content-Type", "application/json")
	    	  .addHeader("authorization", "Bearer "+ generateToken())
	    	  .addHeader("IPAddress", "103.205.64.251")
	    	  .build();
	    	Response response = client.newCall(request).execute();
	    	String jsonData = response.body().string();
	    	System.out.println(jsonData);
	    	returnMap = new Gson().fromJson(jsonData, HashMap.class);
		}catch (Exception e) {
			
		}
		return returnMap;
	}
}
