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
public class RegisterUserController implements Initializable, IExitable, ISuccessAlert, IValidationAlert {
    
      //UserList object
    private UserList uList = new UserList();
    
    //creating user arraylist
    private ArrayList<User> userList = new ArrayList<User>();
    
    @FXML
    private TextField passId;

    @FXML
    private TextField userN;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        //method that helps to exit
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
            String uName = userN.getText();
            String passW = passId.getText();
            
            //creating LandList object
            UserList uList = new UserList();
            //calling land constructor
            User userObj = new User(uName, passW);
            //adding all the values to landList
            userList.add(userObj);
            //writing data to land file
            uList.writeUserDataToFile(userList);
            showS();
            App.setRoot("UserMenu");
        } catch (NumberFormatException e) {
            showValidationAlert("Enter correct value");
        }
    }
    
    //method that helps user to display the CQRealEstate
    @FXML
    private void backBtn() throws IOException
    {
        App.setRoot("UserMenuWindow");
    }
    //display every sucessfu;; acrtion method
     @FXML
    private void showS() {
        // Perform some action
        String successMessage = "Operation completed successfully.";
        showSuccessAlert(successMessage);
    }
    
}
