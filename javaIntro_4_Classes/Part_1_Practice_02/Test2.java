package javaIntro_4_Classes;

public class Test2 {
	
	private int var1, var2;
	
	public Test2() {
		this.var1 = 10;
		this.var2 = 100;
	}
	public Test2(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
	}
	
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
	
}
