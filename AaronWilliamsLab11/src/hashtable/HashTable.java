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
package hashtable;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class HashTable {
	
	private int table[];				// array the hash table
	private ArrayList<Integer> chains[];// separate chaining table
	private int count;					// current number of items in table
	private int hashFunction;			// which hash to use (1, 2, or 3)
	private int collisionResolution;	// which collision resolution to use (1, 2, or 3)
	private int tablesize;				// table size
	
	/*
	 * Description:	This is the constructor method for the hash table
	 * Precondition: tablesize, hashfunction, collisionresolutiontechnique passed in
	 * Postcondition: table is created
	 */
	@SuppressWarnings("unchecked")
	public HashTable(int tablesize, int hashfunction, int collisionResolutionTechnique) {
		this.count = 0;										// initialize item count
		this.hashFunction = hashfunction;						// hash to use
		this.tablesize = tablesize;								// set the table size
		this.collisionResolution = collisionResolutionTechnique;// collision resolution to use
		if(this.collisionResolution == 4) {						// table type depends on collision resolution
			chains = new ArrayList[tablesize];					// create an array for array lists
		} else {
			table = new int[tablesize];							// create an array 
		} // End if
	}
	
	/*
	 * Description:	This method uses the global variables to determine which hash
	 * 				function to use and which collision resolution function to use.
	 * Precondition: int x, hashFunction, and collisionResolution passed in
	 * Postcondition: Table is filled with input values.
	 */
	public void h(int x) {
		int hx = 0;
		
		// selects which hash to use depending on what
		switch(hashFunction) {
			case 1:
				hx = h_modulo(x);
				break;
			case 2:
				hx = h_folding(x);
				break;
			case 3:
				hx = h_Knuth(x);
				break;
			default:
				break;
		} // End switch
		// selects which collision resolution
		switch(collisionResolution) {
			case 1:
				linearProbing(hx, x);
				break;
			case 2:
				quadraticProbing(hx, x);
				break;
			case 3:
				cubicProbing(hx, x);
				break;
			case 4:
				separateChaining(hx, x);
				break;
			default:
				break;
		} // End switch
	}
	
	/*
	 * Description:	Hashing function that uses the simple modulo arithmetic technique 
	 * Precondition: int x is passed in
	 * Postcondition: return h(x)
	 */
	private int h_modulo(int x) {
		int hx = 0;
		// h(x) = mod(x, tablesize)
		hx = x % tablesize;
		return hx;
	}

	/*
	 * Description:	Hashing function that use group folding 
	 * Precondition: int x is passed in
	 * Postcondition: return h(x)
	 */
	private int h_folding(int x) {
		int hx = 0;	
		int x2 = 0;
		
		// String to hold the x value to format for separating
        String tx = "" + x;

        // If the length is an odd value, we want to
        // add a leading zero to make it even
        if ((tx.length() % 2) != 0) {
            tx = "0" + tx;
        } // End if
        
        // Create a temp array to hold the separate values
        int txgrp[] = new int[(tx.length()+1) / 2];
        
        // For each value, add them to the temp array
        for (int i = 0; i < tx.length(); i++) {
            txgrp[i/2] = Integer.parseInt(tx.substring(i, i+2));
            i++;
        } // End for loop
        
        // For each item, add to the total
        for (int j = 0; j < txgrp.length; j++) {
            x2 = x2 + txgrp[j];
        } // End for loop
 
        // Calculate the modulus
        hx = x2 % tablesize;

        return hx;
	}
	
	/*
	 * Description:	Hashing function that uses the Knuth Variant  
	 * Precondition: int x is passed in
	 * Postcondition: return h(x)
	 */
	private int h_Knuth(int x) {
		int hx = 0;	
		// Knuth Function h(x) = x(x+3) % tablesize
		hx = (x * (x+3)) % tablesize;
		return hx;
	}
	
	/*
	 * Description:	Collision resolution technique using linear probing.
	 * Precondition: int h(x) passed in and the value of x
	 * Postcondition: value x added to the table at the correct spot
	 */
	private void linearProbing(int hx, int x) {
		int tmpHX = hx;

		// Check hx is negative
		if (tmpHX < 0) {
			tmpHX = Math.abs(tmpHX);
		}
		
		// Check to see if the table value is empty or not
		if (table[tmpHX] != 0) {
			// Reset hx if it's greater than tablesize
			if(tmpHX > tablesize-1) {
				tmpHX = 0;
			} 
			// While the table doesn't have an empty spot, increment
			while(table[tmpHX] != 0) {
				if(tmpHX >= tablesize-1) {
					tmpHX = 0;
				} // End if
				tmpHX++;
			} // End while loop
			// Set hx to x value
			table[tmpHX] = x;
			// Increment the count
			count++;
		} else {
			// Table spot was empty, set it to x
			table[tmpHX] = x;
			// Increment the count
			count++;
		} // End if
	}

	/*
	 * Description:	Collision resolution technique using quadratic probing for collisions.
	 * Precondition: int h(x) passed in and the value of x
	 * Postcondition: value x added to the table at the correct spot
	 */
	private void quadraticProbing(int hx, int x) {
		int tmpHX = hx;

		// Check hx is negative
		if (tmpHX < 0) {
			tmpHX = Math.abs(tmpHX);
		}
		
		// Check to see if the table value is empty or not	
		if (table[tmpHX] != 0) {
			// Reset hx if it's greater than tablesize
			if(tmpHX > tablesize-1) {
				tmpHX = 0;
			} // End if
			int i = 0; // Value for i
			// While the table doesn't have an empty spot, increment
			while(table[tmpHX] != 0) {
					// Calculate quad prob for hx
					tmpHX = Math.abs((tmpHX + (i * i)) % tablesize);
					i++;
			} // End while
			// Set hx to x value
			table[tmpHX] = x;
			// Increment the count
			count++;
		} else {
			// Table spot was empty, set it to x
			table[tmpHX] = x;
			// Increment the count
			count++;
		} // End if
	}
	
	/*
	 * Description:	Collision resolution technique cubic probing to solve collisions.
	 * Precondition: int h(x) passed in and the value of x
	 * Postcondition: value x added to the table at the correct spot
	 */
	private void cubicProbing(int hx, int x) {
		int tmpHX = hx;

		// Check hx is negative
		if (tmpHX < 0) {
			tmpHX = Math.abs(tmpHX);
		}
		
		// Check to see if the table value is empty or not		
		if (table[tmpHX] != 0) {
			// Reset hx if it's greater than tablesize
			if(tmpHX > tablesize-1) {
				tmpHX = 0;
			} // End if
			int i = 0; // Value for i
			// While the table doesn't have an empty spot, increment
			while(table[tmpHX] != 0) {
				// Calculate cubic prob for hx
					tmpHX = (tmpHX + (i * i * i)) % tablesize;
					// Absolute value of modulus
					if(tmpHX < 0) {
						tmpHX = tmpHX * -1;
					} // End if
					i++;
			}
			// Set hx to x value
			table[tmpHX] = x;
			// Increment the count
			count++;
		} else {
			// Table spot was empty, set it to x
			table[tmpHX] = x;
			// Increment the count
			count++;
		} // End if
	}	
	
	/*
	 * Description:	Collision resolution technique using separate chaining using arraylists.
	 * Precondition: int h(x) passed in and the value of x
	 * Postcondition: value x added to the table at the correct spot
	 */
	private void separateChaining(int hx, int x) {
		int tmpHX = hx;
		
		// Check hx is negative
		if (tmpHX < 0) {
			tmpHX = Math.abs(tmpHX);
		}
		
		// if the chains[hx] is not null, add to the end of array list
		if (chains[tmpHX] != null) {
			chains[tmpHX].add(x); // Set hx to x value
			// Increment the count
			count++;
		} else {
			// We need to initiailze arraylist to add x
			chains[tmpHX] = new ArrayList<Integer>();
			// Add x to the next spot of the arraylist
			chains[tmpHX].add(x); // Set hx to x value
			// Increment the count
			count++;
		} // End if
	}
	
	/*
	 * Description:	This method outputs the efficiency calculations for each of the
	 * 				hashing functions and collision resolutions.
	 * Precondition: The table is filled, correct hash functions and table stats filled.
	 * Postcondition: "Diagnostics" output to the console
	 */
	public void measures() {
		double successful = 0;
		double unsuccessful = 0;
		
		System.out.print("Hash        : ");
		switch(hashFunction) {
			case 1:
				System.out.println("Simple Modulo");
				break;
			case 2:
				System.out.println("Multiply Digits");
				break;
			case 3:
				System.out.println("Multiply Groups");
				break;
			default:
				break;
		} // End Switch
		
		System.out.print("Collisions  : ");
		switch(collisionResolution) {
			case 1:
				System.out.println("Linear Probing");
				successful = linearSuccessful();
				unsuccessful = linearUnsuccessful();
				break;
			case 2:
				System.out.println("Quadratic Probing");
				successful = quadraticSuccessful();
				unsuccessful = quadraticUnsuccessful();
				break;
			case 3:
				System.out.println("Cubic Probing");
				successful = -1;
				unsuccessful = -1;
				break;
			case 4:
				successful = separateChainingSuccessful();
				unsuccessful = separateChainingUnsuccessful();
				System.out.println("Seperate Chaining");
				break;
			default:
				break;
		} // End Switch
		System.out.println("Table Size  : " + tablesize);
		System.out.println("Item Count  : " + count);
		System.out.printf("Load Factor : %.4f\n", loadFactor());
		System.out.printf("Successful  : %.4f\n", successful);
		System.out.printf("Unsuccessful: %.4f\n", unsuccessful);
	}
	
	/*
	 * Description:	This is the load factor aka alpha calculator
	 * Precondition: None
	 * Postcondition: alpha is returned (# table items/tablesize)
	 */
	private double loadFactor() {
		return (double) count/ (double) tablesize;
	}
	
	/*
	 * Description:	Calculates the efficiency of a successful search
	 * 				using linear probing
	 * Precondition: None
	 * Postcondition: efficiency value is returned.
	 */
	private double linearSuccessful() {
		double a = loadFactor();
		return 0.5 * (1.0 + (1.0 / (1.0 - a)));
	}	
	
	/*
	 * Description:	Calculates the efficiency of an unsuccessful search
	 * 				using linear probing
	 * Precondition: None
	 * Postcondition: efficiency value is returned.
	 */
	private double linearUnsuccessful() {
		double a = loadFactor();
		double b = (1.0 - a) * (1.0 - a);
		return 0.5 * (1.0 + (1.0 / b));
	}	

	/*
	 * Description:	Calculates the efficiency of a successful search
	 * 				using quadratic probing
	 * Precondition: None
	 * Postcondition: efficiency value is returned.
	 */
	private double quadraticSuccessful() {
		double a = loadFactor();
		return (-1.0 * Math.log(1.0 - a)) / a;
	}	

	/*
	 * Description:	Calculates the efficiency of an unsuccessful search
	 * 				using quadratic probing
	 * Precondition: None
	 * Postcondition: efficiency value is returned.
	 */
	private double quadraticUnsuccessful() {
		double a = loadFactor();
		return 1.0 / (1.0 - a);
	}	

	/*
	 * Description:	Calculate the efficiency of a successful search
	 * 				using separate chaining
	 * Precondition: None
	 * Postcondition: efficiency value is returned.
	 */
	private double separateChainingSuccessful() {
		double a = loadFactor();
		return 1.0 + (a / 2.0);
	}	

	/*
	 * Description:	Calculates the efficiency of an unsuccessful
	 * 				search using separate chaining
	 * Precondition: None
	 * Postcondition: efficiency value is returned.
	 */
	private double separateChainingUnsuccessful() {
		return loadFactor();
	}	
	
	/*
	 * Description:	This method dumps the table to a txt file, nicely formatted
	 * Precondition: The table exists/has data
	 * Postcondition: Txt file is output with the table data.
	 */
	public void tableDump(String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		PrintWriter pw = new PrintWriter(fw);
		
		// Change output technique to accommodate the arraylists
		if(collisionResolution == 4) {
			for(int i = 0; i < chains.length; i++) {
				pw.printf("%5d ", i);
				if(chains[i] == null) {
					pw.println("");
				} else {
					pw.println(Arrays.toString(chains[i].toArray()));
				} // End if
			} // End for loop	
		} else {
			for(int i = 0; i < table.length; i++) {
				pw.printf("%5d ", i);
				if(table[i] == 0) {
					pw.println("");
				} else {
					pw.println(table[i]);
				} // End if 
			} // End for loop
		} // End if
		pw.close();
		fw.close();
	}
}
