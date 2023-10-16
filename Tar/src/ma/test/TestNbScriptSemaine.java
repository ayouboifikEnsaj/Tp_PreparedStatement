/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.test;

import ma.service.DevelopperService;

/**
 *
 * @author PC
 */
public class TestNbScriptSemaine {
    public static void main(String[] args) {
        DevelopperService dev = new DevelopperService();
        dev.exoJdbcNbscripts("ALAMI");
    }
}
