package javaIntro_3_Strings;

public class ObjectStringPractice01 {

	public static void main(String[] args) {

		String str = "  father mother    sister  brother    cat dog       ";
		int count = 0;
		int maxCount = 0;
		
		for (int i = 0; i < str.length(); i++) {
			count = 0;
			while (str.charAt(i) == ' ') {
				count++;
				i++;
				if (i == str.length()) {
					break;
				}
			}
			if (maxCount < count) {
				maxCount = count;
			}
			
		}
		
		System.out.println("Space maximum count in a row is: " + maxCount);

	}

}
