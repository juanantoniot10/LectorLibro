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
	private JLabel lablelImagen;
	public PanelLectura() {
		setLayout(new BorderLayout(0, 0));
		
		tituloLibro = new JLabel("Titulo Libro");
		tituloLibro.setHorizontalAlignment(SwingConstants.CENTER);
		tituloLibro.setFont(new Font("Harrington", Font.BOLD, 18));
		add(tituloLibro, BorderLayout.NORTH);
		
		panelImagen = new JPanel();
		add(panelImagen, BorderLayout.CENTER);
		
		ImageIcon imagen = new ImageIcon("img/paginaNormal.jpg");
		JLabel labelImagen = new JLabel(imagen);
		labelImagen.setMinimumSize(new Dimension(200, 200));
		labelImagen.setMaximumSize(new Dimension(1000, 700));
		panelImagen.add(labelImagen);
		
		JPanel panelBotones = new JPanel();
		panelBotones.setMaximumSize(new Dimension(70, 32767));
		add(panelBotones, BorderLayout.WEST);
		panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		
		retrocederPaginax10 = new JButton("X10");
		retrocederPaginax10.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		retrocederPaginax10.setMinimumSize(new Dimension(30, 20));
		retrocederPaginax10.setMaximumSize(new Dimension(70, 40));
		panelBotones.add(retrocederPaginax10);
		
		retrocederPagina = new JButton("");
		retrocederPagina.setMaximumSize(new Dimension(70, 40));
		retrocederPagina.setMinimumSize(new Dimension(30, 20));
		retrocederPagina.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/DecreaseIndent_16x16_JFX.png")));
		panelBotones.add(retrocederPagina);
		
		marcarPagina = new JButton("");
		marcarPagina.setMinimumSize(new Dimension(33, 20));
		marcarPagina.setMaximumSize(new Dimension(70, 40));
		marcarPagina.setIcon(new ImageIcon(PanelLectura.class.getResource("/sun/print/resources/oneside.png")));
		panelBotones.add(marcarPagina);
		
		irPaginaMarcada = new JButton("");
		irPaginaMarcada.setMinimumSize(new Dimension(33, 20));
		irPaginaMarcada.setMaximumSize(new Dimension(70, 40));
		irPaginaMarcada.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/control/skin/caspian/images/capslock-icon.png")));
		panelBotones.add(irPaginaMarcada);
		
		avanzarPagina = new JButton("");
		avanzarPagina.setMinimumSize(new Dimension(33, 20));
		avanzarPagina.setMaximumSize(new Dimension(70, 40));
		avanzarPagina.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		panelBotones.add(avanzarPagina);
		
		avanzarPaginax10 = new JButton("X10");
		avanzarPaginax10.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/IncreaseIndent_16x16_JFX.png")));
		avanzarPaginax10.setMinimumSize(new Dimension(33, 20));
		avanzarPaginax10.setMaximumSize(new Dimension(70, 40));
		panelBotones.add(avanzarPaginax10);
		
		salir = new JButton("");
		salir.setMaximumSize(new Dimension(70, 40));
		salir.setIcon(new ImageIcon(PanelLectura.class.getResource("/com/sun/javafx/scene/web/skin/Undo_16x16_JFX.png")));
		panelBotones.add(salir);
	}
	public JLabel getTituloLibro() {
		return tituloLibro;
	}
	public void setTituloLibro(JLabel tituloLibro) {
		this.tituloLibro = tituloLibro;
	}
	public JButton getIrPaginaMarcada() {
		return irPaginaMarcada;
	}
	public void setIrPaginaMarcada(JButton irPaginaMarcada) {
		this.irPaginaMarcada = irPaginaMarcada;
	}
	public JButton getMarcarPagina() {
		return marcarPagina;
	}
	public void setMarcarPagina(JButton marcarPagina) {
		this.marcarPagina = marcarPagina;
	}
	public JButton getRetrocederPagina() {
		return retrocederPagina;
	}
	public void setRetrocederPagina(JButton retrocederPagina) {
		this.retrocederPagina = retrocederPagina;
	}
	public JButton getRetrocederPaginax10() {
		return retrocederPaginax10;
	}
	public void setRetrocederPaginax10(JButton retrocederPaginax10) {
		this.retrocederPaginax10 = retrocederPaginax10;
	}
	public JButton getAvanzarPaginax10() {
		return avanzarPaginax10;
	}
	public void setAvanzarPaginax10(JButton avanzarPaginax10) {
		this.avanzarPaginax10 = avanzarPaginax10;
	}
	public JPanel getPanelImagen() {
		return panelImagen;
	}
	public void setPanelImagen(JPanel panelImagen) {
		this.panelImagen = panelImagen;
	}
	public JButton getAvanzarPagina() {
		return avanzarPagina;
	}
	public void setAvanzarPagina(JButton avanzarPagina) {
		this.avanzarPagina = avanzarPagina;
	}
	public JButton getSalir() {
		return salir;
	}
	public void setSalir(JButton salir) {
		this.salir = salir;
	}
	public JLabel getLablelImagen() {
		return lablelImagen;
	}
	public void setLablelImagen(JLabel lablelImagen) {
		this.lablelImagen = lablelImagen;
	}
	

}
