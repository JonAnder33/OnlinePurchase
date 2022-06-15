package com.onlinepurchase.client.controller;


import com.onlinepurchase.client.App;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AppController {
    @FXML
    private Label onlinePurchaseLabel;

    @FXML
    protected void onOnlinePurchaseButtonClick() {
    	App a1 = new App();
    	a1.initRootLayout(getClass().getResource("MainWindow.fxml")); 
    	}
    
 
}
