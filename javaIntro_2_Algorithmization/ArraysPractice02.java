package javaIntro_2_Algorithmization;

public class ArraysPractice02 {
	
	// 2. Дана последовательность действительных чисел a1, a2, a3,..., an.
	// Заменить все ее члены, большие данного Z, этим числом. Посчитать количество замен.

	public static void main(String[] args) {
		
		double[] myArray = {4.5, 43.78, 13.568, 89.158, 1.34};
		double replaceZ = 10.39;
		int count = 0;
		
		for (int i = 0; i < myArray.length; i++) {
			
			if (myArray[i] > replaceZ) {
				myArray[i] = replaceZ;
				count++;
			}
		}
		
	    for (int i = 0; i < myArray.length; i++) {
	    	System.out.println(myArray[i]);
	    }
	    
	    System.out.println("Количество замен = " + count);
	}

}
