package javaIntro_2_Algorithmization;

public class ArraysPractice10 {

	public static void main(String[] args) {
		
		int[] myArr = {1,2,3,4,5,6,7,8,9};
		
		for (int i = 1; i < myArr.length; i += 2) {
			myArr[i] = 0;
		}
		
		for (int i = 0; i < myArr.length; i++) {
			System.out.println(myArr[i]);
		}
	}

}
