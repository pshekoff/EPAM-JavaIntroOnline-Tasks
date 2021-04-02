package javaIntro_4_Classes;

public class Word {
	private String word;
	
	public Word(String string) {
		set(string);
	}
	
	public String get() {
		return word;
	}
	public void set(String string) {
		word = string;
	}
}
