package pucrs.alpro3np.graphs;

public class DirectedGraphMatrixTestApp
{
	public static void main(String[] args)
	{
		DirectedGraph g = new DirectedGraphMatrix();
		System.out.println(g);
		g.addVertice("POA");
		System.out.println(g);
		g.addVertice("CWB");
		System.out.println(g);
		g.addVertice("SDU");
		System.out.println(g);
		g.addEdge("POA", "CWB");
		System.out.println(g);
		g.addEdge("POA", "SDU");
		System.out.println(g);
		System.out.println(g.getSources());
		System.out.println(g.getSinks());

		System.out.println(g.traversalWidth("POA"));
		System.out.println(g.traversalWidth("CWB"));

		System.out.println(g.traversalDepth("POA"));
		System.out.println(g.traversalDepth("CWB"));
	}
}
