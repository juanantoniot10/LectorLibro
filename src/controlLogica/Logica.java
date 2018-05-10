package controlLogica;

import javax.swing.ImageIcon;

public class Logica {
	private ImageIcon imagenLibroNormal;
	
	public Logica() {
		super();
		this.imagenLibroNormal = generarImagen();
	}

	private ImageIcon generarImagen() {
		return new ImageIcon("img/libroNormal.jpg");
	}

	public ImageIcon getImagenMarcarPagina() {
		return new ImageIcon("img/marcarPagina.jpg");
	}

	public ImageIcon getImagenLibroPlay() {
		return this.imagenLibroNormal;
	}
}
