package pucrs.alpro3np.graphs;

import java.util.ArrayList;

public interface AbstractGraph {
	void addVertice(String vertice);
	void addEdge(String strOrig, String strDest, int peso);
	void addEdge(String strOrig, String strDest);
	
	int getDegree(String vertice);
	ArrayList<String> getAllAdjacents(String vertice);
	
	public ArrayList<String> traversalWidth(String vertice);
	public ArrayList<String> traversalDepth(String vertice);
	
	ArrayList<String> Path(String orig, String dest);
	
	int countNodesReachable(String v);
	
	ArrayList<String> getTwoLevelsAhead(String v);
	public int[][] assp();
	public int[] sssp(String v);
 	
}
