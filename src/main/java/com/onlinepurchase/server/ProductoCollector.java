package com.onlinepurchase.server;

import java.util.ArrayList;

import javax.jdo.JDOHelper;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;

import com.onlinepurchase.server.data.BD.ProductoDAO;
import com.onlinepurchase.server.data.classes.Producto;

public class ProductoCollector {
    public ArrayList<Producto> getProductos() {
        // PM
    	ProductoDAO dao = ProductoDAO.getInstance();
        PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
        PersistenceManager pm = pmf.getPersistenceManager();
        dao.setPM(pm);
        dao.setTransaction(pm.currentTransaction());

        return (ArrayList<Producto>) dao.getAll();
    }

    public ArrayList<Producto> addProducto(Producto p) {
        synchronized (this) {
            // PM
        	ProductoDAO dao = ProductoDAO.getInstance();
            PersistenceManagerFactory pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            PersistenceManager pm = pmf.getPersistenceManager();
            dao.setPM(pm);
            dao.setTransaction(pm.currentTransaction());
            // Save
            dao.save(p);
            // PM
            pmf = JDOHelper.getPersistenceManagerFactory("datanucleus.properties");
            pm = pmf.getPersistenceManager();
            dao.setPM(pm);
            dao.setTransaction(pm.currentTransaction());
            return (ArrayList<Producto>) dao.getAll();
        }
    }
}
