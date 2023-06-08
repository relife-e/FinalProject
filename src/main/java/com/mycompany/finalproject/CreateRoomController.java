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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anmol Saru
 */
public class CreateRoomController implements Initializable, IExitable, ISuccessAlert, IValidationAlert {
    //arraylist object for rooms class
    private ArrayList<Rooms> roomList = new ArrayList<Rooms>();
    //creating RoomList object
    private RoomsList rList = new RoomsList();
    //Initalizing FXMLs id
    @FXML
    private TextField add;
    
    @FXML
    private TextField numBed;
    
    @FXML
    private TextField roomId;
            
    @FXML
    private TextField roomNum;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    //exits program
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
    //defining apply button action
    @FXML
    private void apply(ActionEvent action) throws IOException
    {   
        try {
            //parsing all the values to suitable data type of variables
            String address = add.getText();
            int rId = Integer.parseInt(roomId.getText());
            int rN = Integer.parseInt(roomNum.getText());
            int nB = Integer.parseInt(numBed.getText());
            
            RoomsList rList = new RoomsList();
            //calling rooms constructor
            Rooms r = new Rooms(rId,nB,address,rN);
            //adding all the values to roomsList
            roomList.add(r);
            //writing data to Room file
            rList.writeRoomsDataToFile(roomList);
            showS();
            App.setRoot("AdminMainWindow");
            
            
        } catch (NumberFormatException e) {
            showValidationAlert("Enter correct value");
        }
    }
    
    //method that helps user to display the CQRealEstate
    @FXML
    private void backBtn() throws IOException
    {
        App.setRoot("AdminMainWindow");
    }
    //display every sucessfu;; acrtion method
     @FXML
    private void showS() {
        // Perform some action
        String successMessage = "Operation completed successfully.";
        showSuccessAlert(successMessage);
    }
}
