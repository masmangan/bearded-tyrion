package pucrs.alpro3np.graphs;

public class UndirectedGraphMatrixTestApp
{
	public static void main(String[] args)
	{
		UndirectedGraph g = new UndirectedGraphMatrix();
		g.addVertice("POA");
		g.addVertice("CWB");
		g.addVertice("SDU");
		g.addVertice("FLP");
		g.addVertice("GRU");
		g.addVertice("BHA");

		g.addEdge("POA", "FLP");
		g.addEdge("POA", "CWB");
		g.addEdge("CWB", "SDU");
		g.addEdge("CWB", "GRU");
		g.addEdge("GRU", "BHA");

		System.out.println(g);

		System.out.println(g.traversalWidth("POA"));
		System.out.println(g.traversalWidth("CWB"));

		System.out.println(g.traversalDepth("POA"));
		System.out.println(g.traversalDepth("CWB"));
	}
}
