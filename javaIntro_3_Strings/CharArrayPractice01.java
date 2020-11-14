package javaIntro_3_Strings;

import java.util.Arrays;

public class CharArrayPractice01 {

	public static void main(String[] args) {
		
		String[] varNames = {"intFirstVar","intSecondVar","intThirdVar"};
		System.out.println("camelCase: " + Arrays.toString(varNames));
		
		for (int i = 0; i < varNames.length; i++) {
			varNames[i] = camel2Snake(varNames[i]);
		}
		
		System.out.println("snake_case: " + Arrays.toString(varNames));
	}
	
	public static String camel2Snake(String str) {

		for (int i = 0; i < str.length(); i++) {
			if (Character.isUpperCase(str.charAt(i))) {
				str = str.subSequence(0, i) + "_" + str.subSequence(i, str.length());
				i++;
			}
		}
		str = str.toLowerCase();
		return str;
	}

}
