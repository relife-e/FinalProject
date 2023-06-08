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
public class BookRoomList {
    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

    //initalizing the arraylsit of bookroom data type
    private ArrayList<BookRoom> bRoomList = new ArrayList<>();
    
    
    
    //method that helps to read the data from arraylist
    public ArrayList<BookRoom> readBookRoomDataFromFile() throws IOException {
        Scanner input = new Scanner(System.in);
        
        File file = new File("BookRoom.txt");
        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    //parsing value into variables
                    String[] fields = line.split(",");                    
                    int rId = Integer.parseInt(fields[0]);
                    String cIn = fields[1];
                    String cOut = fields[2];
                    String uName = fields[3];
                    //calling bookroom constructor
                    BookRoom bRObj = new BookRoom(rId, cIn, cOut, uName);
                    bRoomList.add(bRObj);
                    line = reader.readLine();
                }

                reader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading SellerInfo.txt: " + e.getMessage());
        }
        
        return bRoomList;
    }
//writing all the bookroom info into a file
    public void writeBookRoomDataToFile(ArrayList<BookRoom> bRoomList) throws IOException {
        FileWriter writer = new FileWriter("BookRoom.txt",true);
        for (BookRoom brObj : bRoomList) {
            writer.write( brObj.getRoomId() + "," + brObj.getCheckIn()+ "," + brObj.getCheckOut()+ "," + brObj.getUserName() + "\n");
        }
        writer.close();
    }
}


