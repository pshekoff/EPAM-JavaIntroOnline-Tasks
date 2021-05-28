package javaIntro_5_Basics_of_OOP;

import java.io.File;

public class TextFile extends File {
	private static final String format = ".txt";
	
	public TextFile(String path) {
		super(path + format);
	}
	
	public TextFile(String path, String name) {
		super(path, name + format);
	}
	
	public TextFile(File path, String name) {
		super(path, name + format);
	}
}
