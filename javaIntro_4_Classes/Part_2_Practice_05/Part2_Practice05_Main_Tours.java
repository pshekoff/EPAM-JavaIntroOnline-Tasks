package javaIntro_4_Classes;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class Part2_Practice05_Main_Tours {
	
	/* 5. Туристические путевки. Сформировать набор предложений клиенту по выбору туристической путевки
	 * различного типа (отдых, экскурсии, лечение, шопинг, круиз и т.д.) для оптимального выбора.
	 * Учитывать возможность выбора транспорта, питания и числа дней. Реализовать выбор и сортировку путевок.
	 */
	
	public static void main(String[] args) {
		
		//список путевок
		ArrayList<Tour> tours = new ArrayList<>();
		tours.add(new Tour("Vacation", "Plane", false, 8, 700));
		tours.add(new Tour("Vacation", "Plane", true, 10, 1050));
		tours.add(new Tour("Vacation", "Plane", false, 10, 850));
		tours.add(new Tour("Vacation", "Plane", true, 12, 1250));
		tours.add(new Tour("Vacation", "Plane", false, 12, 1000));
		tours.add(new Tour("Vacation", "Plane", true, 14, 1500));
		tours.add(new Tour("Vacation", "Train", false, 14, 350));
		tours.add(new Tour("Vacation", "Bus", false, 14, 300));
		tours.add(new Tour("Cruise", "Plane", true, 18, 3100));
		tours.add(new Tour("Cruise", "Plane", true, 13, 2500));
		tours.add(new Tour("Cruise", "Bus", true, 18, 2700));
		tours.add(new Tour("Cruise", "Train", true, 14, 1900));
		tours.add(new Tour("Cruise", "Bus", true, 14, 1800));
		tours.add(new Tour("Excurtions", "Plane", true, 12, 2150));
		tours.add(new Tour("Excurtions", "Plane", false, 9, 1050));
		tours.add(new Tour("Excurtions", "Train", true, 12, 1700));
		tours.add(new Tour("Excurtions", "Bus", true, 12, 1550));
		tours.add(new Tour("Excurtions", "Train", false, 9, 1100));
		tours.add(new Tour("Excurtions", "Bus", false, 9, 1000));
		tours.add(new Tour("Therapy", "Plane", true, 11, 1950));
		tours.add(new Tour("Therapy", "Plane", false, 8, 1700));
		tours.add(new Tour("Therapy", "Train", true, 11, 1400));
		tours.add(new Tour("Therapy", "Bus", true, 11, 1250));
		tours.add(new Tour("Therapy", "Train", false, 8, 1000));
		tours.add(new Tour("Therapy", "Bus", false, 8, 900));
		tours.add(new Tour("Shopping", "Plane", true, 5, 750));
		tours.add(new Tour("Shopping", "Plane", false, 4, 600));
		tours.add(new Tour("Shopping", "Train", false, 3, 300));
		tours.add(new Tour("Shopping", "Bus", false, 3, 250));
		
		//выбор типа тура
		System.out.println("Choose a tour type:"
						+ "\n(1) Vacation"
						+ "\n(2) Cruise"
						+ "\n(3) Excurtions"
						+ "\n(4) Therapy"
						+ "\n(5) Shopping");
		Scanner scan = new Scanner(System.in);
		int typeOption = scan.nextInt();
		String type = "";
		if (typeOption == 1) {
			type = "Vacation";
		}
		else if (typeOption == 2) {
			type = "Cruise";
		}
		else if (typeOption == 3) {
			type = "Excurtions";
		}
		else if (typeOption == 4) {
			type = "Therapy";
		}
		else if (typeOption == 5) {
			type = "Shopping";
		}
		
		//выбор транспорта
		System.out.println("Choose a transport:"
						+ "\n(1) by plane"
						+ "\n(2) by train"
						+ "\n(3) by bus");
		int transportOption = scan.nextInt();
		
		String transport = "";
		if (transportOption == 1) {
			transport = "Plane";
		}
		else if (transportOption == 2) {
			transport = "Train";
		}
		else if (transportOption == 3) {
			transport = "Bus";
		}
		
		//включать ли питание
		System.out.print("Include food? (1 - yes, 0 - no): ");
		int foodOption = scan.nextInt();
		
		boolean food = false;
		if (foodOption == 1) {
			food = true;
		}
		else if (foodOption == 0) {
			food = false;
		}
	
		//выбор длительности тура
		System.out.println("Enter a tour duration diapazon: ");
		System.out.print("minimum days: ");
		int durationMin = scan.nextInt();
		System.out.print("maximum days: ");
		int durationMax = scan.nextInt();
		
		scan.close();
		
		ArrayList<Tour> toursFiltered  = new ArrayList<>();
		
		//поиск туров по введенным параметрам
		for (int i = 0; i < tours.size(); i++) {
			if (type.equals(tours.get(i).getType())) {
				if (transport.equals(tours.get(i).getTransport())) {
					if (food == tours.get(i).getFood()) {
						if ((durationMin <= tours.get(i).getDuration())&(durationMax >= tours.get(i).getDuration())) {
							toursFiltered.add(tours.get(i));
						}
					}
				}
			}
		}
		
		//вывод подходящих туров с сортировкой по стоимости
		System.out.println("Please, see our tours offers for you:");
		Collections.sort(toursFiltered, new Tour.CompareByCost());
		for (int i = 0; i < toursFiltered.size(); i++) {
			System.out.println(toursFiltered.get(i).toString());
		}

	}
}
