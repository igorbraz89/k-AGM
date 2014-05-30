package toggleButtonListeners;

import gui.AreaDesenho;
import gui.TelaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToolBar;

public class ClearButton extends JButton implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JToolBar jToolBar;
	private AreaDesenho areaDesenho;

	public ClearButton(JToolBar toolBar_BarraPaint, AreaDesenho areaDesenho) {
		setAreaDesenho(areaDesenho);
		this.jToolBar = toolBar_BarraPaint;
		//setBackground(Color.WHITE);
		this.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/icones/limpar.gif")));
		jToolBar.add(this);
		this.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.areaDesenho != null) {
			areaDesenho.getGraphics().clearRect(0, 0,
					areaDesenho.getWidth(), areaDesenho.getHeight());
			this.getAreaDesenho().getDraw().getListaArestas().clear();
			this.getAreaDesenho().getDraw().getListaVertices().clear();
		}

	}

	private AreaDesenho getAreaDesenho() {
		if (areaDesenho == null) {
			areaDesenho = new AreaDesenho();
		}
		return areaDesenho;
	}

	public void setAreaDesenho(AreaDesenho areaDesenho) {
		this.areaDesenho = areaDesenho;
	}

}
