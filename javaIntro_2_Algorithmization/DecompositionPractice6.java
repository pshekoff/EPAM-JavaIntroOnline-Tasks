package javaIntro_2_Algorithmization;

import java.util.Scanner;

public class DecompositionPractice6 {

	public static void main(String[] args) {
		
		System.out.println("������� 3 ����� �����:");
		
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		scan.close();
		
		int nodABC = getNOD(getNOD(a, b), c);
		
		if (nodABC == 1) {
			System.out.print("��������� ����� �������� ������� ��������.");
		}
		else {
			System.out.print("��������� ����� �� �������� ������� ��������.");
		}

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
