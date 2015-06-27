package pucrs.alpro3np.graphs;

import java.util.ArrayList;

public class UndirectedGraphMatrixTestApp {

	public static void main(String[] args) {
		UndirectedGraph  g = new UndirectedGraphMatrix();
		g.addVertice("A");
		g.addVertice("B");
		g.addVertice("C");
		g.addVertice("D");

		g.addEdge("A", "B", 5);
		g.addEdge("A", "C", 4);
		g.addEdge("B", "D", 8);
		g.addEdge("C", "D", 3);
		g.addEdge("A", "D", 1);
		g.addEdge("B", "C", 4);
		
		System.out.println(g);
		
		ArrayList<Edge> kruskal = g.Kruskal();
		System.out.println(kruskal);
		System.out.println(soma(kruskal));
		
//		System.out.println(g.traversalWidth("POA"));
//		System.out.println(g.traversalWidth("CWB"));		
//
//		System.out.println(g.traversalDepth("POA"));
//		System.out.println(g.traversalDepth("CWB"));		
	}
	
	private static int soma(ArrayList<Edge> kruskal)
	{
		int retVal = 0;
		
		for (Edge edge : kruskal) {
			retVal += edge.getWeight();
		}
		
		return retVal;
	}

}
