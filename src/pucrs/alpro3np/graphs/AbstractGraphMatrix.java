package pucrs.alpro3np.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public abstract class AbstractGraphMatrix
{
	protected int[][] matrix;
	protected List<String> names;

	public AbstractGraphMatrix()
	{
		matrix = new int[7][7];
		names = new ArrayList<String>();
	}

	public void addEdge(String strOrig, String strDest)
	{
		addEdge(strOrig, strDest, 1);
	}

	public abstract void addEdge(String strOrig, String strDest, int peso);

	public void addVertice(String vertice)
	{
		// TODO ampliar matriz caso necess�rio

		if (vertice == null)
			throw new IllegalArgumentException("O nodo n�o pode ter nome null. ");

		if (vertice.trim().isEmpty())
			throw new IllegalArgumentException("O nodo n�o pode ter nome em branco. ");

		if (names.contains(vertice))
			throw new IllegalArgumentException("O nodo j� est� cadastrado: " + vertice);

		names.add(vertice);
	}

	public int getDegree(String vertice)
	{
		return getAllAdjacents(vertice).size();
	}

	public ArrayList<String> getAllAdjacents(String vertice)
	{
		ArrayList<String> resposta = new ArrayList<String>();
		int pos = names.indexOf(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		for (int i = 0; i < matrix.length; i++)
		{
			if (matrix[pos][i] != 0)
			{
				resposta.add(names.get(i));
			}
		}
		return resposta;
	}

	public String toString()
	{
		String r = "";
		r += names.toString();
		for (int i = 0; i < matrix.length; i++)
		{
			r += "\n" + Arrays.toString(matrix[i]);
		}
		return r;
	}

	public ArrayList<String> traversalWidth(String vertice)
	{
		// 1. Visite um nodo arbitr�rio
		ArrayList<String> resposta = new ArrayList<String>();
		int pos = names.indexOf(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		resposta.add(names.get(pos)); // resposta.add(vertice);
		// 2. Marque o nodo e coloque-o em uma fila Q
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(pos);
		// 3. Enquanto a fila Q n�o estiver vazia
		while (!queue.isEmpty())
		{
			// 4. Retire um elemento N de Q
			int current = queue.remove();
			// 5. Para cada nodo M (n�o marcado) adjacente a N
			ArrayList<String> adjs = getAllAdjacents(names.get(current));
			for (String a : adjs)
			{
				// n�o marcado
				if (!resposta.contains(a))
				{
					// 6. Visite M
					resposta.add(a);
					// 7. Coloque M na fila Q
					queue.add(names.indexOf(a));
					// 8. Marque M
				}
			}
		}
		return resposta;
	}

	public ArrayList<String> traversalDepth(String vertice)
	{

		// 1. Visite um nodo arbitrário
		ArrayList<String> resposta = new ArrayList<String>();
		int pos = names.indexOf(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		resposta.add(names.get(pos)); // resposta.add(vertice);
		// 2. Marque o nodo e coloque -o em uma pilha S
		Stack<Integer> pilha = new Stack<>();
		pilha.push(pos);
		// 3. Enquanto a pilha S não estiver vazia
		while (!pilha.isEmpty())
		{
			// 4. Retire um elemento N de S
			int current = pilha.pop();
			// 5. Para cada nodo M ( não marcado ) adjacente a N
			ArrayList<String> adjs = getAllAdjacents(names.get(current));
			for (String a : adjs)
			{
				// 6. Visite M
				if (!resposta.contains(a))
				{
					resposta.add(a);
					// 7. Coloque N na pilha S
					pilha.push(current);
					// 8. Marque M

					// 9. Faça N = M
					pilha.push(names.indexOf(a));
					break;
				}
			}

		}
		return resposta;
	}

	private boolean marked[];

	public ArrayList<String> Path(String orig, String dest)
	{
		int posOrig = names.indexOf(orig);
		int posDest = names.indexOf(dest);
		// TODO: verificar se os nodos existem
		ArrayList<String> r = new ArrayList<>();

		marked = new boolean[names.size()];

		Path(posOrig, posDest, r);
		Collections.reverse(r);
		return r;
	}

	private void Path(int posOrig, int posDest, ArrayList<String> r)
	{
		marked[posOrig] = true;
		if (posOrig == posDest)
		{
			r.add(names.get(posDest));
		}
		else
		{
			for (int i = 0; i < names.size(); i++)
			{
				if (matrix[posOrig][i] != 0 && !marked[i])
				{
					Path(i, posDest, r);
					if (!r.isEmpty())
					{
						r.add(names.get(posOrig));
						break;
					}
				}
			}
		}

	}

	public int countNodesReachable(String v)
	{
		return traversalDepth(v).size();
	}

	public ArrayList<String> getTwoLevelsAhead(String v)
	{
		// TODO:
		return null;
	}

	public int[] sssp(String v)
	{
		// Dijkstra
		return null;
	}

	public int[][] assp()
	{
		// Floyd-Warshall
		return null;
	}
}
