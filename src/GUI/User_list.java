package GUI;
import javax.swing.table.AbstractTableModel;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class User_list extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	App_init strater;
	private JScrollPane jScrollPane = null;
	private JScrollPane jScrollPane1 = null;
	private JTable Table_book = null;

	/**
	 * This is the default constructor
	 */
	public User_list(App_init strater) {
		super();
		this.strater=strater;
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		
		Label_title = new JLabel();
		Label_title.setText("Book List");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		Label_title.setBounds(new Rectangle(197, 38, 143, 28));
		this.setSize(550, 400);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(getJScrollPane1(), null);
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(37, 104, 465, 222));
			jScrollPane1.setViewportView(getTable_book());
		}
		return jScrollPane1;
	}

	/**
	 * This method initializes Table_book	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTable_book() {
		if (Table_book == null) {
			Object[][] data = new Object[100][7]; 
			//A string array containing the column names for the JTable. 
			String[] columnNames = {"ID","name","Type","Phone Number","Email","Address"}; 
			
			for(int i=0;i<strater.all_users.list.size();i++)
	        {
				data[i][0]=new String(strater.all_users.list.get(i).getID());
				data[i][1]=new String(strater.all_users.list.get(i).getName());
				data[i][2]=new String(strater.all_users.list.get(i).user_type);
				data[i][3]=new String(strater.all_users.list.get(i).getPhone_number());
				data[i][4]=new String(strater.all_users.list.get(i).getEmail());
				data[i][5]=new String(strater.all_users.list.get(i).getAddress());
	}
			//Create the JTable using the data array and column name array. 
			DefaultTableModel defTableModel = new DefaultTableModel(data,columnNames);
			Table_book =  new JTable(defTableModel);
			
			
		}
		return Table_book;
	}

	
	

}  
