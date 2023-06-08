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
public class ViewBookingController implements Initializable, IExitable, ISuccessAlert, IValidationAlert {
    
    ArrayList<BookRoom> bookrList = new ArrayList<>();
    BookRoomList brList = new BookRoomList();
    
    LoginUserController userL = new LoginUserController();
    
        @FXML
    private TextField rId;

        @FXML
    private TextField name;

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
            bookrList = brList.readBookRoomDataFromFile();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
    
    @FXML
    private void searchBtn() throws IOException
    {
        int roomId = 0;
        String n = null;
        try {
        roomId = Integer.parseInt(rId.getText());
        n = name.getText();
        }
        catch (NumberFormatException e)
        {
            showValidationAlert("Invalid room ID");
        }
         
        BookRoom ee = null;
        
        for (BookRoom r : bookrList) {
            System.out.println(userL.returnName());
            //validating sale id
            if (r.getRoomId() == roomId && n.equals(r.getUserName())) {
                ee =r;
                success();
                //setting app root to UserMainMenu
                
                resultId.setText("check in date: " + r.getCheckIn() + "\ncheck Out date: " + r.getCheckOut() + "\nroomId: " + r.getRoomId() );
                break;
            }
            
        }
        
        if (ee == null)
        {
            showValidationAlert("No booking found");
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
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
}
