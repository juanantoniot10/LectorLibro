package vita;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;

public class PanelLectura extends JPanel{
	private JLabel tituloLibro;
	private JButton irPaginaMarcada;
	private JButton marcarPagina;
	private JButton retrocederPagina;
	private JButton retrocederPaginax10;
	private JButton avanzarPaginax10;
	private JPanel panelImagen;
	private JButton avanzarPagina;
	private JButton salir;
	private JLabel imagenNormal;
	private JLabel imagenMarcar;
	private JButton botonMusica;
	public PanelLectura() {
		setLayout(new BorderLayout(0, 0));
		
		tituloLibro = new JLabel("Titulo Libro");
		tituloLibro.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLibro.setFont(new Font("Harrington", Font.BOLD, 18));
		add(tituloLibro, BorderLayout.NORTH);
		
		panelImagen = new JPanel();
		add(panelImagen, BorderLayout.CENTER);
		
		ImageIcon imagen = new ImageIcon("img/paginaNormal.jpg");
		imagenNormal = new JLabel(imagen);
		imagenNormal.setName("normal");
		imagenNormal.setMinimumSize(new Dimension(200, 200));
		imagenNormal.setMaximumSize(new Dimension(1000, 700));
		panelImagen.add(imagenNormal);
		
		ImageIcon imagenMarcado = new ImageIcon("img/marcarPagina.jpg");
		imagenMarcar = new JLabel(imagenMarcado);
		imagenNormal.setName("marcar");
		imagenMarcar.setMinimumSize(new Dimension(200, 200));
		imagenMarcar.setMaximumSize(new Dimension(1000, 700));
		
		
		
		JPanel panelBotones = new JPanel();
		panelBotones.setMinimumSize(new Dimension(70, 10));
		panelBotones.setMaximumSize(new Dimension(70, 32767));
		add(panelBotones, BorderLayout.WEST);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		
		retrocederPaginax10 = new JButton("X10");
		retrocederPaginax10.setToolTipText("Rereocede diez paginas\r\n");
		retrocederPaginax10.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		retrocederPaginax10.setMinimumSize(new Dimension(90, 20));
		retrocederPaginax10.setMaximumSize(new Dimension(90, 40));
		panelBotones.add(retrocederPaginax10);
		
		retrocederPagina = new JButton("");
		retrocederPagina.setToolTipText("retrocede 1 pagina");
		retrocederPagina.setMaximumSize(new Dimension(90, 40));
		retrocederPagina.setMinimumSize(new Dimension(90, 20));
		retrocederPagina.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		panelBotones.add(retrocederPagina);
		
		marcarPagina = new JButton("");
		marcarPagina.setToolTipText("marcar pagina");
		marcarPagina.setMinimumSize(new Dimension(90, 20));
		marcarPagina.setMaximumSize(new Dimension(90, 40));
		marcarPagina.setIcon(new ImageIcon(PanelLectura.class.getResource("/sun/print/resources/oneside.png")));
		panelBotones.add(marcarPagina);
		
		irPaginaMarcada = new JButton("");
		irPaginaMarcada.setToolTipText("ir a pagina marcada");
		irPaginaMarcada.setMinimumSize(new Dimension(90, 20));
		irPaginaMarcada.setMaximumSize(new Dimension(90, 40));
		irPaginaMarcada.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		panelBotones.add(irPaginaMarcada);
		
		avanzarPagina = new JButton("");
		avanzarPagina.setToolTipText("avanzar pagina");
		avanzarPagina.setMinimumSize(new Dimension(90, 20));
		avanzarPagina.setMaximumSize(new Dimension(90, 40));
		avanzarPagina.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		panelBotones.add(avanzarPagina);
		
		avanzarPaginax10 = new JButton("X10");
		avanzarPaginax10.setToolTipText("avanzar diez paginas");
		avanzarPaginax10.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		avanzarPaginax10.setMinimumSize(new Dimension(90, 20));
		avanzarPaginax10.setMaximumSize(new Dimension(90, 40));
		panelBotones.add(avanzarPaginax10);
		
		botonMusica = new JButton("");
		botonMusica.setIcon(new ImageIcon("img/iconoMusica.png"));
		botonMusica.setToolTipText("Musica de fondo");
		botonMusica.setMinimumSize(new Dimension(90, 20));
		botonMusica.setMaximumSize(new Dimension(90, 40));
		panelBotones.add(botonMusica);
		
		salir = new JButton("");
		salir.setMinimumSize(new Dimension(90, 9));
		salir.setToolTipText("volver a menu principal");
		salir.setMaximumSize(new Dimension(90, 40));
		salir.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		panelBotones.add(salir);
	}
	public JLabel getTituloLibro() {
		return tituloLibro;
	}
	public JButton getIrPaginaMarcada() {
		return irPaginaMarcada;
	}
	public JButton getMarcarPagina() {
		return marcarPagina;
	}
	public JButton getRetrocederPagina() {
		return retrocederPagina;
	}
	public JButton getRetrocederPaginax10() {
		return retrocederPaginax10;
	}
	public JButton getAvanzarPaginax10() {
		return avanzarPaginax10;
	}
	public JPanel getPanelImagen() {
		return panelImagen;
	}
	public JButton getAvanzarPagina() {
		return avanzarPagina;
	}
	public JButton getSalir() {
		return salir;
	}
	public JLabel getImagenNormal() {
		return imagenNormal;
	}
	public JLabel getImagenMarcar() {
		return imagenMarcar;
	}
	

}
