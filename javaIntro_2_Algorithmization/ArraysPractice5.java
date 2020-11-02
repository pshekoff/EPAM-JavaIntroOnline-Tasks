package javaIntro_2_Algorithmization;

public class ArraysPractice5 {

	public static void main(String[] args) {
		
		int[] myArr = {4,2,5,1,4,7,1,5,9,7,3};
		
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] > i+1) {
				System.out.println(myArr[i]);
			}
		}
	}

}
