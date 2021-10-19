package javaIntro_4_Classes;

public class Test1 {
	
	private int var1, var2;
	
	//методы изменения переменных
	public void setVar1(int var) {
		var1 = var;
	}
	public void setVar2(int var) {
		var2 = var;
	}
	
	//метол вывода переменных
	public void print() {
		System.out.println("Var1 = " + var1 + "\nVar2 = " + var2);
	}
	
	//метод нахождения суммы переменных
	public int sum() {
		return var1 + var2;
	}
	
	//метод определения наибольшего значения переменных
	public int maxVal() {
		if (var1 > var2) {
			return var1;
		}
		else {
			return var2;
		}
	}
}
