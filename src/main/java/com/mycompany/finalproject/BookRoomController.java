/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.finalproject;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Anmol Saru
 */
public class BookRoomController implements Initializable, IExitable, IValidationAlert, ISuccessAlert {
    //creating Rooms class arraylist object
    ArrayList<BookRoom> bRList = new ArrayList<BookRoom>();
    
    //creating Rooms class object
    BookRoomList brList = new BookRoomList();
    
    
    //creating RoomList object
    RoomsList rList = new RoomsList();
    //creating arraylist for rooms
    ArrayList<Rooms> roomsList = new ArrayList<Rooms>();
    
    
    //initalizing FXMLs
    @FXML
    private DatePicker checkIn;

    @FXML
    private DatePicker checkOut;

    @FXML
    private TextField roomId;
    
    
    @FXML
    private TextField name;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            //reading dataing and stoting it in arraylist
            roomsList = rList.readRoomsDataFromFile();
            
            
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    //exits program
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
    //shows message for already booked rooms
    private void booked() throws IOException
    {
        this.showValidationAlert("Room is already booked");
        App.setRoot("UserMainMenu");
    }
    //book button
    @FXML
private void bookBtn() throws IOException {
    int rId = 0;

    try {
        rId = Integer.parseInt(roomId.getText());
    } catch (NumberFormatException e) {
        showValidationAlert("Invalid room ID");
        return;
    }
    //parsing data to a variable
    int rmId = rId;
    LocalDate cIn = checkIn.getValue();
            String chIn = cIn.toString();

            LocalDate cOut = checkOut.getValue();
            String chOut = cOut.toString();
            
            String uN = name.getText();
            
    Rooms ee = null;
    //using for loop to check if entered room id is valid
    for (Rooms r : roomsList) {
        if (r.getRoomId() == rId) {      
            ee = r;   
            break;
        }   
    }
    //if room Id doesnot exist displays error message
    if (ee == null) {
        showValidationAlert(" Please enter correct roomId or room that is not sold");
        } 
    //if room is booked displays message
        if(ee.isIsSold())
        {
            booked();
            
        }
        
           //Calling BookRoom constructor
            BookRoom brObj = new BookRoom(rmId, chIn, chOut, uN);
            //bookRoom arraylist
            bRList.add(brObj);

            // Update Rooms object
            ee.setIsSold(true);

            // Write updated data to file
            
            brList.writeBookRoomDataToFile(bRList);

            success();
            App.setRoot("UserMainMenu");
            
    
}
    //method that calls interface to display sucessfull message
    @FXML
    private void success()
    {
        String successMessage = "Operation completed successfully.";
        showSuccessAlert(successMessage);
    }
    //displayes previous gui
    @FXML 
    private void back() throws IOException
    {
        App.setRoot("UserMainMenu");
    }
    //display every sucessfu;; acrtion method
     @FXML
    private void showS() {
        // Perform some action
        String successMessage = "Operation completed successfully.";
        showSuccessAlert(successMessage);
    }
}
