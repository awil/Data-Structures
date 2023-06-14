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
package bst;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import searchkeys.KeyedItem;

public class BinarySearchTree <T extends KeyedItem<KT>, KT extends Comparable<? super KT>> {
	
	// do not change the access modifiers on data members or methods
	private Node<T> root; 
	private Queue<Node<T>> q = new LinkedList<Node<T>>();
	private ArrayList<T> traversal;
	
	/*
	 * Description:	Constructor method
	 * Precondition: None
	 * Postcondition: Root set to null, traversal list created
	 */
	public BinarySearchTree() {
		root = null;
		traversal = new ArrayList<T>();
	}
	
	/*
	 * Description:	Instantiate tree with item
	 * Precondition: item passed in
	 * Postcondition: Root set to item, traversal list created
	 */
	public BinarySearchTree(T item) {
		root = new Node<T>(item);
		traversal = new ArrayList<T>();
	}
	
	/*
	 * Description:	Instantiate tree with item, left and right nodes
	 * Precondition: Item, left and right node items passed
	 * Postcondition: Root set to item, left, right set, traversal list created
	 */
	public BinarySearchTree(T item, Node<T> left, Node<T> right) {
		root = new Node<T>(item, left, right);
		traversal = new ArrayList<T>();
	}
	
	/*
	 * Description: Check if tree is empty
	 * Precondition: none
	 * Postcondition: boolean of true/false accordingly
	 */
	public boolean isEmpty() {
		return (root == null);
	}
	
	/*
	 * Description:	This method deletes the tree
	 * Precondition: none
	 * Postcondition: Root is set to null
	 */
	public void removeAll() {
		root = null;
	}
	
	/*
	 * Description:	This method peeks at the root of the tree
	 * Precondition: none
	 * Postcondition: Root item is returned
	 */
	public T peekRoot() throws BSTException {
		if(root == null) {
			throw new BSTException("BST Exception: Empty Tree");
		} else {
			return root.item;
		}
	}
	
	/*
	 * Description:	This is the public accessor method for adding an item to the tree
	 * Precondition: Item is passed in
	 * Postcondition: Tree is updated with the new item
	 */
	public void add(T item) {
		root = insert(root, item);
	}
	
	/*
	 * Description:	This inserts a node to the tree
	 * Precondition: Called from add() and item passed in
	 * Postcondition: Item is added to the tree
	 */
	private Node<T> insert(Node<T> tn, T item) {
		if(tn == null) { // position found
			tn = new Node<T>(item);// create the new node
		} else {
			Node<T> newSubtree;
			T nodeItem = tn.item;
			// search for the insertion point
			if(item.getKey().compareTo(nodeItem.getKey()) < 0) {
				// search left
//				System.out.println(item  + " " + "left");
				newSubtree = insert(tn.left, item);
				tn.left = newSubtree;
			} else {
				// search right
//				System.out.println(item  + " " + "right");
				newSubtree = insert(tn.right, item);
				tn.right = newSubtree;
			}
		}
		return tn;
	}
	
	/*
	 * Description: public accessor method for delete()	
	 * Precondition: Searchkey is passed in
	 * Postcondition: specified node is deleted from the tree
	 */
	public void remove(KT searchKey) throws BSTException {
		root = delete(root, searchKey);
	}
	
	/*
	 * Description:	This method deletes a node from a given key
	 * Precondition: Node, key passed in
	 * Postcondition: Specified node is deleted or exception is thrown
	 */
	private Node<T> delete(Node<T> tn, KT searchKey) throws BSTException {
		Node<T> newSubtree;
		
		if(tn == null) {
			throw new BSTException("BST Exception: Item Not Found");
		} else {
			T item = tn.item;
			if(searchKey.compareTo(item.getKey()) == 0) {
				tn = deleteNode(tn);
			} else if(searchKey.compareTo(item.getKey()) < 0) {
				// search left
				newSubtree = delete(tn.left, searchKey);
				tn.left = newSubtree;
			} else {
				// search right
				newSubtree = delete(tn.right, searchKey);
				tn.right = newSubtree;				
			}
		}
		return tn;
	}

	/*
	 * Description:	This method deletes a specified node
	 * Precondition: Node is passed
	 * Postcondition: The node's deleted
	 */
	private Node<T> deleteNode(Node<T> tn) {
		if(tn.left == null && tn.right == null) {
			// case 1: node is a leaf
			return null;		
		} else if (tn.left == null) {
			// case 2: no left child
			return tn.right;
		} else if (tn.right == null ) {
			// case 3: no right child
			return tn.left;		
		} else {
			// case 4: two children
			//	note: go right once before it goes left
			T replacement = inorderSuccessor(tn.right);	
			tn.item = replacement;
			tn.right = deleteInorderSuccessor(tn.right);
			return tn;
		}
	}
	
	/*
	 * Description:	This method returns the next node for replacement
	 * Precondition: Node is passed
	 * Postcondition: The left node of the item is returned
	 */
	private T inorderSuccessor(Node<T> tn) {
		if(tn.left == null) {
			return tn.item; // the replacement item
		} else {
			return inorderSuccessor(tn.left);
		}
	}
	
	/*
	 * Description:	This method deletes a node by replacing
	 *				it with the successor to the right.
	 * Precondition: Node is passed
	 * Postcondition: Node is deleted
	 */
	private Node<T> deleteInorderSuccessor(Node<T> tn) {
		if(tn.left == null) {
			return tn.right;
		} else {
			tn.left = deleteInorderSuccessor(tn.left);
			return tn;
		}
	}
	
	/*
	 * Description:	Accessor method for retrieve
	 * Precondition: Searchkey is passed
	 * Postcondition: Corresponding node is returned
	 */
	public T search(KT searchKey) {
		// retrieve method returns a node, so we need to return the item
		return retrieve(root, searchKey).item;
	}

	/*
	 * Description:	This method retrieves a node from the tree by comparing
	 * 				each key to the searchkey recursively. Once the base case has
	 * 				been reached (key == searchkey) return that node
	 * Precondition: node, searchkey provided 
	 * Postcondition: Corresponding node treturned
	 */
	private Node<T> retrieve(Node<T> tn, KT searchKey) {
		if(tn == null) {
			return null;
		} else {
			T item = tn.item;
			if(searchKey.compareTo(item.getKey()) == 0) {
				return tn;
			} else if(searchKey.compareTo(item.getKey()) < 0) {
				return retrieve(tn.left, searchKey);
			} else {
				return retrieve(tn.right, searchKey);
			}
		}
	}
	
	/*
	 * Description:	This method calls the traversals
	 * Precondition: Traversal String passed from main
	 * Postcondition: Traversal ArrayList presented depending on type
	 */
	public ArrayList<T> traversal(String type) {
		traversal.clear();
		if(type.equals("preorder")) {
			preorder(this.root);
		} else if(type.equals("inorder")) {
			inorder(this.root);
		} else if(type.equals("postorder")) {
			postorder(this.root);
		} else if(type.equals("breadthfirst")) {
			BFT();
		}
		return traversal;
	}

	/*
	 * Description:	This traverses the BT in preorder
	 * Precondition: Tree is passed
	 * Postcondition: The tree is placed in preorder to the arraylist
	 */
	private void preorder(Node<T> tn) {
		if (tn != null) {
			traversal.add(tn.item);
			preorder(tn.left);
			preorder(tn.right);
		} // end if
	} // end pre-order
	
	/*
	 * Description:	This traverses the BT inorder
	 * Precondition: Tree is passed
	 * Postcondition: The tree is placed inorder to the arraylist
	 */
	private void inorder(Node<T> tn) {
		if (tn != null) {
			inorder(tn.left);
			traversal.add(tn.item);
			inorder(tn.right);
		} // end if
	} // end in-order
	
	/*
	 * Description:	This traverses the BT in postorder
	 * Precondition: Tree is passed
	 * Postcondition: The tree is placed in postorder to the arraylist
	 */
	private void postorder(Node<T> tn) {
		if (tn != null) {
			postorder(tn.left);
			postorder(tn.right);
			traversal.add(tn.item);
		} // end if
	} // end post-order
	
	/*
	 * Description:	This is the Breadth First Tree Method that 
	 * 				scans the tree level by level
	 * Precondition: The method is called
	 * Postcondition: The tree is returned in BFT order
	 */
	private void BFT() {
		// Clear the queue
		q.clear();
		// Check for root existence
		if (root != null) {
			q.add(this.root);
		}
		// While q isn't empty, we've not gone through all nodes
		while(!q.isEmpty()) {
			Node<T> temp = q.poll(); // dequeue the q
			traversal.add(temp.item); // add to the list
			// Go through the left
			if(temp.left != null) {
				q.add(temp.left);
			}
			// Go through the right side
			if(temp.right != null) {
				q.add(temp.right);
			}
		}
	}

	/*
	 * Description:	This method returns the maximum
	 * Precondition: Main has called
	 * Postcondition: Maximum is presented
	 */
	public T maximum() {
		T max = null; // Item var
		// Call the max method
		max = max(root).item;
		return max;
	}
	
	/*
	 * Description:	This method returns the max for the maximum method
	 * Precondition: Nodes have been sent
	 * Postcondition: The maximum is offered 
	 */
	private Node<T> max(Node<T> tn) {
		Node<T> maxNode = null; // maxNode var
		// Make sure right isn't null
		if (tn.right == null) {
			maxNode = tn;
		} else { // Set the rightmost node that is max
			maxNode = max(tn.right);
		}
		// Return maxnode var
		return maxNode;
	}
	
	/*
	 * Description:	This method calls min to deliver the min
	 * Precondition: Nodes have been sent
	 * Postcondition: It's raining min 
	 */
	public T minimum() {
		T min = null;
		Node<T> temp = min(root);
		min = temp.item;
		return min;
	}

	/*
	 * Description:	This method returns the min for the minimum method
	 * Precondition: Nodes have been sent
	 * Postcondition: Minimum value node
	 */
	private Node<T> min(Node<T> tn) {
		Node<T> minNode = null; // minNode var

		// Make sure left isn't null
		if (tn.left == null) {
			minNode = tn;
		} else { // Set the leftmost node that is min
			minNode = min(tn.left);
		}
		// Return minnode var
		return minNode;
	}
	
	/*
	 * Description:	This method returns result of private treeSize method
	 * Precondition: Method was called
	 * Postcondition: Returned int value of tree size
	 */
	public int size() {
		// Call treeSize to return value
		return treeSize(root);
	}
	
	/*
	 * Description:	This method returns the total size of the tree recursively
	 * Precondition: Tree is passed in
	 * Postcondition: Returns int size
	 */
	private int treeSize(Node<T> tn) {
		// Check if root is null
		if (tn == null) {
			return 0;
		} else {
			// Recurse the tree size = 1(root) + L(leaves) + R(leaves)
			return (1 + treeSize(tn.left) + treeSize(tn.right));
		} // End if
	}
	
	/*
	 * Description:	This method calls treeLevels to return the levels
	 * Precondition: method call
	 * Postcondition: int value with tree levels.
	 */
	public int levels() {
		// Call treeLevels to return value
		return treeLevels(root);
	}
	
	/*
	 * Description:	Called by levels() to return the tree levels
	 * Precondition: Tree is passed in
	 * Postcondition: Int value of tree levels
	 */
	private int treeLevels(Node<T> tn) {
		int lLvls = 0; // Hold value for left nodes
		int rLvls = 0; // Value for right
		
		// Check if tree is empty
		if (tn == null) {
			return 0;
		}
		// If there are no children, it's just 1 (root)
		else if (tn.left == null && tn.right == null) {
			return 1;
		}
		// Travel each branch to check the longest
		else {
			// Left side
			if (tn.left != null) {
				lLvls = treeLevels(tn.left);
			}
			// Right side
			if (tn.right != null) {
				rLvls = treeLevels(tn.right);
			}
			
			// Return the greater of the two
			if (lLvls > rLvls) {
				return 1 + lLvls;
			} else {
				return 1+ rLvls;
			} // End if
		} // End if
	}
	
	/*
	 * Description:	This method returns the leafcount
	 * Precondition: Method called
	 * Postcondition: Int value of the leaves
	 */
	public int leafcount() {
		// Call leaf counter
		return lfCount(root);
	}
	
	/*
	 * Description:	This method returns the leafcount
	 * Precondition: Method called
	 * Postcondition: Int value of the leaves
	 */
	public int lfCount(Node<T> tn) {
		int count = 0; // Counter
		q.clear(); // Clear the queue
		
		// Does tree have tree? hopefully.
		if (tn != null) {
			q.add(tn); // Add the root
			
			// Cycle through to test for leaves
			while(!q.isEmpty()) {
				Node<T> temp = q.poll(); // Add current node to q
				
				// Cycle through left/right
				if(temp.left != null) {
					q.add(temp.left);
				}
				if(temp.right != null) {
					q.add(temp.right);
				}
				
				// If the node doesn't have children == leaf, count up
				if(temp.left == null && temp.right == null) {
					count++;
				}
			} // End while
			return count;
		} else {
			// Tree isn't treeing == sad face and 0
			return 0;
		}

	}
	
	/*
	 * Description:	This method finds a node matching the key
	 * 				and replaces it with the replacement
	 * Precondition: Key and Replacement passed in 
	 * Postcondition: Boolean value
	 */
	public boolean replace(KT searchKey, T replacement) {
		// Does tree have tree? hopefully.
		q.clear(); // Clear queue
		Node<T> curr = root; // Current node
		boolean replaced = false; // Replacement indicator
		
		// Start at the root of the problem
		q.add(curr);
		// Traverse tree until we've gone through them all or found
		// the node we're replacing
		while (!q.isEmpty()) {
			// The first part is going through the left side, queueing the curr for backtracking
			// once a replacement hasn't been found it returns to the curr reference to go
			// through the right side
			if (curr != null) {
				q.add(curr); // Add curr to queue
				curr = curr.left; // Investigate the left
				// Have we found the right item? if so, replace
				if (curr != null && curr.item.getKey() == searchKey) {
					curr.item = replacement;
					replaced = true;
				}
			}
			// Didn't find in the left, so now we go right
			else {
				if (!q.isEmpty()) {
					curr = q.poll(); // Dequeue curr for right traversal
					curr = curr.right;
					// Have we found the right item? if so, replace
					if (curr != null && curr.item.getKey() == searchKey) {
						curr.item = replacement;
						replaced = true;
					} // End if
				} // End if
			} // End if
		} // End while
		return replaced;
	}
	
	/*
	 * Description:	This method returns an arraylist of a given range of nodes
	 * Precondition: Low, High passed
	 * Postcondition: Return arraylist of nodes
	 */
	public ArrayList<T> range(KT low, KT high) {
		traversal.clear(); // Clear the arraylist
		range(low, high, root); // Call the ranger
		return traversal;
	}
	
	/*
	 * Description:	This method finds the nodes within the given range
	 * Precondition: Range is passed/nodes
	 * Postcondition: Return arraylist range
	 */
	private void range(KT low, KT high, Node<T> tn) {
		if (tn != null) {
			// Search left
			range(low, high, tn.left);
			// Search right
			range(low, high, tn.right);
			// Add the node to the list if it's in range
			if (tn.item.getKey().compareTo(low) >= 0 &&
					tn.item.getKey().compareTo(high) < 0) {				
					traversal.add(tn.item);
			}
		} // end if
	} // end post-order
	
	
	/*
	 * Description:	This method calls the method to remove nodes in a range
	 * Precondition: Called from driver
	 * Postcondition: Range of nodes have been deleted
	 */
	public void remove(KT low, KT high) {
		root = remove(root, low, high);
	}
	
	/*
	 * Description:	This method removes nodes within a given range
	 * Precondition: The nodes, low and high are passed
	 * Postcondition: Nodes within range -> dead
	 */
	private Node<T> remove(Node<T> tn, KT low, KT high) {
		// Return if root is null
		if (root == null) {
			return tn;
		}
		T temp = tn.item; // temp item for cleaner code
		// We want to check the left side
		if (tn.left != null)
		tn.left = remove(tn.left, low, high);
		// We want to check the right side
		if (tn.right != null)
		tn.right = remove(tn.right, low, high);
		
		// Jedi? Execute Order 66 (aka delete node in range)
		if (temp.getKey().compareTo(low) >= 0 && temp.getKey().compareTo(high) < 0) {
				return deleteNode(tn);

		} else {
			// Return node if not in range
			return tn;
		}
		
	}	
	
	/*
	 * Description:	This method deletes all of the tree nodes
	 * Precondition: none
	 * Postcondition: The tree is chopped
	 */
	public void chopping() {
		q.clear(); // Clear the queue
		// Check if tree is already empty
		if (root != null) {
			q.add(this.root);
		}
		// Cycle through nulling the nodes
		while(!q.isEmpty()) {
			Node<T> temp = q.poll();
			// Search left
			if(temp.left != null) {
				q.add(temp.left);
				temp.left = null;
			}
			// Search right
			if(temp.right != null) {
				q.add(temp.right);
				temp.right = null;
			}
			
		}
		// Delete last null, the root
		root = null;

	}

}
