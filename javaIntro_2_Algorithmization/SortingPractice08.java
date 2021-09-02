package javaIntro_2_Algorithmization;

import java.lang.Math;

public class SortingPractice08 {
	
	// 8. Даны дроби p1/q1, p2/q2, ..., pn/qn (pi, qi - натуральные). Составить программу,
	// которая приводит эти дроби к общему знаменателю и упорядочиывет их в порядке возрастания.

	public static void main(String[] args) {
		
		//матрица из 10-и дробей (1-й ряд: числители, 2-ой ряд знаменатели)
		int[][] arrPQ = new int[2][10];
		
		//заполнение матрицы случайными числами от 1 до 9
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
		
		//нахождение общего знаменателя
		int comDen = arrPQ[1][0];
		for (int j = 1; j < arrPQ[1].length; j++) {
			int nod = getNOD(comDen, arrPQ[1][j]);
			comDen = comDen*arrPQ[1][j]/nod;
		}

		//приводим каждую дробь к общему знаменателю
		for (int j = 0; j < arrPQ[0].length; j++) {
			arrPQ[0][j] *= comDen/arrPQ[1][j];
			arrPQ[1][j] = comDen;
		}
		
		//сортировка дробей выбором по ворастанию
		for (int i = 0; i < arrPQ[0].length; i++) {
			int minIndex = i;
			for (int j = i; j < arrPQ[0].length; j++) {
				if (arrPQ[0][j] < arrPQ[0][minIndex]) {
					minIndex = j;
				}
			}
			int replace = arrPQ[0][i];
			arrPQ[0][i] = arrPQ[0][minIndex];
			arrPQ[0][minIndex] = replace;
		}
		
		System.out.println("\nДроби приведены к общему знаменателю и отсортированы по возрастанию:");
		MatrixOutput.print(arrPQ);
	}
	
	//поиск наибольшего общего делителя
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
