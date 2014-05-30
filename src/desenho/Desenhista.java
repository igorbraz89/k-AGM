package desenho;

import java.awt.Graphics2D;

import basico.Aresta;
import basico.Vertice;
import util.Coordenada;

public class Desenhista {
	
	public static Aresta desenhaAresta (Vertice v0, Vertice v1, Graphics2D g2d){
		Aresta linha = new Aresta(v0, v1);
		linha.desenha(g2d);
		return linha;
	}


    public static Vertice desenhaVertice(Coordenada centro, Graphics2D g2d){
		Vertice vert = new Vertice(centro);
		vert.desenha(g2d);
		return vert;
    }


	public static Aresta desenhaAresta(Vertice v0, Coordenada coordenada,
			Graphics2D g2d) {
		Aresta linha = new Aresta(v0, coordenada);
		linha.desenha(g2d);
		return linha;
		
	}

}
