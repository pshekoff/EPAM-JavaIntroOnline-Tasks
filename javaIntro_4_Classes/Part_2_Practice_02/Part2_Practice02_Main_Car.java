package javaIntro_4_Classes;

public class Part2_Practice02_Main_Car {
	
	// 2. Создать объект класса Автомобиль, используя классы Колесо, Двигатель.
	// Методы: ехать, заправиться, менять колесо, вывести на консоль марку автомобиля.

	public static void main(String[] args) {
		
		//колесо
		Wheel wheel = new Wheel(16);
		
		//двигатель
		Engine engine = new Engine("2AZ-FE","Gasoline",2396,157);
		
		//новая машина
		Car car = new Car("Toyota","Camry","Grey",2007,70,12,engine,wheel);
		System.out.println(car.toString());
		
		//ехать
		car.go(800);
		car.go(500);
		
		//заправиться
		car.refuel("Diezel", 30); 
		car.refuel("Gasoline", 70);
		car.refuel("Gasoline", 55);
		
		//менять колесо
		car.wheelReplace(17);
	}

}
