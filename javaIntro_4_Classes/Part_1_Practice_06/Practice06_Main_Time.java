package javaIntro_4_Classes;

public class Practice06_Main_Time {
	
	/* 6. Составьте описание класса для представления времени. Предусмотрите возможности установки времени
	 * и изменения его отдельных полей (час, минута, секунда) с проверкой допустимости вводимых значений.
	 * В случае недопустимых значений полей поле устанавливается в значение 0. Создать методы изменения
	 * времени на заданное количество часов, минут и секунд.
	 */

	public static void main(String[] args) {
		
		Time t = new Time(2,30,24);
		t.print();
		t.increase(134,253,122);
		t.print();
	}
}
