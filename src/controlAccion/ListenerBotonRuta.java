package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import controlLogica.Logica;
import javazoom.jl.player.Player;
import vita.PanelInicio;
import vita.PanelLectura;

public class ListenerBotonRuta implements ActionListener{

	private String ruta;
	private Logica logica;
	private Actualizador actualizador;
	private Clip sonido;
	private PanelInicio panelInicio;
	private PanelLectura panelLectura;
	private ListenerMarcador listenerMarcarPagina;
	private ListenerRetroceso listenerRetroceso;
	
	
	public ListenerBotonRuta(Logica logica, Actualizador actualizador,PanelInicio panelInicio,
			PanelLectura panelLectura) {
		super();
		this.logica = logica;
		this.actualizador = actualizador;
		this.panelInicio = panelInicio;
		this.panelLectura = panelLectura;
		this.listenerMarcarPagina = new ListenerMarcador(panelLectura, actualizador);
		this.listenerRetroceso = new ListenerRetroceso(panelInicio,actualizador,panelLectura);
		this.panelLectura.getMarcarPagina().addActionListener(listenerMarcarPagina);
		this.panelLectura.getSalir().addActionListener(listenerRetroceso);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ruta = String.valueOf("audios/abrirLibro.mp3");
		try {
			Player reproductor = new Player(new FileInputStream(ruta));
			reproductor.play();
			}
		catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
		}
		this.panelInicio.getParent().add(this.panelLectura);
		this.panelLectura.getParent().remove(panelInicio);
		this.actualizador.actualizar();
	}
		
}
