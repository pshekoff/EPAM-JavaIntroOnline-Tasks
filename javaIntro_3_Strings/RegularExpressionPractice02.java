package javaIntro_3_Strings;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.regex.*;
import java.util.Arrays;

public class RegularExpressionPractice02 {

	public static void main(String[] args) {

		String inputFileName = "text.xml";
		String text = "";
		
		try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName,StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				text = text.concat(line+"\n");
			}
		}
        catch (IOException e) {
        	e.printStackTrace();
		}

		System.out.println(text);
		
		xmlAnalyzer(text);

	}
	
	
	public static void xmlAnalyzer(String text) {
		
		text = text.trim().replaceAll("\n", "").replaceAll("\t", "");
		
		Pattern openTagPat = Pattern.compile("<[^/].*?>");
		Pattern closeTagPat = Pattern.compile("</.*?>");
		
		String[] tagTypeArr = new String[text.length()];
		int[] tagLengthArr = new int[text.length()];
		
		Matcher openTagMat = openTagPat.matcher(text);
		while (openTagMat.find()) {
			
			tagTypeArr[openTagMat.start()] = "открывающтй тег";
			tagLengthArr[openTagMat.start()] = openTagMat.end() - openTagMat.start();
			
			int bodyStartIndex = openTagMat.end();
			
			String tag = text.substring(openTagMat.start(),openTagMat.end());
			
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
				bodyEndIndex = tagBodyMat.start();
				if (bodyStartIndex < bodyEndIndex) {
					break;
				}
			}
			
			tagTypeArr[bodyStartIndex] = "тело тега";
			tagLengthArr[bodyStartIndex] = bodyEndIndex - bodyStartIndex;

			if (bodyStartIndex == bodyEndIndex) {
				tagTypeArr[openTagMat.start()] = "открывающий тег без тела";
			}			
		}
		
		Matcher closeTagMat = closeTagPat.matcher(text);
		while (closeTagMat.find()) {
			tagTypeArr[closeTagMat.start()] = "закрывающий тег";
			tagLengthArr[closeTagMat.start()] = closeTagMat.end() - closeTagMat.start();
		}
		
		for (int i = 0; i < text.length(); i++) {
			if (tagLengthArr[i] != 0) {
				System.out.println("Узел: " + text.substring(i, i + tagLengthArr[i]) + "; тип узла: " + tagTypeArr[i] + ";");
			}
		}		
	}
	
}
