package javaIntro_6_Tasks;

import java.util.Date;
import java.util.Locale;
import java.text.SimpleDateFormat;
import java.util.Comparator;

public class Note {
	
	private String topic;
	private Date creationDate;
	private String email;
	private String message;
	
	public Note(String topic, String email, String message) {
		setTopic(topic);
		creationDate = new Date();
		setEmail(email);
		setMessage(message);
	}
	
	public Note(String topic, String date, String email, String message) throws Exception {
		setTopic(topic);
		SimpleDateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);  
		creationDate = format.parse(date);
		setEmail(email);
		setMessage(message);
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTopic() {
		return topic;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public String getEmail() {
		return email;
	}
	public String getMessage() {
		return message;
	}
	
	public void print() {
		System.out.println(String.format("Topic: %s\nCreated: %s\nE-mail: %s\nMessage text:\n%s", topic, creationDate, email, message));
	}
	
	public static Comparator<Note> topicComparator = new Comparator<Note>() {
		public int compare(Note note1, Note note2) {
			return note1.getTopic().compareTo(note2.getTopic());
		}
	};
	
	public static Comparator<Note> emailComparator = new Comparator<Note>() {
		public int compare(Note note1, Note note2) {
			return note1.getEmail().compareTo(note2.getEmail());
		}
	};
	
	public static Comparator<Note> dateComparator = new Comparator<Note>() {
		public int compare(Note note1, Note note2) {
			return note1.getCreationDate().compareTo(note2.getCreationDate());
		}
	};
	
	@Override
	public String toString() {
		return String.format("%s\n%s\n%s\n%s", topic, creationDate, email, message);
	}
}
