package javaIntro_6_Tasks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
