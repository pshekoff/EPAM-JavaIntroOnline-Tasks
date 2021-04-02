package javaIntro_4_Classes;

public class Practice02_Main_Test2 {
	public static void main(String[] args) {
		Test2 test = new Test2();
		System.out.println("Variables by default are: " + test.getVar1() + " and " + test.getVar2());
		test.setVar1(49);
		test.setVar2(169);
		System.out.println("New varialbles are: "+ test.getVar1() + " and  " + test.getVar2());		
	}
}
