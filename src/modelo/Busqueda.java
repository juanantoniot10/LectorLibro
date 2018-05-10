package modelo;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Busqueda{
	private String busqueda;
	private ArrayList<String> resultados;
	
	public Busqueda(String busqueda, String ruta) throws IOException {
		super();
		this.busqueda = busqueda;
		this.resultados = new ArrayList<>();
		ejecutarBusqueda(new File(ruta));
	}

	private void ejecutarBusqueda(File elemento) {
		if(elemento.isDirectory()) {
//			String[] lista = elemento.list();
			File[] listFiles = elemento.listFiles();
			for (int i = 0; i < listFiles.length; i++) {
				if (listFiles[i].isDirectory()) {
					ejecutarBusqueda(listFiles[i]);
				}
				else {
					try {
						if(String.valueOf(listFiles[i].getCanonicalFile()).contains((CharSequence) busqueda)) {
							this.resultados.add(String.valueOf(listFiles[i].getCanonicalFile()));
							System.out.println("encontrado");
						}
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}; 
			}
		}
	}

	public ArrayList<String> getResultados() {
		return resultados;
	}
	
}
