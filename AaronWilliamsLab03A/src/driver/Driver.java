/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 3A
 * Date started:	August 29, 2022
 * Date finished:	September 4, 2022
 * Description:		This program uses recursion and backtracking to place N queens
 * 					on a board of size NxN.
 */

package driver;

import java.util.Scanner;

import queens.NQueens;

// Driver class drives the program and prompts the user to enter N queens
public class Driver {
	
	/*
	 * Description:		Main method starts the program, prompts user for input
	 * Precondition:	None
	 * Postcondition:	A solution is determined and displayed 
	 */
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in); // Scanner for input
		System.out.print("Enter a board size: ");
		int size = scnr.nextInt(); // Get user input
		
		// Create a new NQueens object
		NQueens nqueens = new NQueens(size);	
		// Begin placing the queens
		nqueens.place(0);
		// Display the solution
		nqueens.display();
		
		// Close the scanner
		scnr.close();
	}

}
