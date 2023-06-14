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
package driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import graph.Graph;

public class Driver {

	/*
	 * Description:	Driver method
	 * Precondition: None
	 * Postcondition: Outputs DFS_Vertex and DFS_Edge
	 */
	static public void main(String[] args) throws FileNotFoundException {
		File graphfile = new File("files/graph2.txt");
		Scanner graphIn = new Scanner(graphfile);
		ArrayList<Integer> vertexList = new ArrayList<Integer>();
		
		Graph g = new Graph(graphIn.nextInt());
		while(graphIn.hasNext()) {
			int v = graphIn.nextInt();
			int w = graphIn.nextInt();
			if(!vertexList.contains(v)) {
				vertexList.add(v);
			}
			if(!vertexList.contains(w)) {
				vertexList.add(w);
			}
			int cost = graphIn.nextInt();
//			System.out.println(v + " " + w + " " + cost);
			g.addEdge(v, w, cost);
		}
		graphIn.close();
		
//		g.DFS_by_Vertex(0);
		
		System.out.println("Vertices: " + g.getNumVertices());
		System.out.println("Edges: "+ g.getNumEdges());
		System.out.println("By vertex value:");
		for(int i = 0; i < vertexList.size(); i++) {
			g.DFS_by_Vertex(vertexList.get(i));
		}
		System.out.println("By edge weight:");
		for(int i = 0; i < vertexList.size(); i++) {
			g.DFS_by_Edge(vertexList.get(i));
		}
	}
}
