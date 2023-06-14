/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 3B
 * Date started:	September 4, 2022
 * Date finished:	September 4, 2022
 * Description:		This program uses recursion and backtracking to place N queens
 * 					on a board of size NxN. It reverses Lab 3A and processes row-by-row.
 */

package queens;

import java.util.Arrays;

// NQueens class works through possible solutions for placing N queens on the board
public class NQueens {
	
	public int size; // Size of the board
	private final char EMPTY = '_'; // Empty square piece
	private final char QUEEN = 'Q'; // Queen piece
	private char board[][]; // chess board
  
	/*
	 * Description:		Constructor method, instantiates NQueens & creates board
	 * Precondition:	Size is entered
	 * Postcondition:	A board is created of size NxN 
	 */
	public NQueens(int size) {
		this.size = size;
		board = new char[this.size][this.size];
		clear();
	}

	/*
	 * Description:		This method clears the board
	 * Precondition:	None
	 * Postcondition:	Board is filled with empty squares 
	 */
	private void clear() {
		// Loop through the board and fill squares with empty spaces
		for(int i = 0; i < board.length; i++) {
			for(int j = 0; j < board.length; j++) {
				board[i][j] = EMPTY;
			}
		}
	}

	/*
	 * Description:		Displays the board, row by row
	 * Precondition:	None
	 * Postcondition:	Board is displayed in console
	 */
	public void display() {
		System.out.println("");
		for(char[] row : board) {
			System.out.println(Arrays.toString(row));
		}
	}

	/*
	 * Description:		Method to place queens 
	 * Precondition:	Number of row entered
	 * Postcondition:	A solution is determined and the board has N queens placed.
	 */
	public boolean place(int row) {
		
		// If the row number is greater tan the size, problem is solved
		if (row >= board.length) {
			return true;
		} 
		// Begin trying to place the queens, if the queens are all 
		// placed, return placeQueen
		else {
			boolean placeQueen = false;	// boolean for whether queen was placed
			int column = 0; // Start at the first column, index 0
			
			// While the problem isn't solved, and there are spaces keep going
			while (!placeQueen && (column < board.length)) {
				// Determine if the current square is under attack, if it is
				// proceed to the next row.
				if (isUnderAttack(row, column)) {
					++column;
				}
				// Find the next available spot that can hold a queen
				else {
					// Place a queen there
					set(row, column);
					// Start at the next row and place a queen
					placeQueen = place(row+1);
					if (!placeQueen) {
						// Backtrack when there isn't a viable option
						// for placing the queen
						remove(row, column);
						++column;
					} // End if
				} // End if
			} // End while

			// return the status
			return placeQueen;
		} // End if
	}
	
	/*
	 * Description:		This sets the spot (row,column) with a queen
	 * Precondition:	row, column
	 * Postcondition:	Queen is set
	 */
	private void set(int row, int column) {
		// Set the spot to the QUEEN char
		board[row][column] = QUEEN;
	}

	/*
	 * Description:		This removes the queen from spot (row,column)
	 * Precondition:	row, column
	 * Postcondition:	Queen is removed from the board
	 */
	private void remove(int row, int column) {
		// Set the spot to the EMPTY char
		board[row][column] = EMPTY;
	}

	/*
	 * Description:		This method tests to see if the spot can be attacked
	 * 					from the northwest, southwest, and the row/column
	 * Precondition:	row, column
	 * Postcondition:	Queen is set
	 */
	private boolean isUnderAttack(int row, int column) {
		
		// Loop through the array to see if there is a queen on the row & column
        for (int i = 0; i < size; i++) {
            if (board[row][i] == QUEEN || board[i][column] == QUEEN) {
            	// Queen exists, return true
                return true;
            }
        }
 
        // Loop through the array to see if there is a queen on NW axis
        for (int i = row, j = column; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == QUEEN) {
            	// Queen exists, return true
                return true;
            }        		
        }
 
        // Loop through to see if there's a queen on SW axis
        for (int i = row, j = column; j >= 0 && i < board.length; i++, j--) {
            if (board[i][j] == QUEEN) {
            	// Queen exists, return true
                return true;
            }
        }
        // No queens were found, return false
		return false;
	}

}
