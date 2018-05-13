package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import controlLogica.Logica;
import javazoom.jl.player.Player;
import vita.PanelLectura;

public class ListenerMarcador implements ActionListener{
	
	private PanelLectura panelLectura;
	private Actualizador actualizador;
	private Logica logica;
	
	public ListenerMarcador(PanelLectura panelLectura,Actualizador actualizador,Logica logica) {
		super();
		this.panelLectura = panelLectura;
		this.actualizador = actualizador;
		this.logica = logica;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		marcarPagina();
	}

	/**
	 * 
	 */
	private void marcarPagina() {
		if(comprobarImagenActual()){
			desmarcar();
			
		}
		else {
			marcar();
		}
		
		cambiarVisivilidadNumeroPagina();
		cambiarVisivilidadNumeroPaginaCuandoMarcada();
		ponerTextoEnMarcada();	
		this.actualizador.actualizar();
	}

	/**
	 * 
	 */
	private void ponerTextoEnMarcada() {
		this.panelLectura.getNumeroPaginaCuandoMarcada().setText(String.valueOf(this.logica.getPaginaMarcada()+2));
	}

	/**
	 * @return
	 */
	private boolean comprobarImagenActual() {
		return ((ImageIcon)((JLabel)this.panelLectura.getPanelImagen().getComponents()[0]).getIcon()).getImage().equals(((ImageIcon)((JLabel)this.panelLectura.getImagenMarcar()).getIcon()).getImage());
	}

	/**
	 * 
	 */
	private void marcar() {
		anadirImagen(this.panelLectura.getImagenMarcar());
		reproducirAudio("audios/marcarPagina.mp3");
		this.logica.setPaginaMarcada(Integer.valueOf(this.panelLectura.getNumeroPaginaDer().getText()).intValue());
	}

	/**
	 * 
	 */
	private void desmarcar() {
		anadirImagen(this.panelLectura.getImagenNormal());
		reproducirAudio("audios/desmarcarPagina.mp3");
		this.logica.setPaginaMarcada(-1);
	}

	/**
	 * @param imagen 
	 * 
	 */
	private void anadirImagen(JLabel imagen) {
		this.panelLectura.getPanelImagen().removeAll();
		this.panelLectura.getPanelImagen().add(imagen);
	}

	/**
	 * 
	 */
	private void cambiarVisivilidadNumeroPaginaCuandoMarcada() {
		this.panelLectura.getNumeroPaginaCuandoMarcada().setVisible(!this.panelLectura.getNumeroPaginaCuandoMarcada().isVisible());
	}

	/**
	 * 
	 */
	private void cambiarVisivilidadNumeroPagina() {
		this.panelLectura.getNumeroPaginaDer().setVisible(!this.panelLectura.getNumeroPaginaDer().isVisible());
	}


	/**
	 * 
	 */
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
