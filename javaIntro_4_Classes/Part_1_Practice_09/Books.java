package javaIntro_4_Classes;

public class Books {
	private Book[] books;
	private int arraySize;
	private int bookCount;
	
	public Books() {
		arraySize = 5;
		bookCount = 0;
		books = new Book[arraySize];
	}
	public Books(int size) {
		arraySize = size;
		bookCount = 0;
		books = new Book[arraySize];
	}
	
	public int getSize() {
		return arraySize;
	}
	public int getBookCount() {
		return bookCount;
	}
	
	public void add(Book b) {
		if (bookCount < arraySize) {
			books[bookCount] = b;
			bookCount++;
		}
		else {
			Book[] temp = new Book[arraySize*2];
			for (int i = 0; i < bookCount; i++) {
				temp[i] = books[i];
			}
			books = temp;
			arraySize *= 2;
			books[bookCount] = b;
			bookCount++;
		}
	}
	
	public void print() {
		for (int i = 0; i < bookCount; i++) {
			System.out.println(books[i].toString());
		}
	}
	
	public void printByAuthor(String author) {
		for (int i = 0; i < bookCount; i++) {
			for (int j = 0; j < books[i].getAuthors().size(); j++) {
				if (books[i].getAuthors().get(j).equals(author)) {
					System.out.println(books[i].toString());
				}
			}
		}
	}
	
	public void printByPublisher(String publisher) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getPublisher().equals(publisher)) {
				System.out.println(books[i].toString());
			}
		}
	}
	
	public void printByYear(int year) {
		for (int i = 0; i < bookCount; i++) {
			if (books[i].getYear() > year) {
				System.out.println(books[i].toString());
			}
		}
	}
}
