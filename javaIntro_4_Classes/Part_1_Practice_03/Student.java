package javaIntro_4_Classes;

import java.util.Arrays;

public class Student {
	private String name;
	private int group;
	private int[] grades = new int[5];
	private int gradeCount = 0;
	
	public Student(String name, int group) {
		this.name = name;
		this.group = group;
	}
	
	public void addGrade(int p) {	
		grades[gradeCount] = p;	
		gradeCount++;
	}

	public boolean isOK() {
		for (int i = 0; i < gradeCount; i++) {
			if (grades[i] < 9) {
				return false;
			}
		}
		return true;
	}
	
	public void output() {
		System.out.println("Student: " + name + ", group: " + group + ", grades: " + Arrays.toString(grades));
	}
}