package javaIntro_2_Algorithmization;

public class SquareArraysPractice10 {
	
	public static void main(String[] args) {
		
		int[][] myArr = {{1,2,3,4,5},{-1,-2,-3,-4,5},{-2,-3,-4,5,6},{3,-4,-5,6,-7},{-3,4,-5,6,-7}};
		
		for (int i = 0; i < myArr.length; i++) {
			
			if (myArr[i][i] > 0) {
				
				System.out.println(myArr[i][i]);
			}
		}
	}

}
