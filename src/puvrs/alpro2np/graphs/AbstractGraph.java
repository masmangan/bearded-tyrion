package puvrs.alpro2np.graphs;

import java.util.ArrayList;

public interface AbstractGraph {
	void addVertice(String vertice);
	void addEdge(String strOrig, String strDest);
	int getDegree(String vertice);
	ArrayList<String> getAllAdjacents(String vertice);
}
