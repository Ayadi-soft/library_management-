package GUI;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import MDL.Borrow;
import MDL.Reservation;

public class Reseve_book extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JLabel Label_ISBN = null;
	private JTextField ISBN = null;
	private JButton Button_reset = null;
	private JButton Button_return = null;
	App_init strater;
	/**
	 * This is the default constructor
	 */
	public Reseve_book(App_init strater) {
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
		
		Label_ISBN = new JLabel();
		Label_ISBN.setBounds(new Rectangle(56, 170, 44, 19));
		Label_ISBN.setText("ISBN : ");
		Label_title = new JLabel();
		Label_title.setText("Reserve Book");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		Label_title.setBounds(new Rectangle(194, 47, 147, 48));
		this.setSize(550, 400);
		this.setLayout(null );
		this.add(Label_title, null);
		this.add(Label_ISBN, null);
		this.add(getISBN(), null);
		this.add(getButton_reset(), null);
		this.add(getButton_return(), null);
	}

	/**
	 * This method initializes ISBN	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getISBN() {
		if (ISBN == null) {
			ISBN = new JTextField();
			ISBN.setBounds(new Rectangle(103, 169, 101, 21));
		}
		return ISBN;
	}

	/**
	 * This method initializes Button_reset	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_reset() {
		if (Button_reset == null) {
			Button_reset = new JButton();
			Button_reset.setBounds(new Rectangle(397, 282, 85, 35));
			Button_reset.setText("reset");
			Button_reset.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					ISBN.setText(""); // TODO Auto-generated Event stub actionPerformed()
				}
			});
		}
		return Button_reset;
	}

	/**
	 * This method initializes Button_return	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_return() {
		if (Button_return == null) {
			Button_return = new JButton();
			Button_return.setBounds(new Rectangle(308, 283, 80, 33));
			Button_return.setText("reserve");
			Button_return.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane jop1 = new JOptionPane();
					if(strater.all_reservation.add_reservation(new Reservation(strater.current_user.getID(),ISBN.getText())))
						jop1.showMessageDialog(null, "successful operation", "information", JOptionPane.INFORMATION_MESSAGE);
				
					ISBN.setText("");
				}
			});
		}
		return Button_return;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
