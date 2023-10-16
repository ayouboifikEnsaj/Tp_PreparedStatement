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
public class TestAdDevelopper {
    public static void main(String[] args) {
          DevelopperService dev = new DevelopperService();
          Developper d = new Developper("VIP", "Lundi", 100);
          dev.addDevelopper(d);
    }
}
