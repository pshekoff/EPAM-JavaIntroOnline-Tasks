package javaIntro_4_Classes;

public class Part2_Practice02_Main_Car {

	public static void main(String[] args) {
		Wheel wheel = new Wheel(16);
		Engine engine = new Engine("2AZ-FE","Gasoline",2396,157);
		Car car = new Car("Toyota","Camry","Grey",2007,70,12,engine,wheel);
		System.out.println(car.toString());
		car.go(800);
		car.go(500);
		car.refuel("Diezel", 30);
		car.refuel("Gasoline", 70);
		car.refuel("Gasoline", 55);
		car.wheelReplace(17);
	}

}
