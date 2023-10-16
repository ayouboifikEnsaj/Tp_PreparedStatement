/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.bean.Personne;
import ma.projet.bean.Profil;
import ma.projet.impl.PersonneImpl;
import ma.projet.impl.ProfilImpl;

/**
 *
 * @author H P
 */
public class Test {
    public static void main(String[] args) {
        ProfilImpl pi=new ProfilImpl();
       // pi.create(new Profil("16", "Manager"));
        PersonneImpl psi=new PersonneImpl();
       // psi.create(new Personne("oifik", "ayoub", "casablanca", new java.sql.Date(1920, 2, 2), "auoub.oifik1@gmail.com",100.01, pi.findById(3)));
        //for(Profil p : pi.findAll())
         //   System.out.println(p.getId());
        //System.out.println(pi.findById(16).getId());
        
    }
    
}
