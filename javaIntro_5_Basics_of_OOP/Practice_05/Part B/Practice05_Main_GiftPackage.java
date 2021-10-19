package javaIntro_5_Basics_of_OOP;

public class Practice05_Main_GiftPackage {
	
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
	 * Вариант В. Подарки. Реализовать приложение, позволяющее создавать подарки (объект, представляющий собой
	 * подарок). Состовляющими целого подарка являются сладости и упаковка.
	 */

	public static void main(String[] args) {
		
		Gift gift1 = new Gift();
		
		//добавление упаковки
		Package box1 = new SweetsPackage(SweetsPackage.Type.BASKET);
		gift1.setPackage(box1);
		
		//добавление сладостей
		gift1.addItem(new Sweetness(Sweetness.Name.CANDY, 15));
		gift1.addItem(new Sweetness(Sweetness.Name.CAKE, 2));
		gift1.addItem(new Sweetness(Sweetness.Name.LOLLIPOP, 10));
		gift1.addItem(new Sweetness(Sweetness.Name.CHOCOLATE, 5));
		
		gift1.output();

	}

}
