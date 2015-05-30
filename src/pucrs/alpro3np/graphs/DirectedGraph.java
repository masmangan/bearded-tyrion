package pucrs.alpro3np.graphs;

import java.util.ArrayList;

public interface DirectedGraph extends AbstractGraph {
	ArrayList<String> getSources();

	ArrayList<String> getSinks();
}
