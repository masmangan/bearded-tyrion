package pucrs.alpro3np.graphs;

import java.util.ArrayList;
import java.util.Comparator;

public class UndirectedGraphMatrix extends AbstractGraphMatrix implements
		UndirectedGraph {

	private ArrayList<Edge> edges = new ArrayList<Edge>();

	@Override
	public void addEdge(String strOrig, String strDest, int peso) {
		int posOrig = names.indexOf(strOrig);
		int posDest = names.indexOf(strDest);
		matrix[posOrig][posDest] = peso;
		matrix[posDest][posOrig] = peso;

		Edge e = new Edge();
		e.setOrigin(strOrig);
		e.setDestination(strDest);
		e.setWeight(peso);
		edges.add(e);
	}

	@Override
	//@Author Kern
	public ArrayList<Edge> Kruskal() {

		ArrayList<Edge> retVal = new ArrayList<Edge>();

		edges.sort(new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Double.compare(o1.getWeight(), o2.getWeight());
			}
		});
		
		for (Edge edge : edges) {
			if (!isCiclical(edge, retVal)) {
				retVal.add(edge);
			}
		}

		return retVal;
	}

	private ArrayList<Edge> visited = new ArrayList<Edge>();

	private boolean isCiclical(Edge edge, ArrayList<Edge> retVal) {
		String verticeToFind = edge.getOrigin();
		String destination = edge.getDestination();
		
		visited.clear();
		
		return isCiclical(verticeToFind, destination, retVal);
	}
	
	private boolean isCiclical(String verticeToFind, String destination, ArrayList<Edge> retVal) {
		for (Edge edge : retVal) {
			if (visited.contains(edge)) {
				continue;
			}
			
			if (edge.contains(verticeToFind)) {				
				if (edge.contains(destination)) {
					return true;
				}
				else {					
					visited.add(edge);
					String other = (edge.getOrigin() == verticeToFind ? edge.getDestination() : edge.getOrigin());
					return isCiclical(other, destination, retVal);
				}				
			}
		}
		
		return false;
	}

}
