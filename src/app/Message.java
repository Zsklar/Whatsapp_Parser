package app;

public class Message {
	
	private String date;
	private String userName;
	private String message;
	
	public Message(String raw) {
		String s = "";
		this.date = raw.substring(1, raw.indexOf(']'));
		s = raw.substring(raw.indexOf(']') + 2);
		if(s.contains(":")) {
			this.userName = s.substring(0, s.indexOf(':'));
			s = s.substring(s.indexOf(':') + 2);
			this.message = s;
		} else {
			this.message = raw.substring(raw.indexOf(']') + 1);
		}
	}
	
	public String getUserName() {
		return userName;
	}
	
	@Override
	public String toString() {
		return userName + " --> " + date + " --> " + message;
	}

}
