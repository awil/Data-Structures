/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 11
 * Date started:	November 7, 2022
 * Date finished:	November 11, 2022
 * Description:		This program implements hash tables for three hash
 * 					functions: modulo, folding, and knuth. In addition,
 * 					It uses collision resolution techniques like linear probing,
 * 					quadratic probing, cubic probing and separate chaining.
 */
package driver;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import hashtable.HashTable;

public class Driver {

	/*
	 * Main method that drives the program
	 */
	public static void main(String args[]) throws IOException {
		File inFile = new File("files/integers.txt"); // Data File
		Scanner input = new Scanner(inFile); // Scanner for reading in
	
		int tablesize = 950; // Size of the table
		int hash = 3;	// Hash function to use
		int collision = 4;	// Collision Resolution to use
		int count = 0; // iterator for items
		// Create hash table
		HashTable theTable = new HashTable(tablesize, hash, collision);
		// For the items not stored
		System.out.print("Not stored  :");
		// While the file still has integers, continue reading in
		while(input.hasNext()) {
			// If count is less than the table, continue
			if (count < tablesize-1) {
				theTable.h(input.nextInt());
				count++;
			} else { // If not, don't store it
				System.out.print(" " + input.nextInt());
			}
		}
		input.close();	// Close the scanner
		
		// Output the file with tableDump
		String filename = "files/H" + hash + "_CR" + collision + "_T" + tablesize + ".txt";
		theTable.tableDump(filename);
		theTable.measures();
	}
}
