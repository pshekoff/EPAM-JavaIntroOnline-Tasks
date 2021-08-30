package javaIntro_6_Task_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static String readLine() {		
		try {
			String str = reader.readLine();
			return str;
		} catch (IOException e) {
			System.out.println("Error! Try again.");
			return readLine();
		}
	}
	
	public static int readInt() {
		try {
			int i = Integer.parseInt(readLine());
			return i;
		} catch (NumberFormatException e) {
			System.out.println("An error occured trying to read number. Try again.");
			return readInt();
		}
	}
	
}
