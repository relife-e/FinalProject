/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author Anmol Saru
 */
//Class that describes BookRoom attributes
public class BookRoom {
    private int roomId;
    private String checkIn;
    private String checkOut;
    private String userName;

    public BookRoom(int roomId, String checkIn, String checkOut, String userName) {
        this.roomId = roomId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.userName = userName;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
