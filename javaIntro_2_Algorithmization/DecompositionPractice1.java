package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice1 {

	public static void main(String[] args) {
			
		System.out.print("Введите 2 натуральных числа: ");
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		scan.close();
		
		System.out.print("Наибольший общий делитель: " + getNOD(a,b) + ";\nНаимельшее общее кратное: " + getNOK(a,b));
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
	
	public static int getNOK(int a, int b) {
		int nok = a*b/getNOD(a,b);
		return nok;
	}
}
