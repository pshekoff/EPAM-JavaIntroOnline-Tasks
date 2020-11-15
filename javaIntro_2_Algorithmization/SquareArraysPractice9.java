package javaIntro_2_Algorithmization;

public class SquareArraysPractice9 {
	
	public static void main(String[] args) {
		
		int[][] myArr = {{1,2,3,4,5},{2,3,4,5,6},{3,4,5,6,7},{4,5,6,7,8},{5,6,7,8,9}};
		int[] arrSum = new int[5];
		
		for (int i = 1; i < myArr.length; i++) {
			for (int j = 0; j < myArr[i].length; j++) {
				arrSum[i] += myArr[j][i];
			}
		}
		
		int maxSumIndex = 0;
		
		for (int i = 0; i < arrSum.length-1; i++) {
			if (arrSum[i+1] > arrSum[i]) {
				maxSumIndex = i+1;
			}
		}
		
		IntArrayOutput.twoDim(myArr);
		System.out.print("Максимальная сумма чисел в " + (maxSumIndex+1) + "-м столбце и равна " + arrSum[maxSumIndex]);
	}

}
