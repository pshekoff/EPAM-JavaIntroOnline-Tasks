package javaIntro_6_Task_3;

public class Student {

	private int id;
	private static int ID;
	private String name;
	private String birthDate;
	private String group;
	
	public Student() {
		id = ++ID;
	}
	
	public Student(String name, String birthDate, String group) {
		id = ++ID;
		setName(name);
		setBirthDate(birthDate);
		SetGroup(group);
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	public void SetGroup(String group) {
		this.group = group;
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getBirthDate() {
		return birthDate;
	}
	public String getGroup() {
		return group;
	}
	
	@Override
	public String toString() {
		return String.format("Student id=%d: %s\t%s\tgroup: %s", id, name, birthDate, group);
	}
}
