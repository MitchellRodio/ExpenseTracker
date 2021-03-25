import java.time.LocalDate;

public class Expense {

	private double amount;
	private String date;
	private String description;
	
	public Expense (double amount, String description) {
		this.amount = amount;
		this.description = description;
		date = LocalDate.now().toString();
	}

	public Expense (String line) {
		String words[] = line.split(" ");
		date = words[0];
		amount = Double.parseDouble(words[1].substring(1));
		description = words[2];	
	}

	public String getDescription() {
		return description;
	}

	public double getAmount() {
		return amount;
	}

	public void setDescription (String description) {
		this.description = description;
	}

	public void setAmount (double amount) {
		this.amount = amount;
	}

	public String toString() {
		return date + " $" + amount + " " + description;
	}
}
