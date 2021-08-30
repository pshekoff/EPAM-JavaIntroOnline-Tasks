package javaIntro_6_Task_3;

import java.io.*;

import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	
	protected static Socket client;
	protected static ObjectOutputStream out;
	protected static ObjectInputStream in;
	protected static Packet packet;
	
	public static void main(String[] args) {
		
		try {
			try {
				client = new Socket("localhost",8888);
				System.out.println("Client connected to the server.");
                
                out = new ObjectOutputStream(client.getOutputStream());
                in = new ObjectInputStream(client.getInputStream());
                
                packet = new Packet();
                
                //start menu launching
                ArchiveMenu.startMenu();

                packet.setType("disconnect");
                
                out.reset();
                out.writeObject(packet);
                out.flush();

			} finally {
                in.close();
                out.close();
                client.close();
				System.out.println("Client connection was closed.");
			}
		} catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
			e.printStackTrace();
	}
        
	}

}
