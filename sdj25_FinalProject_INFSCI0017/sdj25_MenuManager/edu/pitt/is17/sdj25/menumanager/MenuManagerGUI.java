package edu.pitt.is17.sdj25.menumanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.DefaultListModel;

/**
 * Class: Entree
 * Author: Steve Johnston
 * Created: 4/08/2017
 */

public class MenuManagerGUI {

	private MenuManager menuManagerGUI; 

	//GUI Components

	//-----Primary Window GUI-----
	//Build Your Own Menu Elements
	private JFrame frmMenu;
	private JPanel pnlBuild;
	private JLabel lblEntree;
	private JLabel lblSide;
	private JLabel lblAppetizer;
	private JLabel lblBeer;
	private JComboBox<Entree> cboEntrees;
	private JComboBox<Side> cboSides;
	private JComboBox<Appetizer> cboAppetizers;
	private JComboBox<Beer> cboBeers;
	private JButton btnCreateMenu;

	//Generate a Menu Elements	
	private JPanel pnlGenerate;
	private JButton btnRandomMenu;
	private JButton btnMinCalMenu;
	private JButton btnMaxCalMenu;
	private JButton btnMostExpMenu;
	private JButton btnLeastExpMenu;

	//Created Menus Elements	
	private JLabel lblCreatedMenus;
	private DefaultListModel listMenusModel;
	private JList listMenus;
	private JButton btnDetails;
	private JButton btnDeleteAll;
	private JButton btnSave;

	//-----Secondary Window GUI-----
	private JFrame frmDetails;
	private JLabel lblEntreeDetails;
	private JLabel lblSideDetails;
	private JLabel lblAppetizerDetails;
	private JLabel lblBeerDetails;
	private JLabel lblTotalCalories;
	private JLabel lblTotalPrice;
	private JTextArea txtEntreeDetails;
	private JTextArea txtSideDetails;
	private JTextArea txtAppetizerDetails;
	private JTextArea txtBeerDetails;
	private JTextField txtTotalCalories;
	private JTextField txtTotalPrice;

	//GUI Constructor
	public MenuManagerGUI() {
		//-----Primary GUI Screen-----

		//Load data from file
		menuManagerGUI = new MenuManager("data/dishes.txt");

		ArrayList<Menu> createdMenuAL = new ArrayList<Menu>();


		//Create JFrame
		frmMenu = new JFrame("Bar Menu Manager");
		frmMenu.setLayout(null);
		frmMenu.setBounds(100, 60, 770, 650);
		frmMenu.setResizable(false);
		frmMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//******Build Your Own Menu Section******
		TitledBorder buildMenuBorder = new TitledBorder("Build Your Own Menu");
		buildMenuBorder.setTitleJustification(TitledBorder.LEFT);
		buildMenuBorder.setTitlePosition(TitledBorder.TOP);
		pnlBuild = new JPanel();
		pnlBuild.setBorder(buildMenuBorder);
		pnlBuild.setBounds(20, 30, 350, 285);
		pnlBuild.setLayout(null);
		frmMenu.getContentPane().add(pnlBuild);

		// Components of Build Your Own Menu Section
		//Entree Label
		lblEntree = new JLabel("Entree:");
		lblEntree.setBounds(10, 30, 80, 20);
		pnlBuild.add(lblEntree);

		//Entree Combobox
		ArrayList<Entree> entreeOptions = menuManagerGUI.getEntrees();
		cboEntrees = new JComboBox(entreeOptions.toArray());
		cboEntrees.setSelectedIndex(-1);
		cboEntrees.setBounds(100, 30, 240, 30);
		pnlBuild.add(cboEntrees);

		//Side Label
		lblSide = new JLabel("Side:");
		lblSide.setBounds(10, 80, 80, 20);
		pnlBuild.add(lblSide);

		//Side ComboBox
		ArrayList<Side> sideOptions = menuManagerGUI.getSides();
		cboSides = new JComboBox(sideOptions.toArray());
		cboSides.setSelectedIndex(-1);
		cboSides.setBounds(100, 80, 240, 30);
		pnlBuild.add(cboSides);

		//Appetizer Label
		lblAppetizer = new JLabel("Appetizer:");
		lblAppetizer.setBounds(10, 130, 80, 20);
		pnlBuild.add(lblAppetizer);

		//Appetizer ComboBox
		ArrayList<Appetizer> appetizerOptions = menuManagerGUI.getAppetizers();
		cboAppetizers = new JComboBox(appetizerOptions.toArray());
		cboAppetizers.setSelectedIndex(-1);
		cboAppetizers.setBounds(100, 130, 240, 30);
		pnlBuild.add(cboAppetizers);

		//Beer Label
		lblBeer = new JLabel("Beer:");
		lblBeer.setBounds(10, 180, 80, 20);
		pnlBuild.add(lblBeer);

		//Beer Combobox
		ArrayList<Beer> beerOptions = menuManagerGUI.getBeers();
		cboBeers = new JComboBox(beerOptions.toArray());
		cboBeers.setSelectedIndex(-1);
		cboBeers.setBounds(100, 180, 240, 30);
		pnlBuild.add(cboBeers);

		// Create Menu button
		btnCreateMenu = new JButton("Create Menu With These Selections");
		btnCreateMenu.setBounds(25, 230, 300, 40);
		pnlBuild.add(btnCreateMenu);

		// Create Menu button logic
		btnCreateMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				//Check to see if a menu is selected	
				if(cboEntrees.getSelectedIndex() == -1 || cboSides.getSelectedIndex() == -1 || cboAppetizers.getSelectedIndex() == -1 || cboBeers.getSelectedIndex() == -1) {
					JOptionPane.showMessageDialog(null, "Please select an option from every category and try again.");
				} else {
					//Prompt for user name input
					String menuNameInput = JOptionPane.showInputDialog("Please name your new custom menu.");
					Menu newCreatedMenu;
					boolean nameDuplicateCheck = false;

					//Iterate through list of created menus to check for duplicate names
					for (int i = 0; i < listMenusModel.size(); i++){
						if (listMenusModel.getElementAt(i).toString().equals(menuNameInput)){
							nameDuplicateCheck = true;
						} // End if conditional
					} //End For Loop

					//Send message to confirm cancel of input dialog 	
					if (menuNameInput == null ) {
						JOptionPane.showMessageDialog(frmMenu, "You have canceled without entering a menu name.");
						//Send message to alert user of duplicate menu name
					} else if (nameDuplicateCheck == true && menuNameInput.length() != 0)  {
						JOptionPane.showMessageDialog(frmMenu, "Sorry, but that name has already been used.");
						//Send message to alert user of blank name error
					} else if (menuNameInput.length() == 0) {
						JOptionPane.showMessageDialog(frmMenu, "You left the name blank. Please fill in a name and try again.");
						//Create random menu and update list	
					} else {
						Entree entree = (Entree) cboEntrees.getSelectedItem();
						Side side = (Side) cboSides.getSelectedItem();
						Appetizer appetizer = (Appetizer) cboAppetizers.getSelectedItem();
						Beer beer = (Beer) cboBeers.getSelectedItem();
						newCreatedMenu = new Menu(menuNameInput, entree, side, appetizer, beer);
						createdMenuAL.add(newCreatedMenu);

						listMenusModel.addElement(newCreatedMenu);

					}// End name duplicate check else condition
				} // End Combobox check else condition 
			} // End action event performed method
		});  // End actionListener

		//******Generate a Menu Section******
		TitledBorder generateMenuBorder = new TitledBorder("Generate A Menu");
		buildMenuBorder.setTitleJustification(TitledBorder.LEFT);
		buildMenuBorder.setTitlePosition(TitledBorder.TOP);
		pnlGenerate = new JPanel();
		pnlGenerate.setBorder(generateMenuBorder);
		pnlGenerate.setBounds(20, 330, 350, 285);
		pnlGenerate.setLayout(null);
		frmMenu.getContentPane().add(pnlGenerate);

		//Random Menu Button	
		btnRandomMenu = new JButton("Generate a Random Menu");
		btnRandomMenu.setBounds(25, 30, 300, 40);
		pnlGenerate.add(btnRandomMenu);

		//Random Menu Button Logic
		btnRandomMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt for user name input
				String menuNameInput = JOptionPane.showInputDialog("Please name your new random menu.");
				Menu newCreatedMenu;
				boolean nameDuplicateCheck = false;

				//Iterate through list of created menus to check for duplicate names
				for (int i = 0; i < listMenusModel.size(); i++){
					if (listMenusModel.getElementAt(i).toString().equals(menuNameInput)){
						nameDuplicateCheck = true;
					} // End if conditional
				} //End For Loop

				//Send message to confirm cancel of input dialog 	
				if (menuNameInput == null ) {
					JOptionPane.showMessageDialog(frmMenu, "You have canceled without entering a menu name.");
					//Send message to alert user of duplicate menu name
				} else if (nameDuplicateCheck == true && menuNameInput.length() != 0)  {
					JOptionPane.showMessageDialog(frmMenu, "Sorry, but that name has already been used.");
					//Send message to alert user of blank name error
				} else if (menuNameInput.length() == 0) {
					JOptionPane.showMessageDialog(frmMenu, "You left the name blank. Please fill in a name and try again.");
					//Create random menu and update list
				} else {
					newCreatedMenu = menuManagerGUI.randomMenu(menuNameInput);
					createdMenuAL.add(newCreatedMenu);
					listMenusModel.addElement(newCreatedMenu);
				} // End of else statement
			} // end of actionPerformed method
		}); // End of btnRandomMenu actionListener


		//Minimum Calories Button
		btnMinCalMenu = new JButton("Generate a Minimum Calories Menu");
		btnMinCalMenu.setBounds(25, 80, 300, 40);
		pnlGenerate.add(btnMinCalMenu);

		//Minimum Calories button logic
		btnMinCalMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt for user name input
				String menuNameInput = JOptionPane.showInputDialog("Please name your new random menu.");
				Menu newCreatedMenu;
				boolean nameDuplicateCheck = false;

				//Iterate through list of created menus to check for duplicate names
				for (int i = 0; i < listMenusModel.size(); i++){
					if (listMenusModel.getElementAt(i).toString().equals(menuNameInput)){
						nameDuplicateCheck = true;
					} // End if conditional
				} //End For Loop

				//Send message to confirm cancel of input dialog 	
				if (menuNameInput == null ) {
					JOptionPane.showMessageDialog(frmMenu, "You have canceled without entering a menu name.");
					//Send message to alert user of duplicate menu name
				} else if (nameDuplicateCheck == true && menuNameInput.length() != 0)  {
					JOptionPane.showMessageDialog(frmMenu, "Sorry, but that name has already been used.");
					//Send message to alert user of blank name error
				} else if (menuNameInput.length() == 0) {
					JOptionPane.showMessageDialog(frmMenu, "You left the name blank. Please fill in a name and try again.");
					//Create random menu and update list
				} else {
					newCreatedMenu = menuManagerGUI.minCaloriesMenu(menuNameInput);
					createdMenuAL.add(newCreatedMenu);
					listMenusModel.addElement(newCreatedMenu);
				} // End of else statement
			} // end of actionPerformed method
		}); // End of btnRandomMenu actionListener

		//Maximum Calories Button
		btnMaxCalMenu = new JButton("Generate a Maximum Calories Menu");
		btnMaxCalMenu.setBounds(25, 130, 300, 40);
		pnlGenerate.add(btnMaxCalMenu);

		//Maximum Calories button logic
		btnMaxCalMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt for user name input
				String menuNameInput = JOptionPane.showInputDialog("Please name your new random menu.");
				Menu newCreatedMenu;
				boolean nameDuplicateCheck = false;

				//Iterate through list of created menus to check for duplicate names
				for (int i = 0; i < listMenusModel.size(); i++){
					if (listMenusModel.getElementAt(i).toString().equals(menuNameInput)){
						nameDuplicateCheck = true;
					} // End if conditional
				} //End For Loop

				//Send message to confirm cancel of input dialog 	
				if (menuNameInput == null ) {
					JOptionPane.showMessageDialog(frmMenu, "You have canceled without entering a menu name.");
					//Send message to alert user of duplicate menu name
				} else if (nameDuplicateCheck == true && menuNameInput.length() != 0)  {
					JOptionPane.showMessageDialog(frmMenu, "Sorry, but that name has already been used.");
					//Send message to alert user of blank name error
				} else if (menuNameInput.length() == 0) {
					JOptionPane.showMessageDialog(frmMenu, "You left the name blank. Please fill in a name and try again.");
					//Create random menu and update list
				} else {
					newCreatedMenu = menuManagerGUI.maxCaloriesMenu(menuNameInput);
					createdMenuAL.add(newCreatedMenu);
					listMenusModel.addElement(newCreatedMenu);
				} // End of else statement
			} // end of actionPerformed method
		}); // End of btnRandomMenu actionListener

		//Most Expensive Button
		btnMostExpMenu = new JButton("Generate the Most Expensive Menu");
		btnMostExpMenu.setBounds(25, 180, 300, 40);
		pnlGenerate.add(btnMostExpMenu);

		//Most Expensive button logic
		btnMostExpMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt for user name input
				String menuNameInput = JOptionPane.showInputDialog("Please name your new random menu.");
				Menu newCreatedMenu;
				boolean nameDuplicateCheck = false;

				//Iterate through list of created menus to check for duplicate names
				for (int i = 0; i < listMenusModel.size(); i++){
					if (listMenusModel.getElementAt(i).toString().equals(menuNameInput)){
						nameDuplicateCheck = true;
					} // End if conditional
				} //End For Loop

				//Send message to confirm cancel of input dialog 	
				if (menuNameInput == null ) {
					JOptionPane.showMessageDialog(frmMenu, "You have canceled without entering a menu name.");
					//Send message to alert user of duplicate menu name
				} else if (nameDuplicateCheck == true && menuNameInput.length() != 0)  {
					JOptionPane.showMessageDialog(frmMenu, "Sorry, but that name has already been used.");
					//Send message to alert user of blank name error
				} else if (menuNameInput.length() == 0) {
					JOptionPane.showMessageDialog(frmMenu, "You left the name blank. Please fill in a name and try again.");
					//Create random menu and update list
				} else {
					newCreatedMenu = menuManagerGUI.mostExpMenu(menuNameInput);
					createdMenuAL.add(newCreatedMenu);
					listMenusModel.addElement(newCreatedMenu);
				} // End of else statement
			} // end of actionPerformed method
		}); // End of btnRandomMenu actionListener

		// Least Expensive Button
		btnLeastExpMenu = new JButton("Generate the Least Expensive Menu");
		btnLeastExpMenu.setBounds(25, 230, 300, 40);
		pnlGenerate.add(btnLeastExpMenu);

		//Least Expensive button logic
		btnLeastExpMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Prompt for user name input
				String menuNameInput = JOptionPane.showInputDialog("Please name your new random menu.");
				Menu newCreatedMenu;
				boolean nameDuplicateCheck = false;

				//Iterate through list of created menus to check for duplicate names
				for (int i = 0; i < listMenusModel.size(); i++){
					if (listMenusModel.getElementAt(i).toString().equals(menuNameInput)){
						nameDuplicateCheck = true;
					} // End if conditional
				} //End For Loop

				//Send message to confirm cancel of input dialog 	
				if (menuNameInput == null ) {
					JOptionPane.showMessageDialog(frmMenu, "You have canceled without entering a menu name.");
					//Send message to alert user of duplicate menu name
				} else if (nameDuplicateCheck == true && menuNameInput.length() != 0)  {
					JOptionPane.showMessageDialog(frmMenu, "Sorry, but that name has already been used.");
					//Send message to alert user of blank name error
				} else if (menuNameInput.length() == 0) {
					JOptionPane.showMessageDialog(frmMenu, "You left the name blank. Please fill in a name and try again.");
					//Create random menu and update list
				} else if (menuNameInput != null){
					newCreatedMenu = menuManagerGUI.leastExpMenu(menuNameInput);
					createdMenuAL.add(newCreatedMenu);
					listMenusModel.addElement(newCreatedMenu);
				} // End of else statement
			} // end of actionPerformed method
		}); // End of btnRandomMenu actionListener

		//******Created Menus Section******
		//Created Menus Label
		lblCreatedMenus = new JLabel("Created Menus:");
		lblCreatedMenus.setBounds(400, 25, 100, 20);
		frmMenu.add(lblCreatedMenus);

		//Menu List
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(400,50,350,515);
		frmMenu.getContentPane().add(scrollPane);
		listMenusModel = new DefaultListModel();
		listMenus = new JList(listMenusModel);
		scrollPane.setViewportView(listMenus);

		//frmMenu.add(listMenus);

		//Create Details button
		btnDetails = new JButton("Details");
		btnDetails.setBounds(400, 575, 100, 40);
		frmMenu.add(btnDetails);

		//Details Button Logic
		btnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int index = listMenus.getSelectedIndex();
				//Check if the user has selected a menu
				if (index == -1) {
					//If no selection has been made, inform user of situation.
					JOptionPane.showMessageDialog(frmMenu, "You must first select a menu to view its details.");
				} else {
					//Pull data from the menu the user selected	menu to create a new Menu object
					Menu selectedMenu = (Menu) listMenusModel.getElementAt(index);

					//Populate frmDetails with data from selection
					frmDetails.setTitle("Menu: " + listMenus.getSelectedValue().toString());
					txtEntreeDetails.setText(selectedMenu.getEntree().getDescription());
					txtSideDetails.setText(selectedMenu.getSide().getDescription());
					txtAppetizerDetails.setText(selectedMenu.getAppetizer().getDescription());
					txtBeerDetails.setText(selectedMenu.getBeer().getDescription());
					txtTotalCalories.setText(Integer.toString(selectedMenu.totalCalories()));
					txtTotalPrice.setText(selectedMenu.totalPrice());

					//After populating all text areas with info, display complete screen to user 
					frmDetails.setVisible(true);
				} //End else condition statement
			} //End actionPerformed 
		}); //End Details button logic

		//Create Delete All Button 
		btnDeleteAll = new JButton("Delete All");
		btnDeleteAll.setBounds(525, 575, 100, 40);
		frmMenu.add(btnDeleteAll);

		//Delete All Button Logic
		btnDeleteAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				// First check if the created menus list has any menus to delete	
				if(listMenusModel.getSize() > 0) {
					//Make sure user wants to delete all menus
					int cancelConfirm = JOptionPane.showConfirmDialog(frmMenu, "Are you sure you want to delete all created menus?", "Delete All Confirm", JOptionPane.YES_NO_OPTION);
					//After positive confirmation, delete created menus
					if (cancelConfirm == JOptionPane.YES_OPTION) {
						frmDetails.setVisible(false);
						listMenusModel.removeAllElements();
					} //End if condition 
					// If there are no menus to delete, send a notification to user that deleting is unnecessary
				} else {
					JOptionPane.showMessageDialog(frmMenu, "There are no menus to delete.");
				} //End else condition to manage empty created menus list			
			} //End if conditional to check listMenus size
		}); //End btnDeleteAll logic

		//Create Save to File Button
		btnSave = new JButton("Save to File");
		btnSave.setBounds(650, 575, 100, 40);
		frmMenu.add(btnSave);

		//Save to File Button Logic
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
				// First check if the created menus list has any menus to save	
				if(listMenusModel.getSize() > 0) {
					//Make sure user wants to delete all menus
					int saveConfirm = JOptionPane.showConfirmDialog(frmMenu, "Are you sure you want to save all created menus?"
							+ "\n\n(Previousy saved menus will be overwritten.)", "Save to File Confirm", JOptionPane.YES_NO_OPTION);
					//After positive confirmation, save created menus
					if (saveConfirm == JOptionPane.YES_OPTION) {

						ArrayList<Menu> menus = new ArrayList<Menu>();
						//Build ArrayList to be saved to file
						for (int i = 0; i < listMenusModel.getSize(); i++){
							menus.add((Menu) listMenusModel.getElementAt(i));
						}
						//Write Menus to file
						try {
							FileManager.writeMenu("data/menus.txt", menus);
							JOptionPane.showMessageDialog(frmMenu, "Menu save successfull.");
						} catch (FileNotFoundException e1) {
							e1.printStackTrace();
						}
					} //End if condition 
					// If there are no menus to save, send a notification to user that saving is unnecessary
				} else {
					JOptionPane.showMessageDialog(frmMenu, "There are no menus to save to file.");
				} //End else condition to manage empty created menus list			
			} //End if conditional to check listMenus size
		}); //End Save to File Button logic

		//-----Secondary Menu Screen----
		frmDetails = new JFrame();
		frmDetails.setLayout(null);
		frmDetails.setBounds(200, 80, 680, 500);
		frmDetails.setResizable(false);
		frmDetails.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		lblEntreeDetails = new JLabel("Entree");
		lblEntreeDetails.setBounds(30,20,100,40);
		frmDetails.add(lblEntreeDetails);

		txtEntreeDetails = new JTextArea();
		txtEntreeDetails.setBounds(150, 30, 500, 60);
		txtEntreeDetails.setEditable(false);
		txtEntreeDetails.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frmDetails.add(txtEntreeDetails);

		lblSideDetails = new JLabel("Side");
		lblSideDetails.setBounds(30,100,100,40);
		frmDetails.add(lblSideDetails);

		txtSideDetails = new JTextArea();
		txtSideDetails.setBounds(150, 110, 500, 60);
		txtSideDetails.setEditable(false);
		txtSideDetails.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frmDetails.add(txtSideDetails);

		lblAppetizerDetails = new JLabel("Appetizer");
		lblAppetizerDetails.setBounds(30,180,100,40);
		frmDetails.add(lblAppetizerDetails);

		txtAppetizerDetails = new JTextArea();
		txtAppetizerDetails.setBounds(150, 190, 500, 60);
		txtAppetizerDetails.setEditable(false);
		txtAppetizerDetails.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frmDetails.add(txtAppetizerDetails);

		lblBeerDetails = new JLabel("Beer");
		lblBeerDetails.setBounds(30,260,100,40);
		frmDetails.add(lblBeerDetails);

		txtBeerDetails = new JTextArea();
		txtBeerDetails.setBounds(150, 270, 500, 60);
		txtBeerDetails.setEditable(false);
		txtBeerDetails.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frmDetails.add(txtBeerDetails);

		lblTotalCalories = new JLabel("Total Calories:");
		lblTotalCalories.setBounds(30,350,100,40);
		frmDetails.add(lblTotalCalories);

		txtTotalCalories = new JTextField();
		txtTotalCalories.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalCalories.setBounds(150,360,100,30);
		txtTotalCalories.setEditable(false);
		txtTotalCalories.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frmDetails.add(txtTotalCalories);

		lblTotalPrice = new JLabel("Total Price:");
		lblTotalPrice.setBounds(30,400,100,40);
		frmDetails.add(lblTotalPrice);

		txtTotalPrice = new JTextField();
		txtTotalPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		txtTotalPrice.setBounds(150,410,100,30);
		txtTotalPrice.setEditable(false);
		txtTotalPrice.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		frmDetails.add(txtTotalPrice);

	} // End MenuMangerGUI constructor

	public static void main(String[] args) {
		MenuManagerGUI a = new MenuManagerGUI();
		a.frmMenu.setVisible(true);
	} //End main method

} // End MenuManagerGUI class
