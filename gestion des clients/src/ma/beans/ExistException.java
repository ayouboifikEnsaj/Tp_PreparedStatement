/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.beans;

/**
 *
 * @author PC
 */
public class ExistException extends Exception{
    public String getDetailledMessage(){
        return "user exist";
    }
    public String getDetailledMessage(String m){
        return m;
    }
   
}
