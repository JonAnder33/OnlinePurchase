package com.onlinepurchase.server;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.databene.contiperf.PerfTest;
import org.databene.contiperf.Required;
import org.databene.contiperf.junit.ContiPerfRule;
import org.glassfish.grizzly.http.server.HttpServer;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;

import com.onlinepurchase.client.Cliente;
import com.onlinepurchase.server.data.classes.Producto;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.WebTarget;
//@Category(PerformanceTest.class)
@PerfTest(invocations = 5)
@Required(max = 1200, average = 250)
public class ServerPerfTest {


    @Rule public ContiPerfRule rule = new ContiPerfRule();

    private static HttpServer server;
    private static WebTarget target;

    
    private Cliente c;

    @BeforeClass
    public static void setUp() {
        // start the server
        server = ServerManager.startServer();
        // create the client
        
        Client c = ClientBuilder.newClient();

        // uncomment the following line if you want to enable
        // support for JSON in the client (you also have to uncomment
        // dependency on jersey-media-json module in pom.xml and Main.startServer())
        // --
        // c.configuration().enable(new org.glassfish.jersey.media.json.JsonJaxbFeature());

        target = c.target(ServerManager.BASE_URI);
    }
     
    @Before
    public void setUp2() {
    	
    	c = new Cliente("localhost", "8085");
        
    }
    

	
    @Test
    @PerfTest(invocations = 100, threads = 20)
    @Required(max = 30000, average = 10000)
    public void testAddUsuario(){
        Producto producto = new Producto();
        assertTrue(c.addProducto(producto));
    }


}
