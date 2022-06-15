package com.onlinepurchase.server.data.BD;

import java.util.ArrayList;
import java.util.List;
import javax.jdo.*;



import com.onlinepurchase.server.data.classes.Producto;



public class ProductoDAO implements IDataAccessObject <Producto> {


		private static ProductoDAO instance;
		private PersistenceManager pm = null;
		private PersistenceManagerFactory pmf = null;
		private Transaction tx = null;
		
		private ProductoDAO() { }
		
		public static ProductoDAO getInstance() {
			if (instance == null) {
				instance = new ProductoDAO();
			}		
			
			return instance;
		}

		public void setPM(PersistenceManager pm) {
			this.pm = pm;
		}

		public void setTransaction(Transaction tx) {
			this.tx = tx;
		}

		@Override
		public boolean save(Producto object) {
			boolean result;

			try {
				tx.begin();
				pm.makePersistent(object);
				tx.commit();
				result=true;
			} catch (Exception ex) {
				System.out.println(" $ Error storing a product: " + ex.getMessage());
				result=false;
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

				pm.close();
			}
			return result;
		}

		@Override
		public boolean delete(Producto object) {
			return true;
		}

		@Override
		public List<Producto> getAll() {
			
			List<Producto> productos = new ArrayList<>();

			try {
				tx.begin();
				
				Extent<Producto> retExtent = pm.getExtent(Producto.class, true);
				
				for (Producto p : retExtent) {
					productos.add(p);
				}
							
				tx.commit();
				System.out.println("Lista de productos: " + productos);
			} catch (Exception ex) {
				System.out.println("  $ Error querying all products: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

				pm.close();
			}

			return productos;
		}

		@Override
		public Producto find(String param) {		
			PersistenceManager pm = pmf.getPersistenceManager();
			Transaction tx = pm.currentTransaction();

			Producto result = null; 

			try {
				tx.begin();
				
				Query<?> query = pm.newQuery("SELECT FROM " + Producto.class.getName() + " WHERE nombre == '" + param + "'");
				query.setUnique(true);
				result = (Producto) query.execute();
				
				tx.commit();
			} catch (Exception ex) {
				System.out.println("  $ Error querying a product: " + ex.getMessage());
			} finally {
				if (tx != null && tx.isActive()) {
					tx.rollback();
				}

				pm.close();
			}

			return result;
		}
}
