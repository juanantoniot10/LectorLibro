package controlAccion;

import java.awt.Dimension;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controlLogica.Logica;
import vita.PanelLectura;
import vita.VistaPrincipal;

public class Puente extends VistaPrincipal{
	private ListenerBusqueda listenerBusqueda;
	private ListenerBotonRuta listenerBotonRuta;
	private Logica logica;
	private Actualizador actualizador;
	private PanelLectura panelLectura;
	private ListenerMarcador listenerMarcador;
	
	public Puente() {
		super();
		this.logica = new Logica();
		this.panelLectura = new PanelLectura();
		this.actualizador = new Actualizador((JPanel) this.panelInicio.getParent());
		this.listenerBotonRuta = new ListenerBotonRuta(this.logica,this.actualizador,this.panelInicio,this.panelLectura);
//		this.listenerBusqueda = new ListenerBusqueda(panelBotonesCanciones,listenerBotonRuta,this.textoNombreCancion,this.textoRutaUsuario);
//		this.panelImagen.add(new JLabel(this.logica.getImagenReproductor()));
//		this.panelInicio.getTxtElHobbit().addActionListener(listenerBusqueda);
//		this.panelInicio.getTxtCuserstuusuarioalgoalgo().addActionListener(listenerBusqueda);
		File carpetaLibros = new File("libros");
		for (int i = 0; i <carpetaLibros.listFiles().length ; i++) {
			JButton nuevoBoton = new JButton(carpetaLibros.listFiles()[i].getName());
			nuevoBoton.setMaximumSize(new Dimension(200, 15));
			nuevoBoton.addActionListener(listenerBotonRuta);
			this.panelInicio.getPanelResultado().add(nuevoBoton);
		}
	}
	
}
