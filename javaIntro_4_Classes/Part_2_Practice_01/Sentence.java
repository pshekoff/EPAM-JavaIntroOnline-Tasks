package javaIntro_4_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sentence {
	private ArrayList<Word> body = new ArrayList<>();
	private String ending;
	
	public Sentence(String string) {
		setBody(string);
	}
	
	public ArrayList<Word> getBody() {
		return body;
	}
	public void setBody(String string) {
		Pattern pat = Pattern.compile("\\s*[.!?]+\\s*");
		Matcher mat = pat.matcher(string);
		if (mat.find()) {
			ending = string.substring(mat.start(),mat.end());
			string = string.substring(0,mat.start());
		}
		else {
			ending = ".";
		}
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(string.split("\\s+")));
		for (int i = 0; i < list.size(); i++) {
			body.add(i, new Word(list.get(i)));
		}
	}
	
	public void addWord(Word word) {
		body.add(word);
	}
	public void addWord(String string) {
		body.add(new Word(string));
	}
	
	public void print() {
		for (int i = 0; i < body.size(); i++) {
			System.out.print(" " + body.get(i).get());
		}
		System.out.print(ending);
	}
}
