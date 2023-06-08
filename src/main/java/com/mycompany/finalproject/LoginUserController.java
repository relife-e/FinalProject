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
public class LoginUserController implements Initializable, IExitable,IValidationAlert, ISuccessAlert {
    private String n;
    //UserList object
    private UserList uList = new UserList();
    
    //creating user arraylist
    private ArrayList<User> userList = new ArrayList<User>();
    @FXML
    private TextField passId;

    @FXML
    private TextField userN;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        try {
            //reading  data for sale file
            userList = uList.readUserDataFromFile();
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }    
        //method that helps to exit
    @FXML
    private void exitButtonClick(ActionEvent event) {
        this.exitClick();
    }
    
    @FXML
    private void loginBtn() throws IOException
    {
        //initializing int variable
            String uName = userN.getText();
        String passW = passId.getText();
        
        
         
        User user = null;
        
        for (User u : userList) {
            //validating sale id
            if ((u.getUserName().equals(uName)) && (u.getPassword().equals(passW))) {
                success();
                setName(u.getUserName());
                user = u;
                
                //setting app root to UserMainMenu
                App.setRoot("UserMainMenu");
                
                break;
                
            }
            
            
        }
        setName(uName);
        if (user == null)
        {
            showValidationAlert("Enter correct password or username");
        }
    }
    
    //method that calls interface to display sucessfull message
    @FXML
    private void success()
    {
        String successMessage = "Operation completed successfully.";
        showSuccessAlert(successMessage);
    }
    
    public void setName(String x)
    {
        this.n =x;
    }
    public String returnName()
    {   
        
        return n;
    }
    @FXML 
    private void back() throws IOException
    {
        App.setRoot("UserMainMenu");
    }
}
