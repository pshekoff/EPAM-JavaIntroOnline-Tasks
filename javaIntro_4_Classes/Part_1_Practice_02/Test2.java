package javaIntro_4_Classes;

public class Test2 {
	
	private int var1, var2;
	
	//конструктор, инициализирующий члены класса по умолчанию
	public Test2() {
		this.var1 = 10;
		this.var2 = 100;
	}
	
	//конструктор с входными параметрами
	public Test2(int var1, int var2) {
		this.var1 = var1;
		this.var2 = var2;
	}
	
	//get-методы
	public int getVar1() {
		return var1;
	}
	public int getVar2() {
		return var2;
	}
	
	//set-методы
	public void setVar1(int var) {
		var1 = var;
	}
	public void setVar2(int var) {
		var2 = var;
	}
	
}
