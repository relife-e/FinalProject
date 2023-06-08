/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.finalproject;
//importing libraries
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
    //view room button that views the rooom
    @FXML
    private void viewRoomBtn() throws IOException
    {
        App.setRoot("ViewRoomAdmin");
    }
    //create button that allows admin to create room
    @FXML
    private void createBtn() throws IOException
    {
        App.setRoot("CreateRoom");
    }
    //shows previous GUI
    @FXML
    private void backBtn() throws IOException
    {
        App.setRoot("AdminWindow");
    }
    //exits application
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
}
