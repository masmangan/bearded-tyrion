package pucrs.alpro3np.graphs;

import java.util.ArrayList;
import java.util.List;

public class UndirectedGraphMatrix implements UndirectedGraph {

	private boolean[][] matrix;
	private List<String> names;
	
	public UndirectedGraphMatrix() {
		// TODO inicializar matrix e names
	}
	
	@Override
	public void addVertice(String vertice) {
		// TODO armazenar o vertice em names, se ainda não existir
	}

	@Override
	public void addEdge(String strOrig, String strDest) {
		// TODO obter posicao do strOrig
		// TODO obter posicao do strDest
		// TODO matrix[pos(strOrig)][pos(strDest)] = true;
		// TODO matrix[pos(strDest)][pos(strOrig)] = true;
	}

	@Override
	public int getDegree(String vertice) {
		return getAllAdjacents(vertice).size();
	}

	@Override
	public ArrayList<String> getAllAdjacents(String vertice) {
		ArrayList<String> resposta = new ArrayList<String>(); 
		// TODO obter posicao do vertice
		// TODO verificar quantas saidas tem o vertice, na matrix
		// TODO para cada saida, armazenar o nome do vertice na resposta
		// TODO retornar a resposta
		return resposta;
	}
	
	@Override
	public String toString() {
		return names.toString() + matrix.toString();
	}

}
