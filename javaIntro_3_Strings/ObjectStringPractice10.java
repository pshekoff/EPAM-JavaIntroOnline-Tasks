package javaIntro_3_Strings;

public class ObjectStringPractice10 {

	public static void main(String[] args) {
		
		String text = "Hello! How are you? My name is Pavel. I'm 32 years old.";
		
		int count = 0;
		
		for (int i = 0; i < text.length(); i++) {
			if ((text.charAt(i) == '.')|(text.charAt(i) == '!')|(text.charAt(i) == '?')) {
				count++;
			}
		}
		
		System.out.print("Sentence count is " + count);

	}

}
