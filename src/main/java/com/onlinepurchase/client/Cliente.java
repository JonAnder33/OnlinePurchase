package com.onlinepurchase.client;

import java.util.List;

import com.onlinepurchase.server.data.classes.Producto;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class Cliente {
    Client client;
    WebTarget webTarget;
    public Cliente(String hostname, String port) {
        this.client = ClientBuilder.newClient();
        this.webTarget = client.target(String.format("http://%s:%s/onlinepurchase", hostname, port));
    }
    
    public boolean addProducto(Producto producto) {

        WebTarget productosWebTarget = webTarget.path("/myresource/producto");
        Invocation.Builder invocationBuilder = productosWebTarget.request(MediaType.APPLICATION_JSON);

        Response response = invocationBuilder.post(Entity.entity(producto, MediaType.APPLICATION_JSON));

        if (response.getStatus() != Response.Status.OK.getStatusCode()) {
            System.out.println("No se pudieron obtener los productos");
            System.out.println("Path: " + webTarget.getUri() + " / Estado: " + response.getStatus());
        } else {
            System.out.println("Se han obtenido los productos");
        }
        return true;
    }    


}
