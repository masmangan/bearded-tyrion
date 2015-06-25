package pucrs.alpro3np.graphs;

import java.util.ArrayList;
import java.util.Comparator;

public class UndirectedGraphMatrix extends AbstractGraphMatrix implements UndirectedGraph
{
	ArrayList<Edge> edges = new ArrayList<Edge>();

	@Override
	public void addEdge(String strOrig, String strDest, double peso)
	{
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

	public ArrayList<Edge> Kruskal()
	{
		ArrayList<Edge> retVal = new ArrayList<Edge>();

		edges.sort(new Comparator<Edge>()
		{
			@Override
			public int compare(Edge o1, Edge o2)
			{
				return Double.compare(o1.getWeight(), o2.getWeight());
			}
		});

		for (Edge edge : edges)
		{
			if (!containsEdge(edge, retVal))
			{
				retVal.add(edge);
			}
		}

		return retVal;
	}

	private boolean containsEdge(Edge edge, ArrayList<Edge> edges)
	{
		for (Edge e : edges)
		{
			if (e.getOrigin() == edge.getOrigin() || e.getDestination() == edge.getOrigin() || e.getOrigin() == edge.getDestination() || e.getDestination() == edge.getDestination())
			{
				return false;
			}
		}

		return false;
	}
}
