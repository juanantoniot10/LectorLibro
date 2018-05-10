package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import vita.PanelLectura;

public class ListenerMarcador implements ActionListener{
	
	private PanelLectura panelLectura;
	private Actualizador actualizador;
	
	public ListenerMarcador(PanelLectura panelLectura,Actualizador actualizador) {
		super();
		this.panelLectura = panelLectura;
		this.actualizador = actualizador;
	}





	@Override
	public void actionPerformed(ActionEvent e) {
		this.panelLectura.getPanelImagen().removeAll();
		JLabel labelImagen = new JLabel(new ImageIcon("img/marcarPagina.jpg"));
		this.panelLectura.getPanelImagen().add(labelImagen);
		this.actualizador.actualizar();
	}
	
}
