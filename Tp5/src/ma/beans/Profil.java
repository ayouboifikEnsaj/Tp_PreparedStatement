/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.beans;

/**
 *
 * @author Ismail
 */
public class Profil {
    private int id;
    private String code;
    private String libelle;

    public Profil() {
    }

    public Profil(int id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }
    

    public Profil(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return libelle;
    }
    
    
}
