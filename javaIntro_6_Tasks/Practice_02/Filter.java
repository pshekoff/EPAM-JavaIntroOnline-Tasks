package javaIntro_6_Tasks;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Filter {
	
	private String topic;
	private String email;
	private String[] words;
	private Date dateTo;
	private Date dateFrom;
	
	public Filter() {
	}
	
	public Filter(String topic, String email, String sentence, String dateFrom, String dateTo) throws Exception {
		setTopic(topic);
		setEmail(email);
		setWords(sentence);
		setDateFrom(dateFrom);
		setDateTo(dateTo);
	}
	
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setWords(String string) {
		words = string.split(" ");
	}
	public void setDateFrom(String dateFrom) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");  
		this.dateFrom = format.parse(dateFrom);
	}
	public void setDateTo(String dateTo) throws Exception {
		SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");  
		this.dateTo = format.parse(dateTo);
	}
	
	public boolean compare(Note note) {
		
		int indexTopic = note.getTopic().indexOf(topic);
		int indexEmail = note.getEmail().indexOf(email);
		boolean wordExist = false;
		for (int i = 0; i < words.length; i++) {
			int indexWord = note.getMessage().indexOf(words[i]);
			if (indexWord != -1) {
				wordExist = true;
				break;
			}
		}
		boolean match = (topic == null || indexTopic != -1)
					 && (email == null || indexEmail != -1)
					 && (words == null || wordExist)
					 && (dateFrom == null || dateFrom.equals(note.getCreationDate()) || dateFrom.before(note.getCreationDate()))
					 && (dateTo == null || dateTo.equals(note.getCreationDate()) || dateTo.after(note.getCreationDate()));
		
		return match;
	}

}
