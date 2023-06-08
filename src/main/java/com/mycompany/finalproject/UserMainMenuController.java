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
public class UserMainMenuController implements Initializable,IExitable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    //method that sends user to choose between houseAndLand and Land
    @FXML
    private void btn1 (ActionEvent event) throws IOException
    {
        App.setRoot("SearchRoom");
    }
    //method that allows user to save the seller details
    @FXML
    private void btn2 (ActionEvent event) throws IOException
    {
        App.setRoot("ViewRoom");
    }
    //method that allows user to save the buyer details
    @FXML
    private void btn3 (ActionEvent event) throws IOException
    {
        App.setRoot("BookRoom");
    }
    //method that allows user to save the sale details
    @FXML
    private void btn4 (ActionEvent event) throws IOException
    {
        App.setRoot("ViewBooking");
    }
    //method that allows user to search sale
    @FXML
    private void btn5 (ActionEvent event) throws IOException
    {
        App.setRoot("UserMenu");
    }
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
}
