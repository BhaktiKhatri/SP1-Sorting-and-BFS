/* 
 * Graph diameter problem
 *	@author: Sangeeta Kadambala, Gautam Gunda, Bhakti Khatri, Lopamudra Muduli  
 */
package cs6301.g45;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

import cs6301.g45.Graph.Edge;
import cs6301.g45.Graph.Vertex;

public class BreadthFirstSearch {

	HashMap<Vertex, Vertex> parents;

	public LinkedList<Vertex> diameter(Graph g) { // print the path in reverse order from the end
		BreadthFirstSearch bfsTraversal1 = new BreadthFirstSearch();
		BreadthFirstSearch bfsTraversal2 = new BreadthFirstSearch();
		Vertex arbitraryOp = bfsTraversal1.BFS(g,g.getVertex(1));// call the first BFS with the arbitrary node
		Vertex endPoint = bfsTraversal2.BFS(g,arbitraryOp); // call the 2nd BFS with the output of the 1st BFS
		return bfsTraversal2.backtrace(arbitraryOp, endPoint);
		
	}

	public Vertex BFS(Graph g, Vertex sv) {
		this.parents = new HashMap<Vertex, Vertex>();
		LinkedList<Graph.Vertex> travQueue = new LinkedList<Graph.Vertex>();
		boolean[] visited = new boolean[g.size()]; // array to store if vertex is visited or not
		visited[sv.name] = true;
		travQueue.add(sv);// add the first vertex to the queue
		Vertex v = new Vertex(-1);
		while (!travQueue.isEmpty()) { // loop till queue is empty
			v = travQueue.remove();
			Iterator<Edge> edges = v.adj.iterator();
			while (edges.hasNext()) { // loop through all edges for every vertex in the queue
				Edge next = edges.next();
				Vertex temp = next.otherEnd(v); // get the other end of the current vertex and edge
				if ((visited[temp.name] == false)) { // if it is visited, do not do anything
					travQueue.add(temp); // put the vertex in the queue and set visited for the node to true
					visited[temp.name] = true;
					parents.put(temp, v); // store the node's parent in the parents array
				}	
			}
		}
		return v; // return the last vertex 
	}

	public LinkedList backtrace(Vertex start, Vertex end) {
		LinkedList<Vertex> path = new LinkedList<Vertex>();
		Vertex temp = end;
		while (temp != start) { // start the loop to fetch the parent starting from one node - the end node
			path.add(temp);
			temp = parents.get(temp);
		}
		path.add(start); // add the starting node to the path
		return path;
	}

}
