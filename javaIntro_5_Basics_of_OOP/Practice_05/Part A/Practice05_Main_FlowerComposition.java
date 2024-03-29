package javaIntro_5_Basics_of_OOP;

public class Practice05_Main_FlowerComposition {
	
	/* Задача 5.
	 * Создать консольное приложение, удовлетворяющее следующим требованиям:
	 *  - Корректно спроектируйте и реализуйте предметную область задачи.
	 *  - Для создания объектов из иерархии классов продумайте возможность использования
	 *  порождающих шаблонов проектирования.
	 *  - Реализуйте проверку данных, вводимых пользователем, но не на стороне клиента.
	 *  - Для проверки корректности переданных данных можно применить регулярные выражения.
	 *  - Меню выбора действия пользователем можно не реализовыапть, используйте заглушку.
	 *  - Особое условие: переопределите, где необходимо, методы toString(), equals() и hashCode().
	 *  
	 * Вариант А. Цветочная композиция. Реализовать приложение, позволяющее создавать цветочные композиции
	 * (объект, представляющий собой цветочную композицию). Составляющими цветочной композиции являются
	 * цветы и упаковка.
	 */

	public static void main(String[] args) {
		
		Gift gift1 = new Gift();
		
		//добавление упаковки
		Package box1 = new FlowerPackage(FlowerPackage.Type.TAPE);
		gift1.setPackage(box1);
		
		//добавление цветов
		gift1.addItem(new Flower(Flower.Name.ASTER, 5));
		gift1.addItem(new Flower(Flower.Name.CHRYSANTHEMUMS, 4));
		gift1.addItem(new Flower(Flower.Name.TULIP, 3));
		
		gift1.output();
		
	}

}
