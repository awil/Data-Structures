/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 9
 * Date started:	October 27, 2022
 * Date finished:	October 29, 2022
 * Description:		This program works with priority queues, min/max heaps.
 */
package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import heaps.MaxHeap;
import heaps.MinHeap;

public class Driver {
	
	/*
	 * Main method that kicks off the excitement
	 */
	public static void main(String[] args) throws IOException {
		
		// MinHeap 
	    MinHeap h = new MinHeap();
	   
	    h.insert(70);
	    h.insert(40);
	    h.insert(50);
	    h.insert(20);
	    h.insert(60);
	    h.insert(100);
	    h.insert(80);
	    h.insert(30);
	    h.insert(10);
	    h.insert(90);
	    
	    h.displayHeap();
	    h.remove(); 
	    h.displayHeap();
	    
	    // MaxHeap
	    MaxHeap mh = new MaxHeap();
		   
	    mh.insert(70);
	    mh.insert(40);
	    mh.insert(50);
	    mh.insert(20);
	    mh.insert(60);
	    mh.insert(100);
	    mh.insert(80);
	    mh.insert(30);
	    mh.insert(10);
	    mh.insert(90);
	    
	    mh.displayHeap();
	    mh.remove(); 
	    mh.displayHeap();
	    
	    // Test the MinHeap
	    minheap("heap.txt");
	    // Test the MaxHeap
	    maxheap("heap.txt");
	}
	
	/*
	 * Description:	This method instantiates the MinHeap with the provided filename
	 * Precondition: Filename param passed
	 * Postcondition: MinHeap is created wtih file contents
	 */
	public static void minheap(String filename) throws FileNotFoundException {
		MinHeap h = new MinHeap();
		File f = new File("files/" + filename);
		Scanner scnr = new Scanner(f);
		
		while(scnr.hasNext()) {
			String fnct = scnr.next();
			Integer value = null; 
			if(scnr.hasNextInt()) value = (Integer)scnr.nextInt();
			
			if (fnct.charAt(0) == 'i' ) {
				h.insert(value);
			} else if (fnct.charAt(0) == 'd') {
				h.displayHeap();
			} else if (fnct.charAt(0) == 'r') {
				h.remove();
			}
		}
		
		scnr.close();
		
	}
	
	/*
	 * Description:	This method instantiates the MaxHeap with the provided filename
	 * Precondition: Filename param passed
	 * Postcondition: MaxHeap is created wtih file contents
	 */
	public static void maxheap(String filename) throws FileNotFoundException {
		MaxHeap h = new MaxHeap();
		File f = new File("files/" + filename);
		Scanner scnr = new Scanner(f);
		
		while(scnr.hasNext()) {
			String fnct = scnr.next();
			Integer value = null; 
			if(scnr.hasNextInt()) value = (Integer)scnr.nextInt();
			
			if (fnct.charAt(0) == 'i' ) {
				h.insert(value);
			} else if (fnct.charAt(0) == 'd') {
				h.displayHeap();
			} else if (fnct.charAt(0) == 'r') {
				h.remove();
			}
		}
		
		scnr.close();		
	}
}
