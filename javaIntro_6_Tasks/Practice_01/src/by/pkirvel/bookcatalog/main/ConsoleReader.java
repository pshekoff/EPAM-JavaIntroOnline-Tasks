package by.pkirvel.bookcatalog.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader {

	private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	public static String readLine() {		
		try {
			while (true) {
				String str = reader.readLine();
				if (str == "") {
					System.out.println("Nothing entered, try again.");
					continue;
				}
				else {
					return str;
				}
			}
			
		} catch (IOException e) {
			System.out.println("Error! Try again.");
			return readLine();
		}
	}
	
	public static int readInt() {
		try {
			String s = readLine();
			if (s.equals("q")) {
				return -1;
			}
			else {
				int i = Integer.parseInt(s);
				return i;
			}
		} catch (NumberFormatException e) {
			System.out.println("An error occured trying to read number. Try again.");
			return readInt();
		}
	}
	
	public static String readYN() {
		while (true) {
			String s = readLine();
			if (s.equals("n")) {
				return "false";
			}
			else if (s.equals("y")) {
				return "true";
			}
			else if (s.equals("q")) {
				return s;
			}
			else {
				System.out.println("Choose \"y\" or \"n\", or enter \"q\" to exit.");
				continue;
			}
		}
	}
	
}