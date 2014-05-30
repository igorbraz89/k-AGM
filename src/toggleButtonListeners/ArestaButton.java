package toggleButtonListeners;

import gui.TelaPrincipal;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import controle.ControleDesenhoAresta;

@SuppressWarnings("serial")
public class ArestaButton extends JToggleButton implements ActionListener {

	private JToolBar jToolBar;

	public ArestaButton(JToolBar toolBar_BarraPaint) {
		this.jToolBar = toolBar_BarraPaint;
		this.setToolTipText("Inserir uma nova aresta");
		setBackground(Color.WHITE);
		this.setIcon(new ImageIcon(TelaPrincipal.class
				.getResource("/icones/linha.gif")));
		this.setSelectedIcon(new ImageIcon(TelaPrincipal.class.getResource("/icones/linha.png")));
		this.addActionListener(this);
		jToolBar.add(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.isSelected()) {
			ControleDesenhoAresta.setPodeDesenhar(true);
			
		} else {
			ControleDesenhoAresta.setPodeDesenhar(false);
		}
		//this.disableAllButMe();

	}

	public JToolBar getjToolBar() {
		return jToolBar;
	}

}
