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

	private String rutaAudio;
	private Logica logica;
	private Actualizador actualizador;
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
		this.rutaAudio = String.valueOf("audios/abrirLibro.mp3");
		try {
			Player reproductor = new Player(new FileInputStream(rutaAudio));
			reproductor.play();
			}
		catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
		}
		this.panelInicio.getParent().add(this.panelLectura);
		this.panelLectura.getParent().remove(panelInicio);
		this.panelLectura.getTituloLibro().setText(logica.extraerTitulo(((JButton)e.getSource()).getName()));
		this.panelLectura.getTextPaneLeft().setText(logica.obtenerTexto(0,new File(((JButton)e.getSource()).getName())));
		this.panelLectura.getTextPaneDer().setText(logica.obtenerTexto(1,new File (((JButton)e.getSource()).getName())));
		this.actualizador.actualizar();
	}

}
