package javaIntro_1_Basics;

import java.math.BigInteger;

public class CyclesPractice4 {

	public static void main(String[] args) {
		BigInteger mult = new BigInteger("1");
		for (int i = 1; i <= 200; i++) {
			mult = mult.multiply(BigInteger.valueOf(i*i));
		}
		System.out.println("Multiplication of squares for the first 200 figures = " + mult);	
	}

}
