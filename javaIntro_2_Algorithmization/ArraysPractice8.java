package javaIntro_2_Algorithmization;

public class ArraysPractice8 {

	public static void main(String[] args) {
		
		int[] myArr = {4,1,63,2,7,1,2,8,1,5};
		int minA = myArr[0];
		for (int i = 1; i < myArr.length; i++) {
			if (myArr[i] < minA) {
				minA = myArr[i];
			}
		}
		
		int minCount = 0;
		
		for (int i = 0; i < myArr.length; i++) {
			if (myArr[i] == minA) {
				minCount += 1;
			}
		}
		
		int[] newArr = new int[myArr.length - minCount];
		minCount = 0;
		
		for (int i = 0; i < newArr.length; i++) {
			int j = i + minCount;
			if (myArr[j] == minA) {
				minCount += 1;
			}
			newArr[i] = myArr[i + minCount];
			System.out.println(newArr[i]);
		}
	}

}
