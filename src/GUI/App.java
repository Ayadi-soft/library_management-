package GUI;

import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Event;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.KeyStroke;
import java.awt.Point;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JFrame;
import javax.swing.JDialog;
import javax.swing.JButton;

public class App {

	public JFrame jFrame = null;
	private JPanel jContentPane = null;
	private JMenuBar jJMenuBar = null;
	private JMenu fileMenu = null;
	private JMenu bookMenu = null;
	private JMenu adminMenu = null;
	private JMenu helpMenu = null;
	private JMenuItem exitMenuItem = null;
	private JMenuItem aboutMenuItem = null;
	private JMenuItem cutMenuItem = null;
	private JMenuItem copyMenuItem = null;
	private JMenuItem pasteMenuItem = null;
	private JMenuItem saveMenuItem = null;  //  @jve:decl-index=0:
	private JMenuItem rmvbookMenuItem = null;
	private JMenuItem finesMenuItem = null;
	private JMenuItem delreserveMenuItem = null;
	private JMenuItem reserveMenuItem = null;
	private JMenuItem returnMenuItem = null;
	private JMenuItem borrowMenuItem = null;
	private JMenuItem searchMenuItem = null;
	private JMenuItem allbookMenuItem = null;
	private JMenuItem UIMenuItem = null;
	private JMenuItem all_users_MenuItem = null;
	private JDialog aboutDialog = null;
	private JPanel aboutContentPane = null;
	private JLabel aboutVersionLabel = null;
	public static App_init strater;
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 strater = new App_init();
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				//App_init strater = new App_init();
				App application = new App();
				application.getJFrame().setVisible(true);
				strater.main_form=application;
			}
		});
	}

	/**
	 * This method initializes jFrame
	 * 
	 * @return javax.swing.JFrame
	 */
	private JFrame getJFrame() {
		if (jFrame == null) {
			jFrame = new JFrame();
			jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jFrame.setJMenuBar(getJJMenuBar());
			jFrame.setSize(550, 400);
			java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
			jFrame.setLocation((screenSize.width-jFrame.getSize().width)/2,(screenSize.height-jFrame.getSize().height)/2);
			jFrame.setContentPane(new Authentication(strater,this));
			jFrame.setTitle("Library Management");
		}
		return jFrame;
	}

	

	/**
	 * This method initializes jJMenuBar	
	 * 	
	 * @return javax.swing.JMenuBar	
	 */
	private JMenuBar getJJMenuBar() {
		if (jJMenuBar == null) {
			jJMenuBar = new JMenuBar();
			jJMenuBar.add(getFileMenu());
			jJMenuBar.add(getbookMenu());
			jJMenuBar.add(getadminMenu());
			jJMenuBar.add(getHelpMenu());
		}
		return jJMenuBar;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getFileMenu() {
		if (fileMenu == null) {
			fileMenu = new JMenu();
			fileMenu.setText("File");
			fileMenu.add(get_user_inoMenuItem());
			fileMenu.add(getSaveMenuItem());
			fileMenu.add(getExitMenuItem());
		}
		return fileMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getbookMenu() {
		if (bookMenu == null) {
			bookMenu = new JMenu();
			bookMenu.setText("Book");
			bookMenu.add(getsearchMenuItem());
			bookMenu.add(getborrowMenuItem());
			bookMenu.add(getreturnMenuItem());
			bookMenu.add(getreservMenuItem());
			bookMenu.add(getdelreservMenuItem());
			bookMenu.add(getallbookMenuItem());
		}
		return bookMenu;
	}
	
	private JMenu getadminMenu() {
		if (adminMenu == null) {
			adminMenu = new JMenu();
			adminMenu.setText("Administration");
			adminMenu.add(getCutMenuItem());
			adminMenu.add(getCopyMenuItem());
			adminMenu.add(getPasteMenuItem());
			adminMenu.add(getrmvbookMenuItem());
			adminMenu.add(get_all_users_MenuItem());
			adminMenu.add(getfineMenuItem());
		}
		return adminMenu;
	}

	/**
	 * This method initializes jMenu	
	 * 	
	 * @return javax.swing.JMenu	
	 */
	private JMenu getHelpMenu() {
		if (helpMenu == null) {
			helpMenu = new JMenu();
			helpMenu.setText("Help");
			helpMenu.add(getAboutMenuItem());
		}
		return helpMenu;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getExitMenuItem() {
		if (exitMenuItem == null) {
			exitMenuItem = new JMenuItem();
			exitMenuItem.setText("Exit");
			exitMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
		}
		return exitMenuItem;
	}

	
	private JMenuItem get_user_inoMenuItem() {
		if (UIMenuItem == null) {
			UIMenuItem = new JMenuItem();
			UIMenuItem.setText("User informations");
			UIMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Info_user form = new Info_user(strater);
					jFrame.setContentPane(form);
				}
			});
		}
		return UIMenuItem;
	}
	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getAboutMenuItem() {
		if (aboutMenuItem == null) {
			aboutMenuItem = new JMenuItem();
			aboutMenuItem.setText("About");
			aboutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JDialog aboutDialog = getAboutDialog();
					aboutDialog.pack();
					Point loc = getJFrame().getLocation();
					loc.translate(20, 20);
					aboutDialog.setLocation(loc);
					aboutDialog.setVisible(true);
				}
			});
		}
		return aboutMenuItem;
	}

	/**
	 * This method initializes aboutDialog	
	 * 	
	 * @return javax.swing.JDialog
	 */
	private JDialog getAboutDialog() {
		if (aboutDialog == null) {
			aboutDialog = new JDialog(getJFrame(), true);
			aboutDialog.setTitle("About");
			aboutDialog.setContentPane(getAboutContentPane());
		}
		return aboutDialog;
	}

	/**
	 * This method initializes aboutContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getAboutContentPane() {
		if (aboutContentPane == null) {
			aboutContentPane = new JPanel();
			aboutContentPane.setLayout(new BorderLayout());
			aboutContentPane.add(getAboutVersionLabel(), BorderLayout.CENTER);
		}
		return aboutContentPane;
	}

	/**
	 * This method initializes aboutVersionLabel	
	 * 	
	 * @return javax.swing.JLabel	
	 */
	private JLabel getAboutVersionLabel() {
		if (aboutVersionLabel == null) {
			aboutVersionLabel = new JLabel();
			aboutVersionLabel.setText("Version 1.0");
			aboutVersionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return aboutVersionLabel;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getsearchMenuItem() {
		if (searchMenuItem == null) {
			searchMenuItem = new JMenuItem();
			searchMenuItem.setText("Search book");
			searchMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					search_book form = new search_book(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return searchMenuItem;
	}
	
	private JMenuItem getborrowMenuItem() {
		if (borrowMenuItem == null) {
			borrowMenuItem = new JMenuItem();
			borrowMenuItem.setText("Borrow book");
			borrowMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Borrow_book form = new Borrow_book(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return borrowMenuItem;
	}
	
	private JMenuItem getreturnMenuItem() {
		if (returnMenuItem == null) {
			returnMenuItem = new JMenuItem();
			returnMenuItem.setText("Return book");
			returnMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Return_Book form = new Return_Book(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return returnMenuItem;
	}
	
	private JMenuItem getreservMenuItem() {
		if (reserveMenuItem == null) {
			reserveMenuItem = new JMenuItem();
			reserveMenuItem.setText("Reserve book");
			reserveMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Reseve_book form = new Reseve_book(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return reserveMenuItem;
	}
	
	private JMenuItem getdelreservMenuItem() {
		if (delreserveMenuItem == null) {
			delreserveMenuItem = new JMenuItem();
			delreserveMenuItem.setText("Delete reservation");
			delreserveMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Remove_rsv_book form = new Remove_rsv_book(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return delreserveMenuItem;
	}
	
	private JMenuItem getallbookMenuItem() {
		if (allbookMenuItem == null) {
			allbookMenuItem = new JMenuItem();
			allbookMenuItem.setText("Book List");
			allbookMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Book_list form = new Book_list(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return allbookMenuItem;
	}
	
	
	private JMenuItem getCutMenuItem() {
		if (cutMenuItem == null) {
			cutMenuItem = new JMenuItem();
			cutMenuItem.setText("Add User");
			cutMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Add_user form = new Add_user(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return cutMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getCopyMenuItem() {
		if (copyMenuItem == null) {
			copyMenuItem = new JMenuItem();
			copyMenuItem.setText("Remove User");
			copyMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Remove_user form = new Remove_user(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return copyMenuItem;
	}
	
	private JMenuItem get_all_users_MenuItem() {
		if (all_users_MenuItem == null) {
			all_users_MenuItem = new JMenuItem();
			all_users_MenuItem.setText("Users List");
			all_users_MenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					User_list form = new User_list(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return all_users_MenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getPasteMenuItem() {
		if (pasteMenuItem == null) {
			pasteMenuItem = new JMenuItem();
			pasteMenuItem.setText("Add book");
			pasteMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Add_book form = new Add_book(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return pasteMenuItem;
	}
	
	private JMenuItem getrmvbookMenuItem() {
		if (rmvbookMenuItem == null) {
			rmvbookMenuItem = new JMenuItem();
			rmvbookMenuItem.setText("Remove book");
			rmvbookMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Remove_book form = new Remove_book(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return rmvbookMenuItem;
	}
	
	private JMenuItem getfineMenuItem() {
		if (finesMenuItem == null) {
			finesMenuItem = new JMenuItem();
			finesMenuItem.setText("Fines collection");
			finesMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Controle_fines form = new Controle_fines(strater) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return finesMenuItem;
	}

	/**
	 * This method initializes jMenuItem	
	 * 	
	 * @return javax.swing.JMenuItem	
	 */
	private JMenuItem getSaveMenuItem() {
		if (saveMenuItem == null) {
			
			saveMenuItem = new JMenuItem();
			saveMenuItem.setText("Logout");
			saveMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 Authentication form = new Authentication(strater,strater.main_form) ;
					jFrame.setContentPane(form);
				}
			});
			
		}
		return saveMenuItem;
	}
	public void deactivate_menu()
	{
		bookMenu.setEnabled(false);	
		adminMenu.setEnabled(false);	
		saveMenuItem.setEnabled(false);	
		UIMenuItem.setEnabled(false);	;
	}
	
	public void Activate_menu_super_user()
	{
		bookMenu.setEnabled(true);	
		adminMenu.setEnabled(true);	
		saveMenuItem.setEnabled(true);	
		UIMenuItem.setEnabled(true);	;
	}
	public void Activate_menu_normal_user()
	{
		bookMenu.setEnabled(true);	
		//adminMenu.setEnabled(true);	
		saveMenuItem.setEnabled(true);	
		UIMenuItem.setEnabled(true);	;
	}
}
