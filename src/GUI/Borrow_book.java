package GUI;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Date;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import MDL.Borrow;

public class Borrow_book extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JLabel Label_isbn = null;
	private JTextField ISBN = null;
	private JButton Button_reset = null;
	private JButton Button_borrow = null;
	App_init strater;
	/**
	 * This is the default constructor
	 */
	public Borrow_book(App_init strater) {
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
	
		Label_isbn = new JLabel();
		Label_isbn.setBounds(new Rectangle(57, 156, 41, 23));
		Label_isbn.setText("ISBN : ");
		Label_title = new JLabel();
		Label_title.setText("Borrow Book");
		Label_title.setSize(new Dimension(139, 24));
		Label_title.setLocation(new Point(189, 50));
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		this.setSize(550, 400);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(Label_isbn, null);
		this.add(getISBN(), null);
		this.add(getButton_reset(), null);
		this.add(getButton_borrow(), null);
	}

	/**
	 * This method initializes ISBN	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getISBN() {
		if (ISBN == null) {
			ISBN = new JTextField();
			ISBN.setBounds(new Rectangle(110, 157, 123, 23));
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
			Button_reset.setBounds(new Rectangle(407, 291, 81, 35));
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
	 * This method initializes Button_borrow	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_borrow() {
		if (Button_borrow == null) {
			Button_borrow = new JButton();
			Button_borrow.setBounds(new Rectangle(309, 292, 85, 34));
			Button_borrow.setText("borrow");
			Button_borrow.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane jop1 = new JOptionPane();
					if(strater.all_borrow.add_borrow(new Borrow(strater.current_user.getID(),ISBN.getText(),new Date())))
						jop1.showMessageDialog(null, "successful operation", "information", JOptionPane.INFORMATION_MESSAGE);
					ISBN.setText("");
				}
			});
		}
		return Button_borrow;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
