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
    
    LoginUserController luC = new LoginUserController();
    
    RoomsList rList = new RoomsList();
    ArrayList<Rooms> roomsList = new ArrayList<Rooms>();
    
    
    
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
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
    @FXML
private void bookBtn() throws IOException {
    int rId = 0;

    try {
        rId = Integer.parseInt(roomId.getText());
    } catch (NumberFormatException e) {
        showValidationAlert("Invalid room ID");
        return;
    }

    Rooms ee = null;

    for (Rooms r : roomsList) {
        if (r.getRoomId() == rId && r.isIsSold() != true) {
            int rmId = rId;
            ee = r;
            LocalDate cIn = checkIn.getValue();
            String chIn = cIn.toString();

            LocalDate cOut = checkOut.getValue();
            String chOut = cOut.toString();
            
            String uN = name.getText();
           
            BookRoom brObj = new BookRoom(rmId, chIn, chOut, uN);
            bRList.add(brObj);

            // Update Rooms object
            r.setIsSold(true);

            // Write updated data to file
            
            brList.writeBookRoomDataToFile(bRList);

            success();
            App.setRoot("UserMainMenu");
            return;
        }
        
    }
    if (ee == null) {
        } else {
        
            showValidationAlert("Cannot Book. Please enter correct roomId or room that is not sold");
        }
}
    //method that calls interface to display sucessfull message
    @FXML
    private void success()
    {
        String successMessage = "Operation completed successfully.";
        showSuccessAlert(successMessage);
    }
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
