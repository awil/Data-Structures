/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 8
 * Date started:	October 16, 2022
 * Date finished:	October 22, 2022
 * Description:		This program deals with Binary Search Trees and their
 * 					manipulations.
 */
package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import bst.BinarySearchTree;

// Drives the program
public class Driver {

	/*
	 * Main method that calls the shots
	 */
	public static void main(String args[]) throws FileNotFoundException {
		// Open the text file
		Scanner scnr = new Scanner(new File("files/tree.txt"));
		// Create a new tree
		BinarySearchTree<Item, Integer> tree = new BinarySearchTree<Item, Integer>();

		// Read in the items from the text file
		while(scnr.hasNext()) {
			Integer value = scnr.nextInt();
			String fname = scnr.next();
			String lname = scnr.next();
			Item item = new Item(value, fname, lname);
			System.out.print(item);
			tree.add(item);
		}
		// Close the scanner
		scnr.close();
	
		System.out.println("");
		// Display the tree in preorder format
		ArrayList<Item> traversal = tree.traversal("preorder");
		System.out.println(traversal);
		// Display the tree inorder format
		traversal = tree.traversal("inorder");
		System.out.println(traversal);
		// Display the tree in postorder format
		traversal = tree.traversal("postorder");
		System.out.println(traversal);
		// Display the tree in breadthfirst format
		traversal = tree.traversal("breadthfirst");
		System.out.println(traversal);
		
		// Displays the maximum tree node
		System.out.println(tree.maximum());
		// Displays the minimum tree node
		System.out.println(tree.minimum());
		// Displays the size of the tree
		System.out.println(tree.size());
		// Displays the levels of the tree
		System.out.println(tree.levels());
		// Displays the leaf count
		System.out.println(tree.leafcount());
		// Create replacement item
		Item replacement = new Item(98, "Darth", "Maul");
		// Replace item 95 with Darth Maul
		System.out.println(tree.replace(95, replacement));
		// Display tree inorder
		traversal = tree.traversal("inorder");
		System.out.println(traversal);
		// Display nodes within given range
		traversal = tree.range(2, 26);
		System.out.println(traversal);
		// Remove nodes within given range
		tree.remove(13, 79);
		// Display updated tree
		traversal = tree.traversal("inorder");
		System.out.println(traversal);
		// Chop the tree down
		tree.chopping();


	}	
	
}
