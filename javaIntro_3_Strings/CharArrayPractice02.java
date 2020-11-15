package javaIntro_3_Strings;

public class CharArrayPractice02 {

	public static void main(String[] args) {
		
		String str = "ewordq tgdword wtworsdfh s20;wordletter";
		System.out.println("»сходна¤ строка:\t\t" + str);
		
		char[] strCharArr = str.toCharArray();
		int count = 0;
		
		for (int i = 0; i < strCharArr.length-4; i++) {
			if ((strCharArr[i] == 'w')&(strCharArr[i+1] == 'o')&(strCharArr[i+2] == 'r')&(strCharArr[i+3] == 'd')) {
				str = str.substring(0, i+count) + "letter" + str.substring(i+count+4, str.length());
				i += 3;
				count += 2;
			}
		}
		
		System.out.println("\"word\" заменено на \"letter\":\t" + str);

	}

}
