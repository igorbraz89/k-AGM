package basico;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import util.Coordenada;

public class Vertice extends ElementosDoGrafo{
	private String label;
	private int conjunto;
	private boolean visitado;
	private Coordenada centro;
	private Shape vert;

	public Vertice(Coordenada _centro) {
		this.centro = _centro;
		vert = new Ellipse2D.Double(centro.getX()-15, centro.getY()-15, 30, 30);

	}


	public boolean estaContido(Coordenada coord) {
		return this.vert.contains(coord.getX(), coord.getY());
	}


	public void desenha(Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.draw(vert);
	}
	
	public int getConjunto() {
		return conjunto;
	}


	public void setConjunto(int conjunto) {
		this.conjunto = conjunto;
	}

	public boolean isVisitado() {
		return visitado;
	}


	public void setVisitado(boolean visitado) {
		this.visitado = visitado;
	}


	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "circunfer�ncia";
	}


	public Coordenada getCentro() {
		return centro;
	}


	public void setCentro(Coordenada centro) {
		this.centro = centro;
	}


}
