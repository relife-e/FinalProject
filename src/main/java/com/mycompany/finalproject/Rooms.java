/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author Anmol Saru
 */
public class Rooms {
    private int roomId;    
    private int numBed;
    private String address;
    private int roomNum;
    private boolean isSold;
    public Rooms(int roomId, int numBed, String address, int roomNum) {
        this.roomId = roomId;
        this.numBed = numBed;
        this.address = address;
        this.roomNum = roomNum;
        this.isSold = false;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public int getNumBed() {
        return numBed;
    }

    public void setNumBed(int numBed) {
        this.numBed = numBed;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoomNum() {
        return roomNum;
    }

    public boolean isIsSold() {
        return isSold;
    }

    public void setIsSold(boolean isSold) {
        this.isSold = isSold;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }
    
    
}
