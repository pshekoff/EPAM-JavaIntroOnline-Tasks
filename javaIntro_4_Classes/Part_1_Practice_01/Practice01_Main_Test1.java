package javaIntro_4_Classes;

public class Practice01_Main_Test1 {
	
	/* 1. Создайте класс Test1 с двумя переменными. Добавьте метод вывода на экран и методы
	 * изменения этих переменных. Добавьте метод, который находит сумму значений этих переменных,
	 * и метод, который находит наибольшее значение из этих двух переменных.
	 */
	
	public static void main(String[] args) {
		
		Test1 test = new Test1();
		test.setVar1(5);
		test.setVar2(8);
		
		test.print();
		System.out.println("Sum = " + test.sum());
		System.out.println("MaxVal = " + test.maxVal());		
	}
}
