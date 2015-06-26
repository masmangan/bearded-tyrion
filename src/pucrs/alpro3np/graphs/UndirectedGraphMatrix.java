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
	
	@Override
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
			if (!isCiclical(edge, retVal))
			{
				retVal.add(edge);
			}
		}

		return retVal;
	}

	ArrayList<Edge> visited = new ArrayList<Edge>();
	
	private boolean isCiclical(Edge edge, ArrayList<Edge> verify)
	{
		String verticeToFind = edge.getOrigin();
		String destination = edge.getDestination();
		
		visited.clear();
		
		return isCiclical(verticeToFind, destination, verify);
	}

	private boolean isCiclical(String verticeToFind, String destination, ArrayList<Edge> verify)
	{
		for (int i = 0; i < verify.size(); i++)
		{
			Edge e = verify.get(i);
			
			if (visited.contains(e))
			{
				continue;
			}
			
			if (e.contains(verticeToFind))
			{
				if (e.contains(destination))
				{
					return true;
				}
				else
				{					
					visited.add(e);
					if (isCiclical((e.getOrigin() == verticeToFind ? e.getDestination() : e.getOrigin()), destination, verify))
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
}
