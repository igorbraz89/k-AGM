package toggleButtonListeners;

import gui.AreaDesenho;
import gui.KruskalAgmImpl;
import gui.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;

import basico.Aresta;
import basico.Vertice;
import desenho.Grafo;

public class ContadorButton extends JButton implements ActionListener {
	private JToolBar jToolBar;
	private AreaDesenho areaDesenho;
	private KruskalAgmImpl kr = new KruskalAgmImpl();
	public ContadorButton(JToolBar toolBar_BarraPaint, AreaDesenho areaDesenho) {
		setAreaDesenho(areaDesenho);
		this.jToolBar = toolBar_BarraPaint;
		//setBackground(Color.WHITE);
		setIcon(new ImageIcon(
				TelaPrincipal.class.getResource("/icones/relatorio.gif")));
		this.setSelectedIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/relatorio.png")));

		jToolBar.add(this);
		this.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==this) {
			int vertices = getAreaDesenho().getDraw().getListaVertices().size();
			int arestas = getAreaDesenho().getDraw().getListaArestas().size();
			JOptionPane.showMessageDialog(null,"Total de vértices: "+vertices+
											"\nTotal de arestas: "+arestas);
			 List<Vertice> listaVertices = getAreaDesenho().getDraw().getListaVertices();
			
			 List<Aresta> listaArestas = getAreaDesenho().getDraw().getListaArestas();
			 Grafo g = new Grafo();
			 g.setListaArestas(listaArestas);
			 g.setListaVertices(listaVertices);
			 List<Aresta> listaNova = kr.getArvGeradoraMin(g);
			 double custo = 0;
			 for (Aresta aresta : listaNova) {
				custo +=aresta.getCusto();
			}
			 System.out.println("Custo da arvore: "+custo+" com N.ar= "+listaNova.size());
			 
			 
		} else {
			System.out.println("disable");
		}

	}

	public JToolBar getjToolBar() {
		return jToolBar;
	}

	public AreaDesenho getAreaDesenho() {
		return areaDesenho;
	}

	public void setAreaDesenho(AreaDesenho areaDesenho) {
		this.areaDesenho = areaDesenho;
	}

}
