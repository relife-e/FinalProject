/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Anmol Saru
 */
public class UserList {
    //initalizing the arraylsit of land data type
    private ArrayList<User> userList = new ArrayList<>();
    
    
    //method that helps to read the data from arraylist
    public ArrayList<User> readUserDataFromFile() throws IOException {
        Scanner input = new Scanner(System.in);
        //ArrayList<Land> landList = new ArrayList<>();
        File file = new File("User.txt");
        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    //parsing value into variables
                    String[] fields = line.split(",");
                    
                    String uName = fields[0];
                    String uPass = fields[1];
                    //calling land constructor
                    User userObj = new User(uName, uPass);
                    userList.add(userObj);
                    line = reader.readLine();
                }

                reader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading SellerInfo.txt: " + e.getMessage());
        }
        
        return userList;
    }
//writing all the land info into a file
    public void writeUserDataToFile(ArrayList<User> userList) throws IOException {
        FileWriter writer = new FileWriter("User.txt",true);
        for (User userObj : userList) {
            writer.write( userObj.getUserName() + "," + userObj.getPassword() + "\n");
        }
        writer.close();
    }
}


