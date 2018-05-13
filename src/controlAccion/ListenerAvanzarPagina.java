package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextPane;

import controlLogica.Logica;
import javazoom.jl.player.Player;
import vita.PanelLectura;

public class ListenerAvanzarPagina implements ActionListener{

	private PanelLectura panelLectura;
	private Actualizador actualizador;
	private Logica logica;

	public ListenerAvanzarPagina(PanelLectura panelLectura, Actualizador actualizador,Logica logica) {
		this.panelLectura = panelLectura;
		this.actualizador = actualizador;
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int paginaUno = getValorPagina(this.panelLectura.getNumeroPaginaIzq());
		int paginaDos = getValorPagina(this.panelLectura.getNumeroPaginaDer());
		ponerTextoEnPagina(e, paginaUno,this.panelLectura.getTextPaneLeft());
		ponerTextoEnPagina(e, paginaDos,this.panelLectura.getTextPaneDer());
		ponerNumeroPagina(this.panelLectura.getNumeroPaginaIzq(),e);
		ponerNumeroPagina(this.panelLectura.getNumeroPaginaDer(),e);
		ponerNumeroPaginaMarcada();
		controlarImagenMasNumeroDePagina();
		reproducirAudio("audios/cambiarPagina.mp3");
		this.actualizador.actualizar();
	}

	/**
	 * 
	 */
	private void controlarImagenMasNumeroDePagina() {
		this.panelLectura.getPanelImagen().removeAll();
		
		if(this.logica.getPaginaMarcada()==getValorPagina(this.panelLectura.getNumeroPaginaIzq())-1) {
			ponerImagenMarcadaAnterior();
			controlTextoSiVisibleAnterior();			
			controlVisibleSiMarcadaEsAnterior();
		}
		else if(this.logica.getPaginaMarcada()==getValorPagina(this.panelLectura.getNumeroPaginaDer())) {
			ponerImagenMarcada();
			controlTextoSiMarcada();
			controlVisibleSiMarcada();
			
		}
		else {
			ponerImagenNormal();
			controlVisiblePorDefecto();
		}
	}

	/**
	 * 
	 */
	private void ponerImagenNormal() {
		this.panelLectura.getPanelImagen().add(this.panelLectura.getImagenNormal());
	}

	/**
	 * 
	 */
	private void controlVisiblePorDefecto() {
		this.panelLectura.getNumeroPaginaMarcadaIzq().setVisible(false);
		this.panelLectura.getNumeroPaginaIzq().setVisible(true);
		this.panelLectura.getNumeroPaginaCuandoMarcada().setVisible(false);
		this.panelLectura.getNumeroPaginaDer().setVisible(true);
	}

	/**
	 * 
	 */
	private void ponerImagenMarcada() {
		this.panelLectura.getPanelImagen().add(this.panelLectura.getImagenMarcar());
	}

	private void controlTextoSiMarcada() {
		this.panelLectura.getNumeroPaginaCuandoMarcada().setText(String.valueOf(this.logica.getPaginaMarcada()+2));	
	}

	/**
	 * 
	 */
	private void controlVisibleSiMarcada() {
		this.panelLectura.getNumeroPaginaMarcadaIzq().setVisible(false);
		this.panelLectura.getNumeroPaginaIzq().setVisible(true);
		this.panelLectura.getNumeroPaginaCuandoMarcada().setVisible(true);;
		this.panelLectura.getNumeroPaginaDer().setVisible(false);
	}

	/**
	 * 
	 */
	private void ponerImagenMarcadaAnterior() {
		this.panelLectura.getPanelImagen().add(this.panelLectura.getImagenIzquierda());
	}

	/**
	 * 
	 */
	private void controlTextoSiVisibleAnterior() {
		this.panelLectura.getNumeroPaginaMarcadaIzq().setText(String.valueOf(getValorPagina(this.panelLectura.getNumeroPaginaIzq())-2));
	}

	/**
	 * 
	 */
	private void controlVisibleSiMarcadaEsAnterior() {
		this.panelLectura.getNumeroPaginaIzq().setVisible(false);
		this.panelLectura.getNumeroPaginaMarcadaIzq().setVisible(true);
		this.panelLectura.getNumeroPaginaDer().setVisible(true);
		this.panelLectura.getNumeroPaginaCuandoMarcada().setVisible(false);
	}

	/**
	 * 
	 */
	private void ponerNumeroPaginaMarcada() {
		this.panelLectura.getNumeroPaginaCuandoMarcada().setText(String.valueOf(getValorPagina(this.panelLectura.getNumeroPaginaDer())+2));
	}

	private void ponerNumeroPagina(JLabel lblnumeroPagina, ActionEvent e) {
		lblnumeroPagina.setText(String.valueOf(Integer.valueOf(lblnumeroPagina.getText())+obtenerValorDelBoton(e)));		
	}

	/**
	 * @param e
	 * @param paginaUno
	 */
	private void ponerTextoEnPagina(ActionEvent e, int pagina, JTextPane jTextPane) {
		jTextPane.setText(logica.obtenerTexto(pagina+obtenerValorDelBoton(e)));
	}

	/**
	 * @param labelConNumeroPagina 
	 * @return
	 */
	private int getValorPagina(JLabel labelConNumeroPagina) {
		return Integer.valueOf(labelConNumeroPagina.getText()).intValue();
	}
	/**
	 * @param e
	 * @return
	 */
	private int obtenerValorDelBoton(ActionEvent e) {
		return Integer.valueOf(((JButton)e.getSource()).getName()).intValue();
	}
	private void reproducirAudio(String ruta) {
		try {
			Player reproductor = new Player(new FileInputStream(String.valueOf(ruta)));
			reproductor.play();
			}
		catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
		}
	}
}
