package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;

import toggleButtonListeners.VerticeButton;
import toggleButtonListeners.ClearButton;
import toggleButtonListeners.ContadorButton;
import toggleButtonListeners.ArestaButton;
import toggleButtonListeners.SelecionaButton;
import controle.ControleDesenhoVertice;
import controle.ControleDesenhoAresta;

public class TelaPrincipal implements ActionListener {

	private JFrame frmPaint;
	private JToggleButton ToggleButton_Selecionavel;
	private JToggleButton ToggleButton_Linha;
	private JToggleButton ToggleButton_Circunf;
	private JButton jButton_Clear;
	private JButton jButton_Relatorio;
	private AreaDesenho areaDesenho;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frmPaint.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPrincipal() {
		initialize();
	}

	private void initialize() {

		// create Jframe
		frmPaint = new JFrame();
		// frmPaint.setBackground(Color.WHITE);
		frmPaint.setSize(new Dimension(800, 600));
		frmPaint.setTitle("Paint");
		frmPaint.setBounds(100, 100, 450, 300);
		frmPaint.setLocationRelativeTo(null);
		frmPaint.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// create menu
		JToolBar toolBar_BarraPaint = new JToolBar();
		toolBar_BarraPaint.setBackground(new Color(46, 139, 87));
		frmPaint.getContentPane().add(toolBar_BarraPaint, BorderLayout.NORTH);

		JPanel panel_Principal = new JPanel();
		// panel_Principal.setBackground(Color.WHITE);
		frmPaint.getContentPane().add(panel_Principal, BorderLayout.CENTER);
		panel_Principal.setLayout(new BorderLayout(0, 0));

		areaDesenho = new AreaDesenho();
		areaDesenho.setForeground(Color.BLACK);
		panel_Principal.add(areaDesenho, BorderLayout.CENTER);

		try {
			ToggleButton_Selecionavel = new SelecionaButton(
					toolBar_BarraPaint);
			ToggleButton_Selecionavel.addActionListener(this);

			ToggleButton_Linha = new ArestaButton(toolBar_BarraPaint);
			ToggleButton_Linha.addActionListener(this);

		
			ToggleButton_Circunf = new VerticeButton(toolBar_BarraPaint);
			ToggleButton_Circunf.addActionListener(this);
			
			jButton_Clear = new ClearButton(toolBar_BarraPaint, areaDesenho);
			jButton_Relatorio = new ContadorButton(toolBar_BarraPaint,
					areaDesenho);

		} catch (HeadlessException e1) {
			e1.printStackTrace();
		} catch (NullPointerException e2) {
			e2.printStackTrace();
		} catch (Exception e3) {
			e3.printStackTrace();
		}

	}

	public void actionPerformed(ActionEvent e) {

		this.disableAllButMe(e);

	}

	private void disableAllButMe(ActionEvent e) {

		if (e.getSource() != ToggleButton_Circunf) {
			if (ControleDesenhoVertice.isPodeDesenhar()) {
				ToggleButton_Circunf.doClick();
				ControleDesenhoVertice.setPodeDesenhar(false);
			}
		}
		
		if (e.getSource() != ToggleButton_Linha) {
			if (ControleDesenhoAresta.isPodeDesenhar()) {
				ToggleButton_Linha.doClick();
				ControleDesenhoAresta.setPodeDesenhar(false);
			}
		}

	}

}