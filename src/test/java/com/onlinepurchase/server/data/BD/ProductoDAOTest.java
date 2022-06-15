package com.onlinepurchase.server.data.BD;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import javax.jdo.PersistenceManager;
import javax.jdo.Transaction;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.onlinepurchase.server.data.classes.Producto;
import org.mockito.junit.MockitoJUnitRunner;

public class ProductoDAOTest {
	PersistenceManager pm;
	Transaction tx;
	ProductoDAO productoDAO;
	private Producto producto;
	private ArrayList<Producto> productos;
	private ArrayList<Producto> productosVacio;
	
	@Before
	public void setUp() {
		
		productoDAO= ProductoDAO.getInstance();
		tx = org.mockito.Mockito.mock(Transaction.class);
		pm = org.mockito.Mockito.mock(PersistenceManager.class);

		productoDAO.setPM(pm);
		productoDAO.setTransaction(tx);
		producto = new Producto("Gominolas",2,1);
    	
		productos = new ArrayList<>();
		productosVacio = new ArrayList<>();
		productos.add(producto);
		
	}
	
	@Test
	public void testSave() {
		when(pm.makePersistent(producto)).thenReturn(producto);
		when(tx.isActive()).thenReturn(true);
		assertTrue(productoDAO.save(producto));
	}

	@Test
	public void testDelete() {
		assertTrue(productoDAO.delete(producto));
	}

	@Test
	public void testGetAll() {
		assertEquals(productosVacio, productoDAO.getAll());
	}

	@Test
	@Ignore
	public void testFind() {
		when(productoDAO.find("parametro")).thenReturn(producto);
		
		assertEquals(producto, productoDAO.find("parametro"));
	}

}
