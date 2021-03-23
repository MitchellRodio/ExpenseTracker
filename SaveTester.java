import java.io.*;

public class SaveTester {	
	public static void main(String[] args) throws FileNotFoundException {
		Save save = new Save("example_save.txt");
		save.getFromFile();
		System.out.println(save);
		save.addEntry("2020-03-24 $120.00");
		save.removeEntry(3);
		System.out.println(save);
		save.saveToFile();
	}
}
