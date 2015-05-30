package pucrs.alpro3np.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class AbstractGraphMatrix {

	protected boolean[][] matrix;
	protected List<String> names;

	public AbstractGraphMatrix() {
		matrix = new boolean[5][5];
		names = new ArrayList<String>();
	}

	public abstract void addEdge(String strOrig, String strDest);

	public void addVertice(String vertice) {
		// TODO ampliar matriz caso necessário
	
		if (vertice == null)
			throw new IllegalArgumentException("O nodo não pode ter nome null. ");
	
		if (vertice.trim().isEmpty())
			throw new IllegalArgumentException("O nodo não pode ter nome em branco. ");
	
		if (names.contains(vertice))
			throw new IllegalArgumentException("O nodo já está cadastrado: " + vertice);
		
		names.add(vertice);
	}

	
	public int getDegree(String vertice) {
		return getAllAdjacents(vertice).size();
	}

	public ArrayList<String> getAllAdjacents(String vertice) {
		ArrayList<String> resposta = new ArrayList<String>(); 
		int pos = names.indexOf(vertice);
		for (int i = 0; i < matrix.length; i++) {
			if (matrix[pos][i] == true) {
				resposta.add(names.get(i));
			}
		}
		return resposta;
	}

	public String toString() {
		String r = "";
		r += names.toString();
		for (int i = 0; i < matrix.length; i++) {
			r+= "\n" + Arrays.toString(matrix[i]);
		}
		return r;
	}

}