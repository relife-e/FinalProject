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
public class AdminMainWindowController implements Initializable, IExitable, IValidationAlert {

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void viewRoomBtn() throws IOException
    {
        App.setRoot("ViewRoom");
    }
    
    @FXML
    private void createBtn() throws IOException
    {
        App.setRoot("CreateRoom");
    }
    @FXML
    private void backBtn() throws IOException
    {
        App.setRoot("AdminWindow");
    }
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
}
