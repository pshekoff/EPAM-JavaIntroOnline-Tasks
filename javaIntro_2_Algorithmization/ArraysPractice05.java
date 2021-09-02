package javaIntro_2_Algorithmization;

public class ArraysPractice05 {
	
	// 5. Даны целые числа a1, a2,...,an. Вывести на пепать только ье числа, для которых ai > i.

	public static void main(String[] args) {
		
		int[] myArr = {4,2,5,1,4,7,1,5,9,7,3};
		
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] > i+1) {
				System.out.println(myArr[i] + " > i = " + i);
			}
		}
	}

}
