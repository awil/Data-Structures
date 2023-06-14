/*******************************************************************************
* Name:	Aaron Williams
* Course:	CIS 4020.01I - Advanced Object Oriented Programming
* Semester:	Fall 2022
* Assignment:	Lab 10
* Date started:	November 3, 2022
* Date finished: November 6, 2022	
* Description:	This is an implementation of TreeSet and TreeMap.
* Reference:	
*******************************************************************************/
package trietree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//Java implementation of search and insert operations
//on Trie
public class Trie {
  
 // Alphabet size (# of symbols)
 static final int ALPHABET_SIZE = 26;
  
 // trie node
 static class TrieNode
 {
     TrieNode[] children = new TrieNode[ALPHABET_SIZE];
   
     // isEndOfWord is true if the node represents
     // end of a word
     boolean isEndOfWord;
      
     TrieNode(){
         isEndOfWord = false;
         for (int i = 0; i < ALPHABET_SIZE; i++)
             children[i] = null;
     }
 };
   
 static TrieNode root;
  
 // If not present, inserts key into trie
 // If the key is prefix of trie node,
 // just marks leaf node
 static void insert(String key)
 {
     int level;
     int length = key.length();
     int index;
   
     TrieNode pCrawl = root;
   
     for (level = 0; level < length; level++)
     {
         index = key.charAt(level) - 'a';
         if (pCrawl.children[index] == null)
             pCrawl.children[index] = new TrieNode();
   
         pCrawl = pCrawl.children[index];
     }
   
     // mark last node as leaf
     pCrawl.isEndOfWord = true;
 }
   
 // Returns true if key presents in trie, else false
 static boolean search(String key)
 {
     int level;
     int length = key.length();
     int index;
     TrieNode pCrawl = root;
   
     for (level = 0; level < length; level++)
     {
         index = key.charAt(level) - 'a';
   
         if (pCrawl.children[index] == null)
             return false;
   
         pCrawl = pCrawl.children[index];
     }
   
     return (pCrawl.isEndOfWord);
 }
 
 static void display(TrieNode root) {
	 if (root.children.length > 0) {
		 for (int i = 0; i < root.children.length; i++)
			 System.out.println(root.children[i]);
	 }
 }
   
 // Driver
	public static void main(String[] args) throws FileNotFoundException {
		// Open the text file
		Scanner scnr = new Scanner(new File("files/names.txt"));
		
     // Input keys (use only 'a' through 'z' and lower case)
     String keys[] = new String[106];
   
	 int index = 0;
	 
	 // Read in the items from the text file
	 while(scnr.hasNext()) {
		String value = scnr.next();
		keys[index] = value;
		index++;
	 }
	 scnr.close();
     
     String output[] = {"Not present in trie", "Present in trie"};

     root = new TrieNode();
   
     // Construct trie
     int i;
     for (i = 0; i < keys.length ; i++)
         insert(keys[i]);
     
     display(root);
   
     // Search for different keys
     if(search("mario") == true)
         System.out.println("mario --- " + output[1]);
     else System.out.println("mario --- " + output[0]);
      
     if(search("lucas") == true)
         System.out.println("lucas --- " + output[1]);
     else System.out.println("lucas --- " + output[0]);
      
     if(search("john") == true)
         System.out.println("john --- " + output[1]);
     else System.out.println("john --- " + output[0]);
      
     if(search("brett") == true)
         System.out.println("brett --- " + output[1]);
     else System.out.println("brett --- " + output[0]);
     
 }
}
//This code is contributed by Sumit Ghosh