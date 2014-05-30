package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

import util.Coordenada;
import basico.Aresta;
import basico.ElementosDoGrafo;
import basico.Vertice;
import controle.ControleDesenhoAresta;
import controle.ControleDesenhoVertice;
import controle.ControleSelecao;
import desenho.Desenhista;
import desenho.Grafo;

public class AreaDesenho extends JPanel implements MouseListener, MouseMotionListener {
	private Coordenada p0;
	private Coordenada p1;
	private Vertice v0;
	private Vertice v1;
	private Grafo draw = new Grafo();

	public AreaDesenho() {
		super();
		initialize();
	}

	private void initialize() {

		setSize(new Dimension(800, 600));
		this.setLayout(null);
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) { // TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent e) { // TODO Auto-generated method stub
	}

	@Override
	public void mouseExited(MouseEvent e) { // TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		if (ControleDesenhoAresta.isPodeDesenhar()) {
			for(ElementosDoGrafo vert : draw.getListaVertices())
			{
				if(vert.estaContido(new Coordenada(e.getX(), e.getY())))
					v0 = (Vertice) vert;
			}
			setP0(new Coordenada(e.getX(), e.getY()));
		}

		if (ControleDesenhoVertice.isPodeDesenhar()) {
			setP0(new Coordenada(e.getX(), e.getY()));
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		this.redesenha(this.getGraphics());
		
		if (ControleDesenhoAresta.isPodeDesenhar()&&v0!=null) {
			boolean parouNumVertice = false;
			for(ElementosDoGrafo vert : draw.getListaVertices())
			{
				if(vert.estaContido(new Coordenada(e.getX(), e.getY())))
				{
					v1 = (Vertice) vert;
					parouNumVertice = true;
				}
			}
			if(parouNumVertice)
			{Aresta ar = Desenhista.desenhaAresta(v0, v1,
					(Graphics2D) this.getGraphics());
			draw.getListaArestas().add(ar);
			}
			//ar.setOrdem(draw.getListaArestas().size());

		}


		if (ControleDesenhoVertice.isPodeDesenhar()) {
			setP1(new Coordenada(e.getX(), e.getY()));
			Vertice desenho = Desenhista.desenhaVertice(p0, (Graphics2D) this.getGraphics());
			draw.getListaVertices().add(desenho);
		}
		if (ControleSelecao.isPodeSelecionar()) {
			seleciona(new Coordenada(e.getX(), e.getY()));

		}

	}

	protected void paintComponent(Graphics g2) {
		redesenha(g2);
	}

	public void redesenha(Graphics g2) {
		
		if (this != null) {
			getGraphics().clearRect(0, 0,
					getWidth(), getHeight());
			this.getDraw().getListaElementos().clear();
		}
		
		for (ElementosDoGrafo ar : draw.getListaArestas()) {
			ar.desenha((Graphics2D) g2);
		}
		
		for (ElementosDoGrafo vert : draw.getListaVertices()) {
			vert.desenha((Graphics2D) g2);
		}
	}

	public void setP0(Coordenada p0) {
		this.p0 = p0;
	}

	public Coordenada getP0() {
		return p0;
	}

	public Coordenada getP1() {
		return p1;
	}

	public void setP1(Coordenada p1) {
		this.p1 = p1;
	}

	public Grafo getDraw() {
		return draw;
	}

	public void setDraw(Grafo draw) {
		this.draw = draw;
	}

	public void seleciona(Coordenada pt) {
		List<ElementosDoGrafo> desenhos = draw.getListaElementos();
		Collections.reverse(desenhos);
		for (ElementosDoGrafo geo : desenhos) {
			Graphics2D g2 = (Graphics2D) this.getGraphics();
			g2.setStroke(new BasicStroke(10));
			if (geo.estaContido(pt)) {
				System.out.println(geo);
				g2.setPaint(Color.ORANGE);
				g2.setStroke(new BasicStroke(1));
				geo.desenha(g2);
				break;

			} else {
				g2.setPaint(Color.black);
				g2.setStroke(new BasicStroke(1));
				geo.desenha(g2);
				//break;
			}
		}

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (ControleDesenhoAresta.isPodeDesenhar() && v0!=null) {
			this.redesenha(this.getGraphics());
			Desenhista.desenhaAresta(v0, new Coordenada(e.getX(), e.getY()), (Graphics2D) this.getGraphics());
		}
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		if (ControleDesenhoVertice.isPodeDesenhar()) {
			this.redesenha(this.getGraphics());
			setP0(new Coordenada(e.getX(), e.getY()));
			Vertice desenho = Desenhista.desenhaVertice(p0, (Graphics2D) this.getGraphics());
		}
		
	}
}