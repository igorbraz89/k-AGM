package toggleButtonListeners;

import gui.TelaPrincipal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import controle.ControleDesenhoVertice;

@SuppressWarnings("serial")
public class VerticeButton extends JToggleButton implements ActionListener {

	private JToolBar jToolBar;

	public VerticeButton(JToolBar toolBar_BarraPaint) {
		this.jToolBar = toolBar_BarraPaint;
		this.setToolTipText("Inserir um novo vértice");
		setBackground(Color.WHITE);
		this.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/icones/circunf.gif")));
		this.setSelectedIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/icones/circunf.png")));

		jToolBar.add(this);
		this.addActionListener(this);

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.isSelected()) {
			ControleDesenhoVertice.setPodeDesenhar(true);
		} else {
			ControleDesenhoVertice.setPodeDesenhar(false);
		}
		//this.disableAllButMe();

	}

	public JToolBar getjToolBar() {
		return jToolBar;
	}

}
