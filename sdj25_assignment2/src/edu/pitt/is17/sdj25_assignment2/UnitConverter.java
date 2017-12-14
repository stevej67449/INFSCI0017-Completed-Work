package edu.pitt.is17.sdj25_assignment2;

import javax.swing.JOptionPane;

public class UnitConverter {
	
	public static void main(String[] args) {
		
	// Constants for Conversion Factors
	final double CENTIMETERS_TO_INCHES = 0.393701;
	final double INCHES_TO_CENTIMETERS = 2.54;
	final double YARDS_TO_METERS = 0.9144;
	final double METERS_TO_YARDS = 1.09361;
	final double OUNCES_TO_GRAMS = 28.3495;
	final double GRAMS_TO_OUNCES = 0.035274;
	final double POUNDS_TO_KILOGRAMS = 0.453592;
	final double KILOGRAMS_TO_POUNDS = 2.20462;	
	
	// Declare a variable for converted number
	double convertedOutput;	
	
	// Launch dialog box to capture user number and unit	
	String userInput = JOptionPane.showInputDialog("Please enter a distance or weight to be converted. \nRemember to seperate the amount from the unit with a space. \n(Example: 8.3 gm, 10 oz, 11 in, etc)");
		
	// Find space (" ") character in userInput
	// and divide the input into separate unit and number variables
	int positionOfSpace = userInput.indexOf(" ");		
	String num = userInput.substring(0, positionOfSpace);	
	String inputUnit = userInput.substring(positionOfSpace + 1);
	
	// Parse the user's number from string into a double
	double inputNum = Double.parseDouble(num);

	// Compare the input unit and finds the appropriates conversion unit
	// Once conversion is complete, print the user's input with converted value
	if (inputUnit.equalsIgnoreCase("cm")){
		convertedOutput = inputNum * CENTIMETERS_TO_INCHES;
		System.out.println(userInput + " = " + convertedOutput + " in");
	} else if (inputUnit.equalsIgnoreCase("in")){
		convertedOutput = inputNum * INCHES_TO_CENTIMETERS;
		System.out.println(userInput + " = " + convertedOutput + " cm");
	} else if (inputUnit.equalsIgnoreCase("yd")){
		convertedOutput = inputNum * YARDS_TO_METERS;
		System.out.println(userInput + " = " + convertedOutput + " m");
	} else if (inputUnit.equalsIgnoreCase("m")) {
		convertedOutput = inputNum * METERS_TO_YARDS;
		System.out.println(userInput + " = " + convertedOutput + " yd");
	} else if (inputUnit.equalsIgnoreCase("oz")){
		convertedOutput = inputNum * OUNCES_TO_GRAMS;
		System.out.println(userInput + " = " + convertedOutput + " gm");
	} else if (inputUnit.equalsIgnoreCase("gm")){
		convertedOutput = inputNum * GRAMS_TO_OUNCES;
		System.out.println(userInput + " = " + convertedOutput + " oz");
	} else if (inputUnit.equalsIgnoreCase("lb")){
		convertedOutput = inputNum * POUNDS_TO_KILOGRAMS;
		System.out.println(userInput + " = " + convertedOutput + " kg");
	} else if (inputUnit.equalsIgnoreCase("lb")){
		convertedOutput = inputNum * KILOGRAMS_TO_POUNDS;
		System.out.println(userInput + " = " + convertedOutput + " lb");
	} else {
		System.out.println("Unit not recognized, cannot be converted.\nPlease retry using one of the following units:\nin, cm, oz, gm, kg, lb, yr, or m.");
	} // end of all if/else if/else statements
	

	}
}
