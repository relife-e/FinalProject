/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.finalproject;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anmol Saru
 */
public class ViewRoomAdminController implements Initializable , IExitable, ISuccessAlert, IValidationAlert {
    
    //creating Rooms class arraylist object
    ArrayList<Rooms> roomList = new ArrayList<>();
    
    //creating Rooms class object
    RoomsList rList = new RoomsList();
    
    @FXML
    private TextArea resultId;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            //reading  data for sale file
            roomList = rList.readRoomsDataFromFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    //Dispalyes all the room
@FXML
    private void searchBtn()
    {
        for(Rooms r: roomList)
        {   
            
            resultId.appendText("Room Id: " + r.getRoomId() + "\nRoom Num: " + r.getRoomNum() + "\nNum Bed: " + r.getNumBed() + "\nAddress: " + r.getAddress() + "\n\n");
            
        }
        success();
    }
    //method that calls interface to display sucessfull message
    
    private void success()
    {
        String successMessage = "Operation completed successfully.";
        showSuccessAlert(successMessage);
    }
    @FXML 
    private void back() throws IOException
    {
        App.setRoot("AdminMainWindow");
    }
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
}
