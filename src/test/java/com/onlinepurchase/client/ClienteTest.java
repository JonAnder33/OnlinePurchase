package com.onlinepurchase.client;

import static org.junit.Assert.*;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

import com.onlinepurchase.server.data.classes.Producto;



public class ClienteTest {
	Cliente cliente;
    private Producto p;
	@Before
	public void setUp() {
		cliente= org.mockito.Mockito.mock(Cliente.class);
		
		p = new Producto("Gominolas",2,1);
	}
	
	@Test
	public void testAddProducto() {
		when(cliente.addProducto(p)).thenReturn(true);
		
		assertTrue(cliente.addProducto(p));
	}

}
