package app;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner; 
import java.util.ArrayList;

public class FileScanner{
	
	private ArrayList<String> list = new ArrayList<>();
	
	public FileScanner(String fileName){
		File file = new File(fileName);
		Scanner sc;
		try {
			sc = new Scanner(file);

		while (sc.hasNextLine()) {
			String s = sc.nextLine();
			s = s.replace("\u200E","");
			if(s.length() > 0) {
				list.add(s);
			}
		}
		sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		formatList();
	}
	private void formatList(){
		for(int i = list.size() - 1; i >= 0; i--){
			if(list.get(i).charAt(0) != '[') {
				String s = list.get(i - 1);
				s += " " + list.get(i);
				list.set(i - 1, s);
				list.remove(i);
			}
		}
	}
	public ArrayList<String> getList(){
		ArrayList<String> copy = new ArrayList<>();
		for(String s: list){
			copy.add(s);
		}
		return copy;
	}
}

