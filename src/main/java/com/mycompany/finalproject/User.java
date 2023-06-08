/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.finalproject;

/**
 *
 * @author Anmol Saru
 */
public class User {
    
    private String userName;
    private String password;

    public User(String userName, String password) {
        
        this.userName = userName;
        this.password = password;
    }
    
    public User(){};
    

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
            
}
