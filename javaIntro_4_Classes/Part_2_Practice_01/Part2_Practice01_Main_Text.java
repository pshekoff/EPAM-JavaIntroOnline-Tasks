package javaIntro_4_Classes;

public class Part2_Practice01_Main_Text {

	public static void main(String[] args) {
	
		Word w = new Word("test");
		Sentence head = new Sentence("The new!");
		head.addWord(w);
		head.addWord("header");
		Text t = new Text(head);
		t.setBody("First sentence!? Second sentence!");
		t.addBody("Third sentence");
		Sentence s = new Sentence ("Last sentence");
		t.addBody(s);
		t.printHeader();
		System.out.println();
		t.printBody();
		System.out.println();
	}

}
