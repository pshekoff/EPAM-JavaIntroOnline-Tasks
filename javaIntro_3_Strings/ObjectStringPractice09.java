package javaIntro_3_Strings;

import java.util.Scanner;

public class ObjectStringPractice09 {
	
	// 9. Посчитать количество строчных (маленьких) и прописных (больших) букв в введенной строке. Учитывать только английские буквы.

	public static void main(String[] args) {

		System.out.print("Enter string: ");
		Scanner scan = new Scanner(System.in);
		String sentence = scan.nextLine();
		scan.close();
		
		int upCount = 0;
		int lowCount = 0;
		
		byte[] arr = sentence.getBytes();
		
		for (int i = 0; i < arr.length; i++) {

			if ((97<=arr[i])&(arr[i]<=122)) {
				lowCount++;
			}
			else if ((65<=arr[i])&(arr[i]<=90)) {
				upCount++;
			}
		}
		System.out.println("Upper case count = " + upCount + "\nLower case count = " + lowCount);
	}
	
}
