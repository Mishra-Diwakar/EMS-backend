package com.clickncash.utils;

import java.util.Random;

public class ClicknCashUtils {

	public static String getRandomString(int length) {
		String alphabet = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int index = random.nextInt(alphabet.length());
			char randomChar = alphabet.charAt(index);
			sb.append(randomChar);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getRandomString(21));
	}
}
