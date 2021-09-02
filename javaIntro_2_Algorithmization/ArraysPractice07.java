package javaIntro_2_Algorithmization;

public class ArraysPractice07 {
	
	// 7. Даны действительные числа a1, a2,...,an. Найти max(a1 + a2n, a2 + a2n-1,..., an + an+1).

	public static void main(String[] args) {
		
		double[] myArr = {3.1, 6.4, 2.3, 5.8, 1.9, 9.6, 4.6, 3.7, 1.1, 4.3};
		double maxSum = myArr[0] + myArr[myArr.length - 1];
		
		for (int i = 1; i < myArr.length/2; i++) {
			if (myArr[i] + myArr[myArr.length - i - 1] > maxSum) {
				maxSum = myArr[i] + myArr[myArr.length - i - 1];
			}
		}
		
		System.out.println("Ответ: " + maxSum);
	}

}
