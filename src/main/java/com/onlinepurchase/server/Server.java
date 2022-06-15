package com.onlinepurchase.server;



import com.onlinepurchase.server.data.classes.Producto;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("myresource")
public class Server {
	private ProductoCollector productoCollector;
	public Server() {

		productoCollector = new ProductoCollector();
		
	}
	public Server(ProductoCollector productoCollectort) {
		productoCollector= productoCollectort;
	}
	
//	@POST
//	@Path("/coches")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response anadirCoche(Coche coche) {
//		System.out.println("Coche recibido");
//		System.out.println("Nuevo coche" + coche);
//		cocheCollector.addCoche(coche);
//		return Response.ok(coche.getMatricula()).build();
//	}

	@POST
	@Path("/producto")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response anadirProducto(Producto p) {
		System.out.println("Producto recibido");
		System.out.println("Nuevo producto" + p);
		productoCollector.addProducto(p);
		return Response.ok(p.getNombre()).build();
	}



//falta

}