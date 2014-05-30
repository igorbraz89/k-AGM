package basico;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

import util.Coordenada;

public class Aresta extends ElementosDoGrafo {
	public static final double DIST_TOLERAVEL_SELECAO = 1.5;
	private double custo; //CUSTO DE CAMINHAR POR ESTA ARESTA
	private Vertice v0, v1;
	private Shape aresta;

	public Aresta(Vertice v0, Vertice v1) {
		this.v0 = v0;
		this.v1 = v1;
		aresta = new Line2D.Double(new Point2D.Double(v0.getCentro().getX(), v0.getCentro().getY()
				), new Point2D.Double(v1.getCentro().getX(), v1.getCentro().getY()));
	}
	
	public Aresta(Vertice v0, Coordenada p1) {
		this.v0 = v0;
		aresta = new Line2D.Double(new Point2D.Double(v0.getCentro().getX(), v0.getCentro().getY()
				), new Point2D.Double(p1.getX(), p1.getY()));
	}


	public boolean estaContido(Coordenada coord) {
		double tamanhoDaAresta = Math.sqrt(Math.pow(v0.getCentro().getX() - v1.getCentro().getX(), 2) + Math.pow(v0.getCentro().getY() - v1.getCentro().getY(), 2));
		double distanciaAteV0 = Math.sqrt(Math.pow(v0.getCentro().getX() - coord.getX(), 2) + Math.pow(v0.getCentro().getY() - coord.getY(), 2));
		double distanciaAteV1 = Math.sqrt(Math.pow(v1.getCentro().getX() - coord.getX(), 2) + Math.pow(v1.getCentro().getY() - coord.getY(), 2));
		
		if(distanciaAteV0+distanciaAteV1 - tamanhoDaAresta <= DIST_TOLERAVEL_SELECAO)
			return true;
		else
			return false;
	}




	@Override
	public void desenha(Graphics2D g2d) {
		g2d.draw(aresta);
//		int cap = BasicStroke.CAP_BUTT;
//		int join = BasicStroke.JOIN_MITER;
//		BasicStroke thick = new BasicStroke(4, cap, join);
//		g2d.setStroke(thick);
//		g2d.draw(linha);

	}

	public double getCusto() {
		return custo;
	}

	public void setCusto(double custo) {
		this.custo = custo;
	}
	

	public Vertice getV0() {
		return v0;
	}

	public void setV0(Vertice v0) {
		this.v0 = v0;
	}

	public Vertice getV1() {
		return v1;
	}

	public void setV1(Vertice v1) {
		this.v1 = v1;
	}

	public Shape getAresta() {
		return aresta;
	}

	public void setAresta(Shape aresta) {
		this.aresta = aresta;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Linha";
	}
}
