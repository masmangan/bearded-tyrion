package pucrs.alpro3np.graphs;

import java.util.ArrayList;

public class DirectedGraphMatrix
	extends AbstractGraphMatrix
	implements DirectedGraph
{

	@Override
	public ArrayList<String> getSources()
	{
		ArrayList<String> resposta = new ArrayList<String>();

		for (int i = 0; i < names.size(); i++)
		{
			int entradas = getGrauEntrada(i);
			if (entradas > 0)
				continue;
			int saidas = getGrauSaida(i);
			if (saidas > 0)
				resposta.add(names.get(i));
		}
		return resposta;
	}

	private int getGrauSaida(int i)
	{
		int saidas = 0;
		for (int j = 0; j < names.size(); j++)
			if (matrix[i][j] != 0)
				saidas++;
		return saidas;
	}

	private int getGrauEntrada(int i)
	{
		int entradas = 0;
		for (int j = 0; j < names.size(); j++)
			if (matrix[j][i] != 0)
				entradas++;
		return entradas;
	}

	@Override
	public ArrayList<String> getSinks()
	{
		ArrayList<String> resposta = new ArrayList<String>();

		for (int i = 0; i < names.size(); i++)
		{
			int entradas = getGrauEntrada(i);
			if (entradas > 0)
			{
				int saidas = getGrauSaida(i);
				if (saidas == 0)
					resposta.add(names.get(i));
			}
		}
		return resposta;
	}

	@Override
	public void addEdge(String strOrig, String strDest, int peso)
	{
		int posOrig = names.indexOf(strOrig);
		int posDest = names.indexOf(strDest);
		matrix[posOrig][posDest] = peso;
	}

}
