package basico;

import java.awt.Graphics2D;

import util.Coordenada;

public abstract class ElementosDoGrafo {

	private int ordem;

	public abstract void desenha(Graphics2D g2d);
	
	public abstract boolean estaContido(Coordenada coord);

	@Override
	public String toString() {
		return "Geometria []";
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

}
