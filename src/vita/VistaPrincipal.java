package vita;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.Color;

public class VistaPrincipal extends JFrame{
	protected PanelInicio panelInicio;
	public VistaPrincipal() {
		getContentPane().setBackground(Color.BLACK);
		setResizable(false);
		setMinimumSize(new Dimension(750, 470));
		setMaximumSize(new Dimension(750, 470));
		getContentPane().setLayout(new BorderLayout(0, 0));
		this.panelInicio = new PanelInicio();
		getContentPane().add(this.panelInicio);
	}
	public JTextField getTxtElHobbit() {
		return panelInicio.getTxtElHobbit();
	}
	public JTextField getTxtCuserstuusuarioalgoalgo() {
		return panelInicio.getTxtCuserstuusuarioalgoalgo();
	}
	public JPanel getPanelTitulo() {
		return panelInicio.getPanelTitulo();
	}
	public JPanel getPanelResultado() {
		return panelInicio.getPanelResultado();
	}
	public JPanel getPanelImagen() {
		return panelInicio.getPanelImagen();
	}
	public JLabel getTitulo() {
		return panelInicio.getTitulo();
	}
	
}
