/*******************************************************************************
* Name:	Aaron Williams
* Course:	CIS 4020.01I - Advanced Object Oriented Programming
* Semester:	Fall 2022
* Assignment:	Lab 10
* Date started:	November 3, 2022
* Date finished:	November 6, 2022
* Description:	This is an implementation of a 2-3-4 tree.
* Reference:	https://cs.smu.ca/~porter/csc/341/code/examples/zyBookJava/BTrees/Tree234Demo.java
*******************************************************************************/

package driver;

import twothreefour.Tree234;

import java.io.*;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) throws FileNotFoundException    {
    	 	
		// Open the text file
		Scanner scnr = new Scanner(new File("files/data.txt"));
		// Create a new 234 tree
        Tree234 tree = new Tree234();

		// Read in the items from the text file
		while(scnr.hasNext()) {
			int value = scnr.nextInt();
			tree.insert(value);
		}
		
		System.out.println("The tree height is: " + tree.getHeight());
		System.out.println("The tree lenght is: " + tree.length());
		System.out.println("Here is a printout of the tree: " + tree.toString());
		
		// Close the scanner
		scnr.close();




    }
}
