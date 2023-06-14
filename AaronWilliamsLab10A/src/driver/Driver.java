/*******************************************************************************
* Name:	Aaron Williams
* Course:	CIS 4020.01I - Advanced Object Oriented Programming
* Semester:	Fall 2022
* Assignment:	Lab 10
* Date started:	November 3, 2022
* Date finished:	November 6, 2022
* Description:	This is an implementation of a 2-3 tree.
* Reference:	https://github.com/swapnil0399/2-3-Trees
* *******************************************************************************/

package driver;

import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import twothree.TwoThreeTree;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		Random rand = new Random();
		
		// Open the text file
		Scanner scnr = new Scanner(new File("files/data.txt"));
		// Create a new tree
		TwoThreeTree tree = new TwoThreeTree();

		// Read in the items from the text file
		while(scnr.hasNext()) {
			int value = scnr.nextInt();
			tree.insert(value);
		}
		// Print out a breadth first search 
		tree.bfsList();
		// Close the scanner
		scnr.close();
	}

}
