/* 
 * Graph diameter problem
 *	@author: Sangeeta Kadambala, Gautam Gunda, Bhakti Khatri, Lopamudra Muduli  
 */
package cs6301.g45;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

import cs6301.g45.Graph.Vertex;

public class Sp1 {


	public static void main(String[] args) {
		System.out.println("Please enter the graph: "); // format is same as in graph class given by professor
		Scanner sc = new Scanner(System.in);
		Graph g = Graph.readGraph(sc);
		BreadthFirstSearch bfs=new BreadthFirstSearch();
		LinkedList<Vertex> path=bfs.diameter(g); // backtrace the path using the parents array of the 2nd BFS object
		Iterator it = path.descendingIterator();
		System.out.println("Path : ");
		while (it.hasNext()) {
			System.out.print(it.next().toString() + " ");
		}
	}

}
