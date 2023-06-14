/*
 * Name:			Aaron Williams
 * Course:			CIS 4020.01I - Advanced Object Oriented Programming
 * Semester:		Fall 2022
 * Assignment:		Lab 12
 * Date started:	November 13, 2022
 * Date finished:	November 26, 2022
 * Description:		This program works with undirected graphs and performs depth
 * 					 first searches on vertices and edges.
 */
package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Vector;
import java.util.Map.Entry;

public class Graph {

	private int numVertices; // Num verts in the graph
	private int numEdges; // Num edges in graph
	private int pathCost; // Cost var for edge cost totaling
	private ArrayList<Integer> visited; // ArrayList to hold visited vertices
	private Vector<TreeMap<Integer, Integer>> adjacencyList; // Adjacent vertices, costs
	
	// For each vertex, we need to keep track of the edges,
	// so for each edge, we need to store the second vertex and
	// the edge cost. This can be done as a <key, value> pair,
	// with the second vertex as the key, accessible as
	// adjList.get(v)., and the cost as the value. The TreeMap
	// data structure is used to store a list these (key, value)
	// pairs for each vertex
	public Graph(int n) {
		numVertices = n;
		numEdges = 0;
		adjacencyList = new Vector<TreeMap<Integer, Integer>>();
		for (int i = 0; i < numVertices; i++) {
			adjacencyList.add(new TreeMap<Integer, Integer>());
		}
		pathCost = 0;
		visited = new ArrayList<Integer>();
	}
	
	/*
	 * Description:	Depth First Search by Vertex
	 * Precondition: Vertex exists
	 * Postcondition: Outputs path vertices and total cost
	 */
	public void DFS_by_Vertex(int v) {
		System.out.print("DFS: ");
		visited.clear(); // Clear visited so we have fresh start
		pathCost = 0; // Clear pathCost so it's empty
		DFS_Vertex(v);
		System.out.print(" Cost: " + pathCost + "\n");
	}
	
	/*
	 * Description:	Depth First Search by Vertex
	 * Precondition: Vertex exists
	 * Postcondition: Outputs path vertices and total cost
	 */
	private void DFS_Vertex(int v) {	
		// v is the current vertex being visited
		System.out.print(v + " ");
		// Example of extracting the adjacency list
		// first get the adjacency list for a vertex as a treemap
		// this example will use vertex 1 as an example
		TreeMap<Integer,Integer> vertices = adjacencyList.elementAt(v);
//		System.out.println(vertices);	// displaying the set
		// convert it to a set for the iterator process
		Set<?> theset = vertices.entrySet();
		
		// set up an iterator for it
		Iterator<?> it = theset.iterator();
		// iterate through it
		while(it.hasNext()) {
			// grab it as an entry
			@SuppressWarnings("unchecked")
			Map.Entry<Integer, Integer> mentry = (Entry<Integer, Integer>) it.next();
			// pull off the w vertex (note that we know what v is)
			int w = (int) mentry.getKey();
			// pull off the cost
			int cost = (int) mentry.getValue();
			// Add vertex to visited so we don't revisit
			visited.add(v);
			// Visit the next unvisited vertex
			if(!visited.contains(w)) {
				DFS_Vertex(w);
				// Add cost to pathCost total
				pathCost = pathCost + cost;
			}
			
			// output w and cost. Note v is known because of above
//			System.out.print("v: " + v + " w: "+ w + " cost: " + cost);
//			System.out.println();
		}	
	}

	/*
	 * Description:	Depth First Search by Edge
	 * Precondition: Vertex exists
	 * Postcondition: Outputs path edge vertices and total cost
	 */
	public void DFS_by_Edge(int v) {
		System.out.print("DFS: ");
		pathCost = 0; // Clear pathCost so it's empty
		visited.clear(); // Clear visited so we have fresh start
		DFS_Edge(v); 
		System.out.println("Cost: " + pathCost);
	}

	/*
	 * Description:	Depth First Search by Edge
	 * Precondition: Vertex exists
	 * Postcondition: Outputs path edge vertices and total cost
	 */
	@SuppressWarnings("unchecked")
	private void DFS_Edge(int v) {	
		// v is the current vertex being visited
		System.out.print(v + " ");
		// Example of extracting the adjacency list
		// first get the adjacency list for a vertex as a treemap
		// this example will use vertex 1 as an example
		TreeMap<Integer,Integer> vertices = adjacencyList.elementAt(v);
//		System.out.println(vertices + "\n");	// displaying the set
		
		// convert it to a set for the iterator process
		Set<?> theset = vertices.entrySet();
		// set up an iterator for it
		Iterator<?> it = theset.iterator();

		// iterate through it
		while(it.hasNext()) {
			// grab it as an entry
			@SuppressWarnings("unchecked")
			Map.Entry<Integer, Integer> mentryOne = (Entry<Integer, Integer>) it.next();
			// pull off the w vertex (note that we what v is)
			int w = (int) mentryOne.getKey();
			// pull off the cost
			int cost = (int) mentryOne.getValue();

			// Create second temporary mentry to compare the two
			Map.Entry<Integer,Integer> mentryTwo;
			int w2 = 0;
			int cost2 = 0;
			
			// Add v to visited
			visited.add(v);
			// If it.hasNext() we want to store those in the temp variable
			if(it.hasNext()) {
				mentryTwo = (Entry<Integer, Integer>) it.next();
				w2 = (int) mentryTwo.getKey();
				cost2 = (int) mentryTwo.getValue();
			}
			
			// If cost2 is 0, means there wasn't a trailing vertex
			if (cost2 == 0) {
				if(!visited.contains(w)) {
					DFS_Edge(w);
					// Add cost to pathCost total
					pathCost = pathCost + cost;
				}
			} else if (cost < cost2) { // if cost of w1 is less, visit first
				if(!visited.contains(w)) {
					DFS_Edge(w);
					// Add cost to pathCost total
					pathCost = pathCost + cost;
				} // Visit w2 second
				if(!visited.contains(w2)) {
					DFS_Edge(w2);
					// Add cost to pathCost total
					pathCost = pathCost + cost2;
				}
			} else { // Cost2 was less, visit first
				if(!visited.contains(w2)) {
					DFS_Edge(w2);
					// Add cost to pathCost total
					pathCost = pathCost + cost2;
				} // Visit cost second
				if(!visited.contains(w)) {
					DFS_Edge(w);
					// Add cost to pathCost total
					pathCost = pathCost + cost;
				}
			}
			// output w and cost. Note v is known because of above
//			System.out.print("v: " + v + " w: "+ w + " cost: " + cost);
//			System.out.println();
		}		
	}
	
	/*
	 * Description:	figures out number of vertices
	 * Precondition: none
	 * Postcondition: returns num of vertices
	 */
	public int getNumVertices() {
		return numVertices;
	}

	/*
	 * Description:	figures out number of edges in graph
	 * Precondition: none
	 * Postcondition: returns number of edges in graph
	 */
	public int getNumEdges() {
		return numEdges;
	}

	/*
	 * Description:	figures out the cost of edge between v, w
	 * Precondition: edge exists in graph
	 * Postcondition: return the cost
	 */
	public int getEdgeCost(Integer v, Integer w) {
		return adjacencyList.get(v).get(w);
	}
	
	/*
	 * Description:	adds edge to graph with the assigned weight
	 * Precondition: vertices contained in edge exist in graph
	 * Postcondition: edge is added to the graph
	 */
	public void addEdge(Integer v, Integer w, int wgt) {
		// Add the edge to both v's and w's adjacency list
		adjacencyList.get(v).put(w, wgt);
		adjacencyList.get(w).put(v, wgt);
		numEdges++;
	}

	/*
	 * Description:	add an edge to the graph
	 * Precondition: vertices in the edge exist in graph
	 * Postcondition: 
	 */
	public void addEdge(Edge e) {
		// Extract the vertices and cost from the edge e
		Integer v = e.getV();
		Integer w = e.getW();
		int cost = e.getCost();
		addEdge(v, w, cost);
	}

	/*
	 * Description:	Remove edge from graph
	 * Precondition: vertices in the edge exist in graph
	 * Postcondition: edge is deleted
	 */
	public void removeEdge(Edge e) {
		// Extract the vertices from the edge e
		Integer v = e.getV();
		Integer w = e.getW();

		// Remove the edge from v's and w's adjacency list
		adjacencyList.get(v).remove(w);
		adjacencyList.get(w).remove(v);
		numEdges--;
	}

	/*
	 * Description:	find edge between v, w
	 * Precondition: edge exists
	 * Postcondition: return edge cost
	 */
	public Edge findEdge(Integer v, Integer w) {
		int wgt = adjacencyList.get(v).get(w);
		return new Edge(v, w, wgt);
	}

	/*
	 * Description:	Return list for vertex v
	 * Precondition: Vertex exists
	 * Postcondition: Return adjacency list
	 */
	TreeMap<Integer,Integer> getAdjList(Integer v) {
		return adjacencyList.get(v);
	}

}