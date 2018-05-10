package controlAccion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import modelo.Busqueda;

public class ListenerBusqueda implements ActionListener{

	private Busqueda busqueda;
	private JPanel panelBotonesCanciones;
	private ActionListener listenerBotonRuta;
	private JTextField textoNombreCancion;
	private JTextField textoRutaUsuario;
		
	
	public ListenerBusqueda(JPanel panelBotonesCanciones, ListenerBotonRuta listenerBotonRuta, JTextField textoNombreCancion, JTextField textoRutaUsuario) {
		super();
		this.panelBotonesCanciones = panelBotonesCanciones;
		this.listenerBotonRuta = listenerBotonRuta;
		this.textoNombreCancion = textoNombreCancion;
		this.textoRutaUsuario = textoRutaUsuario;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		panelBotonesCanciones.removeAll();
		try {
			this.busqueda = new Busqueda(String.valueOf(textoNombreCancion.getText()),String.valueOf(textoRutaUsuario.getText()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int i = 0; i < this.busqueda.getResultados().size(); i++) {
			JButton botonRuta = new JButton(this.busqueda.getResultados().get(i));
			botonRuta.setMaximumSize(new Dimension(500, 15));
			botonRuta.addActionListener(listenerBotonRuta);
			panelBotonesCanciones.add(botonRuta);
		}
		SwingUtilities.updateComponentTreeUI(panelBotonesCanciones);
	}

}
