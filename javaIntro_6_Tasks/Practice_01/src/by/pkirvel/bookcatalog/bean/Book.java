package by.pkirvel.bookcatalog.bean;

public class Book {

	private String title;
	private String author;
	private int year;
	private boolean eBook;
	
	public Book(String title, String author, int year, boolean eBook) {
		setTitle(title);
		setAuthor(author);
		setYear(year);
		setType(eBook);
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setType(boolean eBook) {
		this.eBook = eBook;
	}
	
	public String getTitle() {
		return title;
	}
	public String getAuthor() {
		return author;
	}
	public int getYear() {
		return year;
	}
	public boolean isEBook() {
		return eBook;
	}
	
	@Override
	public String toString() {
		return String.format("%s;%s;%d;%s"
							, title, author, year, eBook);
	}
}
