package javaIntro_5_Basics_of_OOP;

public class Practice03_Main_Calendar {

	public static void main(String[] args) {

		Calendar c = new Calendar();
		c.addHoliday(1, 1, 2021);
		c.addHoliday(8, 3, 2021);
		c.addHoliday(1, 9, 2021);
		c.addHoliday(9, 5, 2021);
		c.addDate(10, 5, 2021);
		c.addDate(11, 5, 2021);
		c.addDate(12, 5, 2021);
		c.addDate(13, 5, 2021);
		c.addDate(14, 5, 2021);
		c.addDate(15, 5, 2021);
		c.addDate(16, 5, 2021);
		
		for (int i = 0; i < c.date.size(); i++) {
			c.getDayType(c.date.get(i));
		}

	}

}
