package app;

public class Driver {

	public static void main(String[] args) {
		System.out.println("Running");
		GroupChat g = new GroupChat("/Users/zacharysklar/Downloads/_chat.txt");
		System.out.println(g.toString());
	}

}
