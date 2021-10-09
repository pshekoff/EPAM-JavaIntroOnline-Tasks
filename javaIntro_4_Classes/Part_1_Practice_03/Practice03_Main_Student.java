package javaIntro_4_Classes;

import java.util.Random;

public class Practice03_Main_Student {
	
	/* 3. Создайте класс с именем Student, содержащий поля: фамилия и инициалы, номер группы, успеваемость
	 * (массив из пяти элементов). Создайте массив из десяти элементов такого типа. Добавьте возможность
	 * вывода фамилий и номеров групп студентов, имеющих оценки, равные только 9 или 10.
	 */
	
	public static void main(String[] args) {
		
		Student[] studentList = new Student[10];
		studentList[0] = new Student("Fetisov A.A.", 611101);
		studentList[1] = new Student("Levsha N.F.", 611101);
		studentList[2] = new Student("Osipov E.B.", 611102);
		studentList[3] = new Student("Ezhova O.A.", 611102);
		studentList[4] = new Student("Denisov D.D.", 611102);
		studentList[5] = new Student("Homiak E.V.", 611102);
		studentList[6] = new Student("Novikova A.P.", 611103);
		studentList[7] = new Student("Titov A.V.", 611103);
		studentList[8] = new Student("Fadin E.L.", 611104);
		studentList[9] = new Student("Vilkova N.G.", 611104);
		
		//заполнение массива успеваемости студентов случайными оценками от 8 до 10
		Random ran = new Random();
		for (int i = 0; i < studentList.length; i++) {
			for (int j = 0; j < 5; j++) {
				studentList[i].addGrade(ran.nextInt(3)+8); //min grade is 8, max is 10
			}
		}
		
		//вывод всех студентов
		System.out.println("All students:");
		for (int i = 0; i < studentList.length; i++) {
			studentList[i].output();
		}
		
		//вывод отличников
		System.out.println("Excellent students:");
		for (int i = 0; i < studentList.length; i++) {
			if (studentList[i].isOK()) {
				studentList[i].output();
			}
		}
	}
}
