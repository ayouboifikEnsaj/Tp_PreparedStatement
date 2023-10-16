/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.test;

import ma.beans.Developper;
import ma.service.DevelopperService;

/**
 *
 * @author PC
 */
public class TestMaxScript {
    public static void main(String[] args) {
        DevelopperService dev = new DevelopperService();
          dev.exoJdbcMaxScripts();
         for(Developper dd : dev.exoJdbcMaxScripts())
            System.out.println(dd);
        
        System.out.println("la liste des developpers trier : \n"+dev.exoJdbcTrie());
    }
}
