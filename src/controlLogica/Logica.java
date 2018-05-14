package controlLogica;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.ImageIcon;
import utiles.Constantes;

public class Logica {
	private ImageIcon imagenLibroNormal;
	private File ruta;
	private int paginaMarcada = -1;
	private File rutaMarca;
	

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

	public String obtenerTexto(int numeroPagina) {
		if (ruta.exists()) {
			try {
				return generarPagina(numeroPagina);
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
	private String generarPagina(int numeroPagina) throws IOException {
		FileReader flujoR = new FileReader(ruta);
		char[] letras = null;
		for (int i = 0; i < numeroPagina; i++) {
			letras = new char[Constantes.CARACTERESPAGINA];
			flujoR.read(letras);
		}
		flujoR.close();
		return ponerSaltoDeLineaEnTitulo(reemplazarSaltosDeLinea(generearPaginaSegunPalabraPartida(letras)));
	}

	private String ponerSaltoDeLineaEnTitulo(String reemplazarSaltosDeLinea) {
		int contadorMayusculas =0;
		int masDeDosEspacios=0;
		for (int i = 0; i < reemplazarSaltosDeLinea.length(); i++) {
			if(Character.isUpperCase((char)reemplazarSaltosDeLinea.charAt(i))&&masDeDosEspacios>1){
				contadorMayusculas++;
			}
			else if (!Character.isAlphabetic((char)reemplazarSaltosDeLinea.charAt(i))) {
				masDeDosEspacios++;
			}
			else if(contadorMayusculas>2 && masDeDosEspacios > 1) {
				reemplazarSaltosDeLinea = new String(aniadirSaltoEn(i-2,reemplazarSaltosDeLinea));
				contadorMayusculas=0;
				masDeDosEspacios =0;
			}
			else {
				contadorMayusculas = 0;
				masDeDosEspacios = 0;
			}
		}
		return reemplazarSaltosDeLinea;
	}

	private String aniadirSaltoEn(int i, String reemplazarSaltosDeLinea) {
		String aux = new String(reemplazarSaltosDeLinea);
		String division= new String(aux.substring(0, i)+"\n");
		return new String(division+reemplazarSaltosDeLinea.substring(i+1));
	}

	private String reemplazarSaltosDeLinea(String generearPaginaSegunPalabraPartida) {
		return new String(generearPaginaSegunPalabraPartida.replaceAll("\r", "").replaceAll("\n", " "));
	}

	/**
	 * @param letras
	 * @return
	 */
	private String generearPaginaSegunPalabraPartida(char[] letras) {
		return new String(new String(letras));
	}


	public String extraerTitulo(String nameBoton) {
		return nameBoton.substring(nameBoton.lastIndexOf("\\")+1,nameBoton.lastIndexOf("."));
	}

	public void setRuta(File ruta) {
		this.ruta = ruta;
	}

	public int getPaginaMarcada() {
		return paginaMarcada;
	}
	public File getRutaMarca() {
		return rutaMarca;
	}

	public void setRutaMarca(File rutaMarca) {
		this.rutaMarca = rutaMarca;
	}

	public File getRuta() {
		return ruta;
	}

	public void setPaginaMarcada(int paginaMarcada) {
		this.paginaMarcada = paginaMarcada;
		if(rutaMarca.exists()) {
			try {
				FileWriter flujoR = new FileWriter(rutaMarca);
				flujoR.write(paginaMarcada);
				flujoR.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				rutaMarca.createNewFile();
				FileWriter flujoR = new FileWriter(rutaMarca);
				flujoR.write(paginaMarcada);
				flujoR.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
