import java.util.*;
import java.io.*;
import javax.swing.DefaultListModel;

public class Save {

	private String fileName;
	private Scanner scan;
	
	public DefaultListModel<Expense> entries;

	public Save (String fileName) throws FileNotFoundException {
		this.fileName = fileName;
		entries = new DefaultListModel<>();

		File saveFile = new File(fileName);
		scan = new Scanner(saveFile);
	}

	public void getFromFile () {
		String line = "";
		while(scan.hasNextLine()){
			line = scan.nextLine();
			entries.addElement(new Expense(line));
		}		
	}

	public void saveToFile () throws FileNotFoundException {
		PrintWriter out = new PrintWriter(fileName);

		for (int i = 0; i < entries.getSize(); i++) {
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
		entries.addElement(new Expense(entry));
	}

	public void addEntry (Expense entry) {
		entries.addElement(entry);
	}

	public void addEntry (double amount, String description) {
		entries.addElement(new Expense(amount, description));
	}

	public void removeEntry (int n){
		entries.removeElementAt(n);
	}

	public String toString () {
		String res = "";
		for (int i = 0; i < entries.getSize(); i++) {
			res += entries.get(i) + "\n";	
		}

		return res;
	}
}
