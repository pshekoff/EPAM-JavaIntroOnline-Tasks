package javaIntro_2_Algorithmization;

public class IntArrayOutput {

	public static void oneDim(int[] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		
		System.out.println();
		
	}
	
	public static void twoDim(int[][] arr) {
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			
			System.out.println();
			
		}

	}

}
