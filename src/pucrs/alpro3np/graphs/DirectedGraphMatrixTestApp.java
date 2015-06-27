package pucrs.alpro3np.graphs;

import java.util.Arrays;

public class DirectedGraphMatrixTestApp {

	public static void main(String[] args) {
		UndirectedGraph  g = new UndirectedGraphMatrix();
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
		//System.out.println(g.getSources());
		//System.out.println(g.getSinks());
		
		System.out.println(g.traversalWidth("POA"));
		System.out.println(g.traversalWidth("CWB"));
		
		System.out.println(g.traversalDepth("POA"));
		System.out.println(g.traversalDepth("CWB"));			
		
		System.out.println("Floyd");
	     int [][] r = g.assp();
		for (int i = 0; i < r.length; i++) {
			for (int j = 0; j < r.length; j++) {
				if(r[i][j]> 10)
					System.out.print("* ");
				else
				System.out.print(r[i][j]+ " ");
			}
			System.out.println("");
		}
		
		System.out.println("SSSP");
		System.out.println(Arrays.toString(g.sssp("POA")));
		System.out.println(Arrays.toString(g.sssp("CWB")));
		System.out.println(Arrays.toString(g.sssp("SDU")));
		
	}

}
