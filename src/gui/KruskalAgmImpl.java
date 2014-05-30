package gui;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import util.ArestaComparator;
import basico.Aresta;
import basico.Vertice;
import desenho.Grafo;

public class KruskalAgmImpl {

	public List<Aresta> getArvGeradoraMin(Grafo gf) {
		List<Aresta> listaArestas = gf.getListaArestas();
		List<Vertice> listaVertices = gf.getListaVertices();
		Collections.sort(listaArestas, new ArestaComparator());
		int conj = 1;
		for (Vertice vertice : listaVertices) {
			vertice.setConjunto(conj);
			conj++;
		}
		listaArestas = retrieveArvGeradoraMin(listaArestas, listaVertices);
		return listaArestas;
	}

	private List<Aresta> retrieveArvGeradoraMin(List<Aresta> listaArestas,
			List<Vertice> listaVertices) {
		List<Aresta> novaListArestas = new ArrayList<Aresta>();

		for (Aresta aresta : listaArestas) {
			int conjuntoV0 = aresta.getV0().getConjunto();
			int conjuntoV1 = aresta.getV1().getConjunto();
				if (conjuntoV0 != conjuntoV1) {
					aresta.getV1().setConjunto(conjuntoV0);
					novaListArestas.add(aresta);
				}
		}

		return novaListArestas;
	}
}