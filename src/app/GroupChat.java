package app;
import java.util.ArrayList;

public class GroupChat {
	private String fileName;
	private String chatName;
	private ArrayList<Message> messages = new ArrayList<>();
	private ArrayList<User> users = new ArrayList<>();
	
	public GroupChat(String fileName){
		this.fileName = fileName;
		FileScanner s = new FileScanner(fileName);
		messages = createMessages(s.getList());
		users = createUsers(messages);
	}
	
	public GroupChat(String chatName, String fileName){
		this(fileName);
		this.chatName = chatName;
	}
	
	private static ArrayList<Message> createMessages(ArrayList<String> list){
		ArrayList<Message> messages = new ArrayList<>();
		for(String r: list) {
			Message m = new Message(r);
			messages.add(m);
		}
		return messages;
	}
	
	// Returns a list of all unique UserNames
	private static ArrayList<String> difUsers(ArrayList<Message> list) {
		ArrayList<String> l = new ArrayList<>();
		for (Message m : list) {
			if (!l.contains(m.getUserName())) {
				l.add(m.getUserName());
			}
		}
		return l;
	} 	
		//creates Users	
		private static ArrayList<User> createUsers(ArrayList<Message> list){
			ArrayList<User> users = new ArrayList<>();
			ArrayList<String> userNames = difUsers(list);
			for(String s: userNames) {
				ArrayList<Message> userM = new ArrayList<>();
				for(Message m: list) {
					if(m.getUserName() != null && m.getUserName().equals(s)) {
						userM.add(m);
					}
				}
				users.add(new User(s , userM));
			}
			return users;
		} 
		
	public ArrayList<Message> getMessages() {	
		return this.messages;
	}
	
	public ArrayList<User> getUsers() {
		return this.users;
	}
	
	public String getChatName() {
		return this.chatName;	
	}
		
		
	@Override 
	public String toString() {
		String s = "";
		for(Message m: messages) {
			s += m.toString();
			s += "\n"; 
		}
		return s;
	}
}
