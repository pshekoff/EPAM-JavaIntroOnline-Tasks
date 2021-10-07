package javaIntro_4_Classes;

public class Test1 {
	
	private int var1, var2;
	
	public int getVar1() {
		return var1;
	}
	public int getVar2() {
		return var2;
	}
	public void setVar1(int var) {
		var1 = var;
	}
	public void setVar2(int var) {
		var2 = var;
	}
	
	public void print() {
		System.out.println("Var1 = " + var1 + "\nVar2 = " + var2);
	}
	
	public int sum() {
		return var1 + var2;
	}
	
	public int maxVal() {
		if (var1 > var2) {
			return var1;
		}
		else {
			return var2;
		}
	}
}
