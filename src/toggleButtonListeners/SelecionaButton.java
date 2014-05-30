package toggleButtonListeners;

import gui.TelaPrincipal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import controle.ControleSelecao;

@SuppressWarnings("serial")
public class SelecionaButton extends JToggleButton implements ActionListener {

	private JToolBar jToolBar;

	public SelecionaButton(JToolBar toolBar_BarraPaint) {
		this.jToolBar = toolBar_BarraPaint;
		this.setToolTipText("Selecionar um vértice ou uma aresta");
		setBackground(Color.WHITE);
		setIcon(new ImageIcon(
				TelaPrincipal.class.getResource("/icones/selecionar.gif")));
		this.setSelectedIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/selecionar.png")));

		jToolBar.add(this);
		this.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.isSelected()) {
			ControleSelecao.setPodeSelecionar(true);
		} else {
			ControleSelecao.setPodeSelecionar(false);
		}

	}

	public JToolBar getjToolBar() {
		return jToolBar;
	}

}
