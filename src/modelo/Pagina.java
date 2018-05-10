package modelo;

public class Pagina {
	private long primero;
	private long ultimo;
	
	public Pagina(long primero, long ultimo) {
		super();
		this.primero = primero;
		this.ultimo = ultimo;
	}
	
	public long getPrimero() {
		return primero;
	}
	public void setPrimero(long primero) {
		this.primero = primero;
	}
	public long getUltimo() {
		return ultimo;
	}
	public void setUltimo(long ultimo) {
		this.ultimo = ultimo;
	}
	
	
}
