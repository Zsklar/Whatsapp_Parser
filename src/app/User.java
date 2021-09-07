package app;

import java.util.ArrayList;

public class User {

	private String userName;
	private int sentMessages;
	private ArrayList<Message> messages = new ArrayList<>();
	
	public User(String userName , ArrayList<Message> list) {
		this.userName = userName;
		this.messages = narrowList(list);
		this.sentMessages = messages.size();
	}
	
	private ArrayList<Message> narrowList(ArrayList<Message> list){
		ArrayList<Message> messages = new ArrayList<>();
		for(Message m: list) {
			if(m.getUserName().equals(userName)) {
				messages.add(m);
			}
		}
		return messages;
	}
	
	public String getUserName() {
		return this.userName;
	}
	@Override
	public String toString() {
		return userName + ": Sent Messages: " + sentMessages;
	}
}
