import java.util.*;
import java.io.*;

public class Save {

	private String fileName;
	private ArrayList<Expense> entries;
	private Scanner scan;

	public Save (String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		entries = new ArrayList<Expense>();

		File saveFile = new File(fileName);
		scan = new Scanner(saveFile);
	}

	public void getFromFile () {
		String line = "";
		while(scan.hasNextLine()){
			line = scan.nextLine();
			entries.add(new Expense(line));
		}		
	}

	public void saveToFile () throws FileNotFoundException {
		PrintWriter out = new PrintWriter(fileName);

		for (int i = 0; i < entries.size(); i++) {
			out.println(entries.get(i));
		}	

		out.close();
	}

	public Expense getEntry (int n) {
		return entries.get(n);
	}

	public void setEntry (int n, Expense newEntry) {
		Expense entry = entries.get(n);
		entry = newEntry;	
	}

	public void addEntry (String entry) {
		entries.add(new Expense(entry));
	}

	public void addEntry (Expense entry) {
		entries.add(entry);
	}

	public void removeEntry (int n){
		entries.remove(n);
	}

	public String toString () {
		String res = "";
		for (int i = 0; i < entries.size(); i++) {
			res += entries.get(i) + "\n";	
		}

		return res;
	}
}
