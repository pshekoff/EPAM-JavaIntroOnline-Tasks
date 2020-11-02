package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice2 {

	public static void main(String[] args) {

		System.out.print("Введите 4 натуральных числа: ");
		
		int[] arr = new int[4];
		
		Scanner scan = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		
		int nod = getNODSeveral(arr);
		
		System.out.print("Наименьший общий делитель: " + nod);
	}
	
	public static int getNODSeveral(int[] array) {
		int nod = array[0];
		
		for (int i = 1; i < array.length; i++) {
			nod = getNOD(nod,array[i]);
		}
		
		return nod;
	}
	
    public static int getNOD(int a, int b) {
        int nod = 0;
    	int c = 0;
        if (a > b) {
        	while (b != 0) {
        		c = a % b;
        		a = b;
        		b = c;
        	}
        	nod = a;
        }
        else if (b > a) {
        	while (a != 0) {
        		c = b % a;
        		b = a;
        		a = c;
        	}
        	nod = b;
        }
        else if (a == b) {
        	nod = a;
        } 
        
        return nod;
    }

}
