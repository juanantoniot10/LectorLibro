package controlLogica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import utiles.Constantes;

public class Logica {
	private ImageIcon imagenLibroNormal;
	private String palabraPartidaFinal="";
	
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

	public String obtenerTexto(int numeroPagina,File ruta) {
		if (ruta.exists()) {
			try {
				palabraPartidaFinal = "";
				return generarPagina(ruta,numeroPagina);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "no he podido leer la pagina lo siento soy mu tonto";
	}

	/**
	 * @param ruta
	 * @param numeroPagina 
	 * @return
	 * @throws IOException
	 */
	private String generarPagina(File ruta, int numeroPagina) throws IOException {
		FileReader flujoR = new FileReader(ruta);
		char[] letras = null;
		for (int i = 0; i < numeroPagina+1; i++) {
			letras = new char[Constantes.CARACTERESPAGINA];
			flujoR.read(letras);
			if(i==numeroPagina-1) {
				if(comprobarPalabraFinalRota(letras)) {
					obtenerPalabraPerdida(letras);
				}
			}
		}
		flujoR.close();
		if(palabraPartidaFinal!="")return palabraPartidaFinal+new String(letras);
		else if (comprobarPalabraFinalRota(letras)) {
			return borrarPalabraPartida(letras);
		}
		else return new String(letras);
	}

	private String borrarPalabraPartida(char[] letras) {
		return new String(letras).substring(0, new String (letras).lastIndexOf(' '));
	}

	/**
	 * @param letras
	 * @return
	 */
	private boolean comprobarPalabraFinalRota(char[] letras) {
		return letras[letras.length-1]!='.'&&letras[letras.length-1]!=' '&&letras[letras.length-1]!='\n' && letras[letras.length-1]!='\r';
	}

	private void obtenerPalabraPerdida(char[] letras) {
		String aux = new String(letras);
		this.palabraPartidaFinal = new String (aux.substring(aux.lastIndexOf(' ')));
	}

	public String extraerTitulo(String nameBoton) {
		return nameBoton.substring(nameBoton.lastIndexOf("\\")+1,nameBoton.lastIndexOf("."));
	}
	
	
}
