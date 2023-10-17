/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.beans.Personne;
import ma.beans.Profil;
import ma.projet.impl.PersonneImpl;
import ma.projet.impl.ProfilImpl;

/**
 *
 * @author Ismail
 */
public class Test {
    public static void main(String[] args) {
        ProfilImpl pi=new ProfilImpl();
       // pi.create(new Profil("13", "Manager"));
        PersonneImpl psi=new PersonneImpl();
        //System.out.println(psi.findById(12));
        //for(Profil p : pi.findAll())
         //   System.out.println(p.getId());
        //System.out.println(pi.findById(4));
//        for(Personne p : psi.findAll()){
//            System.out.println(p);}
         for(Personne p : psi.findAll()){
             System.out.println(p);
         }
        //psi.delete(new Personne(5,"newtest", "newTset", "jdida", new Date(), "test", 1200, pi.findById(3)));
        
        }
    }
    

