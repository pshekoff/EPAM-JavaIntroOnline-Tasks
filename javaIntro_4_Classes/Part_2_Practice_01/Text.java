package javaIntro_4_Classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text {
	private Sentence header;
	private ArrayList<Sentence> body = new ArrayList<>();
	
	public Text(String string) {
		setHeader(string);
	}
	public Text(Word word) {
		setHeader(word.get());
	}
	public Text(Sentence sentence) {
		setHeader(sentence);
	}
	
	public Sentence getHeader() {
		return header;
	}
	public ArrayList<Sentence> getBody() {
		return body;
	}
	
	public void setHeader(String string) {
		header.setBody(string);
	}
	public void setHeader(Word word) {
		header.setBody(word.get());
	}
	public void setHeader(Sentence sentence) {
		header = sentence;
	}
	
	public void setBody(String string) {
		Pattern pat = Pattern.compile("\\s*[.!?]+\\s*");
		ArrayList<String> list = new ArrayList<>();
		list.addAll(Arrays.asList(string.split("\\s*[.!?]+\\s*")));
		for (int i = 0; i < list.size(); i++) {
			Matcher mat = pat.matcher(string);
			if (mat.find()) {
				body.add(i, new Sentence(list.get(i) + string.substring(mat.start(),mat.end())));
				string = string.substring(mat.end());
			}
		}
	}
	public void setBody(Sentence sentence) {
		body.add(0, sentence);
	}
	
	public void addBody(String string) {
		body.add(new Sentence(string));
	}	
	public void addBody(Sentence sentence) {
		body.add(sentence);
	}
	
	public void printHeader() {
		header.print();
	}
	public void printBody() {
		for (int i = 0; i < body.size(); i++) {
			body.get(i).print();
		}
	}
	
}
