package javaIntro_4_Classes;

public class Practice02_Main_Test2 {
	
	/* 2. Создайте класс Test2 с двумя переменными. Добавьте конструктор с входными параметрами.
	 * Добавьте конструктор, инициализирующий члены класса по умолчанию. Добавьте set- и get-
	 * методы для полей экземпляра класса.
	 */
	
	public static void main(String[] args) {
		
		//объект класса Test2 с переменными по умолчанию
		Test2 test = new Test2();
		System.out.println("Variables by default are: " + test.getVar1() + " and " + test.getVar2());
		
		//установка новых значений переменных
		test.setVar1(49);
		test.setVar2(169);
		System.out.println("New varialbles are: "+ test.getVar1() + " and  " + test.getVar2());		
	}
}
