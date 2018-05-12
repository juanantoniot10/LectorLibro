package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javazoom.jl.player.Player;
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
		if(((ImageIcon)((JLabel)this.panelLectura.getPanelImagen().getComponents()[0]).getIcon()).getImage().equals(((ImageIcon)((JLabel)this.panelLectura.getImagenMarcar()).getIcon()).getImage())){
			this.panelLectura.getPanelImagen().removeAll();
			this.panelLectura.getPanelImagen().add(this.panelLectura.getImagenNormal());
			reproducirAudio("audios/desmarcarPagina.mp3");
		}
		else {
			this.panelLectura.getPanelImagen().removeAll();
			this.panelLectura.getPanelImagen().add(this.panelLectura.getImagenMarcar());
			reproducirAudio("audios/marcarPagina.mp3");
		}
		
		this.actualizador.actualizar();
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
