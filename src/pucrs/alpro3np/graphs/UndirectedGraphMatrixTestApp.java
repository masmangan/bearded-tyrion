package pucrs.alpro3np.graphs;

import java.util.ArrayList;

public class UndirectedGraphMatrixTestApp
{
	public static void main(String[] args)
	{
		UndirectedGraph g = new UndirectedGraphMatrix();
		g.addVertice("A");
		g.addVertice("B");
		g.addVertice("C");
		g.addVertice("D");
		g.addVertice("E");
		g.addVertice("F");
		g.addVertice("G");
		g.addVertice("H");
		g.addVertice("I");
		
		g.addEdge("A", "B", 4);
		g.addEdge("A", "H", 8);
		g.addEdge("B", "H", 11);
		g.addEdge("B", "C", 8);
		g.addEdge("C", "I", 2);
		g.addEdge("C", "D", 7);
		g.addEdge("C", "F", 4);
		g.addEdge("D", "E", 9);
		g.addEdge("D", "F", 14);
		g.addEdge("E", "F", 10);
		g.addEdge("F", "G", 2);
		g.addEdge("G", "H", 1);
		g.addEdge("G", "I", 6);
		g.addEdge("H", "I", 7);
		
		System.out.println(g);
		
		ArrayList<Edge> kruskal = g.Kruskal();
		
		System.out.println(kruskal);
		System.out.println(somaKruskal(kruskal));
	}

	private static double somaKruskal(ArrayList<Edge> kruskal)
	{
		double retVal = 0;
		
		for (Edge edge : kruskal)
		{
			retVal += edge.getWeight();
		}
		
		return retVal;
	}
}
