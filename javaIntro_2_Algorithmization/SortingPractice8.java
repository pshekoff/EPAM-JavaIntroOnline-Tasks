package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SortingPractice8 {

	public static void main(String[] args) {

		int[][] arrPQ = new int[2][5];
		
		System.out.print("Числители:   ");
		for (int i = 0; i < arrPQ.length; i++) {
			for (int j = 0; j < arrPQ[i].length; j++) {
				arrPQ[i][j] = (int) Math.round(Math.random()*8 + 1);
				System.out.print(arrPQ[i][j] + " ");
			}
			if (i == 0) {
				System.out.print("\nЗнаменатели: ");
			}

		}
		
		int comDen = arrPQ[1][0];
		
		for (int j = 1; j < arrPQ[1].length; j++) {
			int nod = getNOD(comDen, arrPQ[1][j]);
			comDen = comDen*arrPQ[1][j]/nod;
		}
		
		for (int j = 0; j < arrPQ[0].length; j++) {
			arrPQ[0][j] *= comDen/arrPQ[1][j];
			arrPQ[1][j] = comDen;
		}
		
		for (int i = 0; i < arrPQ[0].length; i++) {
			int maxIndex = i;
			for (int j = i+1; j < arrPQ[0].length; j++) {
				if (arrPQ[0][j] < arrPQ[0][maxIndex]) {
					maxIndex = j;
				}
			}
			
			int replace = arrPQ[0][i];
			arrPQ[0][i] = arrPQ[0][maxIndex];
			arrPQ[0][maxIndex] = replace;

		}
		
		System.out.println("\nДроби приведены к общему знаменателю и отсортированы по возрастанию:");
		IntArrayOutput.twoDim(arrPQ);
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
