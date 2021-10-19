package javaIntro_4_Classes;

public class Part2_Practice01_Main_Text {
	
	// 1. Создать объект класса Текст, используя классы Предложение, Слово. Методы: дополнить текст,
	// вывести на консоль текст, заголовок текста.

	public static void main(String[] args) {
	
		//слово
		Word w = new Word("test");
		
		//предложение
		Sentence head = new Sentence("The new!");
		
		//добавление слов в предложение
		head.addWord(w);
		head.addWord("header");
		
		//текст с заголовком head
		Text t = new Text(head);
		
		//содержание текста
		t.setBody("First sentence!? Second sentence!");
		
		//добавление предложений
		t.addBody("Third sentence");
		Sentence s = new Sentence ("Last sentence");
		t.addBody(s);
		
		//вывод заголовка
		t.printHeader();
		System.out.println();
		
		//вывод текста
		t.printBody();
		System.out.println();
	}

}
