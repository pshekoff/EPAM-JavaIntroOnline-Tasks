package javaIntro_6_Tasks;

import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;

public class NotePad {

		private List<Note> notes;
		private List<Note> fileNotes;
		private List<Note> selectedNotes;
		private File file;
		private static final String separator = "==================================================";
		
		public NotePad() {
			notes = new ArrayList<>();
			selectedNotes = new ArrayList<>();
			createFile();
		}
		
		public void createFile() {
			
			fileNotes = new ArrayList<>();
			
			file = new File("src/files","notepad.txt");
			
			if (file.exists()) {
				try {
					Scanner fileScan = new Scanner(new FileReader(file));
					
					while(fileScan.hasNextLine()) {
						
						String topic = fileScan.nextLine();
						String date = fileScan.nextLine();
						String email = fileScan.nextLine();

						StringBuilder text = new StringBuilder();
						
						String textLine;
						
						while(!(textLine = fileScan.nextLine()).equals(separator)) {
							text.append(textLine + "\n");
						}
						
						String message = text.substring(0, text.length()-1).toString();
						
						fileNotes.add(new Note(topic, date, email, message));
					}
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		public void saveFile() {
	        
			if (!file.exists()) {
				try {
					file.createNewFile();
				} catch (IOException e) {
					e.printStackTrace();
				}				
			}

			try(FileWriter writer = new FileWriter(file, true)) {
				for (Note note : notes) {
					writer.write(note.toString() + "\n" + separator + "\n");
				}	        	
	        	writer.close();
	        }
	        catch(IOException e) {
	            System.out.println(e.getMessage());
	        } 

		}
		
		public void addNote(Note note) {
			notes.add(note);
		}
		
		public void printAll() {
			for (Note note : fileNotes) {
				note.print();
				System.out.println(separator);
			}
			for (Note note : notes) {
				note.print();
				System.out.println(separator);
			}
		}
		
		public void printSelected() {
			
			if (selectedNotes.size() == 0) {
				System.out.println("No any notes matches the filter.");
			}
			for (Note note : selectedNotes) {
				note.print();
				System.out.println(separator);
			}
		}
		
		public void filter(Filter filter) {
			
			ArrayList<Note> filteredNotes = new ArrayList<>();
			
			for (Note note : fileNotes) {
				if (filter.compare(note)) {
					filteredNotes.add(note);
				}
			}
			
			for (Note note : notes) {
				if (filter.compare(note)) {
					filteredNotes.add(note);
				}
			}
			
			selectedNotes = filteredNotes;
		}
		
		public void sort(Comparator<Note> comparator) {
			
			Collections.sort(selectedNotes, comparator);
		}
		
}
