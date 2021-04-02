package javaIntro_4_Classes;

import java.util.*;

public class Book {
	private int id;
	private static int ID;
	private String title;
	private ArrayList<String> authors;
	private String publisher;
	private int year;
	private int pageCount;
	private int price;
	private String cover;
	
	public Book(String title, String author, String publisher, int year, int pageCount, int price, String cover) {
		id = ID++;
		this.title = title;
		ArrayList<String> l = new ArrayList<String>();
		l.addAll(Arrays.asList(author.split(" ")));
		authors = l;
		this.publisher = publisher;
		this.year = year;
		this.pageCount = pageCount;
		this.price = price;
		this.cover = cover;
	}
	
	public int getID() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public ArrayList<String> getAuthors() {
		return authors;
	}
	public String getPublisher() {
		return publisher;
	}
	public int getYear() {
		return year;
	}
	public int getPageCount() {
		return pageCount;
	}
	public int price() {
		return price;
	}
	public String cover() {
		return cover;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setAuthors(String author) {
		authors.add(author);
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public void setPageCount(int pc) {
		pageCount = pc;
	}
	public void setPrice(int price) {
		this.price = price;
	}
		
	public String toString() {
		return String.format("ID: %d;\tTitle: %s;\tAuthors: %s;\tPublisher: %s;\tYear: %d;\tPageCount: %d;\tPrice: %d;\tCover: %s.",
				id, title, authors, publisher, year, pageCount, price, cover);
	}
	
	public static Book addBook(Scanner scan) {
		Book b = new Book("","","",0,0,0,"");
		System.out.print("Title: ");
		b.title = scan.next();
		System.out.print("Authors count: ");
		int c = scan.nextInt();
		System.out.print("Authors: ");
		b.authors.set(0,scan.next());
		for (int i = 1; i < c; i++) {
			b.authors.add(scan.next());
		}
		System.out.print("Publisher: ");
		b.publisher = scan.next();
		System.out.print("Year: ");
		b.year = scan.nextInt();
		System.out.print("Page count: ");
		b.pageCount = scan.nextInt();
		System.out.print("Price: ");
		b.price = scan.nextInt();
		System.out.print("Cover: ");
		b.cover = scan.next();
		return b;		
	}
}