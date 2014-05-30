package util;

import java.util.Comparator;

import basico.Aresta;

public class ArestaComparator implements Comparator<Aresta>{

	@Override
	public int compare(Aresta a1, Aresta a2) {
		double custoAresta = a1.getCusto() - a2.getCusto();
			return (int)Math.round(custoAresta);
	}
	
}
