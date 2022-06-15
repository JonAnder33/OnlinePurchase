package com.onlinepurchase.client;


import java.io.IOException;
import java.net.URL;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Hello world!
 *
 */
public class App extends Application {
    public static Stage primaryStage;
    public static Cliente cliente;
    public static void main( String[] args )
    {
    	launch(args);
    }

	@Override
	public void start(Stage primaryStage) throws Exception {
		cliente = new Cliente("localhost", "8085");

        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("AddressApp");

        initRootLayout(getClass().getResource("ProductosWindow.fxml"));
        }

	    /**
	     * Initializes the root layout.
	     * @param fxml El archivo cargado ya como URL
	     */
	    public static void initRootLayout(URL fxml) {
	        try {
	            // Load root layout from fxml file.
	            FXMLLoader loader = new FXMLLoader();
	            Scene scene = new Scene((Parent) loader.load(fxml));

	            // Show the scene containing the root layout.
	            primaryStage.setScene(scene);
	            primaryStage.show();

	        } catch (IOException e) {
	            System.out.println("Error al iniciar la ventana");
	        }
	    }
}
