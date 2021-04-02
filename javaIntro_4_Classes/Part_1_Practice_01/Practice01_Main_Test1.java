package javaIntro_4_Classes;

public class Practice01_Main_Test1 {
	public static void main(String[] args) {
		Test1 test = new Test1();
		test.setVar1(5);
		test.setVar2(8);
		test.print();
		System.out.println("Sum = " + test.sum());
		System.out.println("MaxVal = " + test.maxVal());		
	}
}
