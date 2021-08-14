package javaIntro_6_Tasks;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotePadMenu {
	
	public static void startMenu() {
		
		NotePad notepad = new NotePad();
		
		Boolean exit = false;
		while (!exit) {
			
			System.out.println("1. Add note\n"
							 + "2. Filter notes\n"
							 + "3. Print all notes\n"
							 + "4. Exit");
			int option = chooseOption(1,4);
			
			if (option == 1) {
				notepad.addNote(createNote());
			}			
			else if (option == 2) {
				filterMenu(notepad);
			}			
			else if (option == 3) {
				notepad.printAll();
			}			
			else if (option == 4) {
				exit = true;
			}		
			else {
				System.out.println("Incorrect option! Try again.");
			}
		}
		notepad.saveFile();
	}
	
	public static int chooseOption(int from, int to) {
		int option = ConsoleReader.readInt();
		if (option < from || option > to) {
			System.out.println("Incorrect option! Try again.");
			return chooseOption(from, to);
		}
		else {
			return option;
		}
	}
	
	public static Note createNote() {
		
		System.out.print("Enter topic: ");
		String topic = ConsoleReader.readLine();
		
		String email = "";
		boolean exit = false;
		while (!exit) {
			System.out.print("Enter email: ");
			email = ConsoleReader.readLine();
			Pattern pattern = Pattern.compile(".+@.+\\..+");
			Matcher matcher = pattern.matcher(email);
			if (!matcher.find()) {
				System.out.println("E-mail is incorrect. Try again.");
			}
			else {
				exit = true;
			}
		}

		System.out.println("Enter message (type \"Exit\" when you finish):");
		StringBuilder text = new StringBuilder();
		String textLine;		
		while(!(textLine = ConsoleReader.readLine()).equals("Exit")) {
			text.append(textLine + "\n");
		}
		String message = text.substring(0, text.length()-1).toString();
		
		Note newNote = new Note(topic, email, message);
		
		return newNote;
	}
	
	public static void filterMenu(NotePad notepad) {
		
		try {
			filter(notepad);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		Boolean exit = false;
		while (!exit) {
			
			System.out.println("1. New filter\n"
							 + "2. Print filtered\n"
							 + "3. Sort filtered and print\n"
							 + "4. Back");
			int option = chooseOption(1,4);
			
			if (option == 1) {
				try {
					filter(notepad);
				} catch (Exception e) {
					e.printStackTrace();
				}			
			}			
			else if (option == 2) {
				notepad.printSelected();
			}			
			else if (option == 3) {
				sortMenu(notepad);
			}			
			else if (option == 4) {
				exit = true;
			}			
			else {
				System.out.println("Incorrect option! Try again.");
			}
		}
	}
	
	public static void filter(NotePad notepad) throws Exception{
		
		Filter newFilter = new Filter();
		
		System.out.println("Enter topic or skip it: ");
		String topic = ConsoleReader.readLine();
		newFilter.setTopic(topic);
		
		System.out.println("Enter e-mail or skip it:");
		String email = ConsoleReader.readLine();
		newFilter.setEmail(email);
		
		System.out.println("Enter words to find it on the message or skip it:");
		String message = ConsoleReader.readLine();
		newFilter.setWords(message);
		
		String dateFrom = "";		
		boolean exit = false;
		while (!exit) {
			System.out.println("Enter date from in format DD.MM.YYYY or skip it: ");
			dateFrom = ConsoleReader.readLine();
			
			if (dateFrom.equals("")) {
				break;
			}
			else {
				Pattern pattern = Pattern.compile("\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d");
				Matcher matcher = pattern.matcher(dateFrom);
				if (!matcher.find()) {
					System.out.println("Date format is incorrect. Try again.");
				}
				else {
					exit = true;
					newFilter.setDateFrom(dateFrom);
				}
			}
		}
		
		
		String dateTo = "";
		exit = false;
		while (!exit) {
			System.out.println("Enter date to in format DD.MM.YYYY or skip it: ");
			dateTo = ConsoleReader.readLine();
			
			if (dateTo.equals("")) {
				break;
			}
			else {
				Pattern pattern = Pattern.compile("\\d\\d\\.\\d\\d\\.\\d\\d\\d\\d");
				Matcher matcher = pattern.matcher(dateTo);
				if (!matcher.find()) {
					System.out.println("Date format is incorrect. Try again.");
				}
				else {
					exit = true;
					newFilter.setDateTo(dateTo);
				}
			}
		}		
		
		notepad.filter(newFilter);

	}
	
	public static void sortMenu(NotePad notepad) {
		
		Boolean exit = false;
		while (!exit) {
			
			System.out.println("Enter sorting parameter:\n"
							 + "1. Sort by Topic\n"
							 + "2. Sort by E-mail\n"
							 + "3. Sort by Date\n"
							 + "4. Back");
			int option = chooseOption(1,4);
			
			if (option == 1) {
				notepad.sort(Note.topicComparator);
				notepad.printSelected();
				exit = true;
			}
			else if (option == 2) {
				notepad.sort(Note.emailComparator);
				notepad.printSelected();
				exit = true;
			}
			else if (option == 3) {
				notepad.sort(Note.dateComparator);
				notepad.printSelected();
				exit = true;
			}		
			else if (option == 4) {
				exit = true;
			}			
			else {
				System.out.println("Incorrect option! Try again.");
			}
		}
	}
	
}
