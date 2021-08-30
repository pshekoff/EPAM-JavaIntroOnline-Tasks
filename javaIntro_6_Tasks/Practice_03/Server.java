package javaIntro_6_Task_3;

import java.io.*;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
    private static Socket client;
    private static ServerSocket server;
	private static ObjectOutputStream out;
	private static ObjectInputStream in;

	public static void main(String[] args) {
		
		try {
			try {
				server = new ServerSocket(8888);
				System.out.println("Server is running.");
				
				//student archive initialization
				XmlArchive.main(args);
				
				//credentials file initialization
				Credentials cred = new Credentials();
				
				client = server.accept();
	            System.out.println("Client connection accepted.");
	            
	            try {
	                
	                out = new ObjectOutputStream(client.getOutputStream());
	                in = new ObjectInputStream(client.getInputStream());
	                
	                while (true) {
	                	
	                	Packet packet = (Packet) in.readObject();
	                	
	                	//credentials checking to log in
	                	if (packet.getType().equals("credentials")) {
	                		out.writeBoolean(cred.checkCredentials(packet.getValue()));
	                		out.flush();
	                	}
	                	
	                	//checking is the user an admin
	                	else if (packet.getType().equals("isAdmin")) {
	                		out.writeBoolean(cred.isAdmin(packet.getValue()));
                			out.flush();
	                	}
	                	
	                	//checking if the login is already exist
	                	else if (packet.getType().equals("login")) {
	                		out.writeBoolean(cred.checkLogin(packet.getValue()));
	                		out.flush();
	                	}
	                	
	                	//root password match checking
	                	else if (packet.getType().equals("root")) {
	                		if (cred.getRootPasswordHash() == Integer.parseInt(packet.getValue())) {
		                		out.writeBoolean(true);
	                		}
	                		else {
	                			out.writeBoolean(false);
	                		}
	                		out.flush();
	                	}
	                	
	                	//new admin registration
	                	else if (packet.getType().equals("adminReg")) {
	                		String credStr[] = packet.getValue().split(";");
	                		User u = new User(credStr[0], Integer.parseInt(credStr[1]), true);
	                		cred.addUser(u);
	                		cred.saveToFile(u.toString());
	                	}
	                	
	                	//new user registration
	                	else if (packet.getType().equals("userReg")) {
	                		String credStr[] = packet.getValue().split(";");
	                		User u = new User(credStr[0], Integer.parseInt(credStr[1]), false);
	                		cred.addUser(u);
	                		cred.saveToFile(u.toString());
	                	}
	                	
	                	//print all students from archive
	                	else if (packet.getType().equals("printall")) {
	                		
	                		out.write(XmlArchive.studentList.size());
	                		
	                		for (int i = 0; i < XmlArchive.studentList.size(); i++) {
	                			out.writeUTF(XmlArchive.studentList.get(i).toString());
	                			out.flush();
	                		}

	                	}
	                	
	                	//adding new student into archive
	                	else if (packet.getType().equals("newStudent")) {
	                		String studentStr[] = packet.getValue().split(";");
	                		Student s = new Student(studentStr[0], studentStr[1], studentStr[2]);
	                		XmlArchive.addStudent(s);
	                	}
	                	
	                	//editing student data
	                	else if (packet.getType().equals("editStudent")) {
	                		String[] studentStr = packet.getValue().split(";");
	                		XmlArchive.editStudent(studentStr);
	                	}
	                	
	                	//send max student id to client
	                	else if (packet.getType().equals("getMaxId")) {          		
	                		int maxId = XmlArchive.studentList.size();
	                		out.write(maxId);
	                		out.flush();
	                	}
	                	
	                	//client disconnection
	                	else if (packet.getType().equals("disconnect")) {
	                		break;
	                	}

	                }
	                
	            } catch (ClassNotFoundException e) {
	            	e.printStackTrace();
	            } finally {
	            	in.close();
	            	out.close();
	            	client.close();
	            	System.out.println("Client disconnected");
	            }
			} finally {
				server.close();
				System.out.println("Server is closed.");
			} 
		} catch (IOException e) {
				e.printStackTrace();
		}

	}

}
