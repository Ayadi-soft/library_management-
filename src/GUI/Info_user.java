package GUI;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import MDL.Borrow;
import MDL.Reservation;

public class Info_user  extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JLabel Label_isbn = null;
	private JTextField ISBN = null;
	private JButton Button_reset = null;
	private JButton Button_remove = null;
	App_init strater;
	private JLabel jLabel = null;
	private JLabel lab_id = null;
	private JLabel jLabel1 = null;
	private JLabel lab_name = null;
	private JLabel jLabel2 = null;
	private JScrollPane jScrollPane = null;
	private JTable Table_borrows = null;
	private JLabel jLabel3 = null;
	private JScrollPane jScrollPane1 = null;
	private JTable Table_reserv = null;
	private JLabel jLabel4 = null;
	private JLabel lab_fines = null;
	/**
	 * This is the default constructor
	 */
	public Info_user (App_init strater) {
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
		
		
		lab_fines = new JLabel();
		lab_fines.setBounds(new Rectangle(402, 212, 92, 19));
		lab_fines.setText("");
		jLabel4 = new JLabel();
		jLabel4.setBounds(new Rectangle(303, 212, 94, 20));
		jLabel4.setText("sum of fines : ");
		jLabel3 = new JLabel();
		jLabel3.setBounds(new Rectangle(35, 223, 171, 26));
		jLabel3.setText("list of reserved books");
		jLabel2 = new JLabel();
		jLabel2.setBounds(new Rectangle(37, 88, 142, 30));
		jLabel2.setText("list of borrwed books");
		lab_name = new JLabel();
		lab_name.setBounds(new Rectangle(341, 63, 168, 28));
		lab_name.setText(strater.current_user.getName());
		jLabel1 = new JLabel();
		jLabel1.setBounds(new Rectangle(276, 63, 53, 24));
		jLabel1.setText("Name : ");
		lab_id = new JLabel();
		lab_id.setBounds(new Rectangle(130, 64, 106, 25));
		lab_id.setText(strater.current_user.getID());
		jLabel = new JLabel();
		jLabel.setBounds(new Rectangle(37, 65, 74, 19));
		jLabel.setText("College ID : ");
		Label_title = new JLabel();
		Label_title.setText("User Informations");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		Label_title.setBounds(new Rectangle(167, 33, 184, 25));
		this.setSize(550, 400);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(jLabel, null);
		this.add(lab_id, null);
		this.add(jLabel1, null);
		this.add(lab_name, null);
		this.add(jLabel2, null);
		this.add(getJScrollPane(), null);
		this.add(jLabel3, null);
		this.add(getJScrollPane1(), null);
		this.add(jLabel4, null);
		this.add(lab_fines, null);
	
	
	}

	/**
	 * This method initializes jScrollPane	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane() {
		if (jScrollPane == null) {
			jScrollPane = new JScrollPane();
			jScrollPane.setBounds(new Rectangle(36, 120, 469, 77));
			jScrollPane.setViewportView(getTable_borrows());
		}
		return jScrollPane;
	}

	/**
	 * This method initializes Table_borrows	
	 * 	
	 * @return javax.swing.JTable	
	 */
	private JTable getTable_borrows() {
		if (Table_borrows == null) {
			Object[][] data = new Object[100][6]; int nb=0; double sum=0; double total=0;
			//A string array containing the column names for the JTable. 
			String[] columnNames = {"ISBN","Book name","borrow date","number of days","Fines"}; 
			int j=0; 
			for(int i=0;i<strater.all_borrow.list.size();i++)
	        {
				 Borrow x =(Borrow)strater.all_borrow.list.get(i);  sum=0;
			     if(   x.retour_date==null && x.collage_ID.equalsIgnoreCase(strater.current_user.getID()) ){ 
				data[j][0]=new String(x.isbn_number);
				
				data[j][1]=new String(strater.all_books.get_book_by_id(x.isbn_number).gettitle());
				
				data[j][2]=new String("");
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
				data[j][2] = sdf.format(x.borrow_date);
				
				nb=(int)differenceDate( x.borrow_date,new Date());
				data[j][3]=new String("a");
				data[j][3]=nb;
				if(nb>5)sum=(nb-5)*200;
				data[j][4]=new String("a");
				data[j][4]=sum*0.001;
				j++; total+=sum*0.001;
	        }}
			//Create the JTable using the data array and column name array. 
			DefaultTableModel defTableModel = new DefaultTableModel(data,columnNames);
			Table_borrows =  new JTable(defTableModel);
			lab_fines.setText(Double.toString(total)+"  RIAL");
		
		}
		return Table_borrows;
	}

	/**
	 * This method initializes jScrollPane1	
	 * 	
	 * @return javax.swing.JScrollPane	
	 */
	private JScrollPane getJScrollPane1() {
		if (jScrollPane1 == null) {
			jScrollPane1 = new JScrollPane();
			jScrollPane1.setBounds(new Rectangle(38, 255, 470, 77));
			jScrollPane1.setViewportView(getTable_reserv());
		}
		return jScrollPane1;
	}

	/**
	 * This method 
	 * 	
	 *  differance betwin 2 date	
	 */
	
	  public static long differenceDate(Date date1, Date date2)
	  {
		long UNE_HEURE = 60 * 60 * 1000L;
	    return ((date2.getTime() - date1.getTime() + UNE_HEURE) / (UNE_HEURE * 24));
	  }
	  /**
		 * This method initializes Table_reserv	
		 * 	
		 * @return javax.swing.JTable	
		 */
	private JTable getTable_reserv() {
		if (Table_reserv == null) {
			Object[][] data = new Object[100][6]; 
			//A string array containing the column names for the JTable. 
			String[] columnNames = {"ISBN","Book name","borrow date"}; 
			int j=0; 
			for(int i=0;i<strater.all_reservation.list.size();i++)
	        {
				 Reservation x =(Reservation)strater.all_reservation.list.get(i);
			     if(  x.collage_ID.equalsIgnoreCase(strater.current_user.getID()) ){ 
				data[j][0]=new String(x.isbn_number);
				
				data[j][1]=new String(strater.all_books.get_book_by_id(x.isbn_number).gettitle());
				
				data[j][2]=new String("");
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
				data[j][2] = sdf.format(x.reserv_date);
				
				
				j++; 
	        }}
			//Create the JTable using the data array and column name array. 
			DefaultTableModel defTableModel = new DefaultTableModel(data,columnNames);
			Table_reserv =  new JTable(defTableModel);
			 
		
		}
		return Table_reserv;
	}




}  
