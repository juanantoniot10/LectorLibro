package controlAccion;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Actualizador {
	private JPanel panelPrincipal;
	
	public Actualizador(JPanel panelPrincipal) {
		super();
		this.panelPrincipal = panelPrincipal;
	}

	public void actualizar(){
  		SwingUtilities.updateComponentTreeUI(panelPrincipal);
  	}
}