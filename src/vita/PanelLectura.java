package vita;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JTextPane;

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
	private JLabel imagenIzquierda;
	private JLabel imagenMarcar;
	private JButton botonMusica;
	private JLabel numeroPaginaDer;
	private JLabel numeroPaginaIzq;
	private JTextPane textPaneLeft;
	private JTextPane textPaneDer;
	private JLabel numeroPaginaCuandoMarcada;
	private JLabel numeroPaginaMarcadaIzq;
	private JButton btnLeeParaMi;
	
	public PanelLectura() {
		setBackground(Color.BLACK);
		setMaximumSize(new Dimension(700, 500));
		setMinimumSize(new Dimension(700, 500));
		setLayout(null);
		
		tituloLibro = new JLabel("Titulo Libro");
		tituloLibro.setBounds(0, 0, 738, 22);
		tituloLibro.setOpaque(true);
		tituloLibro.setForeground(Color.ORANGE);
		tituloLibro.setBackground(Color.BLACK);
		tituloLibro.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLibro.setFont(new Font("Harrington", Font.BOLD, 18));
		add(tituloLibro);
		
		ImageIcon imagen = new ImageIcon("img/paginaNormal.jpg");
		
		ImageIcon imagenMarcado = new ImageIcon("img/marcarPagina.jpg");
		imagenMarcar = new JLabel(imagenMarcado);
		imagenMarcar.setBounds(0, 0, 665, 415);
		imagenMarcar.setMinimumSize(new Dimension(612, 419));
		imagenMarcar.setMaximumSize(new Dimension(612, 419));
		imagenMarcar.setName("marcar");
		
		ImageIcon imagenIzquier = new ImageIcon("img/marcarPaginaIzq.jpg");
		imagenIzquierda = new JLabel(imagenIzquier);
		imagenIzquierda.setBounds(0, 0, 665, 415);
		imagenIzquierda.setMinimumSize(new Dimension(612, 419));
		imagenIzquierda.setMaximumSize(new Dimension(612, 419));
		imagenIzquierda.setName("izq");
		
		JPanel panelBotones = new JPanel();
		panelBotones.setBounds(0, 22, 73, 415);
		panelBotones.setBackground(Color.BLACK);
		panelBotones.setMinimumSize(new Dimension(70, 10));
		panelBotones.setMaximumSize(new Dimension(70, 32767));
		add(panelBotones);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		
		retrocederPaginax10 = new JButton("20");
		retrocederPaginax10.setName("-20");
		retrocederPaginax10.setToolTipText("Rereocede diez paginas\r\n");
		retrocederPaginax10.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		retrocederPaginax10.setMinimumSize(new Dimension(90, 20));
		retrocederPaginax10.setMaximumSize(new Dimension(90, 40));
		panelBotones.add(retrocederPaginax10);
		
		retrocederPagina = new JButton("");
		retrocederPagina.setName("-2");
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
		irPaginaMarcada.setName("0");
		irPaginaMarcada.setToolTipText("ir a pagina marcada");
		irPaginaMarcada.setMinimumSize(new Dimension(90, 20));
		irPaginaMarcada.setMaximumSize(new Dimension(90, 40));
		irPaginaMarcada.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		panelBotones.add(irPaginaMarcada);
		
		avanzarPagina = new JButton("");
		avanzarPagina.setName("2");
		avanzarPagina.setToolTipText("avanzar pagina");
		avanzarPagina.setMinimumSize(new Dimension(90, 20));
		avanzarPagina.setMaximumSize(new Dimension(90, 40));
		avanzarPagina.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		panelBotones.add(avanzarPagina);
		
		avanzarPaginax10 = new JButton("20");
		avanzarPaginax10.setName("20");
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
		
		btnLeeParaMi = new JButton("");
		btnLeeParaMi.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/webkit/prism/resources/mediaMuteDisabled.png")));
		btnLeeParaMi.setToolTipText("avanzar diez paginas");
		btnLeeParaMi.setName("20");
		btnLeeParaMi.setMinimumSize(new Dimension(90, 20));
		btnLeeParaMi.setMaximumSize(new Dimension(90, 40));
		panelBotones.add(btnLeeParaMi);
		
		salir = new JButton("");
		salir.setMinimumSize(new Dimension(90, 9));
		salir.setToolTipText("volver a menu principal");
		salir.setMaximumSize(new Dimension(90, 40));
		salir.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		panelBotones.add(salir);
		
		numeroPaginaIzq = new JLabel("1");
		numeroPaginaIzq.setBounds(140, 386, 34, 22);
		add(numeroPaginaIzq);
		numeroPaginaIzq.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPaginaIzq.setForeground(Color.BLACK);
		numeroPaginaIzq.setFont(new Font("Tahoma", Font.BOLD, 12));
		
		numeroPaginaDer = new JLabel("2");
		numeroPaginaDer.setBounds(638, 386, 34, 22);
		add(numeroPaginaDer);
		numeroPaginaDer.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPaginaDer.setFont(new Font("Tahoma", Font.BOLD, 12));
		numeroPaginaDer.setForeground(Color.BLACK);
		
		numeroPaginaCuandoMarcada = new JLabel("4");
		numeroPaginaCuandoMarcada.setVisible(false);
		
		numeroPaginaMarcadaIzq = new JLabel("0");
		numeroPaginaMarcadaIzq.setVisible(false);
		numeroPaginaMarcadaIzq.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPaginaMarcadaIzq.setForeground(Color.BLACK);
		numeroPaginaMarcadaIzq.setFont(new Font("Tahoma", Font.BOLD, 12));
		numeroPaginaMarcadaIzq.setBounds(140, 386, 34, 22);
		add(numeroPaginaMarcadaIzq);
		numeroPaginaCuandoMarcada.setHorizontalAlignment(SwingConstants.CENTER);
		numeroPaginaCuandoMarcada.setForeground(Color.BLACK);
		numeroPaginaCuandoMarcada.setFont(new Font("Tahoma", Font.BOLD, 12));
		numeroPaginaCuandoMarcada.setBounds(638, 386, 34, 22);
		add(numeroPaginaCuandoMarcada);
		
		textPaneLeft = new JTextPane();
		textPaneLeft.setOpaque(false);
		textPaneLeft.setBounds(156, 61, 240, 322);
		textPaneLeft.setText("si lees esto algo va mal");
		add(textPaneLeft);
		
		textPaneDer = new JTextPane();
		textPaneDer.setText("Habia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuego Habia una vez un enano con un anillo El maldito Habia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuegoHabia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuegoHabia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuegoHabia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuegoHabia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuegoHabia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuegoHabia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuego enano va a tardar 2000 paginas en tirarlo al fuego Habia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuego Habia una vez un enano con un anillo El maldito enano va a tardar 2000 paginas en tirarlo al fuego");
		textPaneDer.setOpaque(false);
		textPaneDer.setBounds(424, 61, 240, 322);
		add(textPaneDer);
		
		panelImagen = new JPanel();
		panelImagen.setBounds(73, 22, 665, 415);
		panelImagen.setBackground(Color.BLACK);
		add(panelImagen);
		panelImagen.setLayout(null);
		imagenNormal = new JLabel(imagen);
		imagenNormal.setBounds(0, 0, 665, 415);
		imagenNormal.setName("normal");
		imagenNormal.setMinimumSize(new Dimension(612, 419));
		imagenNormal.setMaximumSize(new Dimension(612, 419));
		panelImagen.add(imagenNormal);
		imagenNormal.setName("marcar");
		
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
	public JButton getBotonMusica() {
		return botonMusica;
	}
	public JLabel getNumeroPaginaDer() {
		return numeroPaginaDer;
	}
	public JLabel getNumeroPaginaIzq() {
		return numeroPaginaIzq;
	}
	public JTextPane getTextPaneLeft() {
		return textPaneLeft;
	}
	public JTextPane getTextPaneDer() {
		return textPaneDer;
	}
	public JLabel getNumeroPaginaCuandoMarcada() {
		return numeroPaginaCuandoMarcada;
	}
	public void setNumeroPaginaCuandoMarcada(JLabel numeroPaginaCuandoMarcada) {
		this.numeroPaginaCuandoMarcada = numeroPaginaCuandoMarcada;
	}
	public JLabel getImagenIzquierda() {
		return imagenIzquierda;
	}
	public JLabel getNumeroPaginaMarcadaIzq() {
		return numeroPaginaMarcadaIzq;
	}
	public JButton getBtnLeeParaMi() {
		return btnLeeParaMi;
	}
	
}
