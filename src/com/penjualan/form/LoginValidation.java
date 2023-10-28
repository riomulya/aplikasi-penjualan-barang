/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.penjualan.form;

/**
 *
 * @author Administrator
 */
public class LoginValidation {
    public static String username;
    public static String password;
    public static Boolean loginIsValid = false;
    
    public static Boolean isValid(String user,String pass){
        if(!user.equals("") && !pass.equals("")){
            loginIsValid = true;
        }else{
            loginIsValid = false;
        }
        return loginIsValid;
    }
}
