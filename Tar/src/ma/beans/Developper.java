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
public class Developper {
    


    private String name ;
    private String jour ;
    private int nbScripts ;
     
    public Developper (String name ,String jour , int nbScripts ){
        this.name = name ;
        this.jour = jour ;
        this.nbScripts = nbScripts ; 
        
    }

    public String getName() {
        return name;
    }

    public String getJour() {
        return jour;
    }

    public int getNbScripts() {
        return nbScripts;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJour(String jour) {
        this.jour = jour;
    }

    public void setNbScripts(int nbScripts) {
        this.nbScripts = nbScripts;
    }

    @Override
    public String toString() {
        return "Developper{" + "name=" + name + ", jour=" + jour + ", nbScripts=" + nbScripts + '}';
    }
    
    
}


