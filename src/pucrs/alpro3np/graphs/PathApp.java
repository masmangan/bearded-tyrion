package pucrs.alpro3np.graphs;

public class PathApp
{
	public static void main(String[] args)
	{
		UndirectedGraph g = new UndirectedGraphMatrix();

		for (int i = 1; i <= 7; i++)
		{
			g.addVertice("N" + i);
		}

		g.addEdge("N1", "N2", 10);
		g.addEdge("N1", "N4", 9);
		g.addEdge("N2", "N3", 7);
		g.addEdge("N3", "N4", 15);

		g.addEdge("N4", "N5", 5);
		g.addEdge("N4", "N7", 3);
		g.addEdge("N5", "N6", 4);
		g.addEdge("N6", "N7", 2);

		System.out.println(g);

		System.out.println(g.traversalWidth("N1"));
		// System.out.println(g.traversalWidth("CWB"));
		//
		System.out.println(g.traversalDepth("N1"));
		// System.out.println(g.traversalDepth("CWB"));

		System.out.println(g.Path("N1", "N7"));
	}
}
