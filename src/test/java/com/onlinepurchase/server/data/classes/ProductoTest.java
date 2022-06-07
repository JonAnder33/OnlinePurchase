package com.onlinepurchase.server.data.classes;

import static org.junit.Assert.*;

import org.junit.Test;

public class ProductoTest {

	private Producto p1 = new Producto("Gominolas",2,1);
	@Test
	public void testGetNombre() {
		p1.getNombre();
	}

	@Test
	public void testSetNombre() {
		p1.setNombre("Saco De Patatas");
	}

	@Test
	public void testGetPrecio() {
		p1.getPrecio();
	}

	@Test
	public void testSetPrecio() {
		p1.setPrecio(100);
	}

	@Test
	public void testGetPeso() {
		p1.getPeso();
	}

	@Test
	public void testSetPeso() {
		p1.setPeso(10);
	}

	@Test
	public void testProductoStringFloatFloat() {
		Producto p2= new Producto("Patatas",3,3);
	}

	@Test
	public void testProducto() {
		Producto p3 = new Producto();
	}

	@Test
	public void testToString() {
		p1.toString();
	}

}
