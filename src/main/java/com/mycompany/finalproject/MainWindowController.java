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
public class MainWindowController implements Initializable,IExitable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //Shows admin window
    @FXML
    private void adminBtn() throws IOException
    {
        App.setRoot("adminWindow");
    }
    //Shows user mindow
    @FXML
    private void userBtn() throws IOException
    {
        App.setRoot("userMenu");
    }
        //method that helps to exit
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
    }
