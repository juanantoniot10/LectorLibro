package controlAccion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingWorker;

import controlLogica.Logica;
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
	
	
	public ListenerBotonRuta(Logica logica, Actualizador actualizador,PanelInicio panelInicio,
			PanelLectura panelLectura) {
		super();
		this.logica = logica;
		this.actualizador = actualizador;
		this.panelInicio = panelInicio;
		this.panelLectura = panelLectura;
		this.listenerMarcarPagina = new ListenerMarcador(panelLectura, actualizador);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.ruta = String.valueOf("audio/sonidoLibroAbriendo");
		try {
			sonido = AudioSystem.getClip();
			File a = new File(ruta);
			sonido.open(AudioSystem.getAudioInputStream(a));
			sonido.start();
			}
		catch (Exception tipoerror) {
			System.out.println("" + tipoerror);
		}
		JPanel inicioParent = (JPanel) panelInicio.getParent();
		inicioParent.removeAll();
		inicioParent.add(panelLectura);
		this.actualizador.actualizar();
		this.panelLectura.getMarcarPagina().addActionListener(listenerMarcarPagina);	
	}
		
}
