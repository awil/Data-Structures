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

public class Edge {

	private Integer v;	// v and w are the vertices of the edge.
	private Integer w;	
	private int cost;	// The cost of the edge.

	/*
	 * Description:	Constructor method. Creates the edge v-w with cost
	 * Precondition: none
	 * Postcondition: edge created
	 */
	public Edge(Integer first, Integer second, int edgeCost) {
		v = first;
		w = second;
		cost = edgeCost;
	}

	/*
	 * Description:	returns edge cost
	 * Precondition: None.
	 * Postcondition: return cost
	 */
	public int getCost() {
		return cost;
	}

	/*
	 * Description:	returns vertex v
	 * Precondition: 
	 * Postcondition: return v
	 */
	public Integer getV() {
		return v;
	}

	/*
	 * Description:	returns vertex w
	 * Precondition: 
	 * Postcondition: return w
	 */
	public Integer getW() {
		return w;
	}
}
