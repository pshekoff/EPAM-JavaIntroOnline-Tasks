package javaIntro_3_Strings;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;

public class RegularExpressionPractice02 {
	
	/* 2. Дана строка, содержащая стедующий текст (xml-документ):
	 * 
	 * <notes>
	 * 		<note id = "1">
	 * 			<to>Вася</to>
	 * 			<from>Света</from>
	 * 			<heading>Напоминание</heading>
	 * 			<body>Позвони мне завтра!</body>
	 * 		</note>
	 * 		<note id = "2">
	 * 			<to>Петя</to>
	 * 			<from>Маша</from>
	 * 			<heading>Важное напоминание</heading>
	 * 			<body></body>
	 * 		</note>
	 * </notes>
	 * 
	 * Напишите анализатор, позволяющий последовательно возвращать содержимое узлов xml-документа и его тип
	 * (открывающий тег, закрывающий тег, содержимое тега, тег без тела). Пользоваться готовыми парсерами XML
	 * для решения данной задачи нельзя.
	 */

	public static void main(String[] args) {
		String text = "";
		
		//считывание данных их файла text.xml в строку
		try (BufferedReader reader = new BufferedReader(new FileReader("src/files/text.xml",StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				text = text.concat(line+"\n");
			}
		}
        catch (IOException e) {
        	e.printStackTrace();
		}
		//вывод считанного текста
		System.out.println(text);
		
		//запуск анализатоа текста
		xmlAnalyzer(text);
	}
	
	//последовательный анализатор xml-документа
	public static void xmlAnalyzer(String text) {
		text = text.trim().replaceAll("\n", "").replaceAll("\t", "");
		
		//шаблоны открывающего и закрывающего тега
		Pattern openTagPat = Pattern.compile("<[^/].*?>");
		Pattern closeTagPat = Pattern.compile("</.*?>");
		
		//массивы для хранения типа тега и его длины
		String[] tagTypeArr = new String[text.length()];
		int[] tagLengthArr = new int[text.length()];
		
		//ищем открывающие теги
		Matcher openTagMat = openTagPat.matcher(text);
		while (openTagMat.find()) {
			tagTypeArr[openTagMat.start()] = "открывающий тег";
			tagLengthArr[openTagMat.start()] = openTagMat.end() - openTagMat.start();
			
			//индекс начала тела тега
			int bodyStartIndex = openTagMat.end();
			
			//сохраняем найденный тег
			String tag = text.substring(openTagMat.start(),openTagMat.end());
			
			//убираем лишние символы, оставляя только название тега
			for (int i = 0; i < tag.length(); i++) {
				if ((tag.charAt(i) == ' ')|(tag.charAt(i) == '>')) {
					tag = tag.substring(1, i);
					break;
				}
			}
			
			tag = "</"+tag;
 			
			Pattern tagBodyPat = Pattern.compile(tag);
			Matcher tagBodyMat = tagBodyPat.matcher(text);
			
			int bodyEndIndex = 0;
			
			while (tagBodyMat.find()) {
				//индекс конца тела тега
				bodyEndIndex = tagBodyMat.start();
				if (bodyStartIndex < bodyEndIndex) {
					break;
				}
			}
			
			//записываем тело тега
			tagTypeArr[bodyStartIndex] = "тело тега";
			tagLengthArr[bodyStartIndex] = bodyEndIndex - bodyStartIndex;

			if (bodyStartIndex == bodyEndIndex) {
				tagTypeArr[openTagMat.start()] = "открывающий тег без тела";
			}			
		}
		
		//ищем закрывающие теги
		Matcher closeTagMat = closeTagPat.matcher(text);
		while (closeTagMat.find()) {
			tagTypeArr[closeTagMat.start()] = "закрывающий тег";
			tagLengthArr[closeTagMat.start()] = closeTagMat.end() - closeTagMat.start();
		}
		
		//последовательный вывод информации о тегах
		for (int i = 0; i < text.length(); i++) {
			if (tagLengthArr[i] != 0) {
				System.out.println("Узел: " + text.substring(i, i + tagLengthArr[i]) + "; тип узла: " + tagTypeArr[i] + ";");
			}
		}		
	}
	
}