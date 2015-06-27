package pucrs.alpro3np.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public abstract class AbstractGraphMatrix {

	protected int[][] matrix;
	protected List<String> names;

	public AbstractGraphMatrix() {
		matrix = new int[7][7];
		names = new ArrayList<String>();
	}

	public void addEdge(String strOrig, String strDest) {
		addEdge(strOrig, strDest, 1);
	}

	public abstract void addEdge(String strOrig, String strDest, int peso);

	public void addVertice(String vertice) {
		// TODO ampliar matriz caso necess�rio

		if (vertice == null)
			throw new IllegalArgumentException(
					"O nodo n�o pode ter nome null. ");

		if (vertice.trim().isEmpty())
			throw new IllegalArgumentException(
					"O nodo n�o pode ter nome em branco. ");

		if (names.contains(vertice))
			throw new IllegalArgumentException(
					"O nodo j� est� cadastrado: " + vertice);

		names.add(vertice);
	}

	public int getDegree(String vertice) {
		return getAllAdjacents(vertice).size();
	}

	public ArrayList<String> getAllAdjacents(String vertice) {
		ArrayList<String> resposta = new ArrayList<String>();
		int pos = names.indexOf(vertice);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + vertice);
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[pos][i] != 0) {
				resposta.add(names.get(i));
			}
		}
		return resposta;
	}

	public String toString() {
		String r = "";
		r += names.toString();
		for (int i = 0; i < matrix.length; i++) {
			r += "\n" + Arrays.toString(matrix[i]);
		}
		return r;
	}

	public ArrayList<String> traversalWidth(String vertice) {
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
		while (!queue.isEmpty()) {
			// 4. Retire um elemento N de Q
			int current = queue.remove();
			// 5. Para cada nodo M (n�o marcado) adjacente a N
			ArrayList<String> adjs = getAllAdjacents(names.get(current));
			for (String a : adjs) {
				// n�o marcado
				if (!resposta.contains(a)) {
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

	public ArrayList<String> traversalDepth(String vertice) {

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
		while (!pilha.isEmpty()) {
			// 4. Retire um elemento N de S
			int current = pilha.pop();
			// 5. Para cada nodo M ( não marcado ) adjacente a N
			ArrayList<String> adjs = getAllAdjacents(names.get(current));
			for (String a : adjs) {
				// 6. Visite M
				if (!resposta.contains(a)) {
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

	public ArrayList<String> Path(String orig, String dest) {
		int posOrig = names.indexOf(orig);
		int posDest = names.indexOf(dest);
		// TODO: verificar se os nodos existem
		ArrayList<String> r = new ArrayList<>();

		marked = new boolean[names.size()];

		Path(posOrig, posDest, r);
		Collections.reverse(r);
		return r;
	}

	private void Path(int posOrig, int posDest, ArrayList<String> r) {
		marked[posOrig] = true;
		if (posOrig == posDest) {
			r.add(names.get(posDest));
		} else {
			for (int i = 0; i < names.size(); i++) {
				if (matrix[posOrig][i] != 0 && !marked[i]) {
					Path(i, posDest, r);
					if (!r.isEmpty()) {
						r.add(names.get(posOrig));
						break;
					}
				}
			}
		}

	}

	public int countNodesReachable(String v) {
		return traversalDepth(v).size();
	}

	public ArrayList<String> getTwoLevelsAhead(String v) {
		ArrayList<String> resposta = new ArrayList<String>();
		int pos = names.indexOf(v);
		if (pos == -1)
			throw new IllegalArgumentException("Vertice invalido: " + v);

		// Level 0
		resposta.add(v);

		// Level 1
		ArrayList<String> adjs = getAllAdjacents(names.get(pos));
		for (String a : adjs)
			if (!resposta.contains(a))
				resposta.add(a);

		// Level 2
		for (String a : adjs) {
			ArrayList<String> adjs2 = getAllAdjacents(a);
			for (String a2 : adjs2)
				if (!resposta.contains(a2))
					resposta.add(a2);
		}
		return resposta;
	}

	/**
	 * 
	 * @param v
	 * @return
	 * @author Arthur Wermann
	 */
	public int[] sssp(String v) {
		// Dijkstra
		// @author Arthur
		int[] result = new int[names.size()];
		int pos = names.indexOf(v);
		ArrayList<String> q = new ArrayList<>(names);
		for (int x = 0; x < result.length; x++)
			result[x] = Integer.MAX_VALUE / 4;
		result[pos] = 0;
		
		while (!q.isEmpty()) {
			int u = remove(q, result);
			for (String x : getAllAdjacents(names.get(u))) {
				if (q.contains(x)) {
					if (result[u] + matrix[u][names.indexOf(x)] < result[names.indexOf(x)])
						result[names.indexOf(x)] = result[u] + matrix[u][names.indexOf(x)];
				}
			}
			
		}
		
		return result;
	}

	private int remove(ArrayList<String> q, int[] result) {
		// FIXME
//		int e = names.indexOf(q.get(0));
//		for (String v : q) {
//			if (result[names.indexOf(v)] < result[e])
//			e = result[names.indexOf(v)];
//		}
//		for (int i = 1; i < q.size(); i++) {
//			if (result[i] < result[e])
//				e = i;
//		}
//		q.remove(names.get(e));
//		return e;
		return 0;
	}

	public int[][] assp() {
		// Floyd-Warshall
		// TODO
		// @autor Jairo Santos
		int[][] distancia = new int[names.size()][names.size()];

		// busca o peso das aresta
		for (int x = 0; x < distancia.length; x++) {
			for (int y = 0; y < distancia.length; y++) {
				if (matrix[x][y] == 0 && x != y)
					distancia[x][y] = Integer.MAX_VALUE / 4;
				else
					distancia[x][y] = matrix[x][y];

			}
		}

		for (int k = 0; k < distancia.length; k++) {
			for (int i = 0; i < distancia.length; i++) {
				for (int j = 0; j < distancia.length; j++) {
					if (distancia[i][k] + distancia[k][j] < distancia[i][j]) {
						distancia[i][j] = distancia[i][k] + distancia[k][j];
					}

				}

			}

		}

		return distancia;
	}

	public void prim() {
		// TODO
	}

	public void fordFulkerson() {
		// TODO
	}

}
