package desenho;

import java.util.ArrayList;
import java.util.List;

import basico.Aresta;
import basico.ElementosDoGrafo;
import basico.Vertice;

public class Grafo {
 
	private List<Vertice> listaVertices;
	
	private List<Aresta> listaArestas;
	

	public Grafo() {
		listaVertices = new ArrayList<Vertice>();
		listaArestas = new ArrayList<Aresta>();
	}

	public List<ElementosDoGrafo> getListaElementos() {
		List<ElementosDoGrafo> retorno = new ArrayList<ElementosDoGrafo>();
		retorno.addAll(listaVertices);
		retorno.addAll(listaArestas);
		return retorno;
	}

	public List<Vertice> getListaVertices() {
		return listaVertices;
	}
	
	


	public void setListaVertices(List<Vertice> listaVertices) {
		this.listaVertices = listaVertices;
	}


	public List<Aresta> getListaArestas() {
		return listaArestas;
	}


	public void setListaArestas(List<Aresta> listaArestas) {
		this.listaArestas = listaArestas;
	}




	
}
 
