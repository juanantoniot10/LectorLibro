package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controlLogica.Logica;
import vita.PanelLectura;

public class ListenerRetrocederPagina implements ActionListener{
	private PanelLectura panelLectura;
	private Actualizador actualizador;
	private Logica logica;

	public ListenerRetrocederPagina(PanelLectura panelLectura, Actualizador actualizador,Logica logica) {
		this.panelLectura = panelLectura;
		this.actualizador = actualizador;
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int paginaUno = Integer.valueOf(this.panelLectura.getNumeroPaginaIzq().getText()).intValue();
		int paginaDos = Integer.valueOf(this.panelLectura.getNumeroPaginaDer().getText()).intValue();
		this.panelLectura.getTextPaneLeft().setText(logica.obtenerTexto(paginaUno-2));
		this.panelLectura.getTextPaneDer().setText(logica.obtenerTexto(paginaDos-2));
		this.panelLectura.getNumeroPaginaIzq().setText(String.valueOf(Integer.valueOf(this.panelLectura.getNumeroPaginaIzq().getText())-2));
		this.panelLectura.getNumeroPaginaDer().setText(String.valueOf(Integer.valueOf(this.panelLectura.getNumeroPaginaDer().getText())-2));
		this.actualizador.actualizar();
	}
}
