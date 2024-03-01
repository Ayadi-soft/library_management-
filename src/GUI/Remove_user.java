package GUI;

import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Rectangle;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Remove_user extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel Label_title = null;
	private JLabel Label_isbn = null;
	private JTextField ISBN = null;
	private JButton Button_reset = null;
	private JButton Button_remove = null;
	App_init strater;
	/**
	 * This is the default constructor
	 */
	public Remove_user(App_init strater) {
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
		Label_isbn.setBounds(new Rectangle(51, 149, 72, 24));
		Label_isbn.setText("College ID : ");
		Label_title = new JLabel();
		Label_title.setText("Remove User");
		Label_title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		Label_title.setBounds(new Rectangle(186, 51, 184, 25));
		this.setSize(550, 400);
		this.setLayout(null);
		this.add(Label_title, null);
		this.add(Label_isbn, null);
		this.add(getISBN(), null);
		this.add(getButton_reset(), null);
		this.add(getButton_remove(), null);
	}

	/**
	 * This method initializes ISBN	
	 * 	
	 * @return javax.swing.JTextField	
	 */
	private JTextField getISBN() {
		if (ISBN == null) {
			ISBN = new JTextField();
			ISBN.setBounds(new Rectangle(136, 150, 129, 23));
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
			Button_reset.setBounds(new Rectangle(401, 306, 78, 34));
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
	 * This method initializes Button_remove	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getButton_remove() {
		if (Button_remove == null) {
			Button_remove = new JButton();
			Button_remove.setBounds(new Rectangle(304, 308, 81, 32));
			Button_remove.setText("remove");
			Button_remove.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					JOptionPane jop1 = new JOptionPane();
					if(strater.all_users.remove_user(ISBN.getText()))
					{
					jop1.showMessageDialog(null, "user deleted" , "Informatioin", JOptionPane.INFORMATION_MESSAGE); ISBN.setText("");}
					else
					{jop1.showMessageDialog(null, "user does not exist" , "Informatioin", JOptionPane.ERROR_MESSAGE);}
			}
			});
		}
		return Button_remove;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
