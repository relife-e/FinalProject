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
public class RoomsList {
    //initalizing the arraylsit of Rooms data type
    private ArrayList<Rooms> roomList = new ArrayList<>();
    
    private int roomId;    
    private int numBed;
    private String address;
    private int roomNum;
    
    //method that helps to read the data from arraylist
    public ArrayList<Rooms> readRoomsDataFromFile() throws IOException {
        Scanner input = new Scanner(System.in);
        
        File file = new File("Room.txt");
        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                while (line != null) {
                    //parsing value into variables
                    String[] fields = line.split(",");                    
                    int rId = Integer.parseInt(fields[0]);
                    int numB = Integer.parseInt(fields[1]);
                    String add = fields[2];
                    int roomN = Integer.parseInt(fields[3]);
                    //calling room constructor
                    Rooms rObj = new Rooms(rId, numB, add, roomN);
                    roomList.add(rObj);
                    line = reader.readLine();
                }

                reader.close();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading SellerInfo.txt: " + e.getMessage());
        }
        
        return roomList;
    }
//writing all the room info into a file
    public void writeRoomsDataToFile(ArrayList<Rooms> roomList) throws IOException {
        FileWriter writer = new FileWriter("Room.txt",true);
        for (Rooms rObj : roomList) {
            writer.write( rObj.getRoomId() + "," + rObj.getNumBed()+ "," + rObj.getAddress()+ "," + rObj.getRoomNum() + "\n");
        }
        writer.close();
    }
}
