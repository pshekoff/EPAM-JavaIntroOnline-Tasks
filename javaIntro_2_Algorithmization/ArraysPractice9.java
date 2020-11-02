package javaIntro_2_Algorithmization;

public class ArraysPractice9 {

	public static void main(String[] args) {
		
		int[] myArr = {4, 9, -3, 8, 4, -6, -6, -6, 8, 4, 9, 9, 7, 1, 8};
		int[] myArrValCount = new int[myArr.length];
		
		for (int i = 0; i < myArr.length; i++) {
			for (int j = 0; j < myArr.length; j++) {
				if (myArr[i] == myArr[j]) {
					myArrValCount[i]++;
				}
			}
		}
		
		int maxCount = getMaxValue(myArrValCount);
		int maxValue = getMaxValue(myArr);
		
		for (int i = 0; i < myArr.length; i++) {
			if ((myArrValCount[i] == maxCount)&(myArr[i] <= maxValue)) {
				maxValue = myArr[i];
			}
		}
		
		System.out.println(maxValue);
	}
	
	public static int getMaxValue(int[] arr) {
		
		int maxValue = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] > maxValue) {
				maxValue = arr[i];
			}
		}
		
		return maxValue;
	}

}
