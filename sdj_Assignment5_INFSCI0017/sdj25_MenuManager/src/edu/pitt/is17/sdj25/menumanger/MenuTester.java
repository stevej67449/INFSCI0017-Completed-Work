package edu.pitt.is17.sdj25.menumanger;

/**
 * Class: MenuTest
 * Author: Steve Johnston
 * Created: 3/16/2017
 */

public class MenuTester{
	public static void main(String[] args) {
		MenuRandomize randomize = new MenuRandomize("data/appetizers.txt","data/entrees.txt","data/sides.txt","data/beers.txt");
		Menu myMenu = randomize.randomMenu();
		System.out.println(myMenu.description()+"\nTotal calories "+
							myMenu.totalCalories());
	}
}
