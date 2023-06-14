/*******************************************************************************
* Name:	Aaron Williams
* Course:	CIS 4020.01I - Advanced Object Oriented Programming
* Semester:	Fall 2022
* Assignment:	Lab 10
* Date started:	November 3, 2022
* Date finished:	November 6, 2022
* Description:	This is an implementation of TreeSet and TreeMap.
* Reference:	
*******************************************************************************/

package treeset;

import java.io.*;
import java.util.*;

public class Driver {

	public static void main(String[] args) throws FileNotFoundException {
		// Open the text file
		Scanner scnr = new Scanner(new File("files/data.txt"));
		// Create a new tree
		TreeSet<Integer> tset = new TreeSet<>();
		TreeMap<Integer, Integer> tmap = new TreeMap<>();

		// Read in the items from the text file
		while(scnr.hasNext()) {
			int value = scnr.nextInt();
			tset.add(value);
		}
		scnr.close();
		
		scnr = new Scanner(new File("files/data2.txt"));
		
		while(scnr.hasNext()) {
			int value = scnr.nextInt();
			tmap.put(value, value+5);
		}
		scnr.close();
		
		System.out.println("TreeSet: ");
		System.out.println(tset);
		System.out.println("TreeMap: ");
		System.out.println(tmap + "\n");
		
		tset.remove(23);
		tset.remove(55);
		tset.remove(15);
		
		tmap.remove(55);
		tmap.remove(34);
		tmap.remove(89);
		
		System.out.println("TreeSet: ");
		System.out.println(tset);
		System.out.println("TreeMap: ");
		System.out.println(tmap);
		// Close the scanner
	}

}
