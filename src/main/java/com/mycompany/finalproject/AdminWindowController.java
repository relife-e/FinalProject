/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anmol Saru
 */
public class AdminWindowController implements Initializable, IValidationAlert, IExitable, ISuccessAlert{

    
     /**
     * Initializes the controller class.
     */
    @FXML
    private TextField p;

    @FXML
    private TextField uN;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void login() throws IOException
    {
        String username = uN.getText();
        String passW = p.getText();
        
        if ("anmol".equals(username) && "ASS3".equals(passW))
        {   
            showSuccessAlert("SuccessFull !!!");
            App.setRoot("AdminMainWindow");
            
        }
        else
            showValidationAlert("Enter correct Username and password. ");
    }
    
    @FXML
    private void returnBtn() throws IOException
    {
        App.setRoot("MainWindow");
    }
}

