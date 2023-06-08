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
    //ArrayList object for BookRoom
    ArrayList<BookRoom> bookrList = new ArrayList<>();
    //BookRoomList object
    BookRoomList brList = new BookRoomList();
    
    //LoginUserController object
    LoginUserController userL = new LoginUserController();
    
    //initializing the text field
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
    //Search button that search all the booking 
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
        //for loop that iterates the number of bookrList size or until room id matches
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
        //validating for wrong room id enterd by user
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
    //dispalyes previous GUI
    @FXML 
    private void back() throws IOException
    {
        App.setRoot("UserMainMenu");
    }
    //Exits the application
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
}
