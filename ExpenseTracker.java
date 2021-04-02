import javax.swing.*;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;  
import java.util.*;
import java.io.*;
public class ExpenseTracker {

	private static JTextField Expense_Input_Field;  
	private static JTextField txtType;
	private static Save save;

	public static void main(String[] args) throws FileNotFoundException {  

		save = new Save("example_save.txt"); 
		save.getFromFile();
		
		String input1 = null;
		String input2 = null;
		String operator = null;
		
		String finalAnswer;

		//	BELOW = JAVA GUI 
		JFrame f=new JFrame();
		f.setTitle("Java Swing Expense Tracker");
		// f.setIconImage(Toolkit.getDefaultToolkit().getImage("")); APP ICON / FAVICON To be set
		f.getContentPane().setBackground(Color.DARK_GRAY);
		f.getContentPane().setForeground(Color.BLACK);
			  
		f.setSize(400,500);//400 width and 500 height  
		f.getContentPane().setLayout(null);
		Expense_Input_Field = new JTextField();
		Expense_Input_Field.setText("Expense $");
		Expense_Input_Field.setToolTipText("Enter Expense");
		Expense_Input_Field.setBounds(45, 66, 85, 28);
		f.getContentPane().add(Expense_Input_Field);

		Expense_Input_Field.setColumns(10);
		JButton Submit_Button = new JButton("Submit");
		Submit_Button.setBounds(251, 69, 85, 21);
		Submit_Button.addActionListener(new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent a){
				double value = Double.parseDouble(Expense_Input_Field.getText());
				String desc = txtType.getText();

				save.addEntry(value, desc);
				try {
					save.saveToFile();
				} catch (Exception e) {
					System.out.println("Error saving to file");
				}
			}
		});
		f.getContentPane().add(Submit_Button);

		JList<Expense> list_1 = new JList<>(save.entries);
		list_1.setBorder(new LineBorder(Color.RED));
		list_1.setBounds(45, 161, 291, 215);
		f.getContentPane().add(list_1);

		txtType = new JTextField();
		txtType.setToolTipText("Expense Type");
		txtType.setText("Type");
		txtType.setColumns(10);
		txtType.setBounds(140, 66, 85, 28);
		f.getContentPane().add(txtType);

		JButton button = new JButton("New button");
		button.setBounds(251, 69, 85, 21);
		f.getContentPane().add(button);

		JLabel Label1 = new JLabel("Total $");
		Label1.setBackground(Color.GRAY);
		Label1.setForeground(Color.GRAY);
		Label1.setBounds(55, 386, 281, 28);
		f.getContentPane().add(Label1);

		f.setVisible(true);//making the frame visible  
	}  

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}  
