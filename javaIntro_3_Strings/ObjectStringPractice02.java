package javaIntro_3_Strings;

public class ObjectStringPractice02 {
	
	// 2. В строке вставить после каждого символа 'a' символ 'b'.

	public static void main(String[] args) {

		String str = "The java is the most popular programming language.";
		System.out.println("Source string:\n" + str);
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				str = str.substring(0, i+1) + 'b' + str.substring(i+1, str.length());
			}
		}
		System.out.println("Result string:\n" + str);
	}

}
