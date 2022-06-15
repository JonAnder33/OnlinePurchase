package com.onlinepurchase.client.controller;



import static org.mockito.ArgumentMatchers.floatThat;

import com.onlinepurchase.client.App;
import com.onlinepurchase.server.data.classes.Producto;

import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AgregarProductoController {
	/** TextFields **/
    @FXML
    private TextField nombre;
    @FXML
    private TextField precio;
   
    /** DatePickers **/
    @FXML
    private TextField peso;

    @FXML
    void onAgregarButtonClick() {
    	Producto p = new Producto(nombre.getText(), Float.parseFloat(precio.getText()) , Float.parseFloat(peso.getText()) );

        App.cliente.addProducto(p);
    	System.out.println(nombre.getText() + " registrado correctamente!");
    }

    @FXML
    void onHomeButtonClick() {
        App.initRootLayout(getClass().getResource("MainWindow.fxml"));
    }

}
