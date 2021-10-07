package javaIntro_3_Strings;

import java.util.regex.*;
import java.util.Scanner;
import java.util.Arrays;

public class RegularExpressionPractice01 {
	
	/* 1. Создать приложение, разбирающее текст (текст хранится в строке) и позволяющее выполнять с текстом
	 * три различные операции: отсортировать абзацы по количеству предложений; в каждом предложении отсортировать
	 * слова по длине; отсортировать лексемы в предложении по убыванию количества вхождений заданного символа,
	 * а в случае равенства - по алфавиту.
	 */

	public static void main(String[] args) {
		
		String text = "\tOnce upon a time there lived a woodcutter and his wife. Their early days were lived in\n bliss in a small wood cottage with their two children, Hansel and Gretel.\n" + 
					"\n\tThese two children grew up to be wise beyond their years. Hansel was smart, soft, and\n charming. The Gretel was poetic, cautious, but quick-witted. The two children loved to skip\n stones in the lake half a mile over.\n" + 
					"\n\tHansel and Gretel spent most of their time finding the perfect, flattest skipping\n stones. Their collection of stones was large, as they spent more time collecting than\n actually skipping the rocks. Over time, they had acquired a strange companion - a bird, who\n would steal their stones and hide them in various places all over the land - though Hansel\n and Gretel knew not why.\n" + 
					"\n\tAt the peak of their childhood, a great famine struck the country where Hansel and\n Gretel lived. It left the rich secluded from the middling and poor classes; the merchant\n class fought to survive; and the poorest of the poor plummeted into utter starvation.\n The woodcutter and his wife, along with Hansel and Gretel eventually struggled to stay fed.\n" + 
					"\n\tThe reoccurring moments of starvation gradually caused the woodcutterТs wife to go\n choose selfishness. One evening, after Hansel and Gretel had been tucked in bed, the woman\n approached her husband...";
							
		System.out.println(text);
		System.out.println("\nЧто сделать с текстом (выберите номер варианта):\n\t"
							+ "1. Отсортировать абзацы по количеству предложений;\n\t"
							+ "2. Отсортировать слова в каждом предложении по длине;\n\t"
							+ "3. Отсортировать лексемы в предложениях по убыванию вхождения заданного символа.");
		
		Scanner scan = new Scanner(System.in);
		int var = scan.nextInt();
		
		do {
			if (var == 1) {
				System.out.println("Сортировка абзацев по количеству предложений:\n");
				paragraphsSortBySentencesCount(text);
				break;
			}
			else if (var == 2) {
				System.out.println("Сортировка слов в предложениях по длине:\n");
				wordsSortByLength(text);
				break;
			}
			else if (var == 3) {
				System.out.print("Задайте символ: ");
				String symbol = scan.next();
				
				System.out.println("Сортировка лексем в предложениях по убыванию вхождения символа \"" + symbol + "\" (при равенстве вхождений - по алфавиту):\n");
				lexemsSortBySymbolCount(text, symbol);
				break;
			}
			else {
				System.out.print("Введите номер варианта 1-3: ");
				var = scan.nextInt();
			}
			
		} while (true);

		scan.close();
	}
	
	//метод сортировки абзацев по количеству предложений
	public static void paragraphsSortBySentencesCount(String text) {
		text = text.trim();
		
		//разбиение тескта на абзацы
		Pattern pattern = Pattern.compile("\\t");
		String[] paragraph = pattern.split(text);			
		int[] sentenceCount = new int[paragraph.length];
		
		//подсчет количества предложений в каждом абзаце
		pattern = Pattern.compile("[\\.!?]+");
		for (int i = 0; i < paragraph.length; i++) {
			Matcher matcher = pattern.matcher(paragraph[i]);
			while (matcher.find()) {
				sentenceCount[i]++;
			}
		}
		//сортировка абзацев
		boolean needSwap = true;
		while(needSwap) {
			needSwap = false;
			
			for (int i = 1; i < paragraph.length; i++) {
				if (sentenceCount[i] < sentenceCount[i-1]) {
					int swapInt = sentenceCount[i];
					sentenceCount[i] = sentenceCount[i-1];
					sentenceCount[i-1] = swapInt;
					
					String swapStr = paragraph[i];
					paragraph[i] = paragraph[i-1];
					paragraph[i-1] = swapStr;
					
					needSwap = true;
				}
			}
		}
		//вывод отсортированного текста
		for (int i = 0; i < paragraph.length; i++) {
			System.out.println("\t"+paragraph[i].trim()+"\n(" + sentenceCount[i] + " предложения)\n");
		}
	}
	
	//метод сортироваки слов в каждом предложении по длине слова
	public static void wordsSortByLength(String text) {
		text = text.trim().replaceAll("\n", "");
		
		//шаблон для поиска каждого предложения
		Pattern pattern = Pattern.compile("[A-Z].*?[\\.!?]+");
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			//получение предложения из текста и разбивка его на массив слов
			String sentence = text.substring(matcher.start(), matcher.end());
			Pattern splitPattern = Pattern.compile("\\W+");
			String[] words = splitPattern.split(sentence);
			
			//сортировка слов в предложении
			boolean needSwap = true;
			while (needSwap) {
				needSwap = false;

				for (int i = 1; i < words.length; i++) {
					if (words[i].length() < words[i-1].length()) {
						String swapStr = words[i];
						words[i] = words[i-1];
						words[i-1] = swapStr;
						needSwap = true;
					}
				}
			}
			//вывод отсортированного предложения
			System.out.println(Arrays.toString(words));
		}	
	}
	
	//метод сортировки лексем в каждом прежложении по количеству вхождений заданного символа (при равенстве - по алфавиту)
	public static void lexemsSortBySymbolCount(String text, String symbol) {
		text = text.trim().replaceAll("\n", "");
		
		//шаблон для поиска каждого предложения
		Pattern pattern = Pattern.compile("[A-Z].*?[\\.!?]+");
		Matcher matcher = pattern.matcher(text);
		
		while (matcher.find()) {
			//получение предложения из текста и разбивка его на массив слов
			String sentence = text.substring(matcher.start(), matcher.end());
			Pattern splitPattern = Pattern.compile("\\W+");
			String[] words = splitPattern.split(sentence);

			//сортировка слов в предложении
			boolean needSwap = true;
			while (needSwap) {
				needSwap = false;
			
				for (int i = 1; i < words.length; i++) {
					Pattern pat = Pattern.compile(symbol);
					Matcher mat1 = pat.matcher(words[i]);
					Matcher mat2 = pat.matcher(words[i-1]);
					int symbolCount1 = 0;
					int symbolCount2 = 0;
					
					//находим кол-во вхождений символа для 2х соседних слов
					while (mat1.find()) {
						symbolCount1++;
					}
					while (mat2.find()) {
						symbolCount2++;
					}
					
					//сравнение 2х соседних слов по кол-ву вхождений символа
					if (symbolCount1 > symbolCount2) {
						String swapStr = words[i];
						words[i] = words[i-1];
						words[i-1] = swapStr;
						needSwap = true;
					}
					//при равном кол-ве вхождений символа, сравниваем по алфавиту
					else if (symbolCount1 == symbolCount2) {
						if (wordsCompare(words[i-1], words[i])) {
							String swapStr = words[i];
							words[i] = words[i-1];
							words[i-1] = swapStr;
							needSwap = true;
						}
					}
				}
			}
			//вывод отсортированного предложения
			System.out.println(Arrays.toString(words));
		}
	}
	
	//метод сравнения слов по алфавиту
	public static boolean wordsCompare(String s1, String s2) {
		boolean b = false;
		int length = 0;
		if (s1.length() < s2.length()) {
			length = s1.length();
		}
		else {
			length = s2.length();
		}
		for (int i = 0; i < length; i++) {
			if (s1.toLowerCase().charAt(i) > s2.toLowerCase().charAt(i)) {
				b = true;
				break;
			}
			else if (s1.toLowerCase().charAt(i) < s2.toLowerCase().charAt(i)) {
				break;
			}
		}
		return b;
	}

}
