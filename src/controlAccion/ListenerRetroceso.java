package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vita.PanelInicio;
import vita.PanelLectura;

public class ListenerRetroceso implements ActionListener{

	private PanelInicio panelInicio;
	private Actualizador actualizador;
	private PanelLectura panelLectura;

	public ListenerRetroceso(PanelInicio panelInicio, Actualizador actualizador,PanelLectura panelLectura) {
		this.panelInicio = panelInicio;
		this.actualizador = actualizador;
		this.panelLectura = panelLectura;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		panelLectura.getParent().add(this.panelInicio);
		panelInicio.getParent().remove(this.panelLectura);
		this.actualizador.actualizar();
	}
	
}
