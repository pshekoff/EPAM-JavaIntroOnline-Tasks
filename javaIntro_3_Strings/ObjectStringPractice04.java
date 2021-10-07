package javaIntro_3_Strings;

public class ObjectStringPractice04 {
	
	// 4. С помощью функции копирования и операции конкатенации составить из частей слова "информатика" слово "торт".

	public static void main(String[] args) {

		String str1 = "информатика";
		String str2 = new String();
		str2 = str2.concat(str1.substring(7,8) + str1.substring(3,5) + str1.substring(7,8));
		System.out.println(str2);
	}

}
