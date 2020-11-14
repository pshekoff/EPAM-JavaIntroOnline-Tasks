package javaIntro_3_Strings;

public class ObjectStringPractice02 {

	public static void main(String[] args) {

		String str = "The java is the most popular programming language.";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				str = str.substring(0, i+1) + 'b' + str.substring(i+1, str.length());
			}
		}
		System.out.println(str);
	}

}
