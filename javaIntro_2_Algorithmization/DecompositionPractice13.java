package javaIntro_2_Algorithmization;

import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class DecompositionPractice13 {

	public static void main(String[] args) {
		
		System.out.println("¬ведите n > 2");
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		scan.close();
		
		System.out.print("—писок простых чисел близнецов на отрезке [" + n + "," + 2*n + "]: " + Arrays.toString(getSimpleTwins(n)));

	}
	
	public static int[] getSimpleTwins(int n) {
		
		int count = 0;
		
		for (int i = n; i <= 2*n-2; i++) {
			if ((isSimple(i) == true)&(isSimple(i+2)) == true) {
				count += 2;
			}
		}
		
		int[] array = new int[count];
		count = 0;
		
		for (int i = n; i <= 2*n-2; i++) {
			if ((isSimple(i) == true)&(isSimple(i+2)) == true) {
				array[count] = i;
				array[count+1] = i+2;
				count += 2;
			}
		}
		return array;
	}
	
	public static boolean isSimple(int a) {
		
		boolean isSimple = true;

		for (int d = 2; d <= (int) Math.sqrt(a); d++) {
			if (a%d == 0) {
				isSimple = false;
				break;
			}
		}
		return isSimple;
	}

}
