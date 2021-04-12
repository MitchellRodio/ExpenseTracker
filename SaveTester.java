import java.io.*;

public class SaveTester {	
	public static void main(String[] args) throws FileNotFoundException {
		Save save = new Save("example_save.txt");
		save.getFromFile();
		System.out.println(save);
		save.addEntry("2020-03-24 $120.00 Food");
		save.removeEntry(3);
		System.out.println(save);
		System.out.println(save.getTotal());
		save.saveToFile();
	}
}
