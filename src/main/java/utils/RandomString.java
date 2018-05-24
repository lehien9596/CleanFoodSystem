package utils;

import java.util.Random;

public class RandomString {
	private static String DEFAUT_CHAR = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
	public static String create6CharRandom() {
		StringBuffer res = new StringBuffer();
		Random rd = new Random();
		for (int i=0; i<6; i++) {
			res.append(DEFAUT_CHAR.charAt(rd.nextInt(DEFAUT_CHAR.length())));
		}
		return res.toString();
	}
}
