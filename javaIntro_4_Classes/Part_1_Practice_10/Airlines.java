package javaIntro_4_Classes;

public class Airlines {
	private Airline[] airlines;
	private int size;
	private int count;
	
	public Airlines(int size) {
		this.size = size;
		airlines = new Airline[size];
		count = 0;
	}
	public Airlines() {
		size = 5;
		airlines = new Airline[size];
		count = 0;
	}
	
	public int getSize() {
		return size;
	}
	public int getCount() {
		return count;
	}
	
	public void print() {
		for (int i = 0; i < count; i++) {
			System.out.println(airlines[i].toString());
		}
	}
	
	public void add(Airline a) {
		if (count < size) {
			airlines[count] = a;
			count++;
		}
		else {
			Airline[] temp = new Airline[size*2];
			for (int i = 0; i < count; i++) {
				temp[i] = airlines[i];
			}
			airlines = temp;
			size *= 2;
			airlines[count] = a;
			count++;
		}
	}
	
	public void printByDestination(String dest) {
		for (int i = 0; i < count; i++) {
			if (airlines[i].getDestination().equals(dest)) {
				System.out.println(airlines[i].toString());
			}
		}
	}
	
	public void printByDayOfWeek(String day) {
		for (int i = 0; i < count; i++) {
			for (int j = 0; j < airlines[i].getDayOfWeek().size(); j++) {
				if (airlines[i].getDayOfWeek().get(j).equals(day)) {
					System.out.println(airlines[i].toString());
					break;
				}
			}
		}
	}
	
	public void printByDayTime(String day, String time) {
		String[] splitTime = time.split(":");
		for (int i = 0; i < count; i++) {
			for(int j = 0; j < airlines[i].getDayOfWeek().size(); j++) {
				String[] deptSplitTime = airlines[i].getDepartureTime().split(":");
				if (airlines[i].getDayOfWeek().get(j).equals(day)) {
					if (Integer.parseInt(deptSplitTime[0]) > Integer.parseInt(splitTime[0])) {
						System.out.println(airlines[i].toString());
						break;
					}
					else if (deptSplitTime[0].equals(splitTime[0])) {
						if (Integer.parseInt(deptSplitTime[1]) > Integer.parseInt(splitTime[1])) {
							System.out.println(airlines[i].toString());
							break;
						}
					}
					else {
						break;
					}
				}
			}
		}
	}
}
