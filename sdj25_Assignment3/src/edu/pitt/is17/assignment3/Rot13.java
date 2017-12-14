package edu.pitt.is17.assignment3;

import javax.swing.JOptionPane;

public class Rot13 {

	public static void main(String[] args) {
		
		// Declaring main variable for program
		String userInput;
		
		// Used to set how many characters per line in display
		int characterLimit = 50;
		
		
		// Prompts user for input and begins program
		do {
			// Ask User to enter text to be encoded		
			userInput = JOptionPane.showInputDialog("Please enter text to be encoded.\n(Type 'Q' or 'q' to quit.)");
				
			//Call rot13 to encoded user's text
			String encodedText = rot13(userInput);
			
			//Call breakLines method to format text.
			String brokenEncodedText = breakLines(characterLimit,encodedText);
		
			//Display encoded message back to user or an exit message
			if (!userInput.equalsIgnoreCase("q")) {
				JOptionPane.showMessageDialog(null,"Your encoded message is:" +"\n" + brokenEncodedText);
			} else {
				JOptionPane.showMessageDialog(null,"Thank you for using this program.\nHave a great day!");
			}
		} while (!userInput.equalsIgnoreCase("q"));
		
	}  // End of Main Method

	// Rot13 Method
	public static String rot13(String input) {
		//Constant for conducting Rot13 operations and declared value to be returned at conclusion of method
		final int ENCODE_KEY = 13;
		String encodedString = "";
		
		// Reassigns char values based on original position and case
	    for (int i = 0; i < input.length(); i++) {
	    	char target = input.charAt(i);
	   
	    	if (target >= 'a' && target <= 'm'){
	    		target += ENCODE_KEY;
	    		encodedString += target;
	    	} else if (target >= 'A' && target <= 'M') {
	    		target += ENCODE_KEY;
	    		encodedString += target;
	    	} else if (target >= 'n' && target <= 'z') {
	    		target -= ENCODE_KEY;
	    		encodedString += target;
	    	} else if (target >= 'N' && target <= 'Z') {
	    		target -= ENCODE_KEY;
	    		encodedString += target;
	    	} else {
	    		encodedString += target;
	    	} //End of Conditionals	
	    } // End of for loop
	    
	    return encodedString;
	} // End of Rot13 Method;

	
	// Break Lines Method
	public static String breakLines(int maxLength, String text){
		
		// String variable to be assigned and returned to main method and counter for appropriate 
		// number of breaks in input based preset character limit
		String brokenString = "";
		int breakNumber = text.length() / maxLength;
		
		//Iterates through input and adds new lines at maxLength position
		for (int i = 0; i <= breakNumber ; i++){
			if (text.length() > maxLength) {
				brokenString += text.substring(0, maxLength) + "\n";
				text = text.substring(maxLength);
			} else {
				brokenString += text.substring(0);
			} //End of conditionals
		} //End of for loop
		return brokenString;
    } //End of Break Lines Method
	
}
