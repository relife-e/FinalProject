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

/**
 * FXML Controller class
 *
 * @author Anmol Saru
 */
public class UserMenuController implements Initializable, IExitable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    private void lgoinBtn()
    {
        try {
            App.setRoot("LoginUser");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //Allows user to create account 
    @FXML
    private void createAc() throws IOException
    {
        App.setRoot("RegisterUser");
    }
    //Displayes previous GUI
     @FXML 
    private void back() throws IOException
    {
        App.setRoot("MainWindow");
    }
    //Exits program
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
}
