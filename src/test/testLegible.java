package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import modelo.Legible;
import modelo.Libro;

class testLegible {
	Legible instancia;
	
	@Before
	public void setUp() {
		instancia = new Libro();
	}
	
	@Test
	void testAvanzarPagina() {
		int paginaActual = ((Libro)instancia).getActual();
		instancia.avanzarPagina();
		assertEquals(paginaActual+1, ((Libro)instancia).getActual());
		//nos queda probar que la ultima no deja avanzar
	}

//	@Test
	void testRetrocederPagina() {
		fail("Not yet implemented");
	}

//	@Test
	void testMarcarPagina() {
		fail("Not yet implemented");
	}

//	@Test
	void testIrAPAgina() {
		fail("Not yet implemented");
	}

}
