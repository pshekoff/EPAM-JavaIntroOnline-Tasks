package javaIntro_3_Strings;

public class ObjectStringPractice05 {

	public static void main(String[] args) {
		
		String str = "m man a;r fwe a fwea ";
		int countA = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'a') {
				countA++;
			}
		}
		
		System.out.print("In the string \"" + str + "\" letter \"a\" occurs " + countA + " times.");

	}

}
