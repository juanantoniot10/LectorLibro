package modelo;

import java.util.ArrayList;

public class Libro implements Legible{
	private String lectura;
	private int actual=0;
	private int marca=0;
	private ArrayList<Pagina> paginas;
	public Libro() {
		super();
		lectura = "ruta al archivo";
		paginas = new ArrayList<Pagina>();
	}
	@Override
	public void avanzarPagina() {
		if(!comprobarUltimaPagina()) {
			if(cargarSiguientePagina());
			actual++;
		}
	}
	private boolean cargarSiguientePagina() {
		// TODO Auto-generated method stub
		return true;
	}
	private boolean comprobarUltimaPagina() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void retrocederPagina() {
		// TODO Auto-generated method stub
	}
	@Override
	public void marcarPagina() {
		// TODO Auto-generated method stub
	}
	@Override
	public void irAPAgina() {
		// TODO Auto-generated method stub
	}
	public String getLectura() {
		return lectura;
	}
	public int getActual() {
		return actual;
	}
	public int getMarca() {
		return marca;
	}
	public ArrayList<Pagina> getPaginas() {
		return paginas;
	} 	
}
