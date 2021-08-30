package javaIntro_6_Task_3;

import java.io.Serializable;

public class Packet implements Serializable{
	
	private static final long serialVersionUID = 2345678901234567890L;
	private String type;
	private String value;
	
	public Packet() {
	}
	
	public Packet(String type) {
		setType(type);
	}
	
	public Packet(String type, String value) {
		setType(type);
		setValue(value);
	}
	
	public String getType() {
		return type;
	}
	public String getValue() {
		return value;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
